package org.skraua.yyzxbackend.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 膳食日历
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "DietaryCalendar", description = "DietaryCalendar实体对象")
public class DietaryCalendar {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "膳食日历编号")
    private Integer dietaryId;

    @ApiModelProperty(value = "早餐中餐晚餐")
    private String dietaryType;

    @ApiModelProperty(value = "星期几")
    private String weekDay;

    @ApiModelProperty(value = "口味")
    private String taste;

    // TODO: 确认时间的数据类型(timestamp)
    @ApiModelProperty(value = "创建时间")
    private Date create_on;

}
