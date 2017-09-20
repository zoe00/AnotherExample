package com.example.zoe.test.rest;

import com.example.zoe.test.entity.data.UserRequestParams;
import com.example.zoe.test.entity.data.UserResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {

    @POST("user/login")
    Single<UserResponse> login(@Body UserRequestParams requestParams);
}
