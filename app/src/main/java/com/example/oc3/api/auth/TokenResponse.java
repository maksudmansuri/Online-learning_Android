package com.example.oc3.api.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("token")
    private String token;

    @SerializedName("email")
    private String email;

    @SerializedName("pk")
    private Integer pk;

    @SerializedName("response")
    private String response;

    public TokenResponse(){

    }
    public void setToken(String token) { this.token = token; }

    public void setEmail(String email ) { this.email = email; }

    public void setPk(Integer pk) { this.pk = pk; }

    public void getResponse(String response) { this.response = response; }

    public String getToken(){return token; }

    public String getEmail(){return email; }

    public String getResponse(){return response; }

    public Integer getPk(){return pk; }

}
