
package com.example.oc3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("pk")
    @Expose
    private Integer pk;
    @SerializedName("course")
    @Expose
    private Integer course;
    @SerializedName("module")
    @Expose
    private String module;
    @SerializedName("module_desc")
    @Expose
    private String moduleDesc;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("created_date")
    @Expose
    private String createdDate;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
