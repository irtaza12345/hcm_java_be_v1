package com.conurets.hcm.security.model;

import com.conurets.hcm.base.util.HCMConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author MSA
 * @version 1.0
 */

public class CustomUserDetails implements UserDetails {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String role;
    private String designation;
    private Long organizationId;
    private String organizationName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Boolean isAccountNonExpired;
    @JsonIgnore
    private Boolean isAccountNonLocked;
    @JsonIgnore
    private Boolean isCredentialsNonExpired;
    @JsonIgnore
    private Boolean isEnabled;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    public CustomUserDetails(Long userId, String firstName, String lastName, String username,
                             String password, String role, String designation, Long organizationId,
                             String organizationName, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.designation = designation;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.isAccountNonExpired = Boolean.TRUE;
        this.isAccountNonLocked = Boolean.TRUE;
        this.isCredentialsNonExpired = Boolean.TRUE;
        this.isEnabled = Boolean.TRUE;
        this.authorities = authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return firstName + HCMConstants.Common.SC_SPACE + lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDesignation() {
        return designation;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @JsonIgnore
    public boolean isEnabled() {
        return isEnabled;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
