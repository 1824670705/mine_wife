package com.oa.domain.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oa.utils.constans.RedisKeyConstant;
import com.oa.utils.other.RequestUtils;
import com.oa.utils.other.ResponseUtils;
import com.oa.utils.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Slf4j
public class LoginUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager loginAuthenticationManager;
    private final RedisTemplate<String, Object> oaRedisTemplate;

    public LoginUsernamePasswordFilter(AuthenticationManager loginAuthenticationManager, RedisTemplate<String, Object> oaRedisTemplate) {
        this.loginAuthenticationManager = loginAuthenticationManager;
        this.oaRedisTemplate = oaRedisTemplate;
        this.setPostOnly(true);
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType()) || "application/json;charset=UTF-8".equals(request.getContentType())) {
            try {
                ServletInputStream loginInfo = request.getInputStream();
                String loginJson = StreamUtils.copyToString(loginInfo, StandardCharsets.UTF_8);
                JSONObject info = JSONObject.parseObject(loginJson);
                String username = info.getString("username");
                String password = info.getString("password");
                log.info("登陆信息\t=>\t用户名：{}密码：{}", username, password);
                return loginAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            log.error("用户信息解析失败\t=>\t{}", request.getContentType());
        }
        return loginAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken("", "", new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        LoginUserDetails principal = (LoginUserDetails) authResult.getPrincipal();
        log.info("认证成功，登陆信息\t=>\t{}", JSON.toJSONString(principal));
        HashOperations<String, Object, Object> opsForHash = oaRedisTemplate.opsForHash();
        // 写入 redis
        opsForHash.put(RedisKeyConstant.userLoginKey, RequestUtils.getIp(request) + ":" + principal.getUsername(), principal);
        ResponseUtils.responseInfoByJson(response, R.success().message("认证成功").data(principal.getToken()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.warn("认证失败");
        ResponseUtils.responseInfoByJson(response, R.error().code(401).message("认证失败"));
    }
}
