package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.NurseRecordDTO;
import org.skraua.yyzxbackend.mapper.CustomerNurseItemMapper;
import org.skraua.yyzxbackend.mapper.NurseRecordMapper;
import org.skraua.yyzxbackend.pojo.CustomerNurseItem;
import org.skraua.yyzxbackend.pojo.NurseRecord;
import org.skraua.yyzxbackend.service.NurseRecordService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.NurseRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService {

    @Autowired
    private NurseRecordMapper nurseRecordMapper;

    @Autowired
    private CustomerNurseItemMapper customerNurseItemMapper;

    @Override
    public ResultVo<Page<NurseRecordVo>> listPage(NurseRecordDTO nurseRecordDTO) throws Exception {
        Page<NurseRecordVo> page = new Page<>(nurseRecordDTO.getPageSize(), 6);
        nurseRecordMapper.selectPageVo(page, nurseRecordDTO.getCustomerId());
        return ResultVo.ok(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVo<Void> add(NurseRecord nurseRecord) throws Exception {
        // 生成护理记录
        nurseRecord.setIsDeleted(0);
        boolean temp = save(nurseRecord);
        // 查询当前客户护理项目余量
        QueryWrapper<CustomerNurseItem> qw = new QueryWrapper<>();
        qw.eq("customer_id", nurseRecord.getCustomerId());
        qw.eq("item_id", nurseRecord.getItemId());
        qw.eq("is_deleted", 0);
        CustomerNurseItem customerNurseItem = customerNurseItemMapper.selectOne(qw);
        // 修改客户护理项目数量
        UpdateWrapper<CustomerNurseItem> uw = new UpdateWrapper<>();
        uw.set("nurse_number", customerNurseItem.getNurseNumber() - nurseRecord.getNursingCount());
        uw.eq("customer_id", nurseRecord.getCustomerId());
        uw.eq("item_id", nurseRecord.getItemId());
        uw.eq("is_deleted", 0);
        int update = customerNurseItemMapper.update(customerNurseItem, uw);
        if (!(temp && update > 0)) {
            throw new Exception("护理记录生成失败");
        }
        return ResultVo.ok("护理记录添加成功");
    }

}
