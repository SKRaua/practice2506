package org.skraua.yyzxbackend.vo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 退住信息视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "BackdownVo", description = "BackdownVo视图数据对象")
public class BackdownVo {
    private static final long serialVersionUID = 1L;

    // Backdown
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

    // Bed
    @ApiModelProperty(value = "床位详情（备注）")
    private String bedDetails;

    @ApiModelProperty(value = "床位id")
    private String bedId;

    // Customer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "入住时间")
    private Date checkinDate;
}
