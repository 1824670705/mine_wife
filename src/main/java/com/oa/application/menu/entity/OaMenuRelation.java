package com.oa.application.menu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("oa_menu_relation")
public class OaMenuRelation implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "menu_rel_id", type = IdType.ASSIGN_ID)
    private Long menuRelId;

    /**
     * 字典 id
     */
    private Long menuId;

    /**
     * 外部Id
     */
    private Long outId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
