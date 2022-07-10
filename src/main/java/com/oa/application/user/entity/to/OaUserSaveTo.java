package com.oa.application.user.entity.to;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OaUserSaveTo implements Serializable {
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
     * 角色信息
     */
    private List<Long> oaRoleVos;
}
