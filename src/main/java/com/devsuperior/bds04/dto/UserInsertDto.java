package com.devsuperior.bds04.dto;

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
