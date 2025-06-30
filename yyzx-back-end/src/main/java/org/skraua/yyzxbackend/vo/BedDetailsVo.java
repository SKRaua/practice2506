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
 * @description 床位信息视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "BedDetails", description = "BedDetails视图数据对象")
public class BedDetailsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    // BedDetails
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "床位起始时间")
    private Date startDate;

    @ApiModelProperty(value = "床位结束时间")
    private Date endDate;

    @ApiModelProperty(value = "床位详细信息")
    private String bedDetails;

    @ApiModelProperty(value = "客户id")
    private Integer customerId;

    @ApiModelProperty(value = "床位id")
    private Integer bedId;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;

    // Custmoer
    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客性别 0-男 1-女")
    private Integer customerSex;

}
