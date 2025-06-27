package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.MealDTO;
import org.skraua.yyzxbackend.pojo.Meal;
import org.skraua.yyzxbackend.service.MealService;
import org.skraua.yyzxbackend.utils.ResultVo;
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
 * @date 2025/06/25
 * @description
 */
@RestController
@RequestMapping("/meal")
@Api(tags = "膳食日历管理")
@CrossOrigin
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/listPage")
    @ApiOperation("分页膳食查询 根据星期，类型（1早餐，2午餐，3晚餐）")
    public ResultVo<Page<MealVo>> listPage(MealDTO mealDTO) throws Exception {
        return mealService.listPage(mealDTO);
    }

    @PostMapping("/add")
    @ApiOperation("添加膳食")
    public ResultVo<Void> add(Meal meal) throws Exception {
        mealService.save(meal);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改膳食")
    public ResultVo<Void> update(Meal meal) throws Exception {
        mealService.updateById(meal);
        return ResultVo.ok("修改成功");
    }

    @PostMapping("/remove")
    @ApiOperation("删除膳食")
    public ResultVo<Void> remove(Meal meal) throws Exception {
        mealService.removeById(meal);
        return ResultVo.ok("删除成功");
    }

}
