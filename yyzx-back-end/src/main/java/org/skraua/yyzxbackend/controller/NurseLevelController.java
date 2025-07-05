package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.pojo.NurseContent;
import org.skraua.yyzxbackend.pojo.NurseLevel;
import org.skraua.yyzxbackend.pojo.NurseLevelItem;
import org.skraua.yyzxbackend.service.NurseContentService;
import org.skraua.yyzxbackend.service.NurseLevelItemService;
import org.skraua.yyzxbackend.service.NurseLevelService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Autowired
    private NurseLevelItemService nurseLevelItemService;

    @Autowired
    private NurseContentService nurseContentService;

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

    // 实在懒得搬，懒得整理了，就这样吧，能用就行，高耦合战士
    @GetMapping("/listNurseLevel")
    @ApiOperation("查询护理级别列表")
    public ResultVo<List<NurseLevel>> listNurseLevel(NurseLevel nurseLevel) throws Exception {
        QueryWrapper<NurseLevel> qw = new QueryWrapper<>();
        if (nurseLevel.getLevelStatus() != null) {
            qw.eq("level_status", nurseLevel.getLevelStatus());
        }
        if (nurseLevel.getLevelName() != null) {
            qw.eq("level_name", nurseLevel.getLevelName());
        }
        return ResultVo.ok(nurseLevelService.list(qw));
    }

    @GetMapping("/listItemToLevel")
    @ApiOperation("根据护理级别查询护理项目 不分页")
    public ResultVo<List<NurseContent>> listNurseItemByLevel(Integer levelId) throws Exception {
        return nurseContentService.listByLevel(levelId);
    }

    @PostMapping("/addItemToLevel")
    @ApiOperation("护理项目的配置")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "itemId", value = "关联护理项目ID", required = true),
            @ApiImplicitParam(dataType = "int", name = "levelId", value = "关联护理级别ID", required = true)
    })
    public ResultVo<Void> addItemToLevel(NurseLevelItem nurseLevelItem) throws Exception {
        // 判断当前级别是否存在相同的护理项目
        QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
        qw.eq("level_id", nurseLevelItem.getLevelId());
        qw.eq("item_id", nurseLevelItem.getItemId());
        int count = nurseLevelItemService.count(qw);
        if (count > 0) {
            return ResultVo.fail("当前级别已存在相同项目");
        }
        nurseLevelItemService.save(nurseLevelItem);
        return ResultVo.ok("添加成功");
    }

    @GetMapping("/removeNurseLevelItem")
    @ApiOperation("删除护理级别中的护理项目")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "itemId", value = "关联护理项目ID", required = true),
            @ApiImplicitParam(dataType = "int", name = "levelId", value = "关联护理级别ID", required = true)
    })
    public ResultVo<Void> removeNurseLevelItem(Integer levelId, Integer itemId) throws Exception {
        QueryWrapper<NurseLevelItem> qw = new QueryWrapper<>();
        qw.eq("level_id", levelId);
        qw.eq("item_id", itemId);
        nurseLevelItemService.remove(qw);
        return ResultVo.ok("删除成功");
    }
}
