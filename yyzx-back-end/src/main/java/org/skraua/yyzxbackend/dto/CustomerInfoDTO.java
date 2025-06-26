package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 客户信息查询实体对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerInfoDTO", description = "CustomerInfoDTO客户信息查询实体对象")
public class CustomerInfoDTO {
    @ApiModelProperty(value = "客户编号")
    private Integer customerId;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;

    @ApiModelProperty(value = "健康管家id")
    private Integer userId;

    @ApiModelProperty(value = "客户种类 1-自理 2-护理 3-无管家")
    private Integer manType;

}
