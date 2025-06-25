package org.skraua.yyzxbackend.mapper;

import org.skraua.yyzxbackend.pojo.Customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description CustomerMapper
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    Customer selectBedCountVo();
}