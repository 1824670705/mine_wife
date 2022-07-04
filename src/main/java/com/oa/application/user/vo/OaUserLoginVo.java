package com.oa.application.user.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OaUserLoginVo implements Serializable {

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 手机验证码
     */
    private String mobileCode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 验证码
     */
    private String validateCode;
}
