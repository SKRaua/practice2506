package org.skraua.yyzxbackend.pojo;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 房间
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Room", description = "Room实体对象")
public class Room {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房间楼层")
    private String roomFloor;

    @ApiModelProperty(value = "房间号")
    private Integer RoomNo;

    @ApiModelProperty(value = "床位列表")
    @TableField(exist = false)
    private List<Bed> bedList;
}
