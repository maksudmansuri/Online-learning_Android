package com.example.oc3.api.auth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("accounts/login/")
        @Headers({
                "Accept: application/json",
                "Content-Type: application/x-www-form-urlencoded",
        })
    Call<ResponseBody> getToken(@Field("username") String email,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("accounts/register/")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
    })
    Call<ResponseBody> getSignUpToken(@Field("username") String username,
                                @Field("email") String email,
                                @Field("password") String password,
                                @Field("password2") String password2);

}
