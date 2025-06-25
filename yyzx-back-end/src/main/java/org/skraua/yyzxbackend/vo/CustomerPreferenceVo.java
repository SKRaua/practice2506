package org.skraua.yyzxbackend.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 顾客偏好视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerPreferenceVo", description = "CustomerPreferenceVo视图数据对象")
public class CustomerPreferenceVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户id")
    private Integer customerId;

    @ApiModelProperty(value = "饮食喜好")
    private String preferences;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "逻辑删除标记 0-显示 1-隐藏）")
    private Integer isDeleted;

    // Customer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别 0-男 1-女")
    private Integer customerSex;
}
