package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.services.valid.UserInsertValid;

@UserInsertValid
public class UserInsertDto extends UserDto{

    private String password;

    public UserInsertDto(){
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
