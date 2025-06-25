package org.skraua.yyzxbackend.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 顾客护理项目视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomernurseitemVo", description = "CustomernurseitemVo视图数据对象")
public class CustomerNurseItemVo implements Serializable {
    private static final long serialVersionUID = 1L;

    // Customernurseitem
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户项目编号")
    private Integer itemId;

    @ApiModelProperty(value = "客户id")
    @TableField(value = "custormer_id") // 数据库错字，适配性修改
    private Integer customerId;

    @ApiModelProperty(value = "护理级别编号")
    private Integer levelId;

    @ApiModelProperty(value = "购买数量")
    private Integer nurseNumber;

    @ApiModelProperty(value = "逻辑删除标记 0-显示 1-隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "购买服务日期")
    private Date buyTime;

    @ApiModelProperty(value = "服务到期日期")
    private Date maturityTime;

    // Customer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    // NurseContent
    @ApiModelProperty(value = "项目编号")
    private String serialNumber;

    @ApiModelProperty(value = "项目名称")
    private String nursingName;

    @ApiModelProperty(value = "项目价格")
    private String servicePrice;

}