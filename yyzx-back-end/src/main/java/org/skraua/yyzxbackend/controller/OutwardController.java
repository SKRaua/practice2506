package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.OutwardDTO;
import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.pojo.Outward;
import org.skraua.yyzxbackend.service.BedService;
import org.skraua.yyzxbackend.service.CustomerService;
import org.skraua.yyzxbackend.service.OutwardService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.OutwardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@RestController
@RequestMapping("/outward")
@Api(tags = "外出管理")
@CrossOrigin
public class OutwardController {
    @Autowired
    OutwardService outwardService;
    @Autowired
    private BedService bedService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/listPage")
    @ApiOperation("分页查询")
    public ResultVo<Page<OutwardVo>> listPage(OutwardDTO outwardDTO) throws Exception {
        return outwardService.listPage(outwardDTO);
    }

    @PostMapping("/examineOutward")
    @ApiOperation("审批外出")
    public ResultVo<Void> examineOutward(Outward outward) throws Exception {
        Outward od = outwardService.getById(outward.getId());
        // 若审批通过，修改床铺记录，对应床铺状态改为外出
        if (outward.getAuditStatus() == 1) {
            Customer cs = customerService.getById(od.getCustomerId());
            Bed bed = new Bed();
            bed.setId(cs.getBedId());
            bed.setBedStatus(3);
            bedService.updateById(bed);
        }
        // 继续设置其他信息
        return outwardService.examineOutward(outward);
    }

    @PostMapping("/add")
    @ApiOperation("添加外出申请")
    public ResultVo<Void> add(Outward outward) throws Exception {
        outwardService.save(outward);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/delete")
    @ApiOperation("撤销外出申请")
    public ResultVo<Void> delete(Outward outward) throws Exception {
        return outwardService.delete(outward);
    }

    @PostMapping("/updateBackTime")
    @ApiOperation("登记回院时间")
    public ResultVo<Void> updateBackTime(Outward outward) throws Exception {
        return outwardService.updateBackTime(outward);
    }

}
