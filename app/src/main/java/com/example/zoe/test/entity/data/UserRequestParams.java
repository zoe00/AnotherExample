package com.example.zoe.test.entity.data;

import android.support.annotation.NonNull;

public class UserRequestParams {

    @NonNull
    private String email;

    @NonNull
    private String pwd;

    public UserRequestParams(String email, String password){
        this.email = email;
        this.pwd = password;
    }
}
