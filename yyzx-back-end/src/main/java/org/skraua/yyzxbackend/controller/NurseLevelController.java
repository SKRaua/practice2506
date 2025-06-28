package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.pojo.NurseLevel;
import org.skraua.yyzxbackend.service.NurseLevelService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zhou Xinyang
 * @date 2025/06/28
 * @description
 */
@RestController
@RequestMapping("/NurseLevel")
@Api(tags = "护理等级")
@CrossOrigin
public class NurseLevelController {

    @Autowired
    private NurseLevelService nurseLevelService;

    @GetMapping("/add")
    @ApiOperation("添加")
    public ResultVo<Void> add(NurseLevel nurseLevel) throws Exception {
        nurseLevelService.save(nurseLevel);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/update")
    @ApiOperation("更新护理等级")
    public ResultVo<Void> update(NurseLevel nurseLevel) throws Exception {
        nurseLevelService.updateById(nurseLevel);
        return ResultVo.ok("更新成功");

    }

    @PostMapping("/remove")
    @ApiOperation("移除除护理等级")
    public ResultVo<Void> delete(Integer id) throws Exception {
        nurseLevelService.removeById(id);
        return ResultVo.ok("移除成功");
    }

}
