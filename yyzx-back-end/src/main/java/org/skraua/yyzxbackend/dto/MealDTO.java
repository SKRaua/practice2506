package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description ExchangeDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "MealDTO", description = "MealDTO床位调换查询实体对象")
public class MealDTO {
    @ApiModelProperty(value = "食品编号")
    private Integer mealId;

    @ApiModelProperty(value = "星期")
    private String weekDay;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "食品类型 1.早餐、2.午餐、3.晚餐")
    private Integer mealType;
}
