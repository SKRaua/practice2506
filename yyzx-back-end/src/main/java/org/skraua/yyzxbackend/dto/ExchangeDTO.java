package org.skraua.yyzxbackend.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description ExchangeDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "ExchangeDTO", description = "ExchangeDTO床位调换查询实体对象")
public class ExchangeDTO {
    @ApiModelProperty(value = "床位详情编号")
    private Integer beddetailsId;

    @ApiModelProperty(value = "客户编号")
    private Integer customerId;

    @ApiModelProperty(value = "新楼号")
    private String newBuilding;

    @ApiModelProperty(value = "新房间号")
    private String newRoomNo;

    @ApiModelProperty(value = "新床位编号")
    private Integer newBedId;

    @ApiModelProperty(value = "旧床位编号")
    private Integer oldBedId;

    @ApiModelProperty(value = "床位使用结束时间")
    private Date endDate;
}
