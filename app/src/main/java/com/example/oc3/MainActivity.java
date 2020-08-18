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
import com.google.gson.Gson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView signup;
    EditText inputUserNameEditText,passwordEditText;
    Button signin_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin_button = findViewById(R.id.signup_button);
        inputUserNameEditText = findViewById(R.id.signupEmailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallLoginService();
            }
        });


        signup = findViewById(R.id.sing_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SingUp.class);
                startActivity(i);
            }
        });
    }


    private void CallLoginService(){

        try {
            final String username = inputUserNameEditText.getText().toString();
            final String password = passwordEditText.getText().toString();

            APIService service = ApiClient.getClient().create(APIService.class);
            Call<ResponseBody> srvLogin = service.getToken(username, password);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try{
                            String ResponseJson = response.body().string();
                            Gson objGson = new Gson();
                            TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
                            getSharedPreferences("OC3",MODE_PRIVATE).edit().putString("token",objResp.getToken()).commit();
//                            Toast.makeText(MainActivity.this, objResp.getResponse(), Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(a);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "System Error occured:"+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "System error occured, Please check your insternet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}