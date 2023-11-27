package org.java.finalprove.photoalbum.security;

import org.java.finalprove.photoalbum.model.Role;
import org.java.finalprove.photoalbum.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DatabaseUserDetails implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    ///////////// CONSTRUCTORS /////////////
    public DatabaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getEmail();
        this.password = user.getPassword();
        authorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            this.authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
    }


    ///////////// GETTERS /////////////
    public Integer getId() {
        return id;
    }

    ///////////// METHODS /////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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



}

