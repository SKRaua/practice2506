package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description NurseRecordDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "NurseRecordDTO", description = "NurseRecordDTO查询实体对象")
public class NurseRecordDTO {
    @ApiModelProperty(value = "客户编号")
    private Integer customerId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
