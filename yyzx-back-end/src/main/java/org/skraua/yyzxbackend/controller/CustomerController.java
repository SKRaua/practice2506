package org.skraua.yyzxbackend.controller;

import org.skraua.yyzxbackend.dto.CustomerInfoDTO;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.service.CustomerService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zhou Xinyang
 * @date 2025/06/26
 * @description
 */
@RestController
@RequestMapping("/customer")
@Api(tags = "客户管理")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/listPage")
    @ApiOperation("分页查询客户信息")
    public ResultVo<Page<CustomerInfoVo>> listPage(CustomerInfoDTO customerInfoDTO) throws Exception {
        return customerService.listPage(customerInfoDTO);
    }

    @PostMapping("/checkIn")
    @ApiOperation("入住登记")
    public ResultVo<Void> checkIn(Customer customer) throws Exception {
        // TODO 检查
        return customerService.addCustomer(customer);
    }

    // 同理，逻辑为标记删除，并非数据库移除，改为delete方法名
    @PostMapping("/delete")
    @ApiOperation("删除客户")
    public ResultVo<Void> delete(Customer customer) throws Exception {
        // TODO 检查
        return customerService.delCustomer(customer.getId(), customer.getBedId());
    }

    @PostMapping("/edit")
    @ApiOperation("编辑客户")
    public ResultVo<Void> edit(Customer customer) throws Exception {
        // TODO 检查
        return customerService.editCustomer(customer);
    }

}
