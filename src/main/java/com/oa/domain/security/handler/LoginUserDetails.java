package com.oa.domain.security.handler;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUserDetails implements UserDetails {

    private final String userName;
    private final String password;
    private final String ip;
    private final List<GrantedAuthority> roles;

    public LoginUserDetails(String userName, String password, String ip, List<GrantedAuthority> roles) {
        this.userName = userName;
        this.password = password;
        this.ip = ip;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getIp() {
        return ip;
    }
}
