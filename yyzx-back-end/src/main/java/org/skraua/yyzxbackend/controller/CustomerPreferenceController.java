package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.CustomerPreferenceDTO;
import org.skraua.yyzxbackend.pojo.CustomerPreference;
import org.skraua.yyzxbackend.service.CustomerPreferenceService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerPreferenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description
 */
@RestController
@RequestMapping("/customerPreference")
@Api(tags = "客户偏好")
@CrossOrigin
public class CustomerPreferenceController {

    @Autowired
    private CustomerPreferenceService customerPreferenceService;

    @GetMapping("/listPage")
    @ApiOperation("查询客户偏好")
    public ResultVo<Page<CustomerPreferenceVo>> listPage(CustomerPreferenceDTO customerPreferenceDTO)
            throws Exception {
        return customerPreferenceService.listPage(customerPreferenceDTO);
    }

    @PostMapping("/add")
    @ApiOperation("添加客户偏好")
    public ResultVo<Void> add(CustomerPreference customerPreference) throws Exception {
        customerPreferenceService.save(customerPreference);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/update")
    @ApiOperation("更新客户偏好")
    public ResultVo<Void> update(CustomerPreference customerPreference) throws Exception {
        customerPreferenceService.updateById(customerPreference);
        return ResultVo.ok("更新成功");
    }

    @PostMapping("/remove")
    @ApiOperation("移除客户偏好")
    public ResultVo<Void> remove(Integer id) throws Exception {
        customerPreferenceService.removeById(id);
        return ResultVo.ok("移除成功");
    }
}
