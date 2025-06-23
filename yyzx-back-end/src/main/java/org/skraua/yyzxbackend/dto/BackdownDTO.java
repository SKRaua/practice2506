package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description BackdownDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "BackdownDTO", description = "BackdownDTO查询实体对象")
public class BackdownDTO {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
