package org.skraua.yyzxbackend.controller;

import java.util.List;

import org.skraua.yyzxbackend.dto.CustomerNurseItemDTO;
import org.skraua.yyzxbackend.pojo.CustomerNurseItem;
import org.skraua.yyzxbackend.service.CustomerNurseItemService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("/customerNurseItem")
@Api(tags = "客户护理项目")
@CrossOrigin
public class CustomerNurseItemController {

    @Autowired
    private CustomerNurseItemService customerNurseItemService;

    @GetMapping("/listPage")
    @ApiOperation("查询客户护理项目")
    public ResultVo<Page<CustomerNurseItemVo>> listPage(CustomerNurseItemDTO customerNurseItemDTO)
            throws Exception {
        return customerNurseItemService.listPage(customerNurseItemDTO);
    }

    @PostMapping("/addItemToCustomer")
    @ApiOperation("为客户批量添加护理项目")
    public ResultVo<Void> add(List<CustomerNurseItem> customerNurseItems) throws Exception {
        customerNurseItemService.add(customerNurseItems);
        return ResultVo.ok("添加成功");
    }

    @PostMapping("/delLevelAndItem")
    @ApiOperation("删除客户护理级别和级别下项目")
    public ResultVo<Void> delLevelAndItem(Integer levelId, Integer customerId) throws Exception {
        customerNurseItemService.delLevelAndItem(levelId, customerId);
        return ResultVo.ok("删除成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除客户护理项目")
    public ResultVo<Void> remove(Integer id) throws Exception {
        customerNurseItemService.delete(id);
        return ResultVo.ok("移除成功");
    }

    @PostMapping("/enewNurseItem")
    @ApiOperation("客户续费")
    public ResultVo<Void> enewNurseItem(CustomerNurseItem customerNurseItem) throws Exception {
        customerNurseItemService.updateById(customerNurseItem);
        return ResultVo.ok("客户续费成功");
    }

    @GetMapping("/isIncludesItemCustomer")
    @ApiOperation("用户是否已配置某个项目")
    public ResultVo<Void> isIncludesItemCustomer(Integer customerId, Integer itemId) throws Exception {
        return customerNurseItemService.isIncludesItemCustomer(customerId, itemId);
    }

}
