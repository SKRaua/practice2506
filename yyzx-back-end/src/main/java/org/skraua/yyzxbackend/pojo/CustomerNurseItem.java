package org.skraua.yyzxbackend.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 顾客护理项目
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Customernurseitem", description = "Customernurseitem实体对象")
@TableName("customernurseItem") // 显式指定表名
public class CustomerNurseItem implements Serializable {
    private static final long serialVersionUID = 1L;

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
}