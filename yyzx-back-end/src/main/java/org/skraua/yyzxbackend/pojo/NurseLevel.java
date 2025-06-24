package org.skraua.yyzxbackend.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 护理级别
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Nurselevel", description = "Nurselevel实体对象")
public class NurseLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "护理级别")
    private String levelName;

    @ApiModelProperty(value = "级别状态 启用1，停用2")
    private Integer levelStatus;
}
