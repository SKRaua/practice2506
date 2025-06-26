package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.Customer;
import org.skraua.yyzxbackend.vo.CustomerInfoVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/256
 * @description CustomerMapper
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    // manType 1-自理老人，2-失能老人，3-无管家
    Page<CustomerInfoVo> selectPageVo(@Param("page") Page<CustomerInfoVo> page,
            @Param("customerName") String customerName,
            @Param("manType") Integer manType,
            @Param("userId") Integer userId);
}