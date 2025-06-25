package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.BedDetailsDTO;
import org.skraua.yyzxbackend.dto.ExchangeDTO;
import org.skraua.yyzxbackend.pojo.BedDetails;
import org.skraua.yyzxbackend.service.BedDetailsService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Zhou Xinyang
 * @date 2025/06/24
 * @description
 */
@RestController
@RequestMapping("/bedDetails")
@Api(tags = "床位详情管理")
@CrossOrigin
public class BedDetailsController {

    @Autowired
    private BedDetailsService bedDetailsService;

    @GetMapping("/listBedDetailsVoPage")
    @ApiOperation("床位详细列表动态查询")
    public ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(BedDetailsDTO bedDetailsDTO) throws Exception {
        return bedDetailsService.listBedDetailsVoPage(bedDetailsDTO);
    }

    @PostMapping("/updateBedDetails")
    @ApiOperation("修改床位详情信息 - 只能修改床位的结束时间")
    public ResultVo<Void> updateBedDetails(BedDetails bedDetails) throws Exception {
        bedDetailsService.updateById(bedDetails);
        return ResultVo.ok("修改成功");
    }

    @PostMapping("/exchangeBed")
    @ApiOperation("床位调换")
    public ResultVo<Void> exchangeBed(ExchangeDTO exchangeDTO) throws Exception {
        return bedDetailsService.exchangeBed(exchangeDTO);
    }

    @GetMapping("/delBedDetails")
    @ApiOperation("删除记录")
    public ResultVo<Void> delBedDetails(Integer id) throws Exception {
        bedDetailsService.removeById(id);
        return ResultVo.ok("删除成功");
    }
}
