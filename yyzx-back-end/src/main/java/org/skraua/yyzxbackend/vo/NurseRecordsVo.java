package org.skraua.yyzxbackend.vo;

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
 * @description 护理记录视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "NurseRecordsVo", description = "NurseRecordsVo视图数据对象")
public class NurseRecordsVo {
    private static final long serialVersionUID = 1L;

    // NurseRecord
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "客户id")
    private Integer customerId;

    @ApiModelProperty(value = "护理记录id")
    private Integer itemId;

    @ApiModelProperty(value = "护理时间")
    private Date nursingTime;

    @ApiModelProperty(value = "护理内容")
    private String nursingContent;

    @ApiModelProperty(value = "护理数量")
    private Integer nursingCount;

    @ApiModelProperty(value = "护理人员id")
    private Integer userId;

    // User
    @ApiModelProperty(value = "护理人姓名")
    private String nickName;

    @ApiModelProperty(value = "护理人电话号码")
    private String phoneNumber;

    // NurseContent
    @ApiModelProperty(value = "护理项目编号")
    private String serialNumber;

    @ApiModelProperty(value = "护理项目名称")
    private String nursingName;

}
