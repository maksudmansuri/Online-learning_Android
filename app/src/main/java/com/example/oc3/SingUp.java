package com.example.oc3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oc3.api.auth.APIService;
import com.example.oc3.api.auth.ApiClient;
import com.example.oc3.api.auth.TokenResponse;
import com.example.oc3.api.auth.TokenSignUp;
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUp extends AppCompatActivity {
    TextView singin;
    EditText signupUserNameEditText,signupEmailEditText,signupPasswordeditText,signupPasswordeditText2;
    Button signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        signup_button = (Button)findViewById(R.id.signup_button);
        signupEmailEditText = (EditText) findViewById(R.id.signupEmailEditText);
        signupUserNameEditText = (EditText) findViewById(R.id.signupUserNameEditText);
        signupPasswordeditText = (EditText) findViewById(R.id.signupPasswordeditText);
        signupPasswordeditText2 = (EditText) findViewById(R.id.signupPasswordeditText2);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallSignupService();
            }
        });
        singin = findViewById(R.id.sing_up);
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SingUp.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
    private void CallSignupService(){

        try {
            final String username = signupUserNameEditText.getText().toString();
            final String password = signupPasswordeditText.getText().toString();
            final String email = signupEmailEditText.getText().toString();
            final String password2 = signupPasswordeditText2.getText().toString();

            APIService service = ApiClient.getClient().create(APIService.class);
            Call<ResponseBody> srvLogin = service.getSignUpToken(username,email,password,password2);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try{
                            String ResponseJson = response.body().string();
                            Gson objGson2 = new Gson();
                            TokenSignUp objResp = objGson2.fromJson(ResponseJson,TokenSignUp.class);
                            Toast.makeText(SingUp.this, objResp.getResponse(), Toast.LENGTH_SHORT).show();
//                            getSharedPreferences("OC3",MODE_PRIVATE).edit().putString("token",objResp.getToken()).commit();
                            Intent a = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(a);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(SingUp.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(SingUp.this, "System Error occured:"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(SingUp.this, "System error occured, Please check your internet Connection", Toast.LENGTH_SHORT).show();
        }

    }


}