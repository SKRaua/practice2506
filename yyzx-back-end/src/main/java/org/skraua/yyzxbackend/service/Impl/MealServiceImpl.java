package org.skraua.yyzxbackend.service.Impl;

import org.skraua.yyzxbackend.dto.MealDTO;
import org.skraua.yyzxbackend.mapper.MealMapper;
import org.skraua.yyzxbackend.pojo.Meal;
import org.skraua.yyzxbackend.service.MealService;
import org.skraua.yyzxbackend.utils.ResultVo;
import org.skraua.yyzxbackend.vo.MealVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

    @Autowired
    private MealMapper mealMapper;

    @Override
    public ResultVo<Page<MealVo>> listMealVoPage(MealDTO mealDTO) throws Exception {
        Page<MealVo> page = new Page<>(mealDTO.getPageSize(), 6);
        mealMapper.selectMealVo(page, mealDTO.getWeekDay(), mealDTO.getMealType());
        return ResultVo.ok(page);
    }
}
