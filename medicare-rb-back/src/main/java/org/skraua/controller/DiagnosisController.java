package org.skraua.controller;

import org.skraua.dto.DiagnosisDTO;
import org.skraua.service.DiagnosisService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.DiagnosisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/diagnosis")
@Api(tags = "诊断信息")
@CrossOrigin
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @ApiOperation("诊断分页查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<DiagnosisVo>> selectDiagnosisVoPage(DiagnosisDTO diagnosisDTO) throws Exception {
        return diagnosisService.selectDiagnosisVoPage(diagnosisDTO);
    }

    @ApiOperation("添加诊断")
    @PostMapping("/add")
    public ResultVo<Void> addDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) throws Exception {
        return diagnosisService.addDiagnosis(diagnosisDTO);
    }

    @ApiOperation("修改诊断")
    @PostMapping("/edit")
    public ResultVo<Void> updateDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) throws Exception {
        return diagnosisService.updateDiagnosis(diagnosisDTO);
    }

    @ApiOperation("删除诊断")
    @ApiImplicitParam(dataType = "int", name = "id", value = "诊断ID", required = true)
    @PostMapping("/remove")
    public ResultVo<Void> removeDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) throws Exception {
        return diagnosisService.removeDiagnosis(diagnosisDTO.getId());
    }
}