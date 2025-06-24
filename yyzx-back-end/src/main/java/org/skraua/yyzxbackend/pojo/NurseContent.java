package org.skraua.yyzxbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 护理项目
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "NurseContent", description = "NurseContent实体对象")
public class NurseContent {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "编号")
    private String serialNumber;

    @ApiModelProperty(value = "名称")
    private String nursingName;

    @ApiModelProperty(value = "价格")
    private String servicePrice;

    @ApiModelProperty(value = "描述")
    private String message;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "执行周期")
    private String executionCycle;

    @ApiModelProperty(value = "执行次数")
    private String executionTimes;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;
}
