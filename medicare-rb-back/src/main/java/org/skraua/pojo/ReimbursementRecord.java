package org.skraua.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/07/09
 * @description 报销记录实体类
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "ReimbursementRecord", description = "报销记录实体对象")
public class ReimbursementRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "患者ID")
    private Integer patientId;

    @ApiModelProperty(value = "医院ID")
    private Integer hospitalId;

    @ApiModelProperty(value = "总医疗费用")
    private BigDecimal totalMedicalFee;

    @ApiModelProperty(value = "起付金额")
    private BigDecimal deductibleAmount;

    @ApiModelProperty(value = "可报销金额")
    private BigDecimal reimbursableAmount;

    @ApiModelProperty(value = "实际报销金额")
    private BigDecimal reimbursementAmount;

    @ApiModelProperty(value = "自付金额")
    private BigDecimal selfPayAmount;

    @ApiModelProperty(value = "报销比例")
    private BigDecimal reimbursementRatio;

    @ApiModelProperty(value = "报销日期")
    private LocalDateTime reimbursementDate;

    @ApiModelProperty(value = "操作员")
    private String operator;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "住院号")
    private String inpatientNo;

    @ApiModelProperty(value = "工作状态 '在职','退休','无业','学生'")
    private String workStatus;

}