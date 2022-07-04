package com.oa.domain.security.handler;

import com.oa.utils.other.ResponseUtils;
import com.oa.utils.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * 鉴权
 */
@Slf4j
public class LoginAuthFilterHandler extends BasicAuthenticationFilter {

    public LoginAuthFilterHandler(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("解析授权信息");
        String token = request.getHeader("token");
        if (ObjectUtils.isEmpty(token)) {
            ResponseUtils.responseInfoByJson(response, R.error().code(401).message("未登录"));
        } else {
            // 解析 token
            // 解析角色信息
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("root", token, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
            if (!ObjectUtils.isEmpty(authenticationToken)) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            chain.doFilter(request, response);
        }
    }
}
