package org.skraua.yyzxbackend.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 床位信息视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "BedDetails", description = "BedDetails视图数据对象")
public class BedDetails {
    private static final long serialVersionUID = 1L;

    // BedDetails
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

    // Custmoer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客性别 0-男 1-女")
    private Integer customerSex;

}
