package org.skraua.yyzxbackend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/23
 * @description 客户信息查询实体对象
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "CustomerInfoDTO", description = "CustomerInfoDTO客户信息查询实体对象")
public class CustomerInfoDTO {
    public class UserDTO {
        @ApiModelProperty(value = "客户编号")
        private Integer customerId;

        @ApiModelProperty(value = "页码")
        private Integer pageSize;
    }
}
