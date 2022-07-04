package com.oa.domain.security.handler;

import com.oa.application.user.service.OaUserService;
import com.oa.application.user.vo.OaUserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Slf4j
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Resource
    private OaUserService oaUserService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userAccess) throws UsernameNotFoundException {
        log.info("用户名字：{}", userAccess);
        // 查询用户名
        OaUserLoginVo loginVo = new OaUserLoginVo();
        loginVo.setUsername(userAccess);
//        OaUserLoginResponseVo login = oaUserService.login(loginVo);
        return new LoginUserDetails(userAccess, bCryptPasswordEncoder.encode("root"), null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
}
