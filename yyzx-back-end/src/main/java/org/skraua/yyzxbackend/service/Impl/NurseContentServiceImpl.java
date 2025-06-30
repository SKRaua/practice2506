package org.skraua.yyzxbackend.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.skraua.yyzxbackend.dto.NurseContentDTO;
import org.skraua.yyzxbackend.mapper.NurseContentMapper;
import org.skraua.yyzxbackend.mapper.NurseLevelItemMapper;
import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.pojo.NurseLevelItem;
import org.skraua.yyzxbackend.service.NurseContentService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/28
 * @description
 */
@Service
public class NurseContentServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent>
        implements NurseContentService {

    @Autowired
    private NurseContentMapper nurseContentMapper;

    @Autowired
    private NurseLevelItemMapper nurseLevelItemMapper;

    @Override
    public ResultVo<Page<NurseContent>> listlistNurseItemPage(NurseContentDTO nurseContentDTO) throws Exception {
        if (nurseContentDTO == null) {
            throw new Exception("参数不得为空");
        }
        Page<NurseContent> p = new Page<>(nurseContentDTO.getPageSize(), 6);
        // 查询
        QueryWrapper<NurseContent> qw = new QueryWrapper<>();
        if (nurseContentDTO.getNursingName() != null && nurseContentDTO.getNursingName() != "") {
            qw.like("nursing_name", "%" + nurseContentDTO.getNursingName() + "%");
        }
        if (nurseContentDTO.getStatus() != null) {
            qw.eq("status", nurseContentDTO.getStatus());
        }
        qw.eq("is_deleted", 0);
        page(p, qw);
        return ResultVo.ok(p);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<List<NurseContent>> listByLevel(Integer levelId) throws Exception {
        // 先查询级别的项目配置，只查询item_id
        QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
        qw.eq("level_id", levelId);
        qw.select("item_id");

        List<NurseLevelItem> items = nurseLevelItemMapper.selectList(qw);
        List<Integer> itemsId = items.stream()
                .map(NurseLevelItem::getItemId)
                .collect(Collectors.toList());

        List<NurseContent> nurseContents = new ArrayList<>();
        // 判断是否有记录
        if (itemsId.size() > 0) {
            nurseContents = nurseContentMapper.selectBatchIds(itemsId);
        }
        return ResultVo.ok(nurseContents);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> update(NurseContent nurseContent) throws Exception {
        // 如果修改转改为 停用，需要直接剔除护理级别护理项目表中的对应记录，保证可用状态
        if (nurseContent.getStatus() == 2) {
            // 查询当前护理项目是否在护理级别-项目表中，如果存在就剔除
            QueryWrapper<NurseLevelItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("item_id", nurseContent.getId());// selectCount(queryWrapper);
            int count = nurseLevelItemMapper.selectCount(queryWrapper);
            if (count > 0) {
                QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
                qw.eq("item_id", nurseContent.getId());
                int count1 = nurseLevelItemMapper.selectCount(qw);
                // 更新护理项目
                boolean temp = updateById(nurseContent);
                if (!(count1 > 0 && temp)) {
                    throw new Exception("更新护理项目失败");
                }
            }
            updateById(nurseContent);
        }
        return ResultVo.ok("更新护理项目成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> delete(Integer id) throws Exception {
        NurseContent nurseContent = new NurseContent();
        nurseContent.setIsDeleted(1);
        nurseContent.setId(id);
        // 查询当前护理项目是否在护理级别-项目表中，如果存在就剔除
        QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
        qw.eq("item_id", nurseContent.getId());// selectCount(queryWrapper);
        int count = nurseLevelItemMapper.selectCount(qw);
        if (count > 0) {
            QueryWrapper<NurseLevelItem> qw1 = new QueryWrapper<>();
            qw1.eq("item_id", id);
            int count1 = nurseLevelItemMapper.delete(qw1);
            // 更新删除标记 1
            boolean temp = updateById(nurseContent);
            if (!(count1 > 0 && temp)) {
                throw new Exception("删除护理项目失败");
            }
        }
        updateById(nurseContent);
        return ResultVo.ok("删除护理项目成功");
    }

}
