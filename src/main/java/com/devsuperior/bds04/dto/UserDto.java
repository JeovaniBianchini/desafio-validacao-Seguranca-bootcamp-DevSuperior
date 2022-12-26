package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements Serializable {

    private Long id;
    private String email;

    private Set<RoleDto> roles = new HashSet<>();

    public UserDto(){
    }

    public UserDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDto(User user) {
        id = user.getId();
        email = user.getEmail();
        user.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }
}
