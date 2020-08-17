package com.example.oc3.api.main;

//import com.example.oc3.api.main.responses.CourseListResponse;
import com.example.oc3.model.CourseResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APICourse {

    @GET("front/list")
//    @FormUrlEncoded
//    getCourseList(
//
//
//    ) CourseListResponse;
    Call<List<CourseList>> getAllCourseList();
//
//    @FormUrlEncoded
//    @GET("front/list")
//    @Headers("Athorization") String token;

}