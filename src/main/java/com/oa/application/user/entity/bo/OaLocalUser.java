package com.oa.application.user.entity.bo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 地址信息存取
 */
@Data
@TableName("oa_local_user")
public class OaLocalUser implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "local_id", type = IdType.ASSIGN_ID)
    private Long localId;

    /**
     * 地址全程
     */
    private String localFullName;

    /**
     * 地址的code
     */
    private String locallastCode;

    /**
     * 拥有者
     */
    private Long ownerId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除[0删除1没有删除]
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
