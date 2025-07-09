package org.skraua.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@ApiModel(value = "ReimbursementRatioDTO", description = "")
public class ReimbursementCalcDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总费用")
    private BigDecimal totalFee;

    @ApiModelProperty(value = "报销费用")
    private BigDecimal reimbursementAmount;

    @ApiModelProperty(value = "自费费用")
    private BigDecimal selfPayAmount;

    @ApiModelProperty(value = "甲类药品费用（已乘药品报销比例）")
    private BigDecimal drugAFee;

    @ApiModelProperty(value = "乙类药品费用（已乘药品报销比例）")
    private BigDecimal drugBFee;

    @ApiModelProperty(value = "丙类药品费用（已乘药品报销比例）")
    private BigDecimal drugCFee;

    @ApiModelProperty(value = "医疗服务费用")
    private BigDecimal serviceFee;

    @ApiModelProperty(value = "诊疗项目费用")
    private BigDecimal itemFee;

    public ReimbursementCalcDTO(BigDecimal totalFee, BigDecimal reimbursementAmount, BigDecimal selfPayAmount,
            BigDecimal drugAFee, BigDecimal drugBFee, BigDecimal drugCFee,
            BigDecimal serviceFee, BigDecimal itemFee) {
        this.totalFee = totalFee;
        this.reimbursementAmount = reimbursementAmount;
        this.selfPayAmount = selfPayAmount;
        this.drugAFee = drugAFee;
        this.drugBFee = drugBFee;
        this.drugCFee = drugCFee;
        this.serviceFee = serviceFee;
        this.itemFee = itemFee;
    }
}
