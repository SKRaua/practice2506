package org.skraua.controller;

import org.skraua.dto.DrugDTO;
import org.skraua.service.DrugService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DrugVo;
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
 * @date 2025/07/10
 * @description
 */
@RestController
@RequestMapping("/drug")
@Api(tags = "药品信息")
@CrossOrigin
public class DrugController {
    @Autowired
    private DrugService drugService;

    @ApiOperation("药品分页查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<DrugVo>> selectDrugVoPage(DrugDTO drugDTO) throws Exception {
        return drugService.selectDrugVoPage(drugDTO);
    }

    @ApiOperation("添加药品")
    @PostMapping("/add")
    public ResultVo<Void> addDrug(@RequestBody DrugDTO dto) throws Exception {
        return drugService.addDrug(dto);
    }

    @ApiOperation("修改药品")
    @PostMapping("/edit")
    public ResultVo<Void> updateDrug(@RequestBody DrugDTO dto) throws Exception {
        return drugService.updateDrug(dto);
    }

    @ApiOperation("删除药品")
    @PostMapping("/remove")
    public ResultVo<Void> removeDrug(@RequestBody DrugDTO dto) throws Exception {
        return drugService.removeDrug(dto.getId());
    }
}