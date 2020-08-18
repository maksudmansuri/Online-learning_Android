package com.example.oc3.api.main.responses;

import android.telecom.Call;

import com.example.oc3.model.CourseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CourseListResponse{

    @SerializedName("results")
    @Expose
    private List<CourseResponse> results;

    @SerializedName("detail")
    @Expose
    private String detail;

    public List getResults(){return results;}
    public void setResults(List results){this.results = results; }

    public String getDetail(){return detail;}
    public void setDetail(String detail){this.detail = detail; }

//    toList(){
//        Array CourseList:ArrayList<CourseResponse> = ArrayList()
//                for(courseResponse in results){
//                    CourseList
//                }

//    }

}


