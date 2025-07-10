package org.skraua.controller;

import org.skraua.dto.TreatmentItemOrderDTO;
import org.skraua.service.TreatmentItemOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.TreatmentItemOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/treatmentItemOrder")
@Api(tags = "诊疗项目")
@CrossOrigin
public class TreatmentItemOrderController {
    @Autowired
    private TreatmentItemOrderService treatmentItemOrderService;

    @ApiOperation("信息查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<TreatmentItemOrderVo>> selectDrugOrderVoPage(TreatmentItemOrderDTO treatmentItemOrderDTO)
            throws Exception {
        return treatmentItemOrderService.selectTreatmentItemOrderVoPage(treatmentItemOrderDTO);
    }

    @ApiOperation("添加诊疗项目订单")
    @PostMapping("/add")
    public ResultVo<Void> addTreatmentItemOrder(@RequestBody TreatmentItemOrderDTO dto) throws Exception {
        return treatmentItemOrderService.addTreatmentItemOrder(dto);
    }

    @ApiOperation("修改诊疗项目订单")
    @PostMapping("/edit")
    public ResultVo<Void> updateTreatmentItemOrder(@RequestBody TreatmentItemOrderDTO dto) throws Exception {
        return treatmentItemOrderService.updateTreatmentItemOrder(dto);
    }

    @ApiOperation("删除诊疗项目订单")
    @PostMapping("/remove")
    public ResultVo<Void> removeTreatmentItemOrder(@RequestBody TreatmentItemOrderDTO dto) throws Exception {
        return treatmentItemOrderService.removeTreatmentItemOrder(dto.getId());
    }
}
