package com.oa.domain.security.handler;

import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.domain.security.token.TokenUtils;
import com.oa.utils.constans.RedisKeyConstant;
import com.oa.utils.other.RequestUtils;
import com.oa.utils.other.ResponseUtils;
import com.oa.utils.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 鉴权
 */
@Slf4j
public class LoginAuthFilterHandler extends BasicAuthenticationFilter {
    private final RedisTemplate<String, Object> oaRedisTemplate;

    public LoginAuthFilterHandler(AuthenticationManager authenticationManager, RedisTemplate<String, Object> oaRedisTemplate) {
        super(authenticationManager);
        this.oaRedisTemplate = oaRedisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("解析授权信息");
        String token = request.getHeader("token");
        String ip = RequestUtils.getIp(request);
        if (ObjectUtils.isEmpty(token)) {
            ResponseUtils.responseInfoByJson(response, R.error().code(401).message("未登录"));
        } else {
            // 解析 token
            OaUserLoginResponseVo loginResponseVo = TokenUtils.parseToken(token);
            Object userInfo = oaRedisTemplate.opsForHash().get(RedisKeyConstant.userLoginKey, ip + ":" + loginResponseVo.getUserId());
            Assert.notNull(userInfo, "登录信息不存在");
            // 解析角色信息
            List<SimpleGrantedAuthority> roleCollect = loginResponseVo.getRoles().stream().map(v -> new SimpleGrantedAuthority("ROLE_" + v.getRoleName())).collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginResponseVo.getUsername(), token, roleCollect);
            if (!ObjectUtils.isEmpty(authenticationToken)) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            chain.doFilter(request, response);
        }
    }
}
