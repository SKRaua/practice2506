package org.skraua.yyzxbackend.vo;

import java.io.Serializable;
import java.util.List;

import org.skraua.yyzxbackend.pojo.Room;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 床位使用视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CwsyBedVo", description = "CwsyBedVo视图数据对象")
public class BedUsageVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总床位")
    private Integer totalNum;

    @ApiModelProperty(value = "空闲床位")
    private Integer availableNum;

    @ApiModelProperty(value = "有人床位")
    private Integer occupiedNum;

    @ApiModelProperty(value = "外出床位")
    private Integer outwardNum;

    @ApiModelProperty(value = "床位和房间列表")
    private List<Room> roomList;
}
