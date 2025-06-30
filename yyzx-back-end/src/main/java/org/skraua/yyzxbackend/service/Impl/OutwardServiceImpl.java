package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.OutwardDTO;
import org.skraua.yyzxbackend.mapper.OutwardMapper;
import org.skraua.yyzxbackend.pojo.Outward;
import org.skraua.yyzxbackend.service.OutwardService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@Service
public class OutwardServiceImpl extends ServiceImpl<OutwardMapper, Outward> implements OutwardService {
    @Autowired
    OutwardMapper outwardMapper;

    @Override
    public ResultVo<Page<OutwardVo>> listPage(OutwardDTO outwardDTO) throws Exception {
        Page<OutwardVo> page = new Page<>(outwardDTO.getPageSize(), 6);
        outwardMapper.selectOutwardPage(page, outwardDTO.getUserId());
        return ResultVo.ok(page);
    }

    // 审批外出
    @Override
    public ResultVo<Void> examineOutward(Outward outward) throws Exception {
        // 审批状态更新
        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("audit_status", outward.getAuditStatus());
        // 审批时间设置
        uw.set("audit_time", outward.getAuditTime());
        // 审批人设置
        uw.set("audit_person", outward.getAuditPerson());
        outwardMapper.update(outward, uw);
        return ResultVo.ok("审批完成");
    }

    // 撤销外出登记
    @Override
    public ResultVo<Void> delOutward(Outward outward) throws Exception {
        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("is_deleted", 1);
        outwardMapper.update(outward, uw);
        return ResultVo.ok("撤销完成");
    }

    // 登记回院时间
    public ResultVo<Void> updateBackTime(Outward outward) throws Exception {
        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("actual_return_time", outward.getActualReturnTime());
        outwardMapper.update(outward, uw);
        return ResultVo.ok("登记完成");
    }

}
