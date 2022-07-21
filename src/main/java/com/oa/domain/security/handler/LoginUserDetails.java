package com.oa.domain.security.handler;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LoginUserDetails implements UserDetails, Serializable {

    private String userName;
    private String password;
    @Getter
    private String token;
    private String ip;
    private List<String> roles;

    public LoginUserDetails() {
    }

    public LoginUserDetails(String userName, String password, String ip, List<String> roles, String token) {
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.ip = ip;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
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
