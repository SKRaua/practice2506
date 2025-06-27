package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.CustomerPreference;
import org.skraua.yyzxbackend.vo.CustomerPreferenceVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/27
 * @description CustomerPreferenceMapper
 */
public interface CustomerPreferenceMapper extends BaseMapper<CustomerPreference> {
    Page<CustomerPreferenceVo> selectPageVo(@Param("page") Page<CustomerPreferenceVo> page,
            @Param("customerName") String customerName) throws Exception;
}