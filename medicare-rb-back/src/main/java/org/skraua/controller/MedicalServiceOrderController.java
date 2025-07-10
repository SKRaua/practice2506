package org.skraua.controller;

import org.skraua.dto.MedicalServiceOrderDTO;
import org.skraua.service.MedicalServiceOrderService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.MedicalServiceOrderVo;
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
@RequestMapping("/medicalServiceOrder")
@Api(tags = "医疗服务")
@CrossOrigin
public class MedicalServiceOrderController {
    @Autowired
    private MedicalServiceOrderService medicalServiceOrderService;

    @ApiOperation("信息查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<MedicalServiceOrderVo>> selectDrugOrderVoPage(MedicalServiceOrderDTO medicalServiceOrderDTO)
            throws Exception {
        return medicalServiceOrderService.selectMedicalServiceOrderVoPage(medicalServiceOrderDTO);
    }

    @ApiOperation("添加医疗服务记录")
    @PostMapping("/add")
    public ResultVo<Void> addMedicalServiceOrder(@RequestBody MedicalServiceOrderDTO dto) throws Exception {
        return medicalServiceOrderService.addMedicalServiceOrder(dto);
    }

    @ApiOperation("修改医疗服务记录")
    @PostMapping("/edit")
    public ResultVo<Void> updateMedicalServiceOrder(@RequestBody MedicalServiceOrderDTO dto) throws Exception {
        return medicalServiceOrderService.updateMedicalServiceOrder(dto);
    }

    @ApiOperation("删除医疗服务记录")
    @PostMapping("/remove")
    public ResultVo<Void> removeMedicalServiceOrder(@RequestBody MedicalServiceOrderDTO dto) throws Exception {
        return medicalServiceOrderService.removeMedicalServiceOrder(dto.getId());
    }

}
