
package com.example.oc3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("pk")
    @Expose
    private Integer pk;
    @SerializedName("course_name")
    @Expose
    private String courseName;
    @SerializedName("course_category")
    @Expose
    private Integer courseCategory;
    @SerializedName("course_subcategory")
    @Expose
    private Integer courseSubcategory;
    @SerializedName("course_video")
    @Expose
    private Object courseVideo;
    @SerializedName("course_requirement")
    @Expose
    private Object courseRequirement;
    @SerializedName("course_desc")
    @Expose
    private String courseDesc;
    @SerializedName("course_why_take")
    @Expose
    private Object courseWhyTake;
    @SerializedName("course_slug")
    @Expose
    private String courseSlug;
    @SerializedName("course_level")
    @Expose
    private String courseLevel;
    @SerializedName("course_image")
    @Expose
    private String courseImage;
    @SerializedName("course_duration")
    @Expose
    private String courseDuration;
    @SerializedName("course_fee")
    @Expose
    private Integer courseFee;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(Integer courseCategory) {
        this.courseCategory = courseCategory;
    }

    public Integer getCourseSubcategory() {
        return courseSubcategory;
    }

    public void setCourseSubcategory(Integer courseSubcategory) {
        this.courseSubcategory = courseSubcategory;
    }

    public Object getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(Object courseVideo) {
        this.courseVideo = courseVideo;
    }

    public Object getCourseRequirement() {
        return courseRequirement;
    }

    public void setCourseRequirement(Object courseRequirement) {
        this.courseRequirement = courseRequirement;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Object getCourseWhyTake() {
        return courseWhyTake;
    }

    public void setCourseWhyTake(Object courseWhyTake) {
        this.courseWhyTake = courseWhyTake;
    }

    public String getCourseSlug() {
        return courseSlug;
    }

    public void setCourseSlug(String courseSlug) {
        this.courseSlug = courseSlug;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Integer getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Integer courseFee) {
        this.courseFee = courseFee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
