package com.oa.application.user.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户登陆返回登陆信息
 */
@Data
public class OaUserLoginResponseVo implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 账户信息
     */
    private String account;

    /**
     * 用户 Id
     */
    private Long userId;

    /**
     * 登陆 Token
     */
    private String token;

    /**
     * 角色信息
     */
    private List<OaRoleVo> password;
}
