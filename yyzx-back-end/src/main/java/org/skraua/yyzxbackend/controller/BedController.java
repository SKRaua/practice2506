package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.pojo.Bed;
import org.skraua.yyzxbackend.service.BedService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/bed")
@Api(tags = "床位管理") // 所有的swagger都在这下面
@CrossOrigin // 解决跨域问题
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping("/findBed")
    @ApiOperation("查询所有床位") // swagger文档方法描述
    public ResultVo<List<Bed>> findBed(Bed bed) {
        // 创建查询条件包裹器
        QueryWrapper<Bed> wrapper = new QueryWrapper<>(bed);
        if (bed.getRoomNo() != null) {
            wrapper.eq("room_no", bed.getRoomNo());
        }
        if (bed.getBedStatus() != null) {
            wrapper.eq("bed_status", bed.getBedStatus());
        }
        return ResultVo.ok(bedService.list(wrapper));
    }

}
