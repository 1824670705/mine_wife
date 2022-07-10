package com.oa.domain.security.handler;

import com.oa.application.user.entity.vo.OaRoleVo;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.application.user.service.OaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Resource
    private OaUserService oaUserService;

    @Override
    public UserDetails loadUserByUsername(String userAccess) throws UsernameNotFoundException {
        log.info("用户名字：{}", userAccess);
        // 查询用户名
        OaUserLoginResponseVo userLoginResponseVo = oaUserService.login(userAccess);
        if (ObjectUtils.isEmpty(userLoginResponseVo)) throw new UsernameNotFoundException("用户不存在，检查账户是否输入正确");
        return new LoginUserDetails(userAccess, userLoginResponseVo.getPassword(), null, userLoginResponseVo.getRoles().stream().map(OaRoleVo::getRoleName).collect(Collectors.toList()), userLoginResponseVo.getToken());
    }
}
