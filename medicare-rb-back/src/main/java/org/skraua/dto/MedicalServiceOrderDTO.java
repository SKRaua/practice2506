package org.skraua.dto;

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
 * @date 2025/07/09
 * @description MedicalServiceOrderDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "MedicalServiceOrderDTO", description = "MedicalServiceOrderDTO")
public class MedicalServiceOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "患者ID")
    private Integer patientId;

    @ApiModelProperty(value = "项目ID（关联药品、服务或诊疗项目）")
    private Integer itemId;

    @ApiModelProperty(value = "开单时间")
    private Date orderTime;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "执行状态（'未执行','执行中','已执行','取消'）")
    private String executeStatus;

    @ApiModelProperty(value = "执行时间")
    private Date executeTime;

    @ApiModelProperty(value = "开单医生姓名")
    private String doctorName;

    @ApiModelProperty(value = "执行护士姓名")
    private String nurseName;

    @ApiModelProperty(value = "页码")
    private Integer page;
}