
package com.example.oc3.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Courses {

//    @SerializedName("count")
//    @Expose
//    private Integer count;
//    @SerializedName("next")
//    @Expose
//    private Object next;
//    @SerializedName("previous")
//    @Expose
//    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Result> results ;

//    public Integer getCount() {
//        return count;
//    }
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public Object getNext() {
//        return next;
//    }
//
//    public void setNext(Object next) {
//        this.next = next;
//    }
//
//    public Object getPrevious() {
//        return previous;
//    }
//
//    public void setPrevious(Object previous) {
//        this.previous = previous;
//    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
