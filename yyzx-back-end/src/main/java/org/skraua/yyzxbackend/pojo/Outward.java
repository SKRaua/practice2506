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
 * @description 外出
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Outward", description = "Outward实体对象")
public class Outward implements Serializable {
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

    @ApiModelProperty(value = "外出事由")
    private String outgoingReason;

    @ApiModelProperty(value = "外出时间")
    private Date outgoingTime;

    @ApiModelProperty(value = "预计回院时间")
    private Date expectedReturnTime;

    @ApiModelProperty(value = "实际回院时间")
    private Date actualReturnTime;

    @ApiModelProperty(value = "陪同人")
    private String escorted;

    @ApiModelProperty(value = "陪同人与老人关系")
    private String relation;

    @ApiModelProperty(value = "陪同人电话")
    private String escortedTel;

    @ApiModelProperty(value = "审批状态")
    private Integer auditStatus;

    @ApiModelProperty(value = "审批人")
    private String auditPerson;

    @ApiModelProperty(value = "审批时间")
    private Date auditTime;
}
