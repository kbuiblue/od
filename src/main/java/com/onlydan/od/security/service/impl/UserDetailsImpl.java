package com.onlydan.od.security.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.entities.Accounts;
import com.onlydan.od.security.entity.RoleAssignment;
import com.onlydan.od.security.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String accountName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImpl build(Accounts userAccount) {
        if (userAccount == null) {
            throw new IllegalArgumentException("userAccount cannot be null");
        }

        Set<RoleAssignment> roleAssignments = userAccount.getRoles();
        if (roleAssignments == null) {
            throw new IllegalArgumentException("roleAssignments cannot be null");
        }

        Set<Roles> roles = userAccount.getRoles()
                .stream()
                .map(RoleAssignment::getRole)
                .collect(Collectors.toSet());

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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
