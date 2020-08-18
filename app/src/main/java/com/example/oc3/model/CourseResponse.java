package com.example.oc3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CourseResponse {

    @SerializedName("course_name")
    @Expose
    private String course_name;

    @SerializedName("course_category")
    @Expose
    private String course_category;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("course_subcategory")
    @Expose
    private String course_subcategory;

    @SerializedName("course_video")
    @Expose
    private String course_video;

    @SerializedName("course_requirement")
    @Expose
    private String course_requirement;

    @SerializedName("course_desc")
    @Expose
    private String course_desc;

    @SerializedName("course_why_take")
    @Expose
    private String course_why_take;

    @SerializedName("course_slug")
    @Expose
    private String course_slug;

    @SerializedName("course_level")
    @Expose
    private String course_level;

    @SerializedName("course_duration")
    @Expose
    private Integer course_duration;

    @SerializedName("course_image")
    @Expose
    private String course_image;

    @SerializedName("created_date")
    @Expose
    private String created_date;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("course_fee")
    @Expose
    private Integer course_fee;


    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id; }

    public String getCourse_name(){return course_name;}
    public void setCourse_name(String course_name){this.course_name = course_name; }

    public String getCourse_category(){return course_category;}
    public void setCourse_category(String course_category){this.course_category = course_category; }

    public String getCourse_subcategory(){return course_subcategory;}
    public void setCourse_subcategory(String course_subcategory){this.course_subcategory = course_subcategory; }

    public String getCourse_video(){return course_video;}
    public void setCourse_video(String course_video){this.course_video = course_video; }

    public String getCourse_requirement(){return course_requirement;}
    public void setCourse_requirement(String course_requirement){this.course_requirement = course_requirement; }

    public String getCourse_desc(){return course_desc;}
    public void setCourse_desc(String course_desc){this.course_desc = course_desc; }

    public String getCourse_why_take(){return course_why_take;}
    public void setCourse_why_take(String course_why_take){this.course_why_take = course_why_take; }

    public String getCourse_slug(){return course_slug;}
    public void setCourse_slug(String course_slug){this.course_slug = course_slug; }

    public String getCourse_level(){return course_level;}
    public void setCourse_level(String course_level){this.course_level = course_level; }

    public Integer getCourse_duration(){return course_duration;}
    public void setCourse_duration(Integer course_duration){this.course_duration = course_duration; }

    public String getCourse_image(){return course_image;}
    public void setCourse_image(String course_image){this.course_image = course_image; }

    public String getCreated_date(){return created_date;}
    public void setCreated_date(String created_date){this.created_date = created_date; }

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username; }

    public Integer getCourse_fee(){return course_fee;}
    public void setCourse_fee(Integer course_fee){this.course_fee = course_fee; }

}
