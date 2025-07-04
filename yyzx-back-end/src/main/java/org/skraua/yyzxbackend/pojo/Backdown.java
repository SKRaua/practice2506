package org.skraua.yyzxbackend.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 退住信息
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Backdown", description = "Backdown实体对象")
public class Backdown implements Serializable  {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "客户id")
    private Integer customerId;

    @ApiModelProperty(value = "退住时间")
    private Date retreattime;

    @ApiModelProperty(value = "退住类型 0-正常退住 1-死亡退住 2-保留床位")
    private Integer retreattype;

    @ApiModelProperty(value = "退住原因")
    private String retreatreason;

    @ApiModelProperty(value = "审批状态 0-已提交 1-同意 2-拒绝")
    private Integer auditstatus;

    @ApiModelProperty(value = "审批人")
    private String auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date audittime;
}