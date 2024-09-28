package com.cinderhk.litemusic.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 根据用户类型设置权限
        return Collections.singletonList(new SimpleGrantedAuthority("role" + user.getType()));
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 默认为true，可以根据业务逻辑调整
    }

    @Override
    public boolean isAccountNonLocked() {
        return !"locked".equals(user.getStatus()); // 假设status字段表示账户是否锁定
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 默认为true，可以根据业务逻辑调整
    }

    @Override
    public boolean isEnabled() {
        return !"disabled".equals(user.getStatus()); // 假设status字段表示账户是否启用
    }
}