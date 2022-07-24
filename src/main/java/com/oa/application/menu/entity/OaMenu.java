package com.oa.application.menu.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oa_menu")
@ApiModel(value = "OaMenu对象", description = "")
public class OaMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键Id")
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private Long menuId;

    @ApiModelProperty(value = "菜单名字")
    private String menuName;

    @ApiModelProperty(value = "菜单父类Id，没有为0")
    private Long parentMenuId;

    /**
     * 全局标志
     * <p>
     * 0：全局，1：个人
     */
    private Integer globalTag;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "0删除，1没删除")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;

    /**
     * 创建者
     */
    private Long createBy;
}
