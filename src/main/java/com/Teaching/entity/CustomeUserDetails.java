package com.Teaching.entity;

import com.Teaching.Student.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomeUserDetails implements UserDetails {

    private Student user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        HashSet<SimpleGrantedAuthority> set=new HashSet<>();
        set.add(new SimpleGrantedAuthority(this
                .user.getRole()));
        return set;
    }



    public CustomeUserDetails(Student user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
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
