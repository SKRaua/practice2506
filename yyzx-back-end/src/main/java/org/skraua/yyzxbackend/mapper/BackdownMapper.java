package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.Backdown;
import org.skraua.yyzxbackend.vo.BackdownVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/30
 * @description BackdownMapper
 */
public interface BackdownMapper extends BaseMapper<Backdown> {
    Page<BackdownVo> selectPageVo(@Param("page") Page<BackdownVo> page,
            @Param("userId") Integer userId) throws Exception;
}