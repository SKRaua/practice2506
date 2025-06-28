package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.service.NurseContentService;
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
@RequestMapping("/nurseContent")
@Api(tags = "护理项目")
@CrossOrigin
public class NurseContentController {

    @Autowired
    private NurseContentService nurseContentService;

    @GetMapping("/listByLevel")
    @ApiOperation("根据护理等级查询护理项目")
    public ResultVo<List<NurseContent>> listByLevel(Integer levelId) throws Exception {
        return nurseContentService.listByLevel(levelId);
    }

    @PostMapping("/update")
    @ApiOperation("更新护理项目")
    public ResultVo<Void> update(NurseContent nurseContent) throws Exception {
        return nurseContentService.update(nurseContent);

    }

    @PostMapping("/delete")
    @ApiOperation("删除护理项目")
    public ResultVo<Void> delete(Integer id) throws Exception {
        return nurseContentService.delete(id);
    }

}
