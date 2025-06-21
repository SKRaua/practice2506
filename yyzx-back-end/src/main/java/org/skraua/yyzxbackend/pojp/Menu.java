package org.skraua.yyzxbackend.pojp;

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
 * @description 菜单
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "Menu", description = "Menu实体对象")
public class Menu {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "一级菜单索引")
    private String menusIndex;

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单路径")
    private String path;

    @ApiModelProperty(value = "父级Id")
    private Integer parentId;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<Menu> children;
}
