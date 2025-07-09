package org.skraua.controller;

import org.skraua.dto.DrugOrderDTO;
import org.skraua.service.DrugOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zhou Xinyang
 * @date 2025/07/08
 * @description
 */
@RestController
@RequestMapping("/drugOrder")
@Api(tags = "药品订单")
@CrossOrigin
public class DrugOrderController {
    @Autowired
    private DrugOrderService drugOrderService;

    @ApiOperation("参保人信息查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<DrugOrderVo>> selectDrugOrderVoPage(DrugOrderDTO drugOrderDTO) throws Exception {
        return drugOrderService.selectDrugOrderVoPage(drugOrderDTO);
    }

}
