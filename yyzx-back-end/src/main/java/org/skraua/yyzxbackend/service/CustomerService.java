package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.CustomerInfoDTO;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.CustomerInfoVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/26
 * @description
 */
public interface CustomerService extends IService<Customer> {
    // 添加用户
    public ResultVo<Void> add(Customer customer) throws Exception;

    // 分页查询客户信息
    public ResultVo<Page<CustomerInfoVo>> listPage(CustomerInfoDTO customerInfoDTO) throws Exception;

    // 删除客户信息和床位信息
    public ResultVo<Void> delete(Integer id, Integer bedId) throws Exception;

    // 修改客户信息
    public ResultVo<Void> update(Customer customer) throws Exception;
}
