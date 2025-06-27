package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.CustomerNurseItem;
import org.skraua.yyzxbackend.vo.CustomerNurseItemVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description CustomerNurseItemMapper
 */
public interface CustomerNurseItemMapper extends BaseMapper<CustomerNurseItem> {
    Page<CustomerNurseItemVo> selectPageVo(@Param("page") Page<CustomerNurseItemVo> page,
            @Param("customerId") Integer customerId) throws Exception;
}