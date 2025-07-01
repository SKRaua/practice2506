package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.OutwardDTO;
import org.skraua.yyzxbackend.mapper.BedMapper;
import org.skraua.yyzxbackend.mapper.CustomerMapper;
import org.skraua.yyzxbackend.mapper.OutwardMapper;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.Customer;
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
    private OutwardMapper outwardMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ResultVo<Page<OutwardVo>> listPage(OutwardDTO outwardDTO) throws Exception {
        Page<OutwardVo> page = new Page<>(outwardDTO.getPageSize(), 6);
        outwardMapper.selectOutwardPage(page, outwardDTO.getUserId());
        return ResultVo.ok(page);
    }

    // 审批外出
    @Override
    public ResultVo<Void> examineOutward(Outward outward) throws Exception {
        Outward od = getById(outward.getId());
        // 若审批通过，修改床铺记录，对应床铺状态改为外出
        if (outward.getAuditStatus() == 1) {
            Customer cs = customerMapper.selectById(od.getCustomerId());
            Bed bed = bedMapper.selectById(cs.getBedId());
            if (bed.getBedStatus() != 3) {
                bed.setBedStatus(3);
                int update = bedMapper.updateById(bed);
                if (update <= 0) {
                    return ResultVo.fail("登记失败,床位状态异常");
                }
            }

        }

        // 审批状态更新
        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("auditstatus", outward.getAuditStatus());
        // 审批时间设置
        uw.set("audittime", outward.getAuditTime());
        // 审批人设置
        uw.set("auditperson", outward.getAuditPerson());
        int update1 = outwardMapper.update(outward, uw);
        if (update1 <= 0) {
            throw new Exception("更新外出信息失败");
        }
        return ResultVo.ok("审批完成");
    }

    // 撤销外出登记
    @Override
    public ResultVo<Void> delete(Outward outward) throws Exception {
        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("is_deleted", 1);
        int update = outwardMapper.update(outward, uw);
        if (update <= 0) {
            throw new Exception("更新外出信息失败");
        }
        return ResultVo.ok("撤销完成");
    }

    // 登记回院时间
    public ResultVo<Void> updateBackTime(Outward outward) throws Exception {

        Outward od = getById(outward.getId());
        Customer cs = customerMapper.selectById(od.getCustomerId());
        Bed bed = bedMapper.selectById(cs.getBedId());
        // 回院，更改床位状态
        if (bed.getBedStatus() != 2) {
            bed.setBedStatus(2);
            int update = bedMapper.updateById(bed);
            if (update <= 0) {
                return ResultVo.fail("登记失败,床位状态异常");
            }
        }

        UpdateWrapper<Outward> uw = new UpdateWrapper<>();
        uw.eq("id", outward.getId());
        uw.set("actualreturntime", outward.getActualReturnTime());
        int update1 = outwardMapper.update(outward, uw);

        if (update1 <= 0) {
            return ResultVo.fail("登记失败");
        }
        return ResultVo.ok("登记完成");
    }

}
