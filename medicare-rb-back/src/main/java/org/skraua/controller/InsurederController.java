package org.skraua.controller;

import org.skraua.dto.InsurederDTO;
import org.skraua.pojo.Insureder;
import org.skraua.service.InsurederService;
import org.skraua.utils.ResultVo;
import org.skraua.vo.InsurederVo;
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
@RequestMapping("/insureder")
@Api(tags = "参保人信息")
@CrossOrigin
public class InsurederController {
    @Autowired
    private InsurederService insurederService;

    @ApiOperation("参保人信息查询")
    @GetMapping("/info")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "page", value = "页码", required = true)
    })
    public ResultVo<Page<InsurederVo>> selectInsurederPage(InsurederDTO insurederDTO) throws Exception {
        return insurederService.selectInsurederPage(insurederDTO);
    }

    // 新增参保人（用POJO接收参数）
    @ApiOperation("新增参保人信息")
    @PostMapping("/add")
    public ResultVo<Void> add(@RequestBody Insureder insureder) throws Exception {
        // 直接用POJO作为参数传递给Service
        boolean save = insurederService.save(insureder);
        return save ? ResultVo.ok("添加成功") : ResultVo.fail("添加失败");

    }

    // 修改参保人信息（用POJO接收参数）
    @ApiOperation("修改参保人信息")
    @PostMapping("/update")
    public ResultVo<Void> update(@RequestBody Insureder insureder) throws Exception {
        boolean update = insurederService.updateById(insureder);
        return update ? ResultVo.ok("修改成功") : ResultVo.fail("修改失败");
    }

    // 删除参保人信息（用POJO的ID作为参数）
    @ApiOperation("删除参保人信息")
    @ApiImplicitParam(dataType = "int", name = "id", value = "ID（必填）", required = true)
    @PostMapping("/remove")
    public ResultVo<Void> remove(@RequestBody InsurederDTO insurederDTO) throws Exception {
        boolean remove = insurederService.removeById(insurederDTO);
        return remove ? ResultVo.ok("删除成功") : ResultVo.fail("删除失败");
    }
}
