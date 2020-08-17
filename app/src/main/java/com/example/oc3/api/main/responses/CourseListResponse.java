package com.example.oc3.api.main.responses;

import com.example.oc3.api.main.CourseList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class CourseListResponse{

    @SerializedName("results")
    @Expose
    private List<CourseList> results;

    @SerializedName("detail")
    @Expose
    private String detail;


    }


