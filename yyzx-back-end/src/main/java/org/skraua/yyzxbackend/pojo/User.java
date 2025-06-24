package org.skraua.yyzxbackend.pojo;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 用户
 */
@Data
@EqualsAndHashCode // 自动生成equals和hashCode方法
@ApiModel(value = "User对象", description = "User实体对象")
public class User {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time") // 驼峰 <-> 全小写下划线 可自动转换
    private Date createTime;

    @ApiModelProperty(value = "创建者")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除标记，（0显示，1隐藏）")
    private Integer isDeleted;

    @ApiModelProperty(value = "真实姓名")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别（0女，1男")
    private Integer sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "系统角色编号，（1管理员，2健康管家）")
    private Integer roleId;

    // 一个角色有多个菜单
    @ApiModelProperty(value = "角色菜单")
    @TableField(exist = false)
    private List<Menu> menusList;
}
