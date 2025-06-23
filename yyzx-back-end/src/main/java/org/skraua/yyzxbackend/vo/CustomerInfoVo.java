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
 * @description 顾客信息视图数据对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerInfoVo", description = "CustomerInfoVo视图数据对象")
public class CustomerInfoVo {
    private static final long serialVersionUID = 1L;

    // Customer
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标记 0-显示 1-隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "顾客姓名")
    private String customerName;

    @ApiModelProperty(value = "顾客年龄")
    private Integer customerAge;

    @ApiModelProperty(value = "顾客性别 0-男 1-女")
    private Integer customerSex;

    @ApiModelProperty(value = "身份证号")
    private String idcard;

    @ApiModelProperty(value = "房间号")
    private String roomNo;

    @ApiModelProperty(value = "所属楼栋号")
    private String buildingNo;

    @ApiModelProperty(value = "入住时间")
    private Date checkinDate;

    @ApiModelProperty(value = "合同到期时间")
    private Date expirationDate;

    @ApiModelProperty(value = "联系电话")
    private String contactTel;

    @ApiModelProperty(value = "床号")
    private Integer bedId;

    @ApiModelProperty(value = "身心状况")
    private String psychosomaticState;

    @ApiModelProperty(value = "注意事项")
    private String attention;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "身高")
    private String height;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "血型")
    private String bloodType;

    @ApiModelProperty(value = "头像路径")
    private String filepath;

    @ApiModelProperty(value = "管理健康管家id 无id管家为-1")
    private Integer userId;

    @ApiModelProperty(value = "护理等级")
    private Integer levelId;

    @ApiModelProperty(value = "家属")
    private String familyMember;

    // User 管家信息
    @ApiModelProperty(value = "护工姓名")
    private String nickName;

    // Nurselevel 护理级别
    @ApiModelProperty(value = "护理级别")
    private String levelName;

    // bed 床号
    @ApiModelProperty(value = "床位号（字符串完整号码）")
    private String BedNo;
}