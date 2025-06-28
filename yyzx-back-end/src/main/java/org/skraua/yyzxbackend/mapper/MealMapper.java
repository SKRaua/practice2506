package org.skraua.yyzxbackend.mapper;

import org.apache.ibatis.annotations.Param;
import org.skraua.yyzxbackend.pojo.Meal;
import org.skraua.yyzxbackend.vo.MealVo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description MealMapper
 */
public interface MealMapper extends BaseMapper<Meal> {
    Page<MealVo> selectPageVo(@Param("page") Page<MealVo> page,
            @Param("weekDay") String weekDay,
            @Param("mealType") Integer mealType) throws Exception;
}