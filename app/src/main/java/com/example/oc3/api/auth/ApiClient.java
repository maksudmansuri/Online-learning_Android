package com.example.oc3.api.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL ="http://aptechlearning.herokuapp.com/api/";
    private static Retrofit retrofit = null;

    public  static Retrofit getClient(){
        if (retrofit==null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();
                    Request.Builder builder = originalRequest.newBuilder().header("Authorization", Credentials.basic("email","password"));
                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
//                    .setClient(new okClient(okHttpClient))
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }

        return retrofit;
    }


}
