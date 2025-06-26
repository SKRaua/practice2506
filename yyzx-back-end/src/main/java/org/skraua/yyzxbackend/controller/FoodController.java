package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.pojo.Food;
import org.skraua.yyzxbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhou Xinyang
 * @date 2025/06/26
 * @description
 */
@RestController
@RequestMapping("/food")
@Api(tags = "食物")
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/listFood")
    @ApiOperation("查询食物列表")
    public List<Food> listFood() {
        // 创建查询条件包裹器、
        return foodService.list();
        // return ResultVo.ok(roomService.list());
    }
}
