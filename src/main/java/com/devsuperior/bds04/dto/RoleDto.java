package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.Role;

import java.io.Serializable;

public class RoleDto implements Serializable {

    private Long id;
    private String authority;

    public RoleDto(){
    }

    public RoleDto(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDto(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
