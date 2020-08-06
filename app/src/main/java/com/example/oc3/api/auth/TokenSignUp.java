package com.example.oc3.api.auth;

import com.google.gson.annotations.SerializedName;

public class TokenSignUp {
    @SerializedName("token")
    private String token;

    @SerializedName("email")
    private String email;

    @SerializedName("pk")
    private Integer pk;

    @SerializedName("response")
    private String response;

    @SerializedName("username")
    private String username;

    public TokenSignUp(){

    }
    public void setToken(String token) { this.token = token; }

    public void setEmail(String email ) { this.email = email; }

    public void setPk(Integer pk) { this.pk = pk; }

    public void getResponse(String response) { this.response = response; }

    public void getUsername(String username) { this.response = username; }

    public String getToken(){return token; }

    public String getEmail(){return email; }

    public String getResponse(){return response; }

    public Integer getPk(){return pk; }

    public String getUsername(){return username; }
}
