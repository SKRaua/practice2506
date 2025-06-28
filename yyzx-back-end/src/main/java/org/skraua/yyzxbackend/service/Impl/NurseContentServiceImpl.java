package org.skraua.yyzxbackend.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.skraua.yyzxbackend.mapper.NurseContentMapper;
import org.skraua.yyzxbackend.mapper.NurseLevelItemMapper;
import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.pojo.NurseLevelItem;
import org.skraua.yyzxbackend.service.NurseContentService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public ResultVo<List<NurseContent>> listByLevel(Integer levelId) throws Exception {
        // 先查询级别的项目配置，只查询item_id
        QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
        qw.eq("level_id", levelId);
        qw.select("item_id");
        List<Integer> itemsId = nurseLevelItemMapper.selectObjs(qw, Integer.class);
        List<NurseContent> nurseContents = new ArrayList<>();

    }

    @Override
    public ResultVo<Void> update(NurseContent nurseContent) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResultVo<Void> delete(NurseContent nurseContent) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
