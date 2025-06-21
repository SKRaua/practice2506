package org.skraua.yyzxbackend.pojp;

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
 * @description 床位详情
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Beddetails", description = "Beddetails实体对象")
public class Beddetails {
    private static final long serialVersionUID = 1L;

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
}
