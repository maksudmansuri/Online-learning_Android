package com.example.oc3.api.main;

//import com.example.oc3.api.main.responses.CourseListResponse;
import android.media.session.MediaSession;

import com.example.oc3.api.main.responses.CourseListResponse;
import com.example.oc3.model.CourseResponse;
import com.example.oc3.model.Courses;
import com.example.oc3.model.Datum;
import com.example.oc3.model.Moduels;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APICourse {
//    @FormUrlEncoded
    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded",
    })
    @GET("front/list")
    Call<Courses> getAllCourses(@Header("Authorization") String token
//            @Query("search") String query,
//            @Query("ordering") String ordering,
//            @Query("page")Integer page
    );

    @GET("front/module/{id}/")
    Call<Moduels> getAllModules(@Header("Authorization") String token,@Path("id") Integer id
//            @Query("search") String query,
//            @Query("ordering") String ordering,
//            @Query("page")Integer page
    );

}