package org.skraua.yyzxbackend.service;

import org.skraua.yyzxbackend.dto.MealDTO;
import org.skraua.yyzxbackend.pojo.Meal;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.MealVo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Zhou Xinyang
 * @date 2025/06/25
 * @description
 */
public interface MealService extends IService<Meal> {
    public ResultVo<Page<MealVo>> listPage(MealDTO mealDTO) throws Exception;
}
