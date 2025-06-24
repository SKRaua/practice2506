package org.skraua.yyzxbackend.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhou Xinyang
 * @date 2025/06/21
 * @description 关联护理 级别-项目
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Nurselevelitem", description = "Nurselevelitem实体对象")
public class NurseLevelItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "关联护理级别")
    private Integer levelId;

    @ApiModelProperty(value = "关联护理项目")
    private Integer itemId;
}
