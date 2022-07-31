package com.oa.domain.security;

import com.oa.domain.security.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Spring Security Configuration
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OaSpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginUserDetailsService loginUserDetailsService;
    @Resource
    private LoginAccessDeniedHandler loginAccessDeniedHandler;
    @Resource
    private LoginAuthEntryPoint loginAuthEntryPoint;
    @Resource
    private LoginLogOutHandler loginLogOutHandler;
    @Resource
    private RedisTemplate<String, Object> oaRedisTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 异常处理
        http.exceptionHandling().accessDeniedHandler(loginAccessDeniedHandler)
                .authenticationEntryPoint(loginAuthEntryPoint);
        // 访问接口处理处理
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 登陆接口配置
                .and().formLogin().loginPage("/user/login").usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().logoutUrl("/user/loginOut").addLogoutHandler(loginLogOutHandler)
                // 配置不需要授权的接口
                .and().authorizeRequests().antMatchers("/public/**", "/file/upload").permitAll()
                .anyRequest().authenticated();
        http.addFilterAt(new LoginUsernamePasswordFilter(authenticationManager(), oaRedisTemplate), UsernamePasswordAuthenticationFilter.class)
                .addFilter(new LoginAuthFilterHandler(authenticationManager(), oaRedisTemplate));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/public/**", "/file/upload");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
