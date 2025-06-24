package org.skraua.yyzxbackend.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @description 膳食
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Dietary", description = "Dietary实体对象")
public class Dietary implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标记 0显示 1隐藏")
    private Integer isDeleted;

    @ApiModelProperty(value = "膳食类型")
    private String type;

    @ApiModelProperty(value = "膳食名称")
    private String name;

    // TODO: 确认价格的数据类型
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "清真")
    private String Islamic;

    @ApiModelProperty(value = "图片")
    private String picture;

    // TODO: 确认时间的数据类型(数据库中为timestamp)
    @ApiModelProperty(value = "创建时间")
    private Date create_on;

}
