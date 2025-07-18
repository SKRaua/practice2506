package org.skraua.controller;

import org.skraua.dto.ReimbursementRatioDTO;
import org.skraua.service.ReimbursementRatioService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.ReimbursementRatioVo;
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
@RequestMapping("/reimbursementRatio")
@Api(tags = "报销比例")
@CrossOrigin
public class ReimbursementRatioController {
    @Autowired
    private ReimbursementRatioService ratioService;

    @ApiOperation("信息查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<ReimbursementRatioVo>> selectReimbursementRatioPage(ReimbursementRatioDTO ratioDTO)
            throws Exception {
        return ratioService.selectReimbursementRatioPage(ratioDTO);
    }

    @ApiOperation("添加报销比例")
    @PostMapping("/add")
    public ResultVo<Void> addReimbursementRatio(@RequestBody ReimbursementRatioDTO dto) throws Exception {
        return ratioService.addReimbursementRatio(dto);
    }

    @ApiOperation("修改报销比例")
    @PostMapping("/edit")
    public ResultVo<Void> updateReimbursementRatio(@RequestBody ReimbursementRatioDTO dto) throws Exception {
        return ratioService.updateReimbursementRatio(dto);
    }

    @ApiOperation("删除报销比例")
    @PostMapping("/remove")
    public ResultVo<Void> removeReimbursementRatio(@RequestBody ReimbursementRatioDTO dto) throws Exception {
        return ratioService.removeReimbursementRatio(dto.getId());
    }
}
