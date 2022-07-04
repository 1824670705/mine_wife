package com.oa.application.user.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("oa_user")
public class OaUser implements Serializable {

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 账户
     */
    private String account;

    /**
     * 地区信息
     */
    private String locationId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 权限 Id
     */
    private Long authorityId;

    /**
     * 角色 Id
     */
    private Long roleId;

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
     * 逻辑删除
     * [0删除1没有删除]
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
