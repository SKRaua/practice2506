package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 用户UserDTO
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "UserDTO", description = "UserDTO查询实体对象")
public class UserDTO {
    @ApiModelProperty(value = "真实姓名")
    private String nickname;

    @ApiModelProperty(value = "系统角色编号，（1管理员，2健康管家）")
    private Integer roleId;

    @ApiModelProperty(value = "页码")
    private Integer pageSize;
}
