package com.example.oc3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    accUserLogin();
                    finish();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    //Current user Detail
    private void accUserLogin(){
        SharedPreferences _objpref = getSharedPreferences("OC3",MODE_PRIVATE);
        //check login or not
        if(_objpref.getString("token","") != "")
        {
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent login = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(login);
        }

    }
}