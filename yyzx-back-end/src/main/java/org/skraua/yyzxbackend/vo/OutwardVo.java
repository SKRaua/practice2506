package org.skraua.yyzxbackend.vo;

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
 * @date 2025/06/23
 * @description 外出登记视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "OutwardVo", description = "OutwardVo视图数据对象")
public class OutwardVo implements Serializable {
    private static final long serialVersionUID = 1L;//

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
    private String outgoingreason;

    @ApiModelProperty(value = "外出时间")
    private Date outgoingtime;

    @ApiModelProperty(value = "预计回院时间")
    private Date expectedreturntime;

    @ApiModelProperty(value = "实际回院时间")
    private Date actualreturntime;

    @ApiModelProperty(value = "陪同人")
    private String escorted;

    @ApiModelProperty(value = "陪同人与老人关系")
    private String relation;

    @ApiModelProperty(value = "陪同人电话")
    private String escortedtel;

    @ApiModelProperty(value = "审批状态")
    private Integer auditstatus;

    @ApiModelProperty(value = "审批人")
    private String auditperson;

    @ApiModelProperty(value = "审批时间")
    private Date audittime;

    // User
    @ApiModelProperty(value = "护理人姓名")
    private String nickName;

    @ApiModelProperty(value = "护理人电话号码")
    private String phoneNumber;

    // NurseContent （可能不需要）
    @ApiModelProperty(value = "护理项目编号")
    private String serialNumber;

    @ApiModelProperty(value = "护理项目名称")
    private String nursingName;

    // Custmoer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;
}
