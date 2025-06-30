package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.BackdownDTO;
import org.skraua.yyzxbackend.dto.MealDTO;
import org.skraua.yyzxbackend.pojo.Backdown;
import org.skraua.yyzxbackend.pojo.Meal;
import org.skraua.yyzxbackend.service.BackdownService;
import org.skraua.yyzxbackend.service.MealService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.BackdownVo;
import org.skraua.yyzxbackend.vo.MealVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description
 */
@RestController
@RequestMapping("/backdown")
@Api(tags = "退住管理")
@CrossOrigin
public class BackdownController {

    @Autowired
    private BackdownService backdownService;

    @GetMapping("/listPage")
    @ApiOperation("分页查询")
    public ResultVo<Page<BackdownVo>> listPage(BackdownDTO backdownDTO) throws Exception {
        return backdownService.listPage(backdownDTO);
    }

    @PostMapping("/add")
    @ApiOperation("添加审批")
    public ResultVo<Void> add(Backdown backdown) throws Exception {
        backdownService.save(backdown);
        return ResultVo.ok("添加完成");
    }

    @PostMapping("/examineBackdown")
    @ApiOperation("审批退住申请")
    public ResultVo<Void> examineBackdown(Backdown backdown) throws Exception {
        backdownService.examineBackdown(backdown);
        return ResultVo.ok("审批完成");
    }

    @PostMapping("/delete")
    @ApiOperation("撤回退住申请")
    public ResultVo<Void> delete(Integer id) throws Exception {
        backdownService.delete(id);
        return ResultVo.ok("撤回完成");
    }

}
