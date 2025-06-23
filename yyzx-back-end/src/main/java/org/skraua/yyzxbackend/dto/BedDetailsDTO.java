package org.skraua.yyzxbackend.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description BedDetailsDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "BedDetailsDTO", description = "BedDetailsDTO床位管理查询实体对象")
public class BedDetailsDTO {
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "床位是否生效，（0显示，1隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "床位起始时间")
    private Date startDate;

    @ApiModelProperty(value = "床位结束时间")
    private Date endDate;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
