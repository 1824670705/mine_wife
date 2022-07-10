package com.oa.domain.security;

import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.domain.security.token.TokenUtils;
import com.oa.utils.constans.RedisKeyConstant;
import com.oa.utils.other.RequestUtils;
import com.oa.utils.other.ResponseUtils;
import com.oa.utils.result.R;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 退出登录成功
 */
@Component
public class LoginLogOutHandler implements LogoutHandler {

    @Resource
    private RedisTemplate<String, Object> oaRedisTemplate;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        // 移除 Token 信息
        Optional.ofNullable(httpServletRequest.getHeader("token")).ifPresent(token -> {
            HashOperations<String, Object, Object> opsForHash = oaRedisTemplate.opsForHash();
            OaUserLoginResponseVo userDetails = TokenUtils.parseToken(token);
            // 移除 redis 中的内容
            Optional.ofNullable(userDetails).ifPresent(v -> opsForHash.delete(RedisKeyConstant.userLoginKey, RequestUtils.getIp(httpServletRequest) + ":" + v.getUsername()));
        });
        try {
            ResponseUtils.responseInfoByJson(httpServletResponse, R.success().message("退出登陆成功"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
