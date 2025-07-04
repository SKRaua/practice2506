package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description NurseContentDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "NurseContentDTO", description = "NurseItemDTO查询实体对象")
public class NurseContentDTO {
    @ApiModelProperty(value = "名称")
    private String nursingName;

    @ApiModelProperty(value = "状态 1-启用 2-停用")
    private Integer status;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
