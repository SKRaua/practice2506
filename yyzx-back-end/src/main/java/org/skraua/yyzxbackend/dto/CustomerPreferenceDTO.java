package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description CustomerPreference
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerPreference", description = "CustomerPreference查询实体对象")
public class CustomerPreferenceDTO {
    @ApiModelProperty(value = "喜好编号")
    private Integer preferId;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
