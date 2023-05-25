package com.onlydan.od.security.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.security.entities.RoleAssignment;
import com.onlydan.od.security.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@EqualsAndHashCode
public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String accountName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Accounts userAccount) {
        List<Roles> roles = userAccount.getRoles()
                .stream()
                .map(RoleAssignment::getRole)
                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                userAccount.getAccountId(),
                userAccount.getAccountName(),
                userAccount.getAccountPassword(),
                authorities
        );
    }

    @Override
    public String getUsername() {
        return accountName;
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
