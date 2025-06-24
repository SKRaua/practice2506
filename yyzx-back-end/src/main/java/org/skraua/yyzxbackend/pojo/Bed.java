package org.skraua.yyzxbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 床位
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Bed", description = "Bed实体对象")
public class Bed {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房间号")
    private Integer roomNo;

    @ApiModelProperty(value = "床位状态 1-空闲 2-有人 3-外出")
    private Integer bedStatus;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "床位号（字符串完整号码）")
    private String BedNo;
}
