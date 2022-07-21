package com.oa.utils.other;

import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.domain.security.handler.LoginUserDetails;
import com.oa.domain.security.token.TokenUtils;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 登录信息用户工具
 *
 * @author L
 */
public class LoginUserInfoUtils {

    /**
     * 获取当前登陆人信息
     *
     * @return 用户信息
     */
    public static OaUserLoginResponseVo getLoginUser() {
        String token = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
        return TokenUtils.parseToken(token);
    }

    /**
     * 获取当前登陆人 Id
     *
     * @return Long 类型的用户 Id
     */
    public static Long getLoginUserId() {
        return getLoginUser().getUserId();
    }
}
