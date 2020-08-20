package com.example.oc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oc3.api.auth.ApiClient;
import com.example.oc3.api.main.APICourse;
import com.example.oc3.model.Courses;
import com.example.oc3.ui.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursePageActivity extends AppCompatActivity {


    ImageView crsPgBck;
    BottomNavigationView navigation;
    APICourse apiCourse;
    TextView crsPgCrsNm,crsPgCrsF;
    Bundle position;
    Button crsPgByNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        crsPgBck = findViewById(R.id.crsPgBck);
        //Get value from previous intent
        position = getIntent().getExtras();
        Integer p = position.getInt("pos");


        String tk = getSharedPreferences("OC3",MODE_PRIVATE).getString("token","");
        String token = "Token "+ tk;
        apiCourse = ApiClient.getClient().create(APICourse.class);
        crsPgCrsNm = findViewById(R.id.crsPgCrsNm);
        crsPgCrsF = findViewById(R.id.crsPgCrsF);

        Call<Courses> call = apiCourse.getAllCourses( token
//                "","",1
        );
        call.enqueue(new Callback<Courses>() {
            @Override
            public void onResponse(Call<Courses> call, Response<Courses> response) {
                Courses courseLists = response.body();
                crsPgCrsNm.setText((courseLists.getResults().get(p).getCourseName()));
                crsPgCrsF.setText((courseLists.getResults().get(p).getCourseDuration()));
            }

            @Override
            public void onFailure(Call<Courses> call, Throwable t) {
                Toast.makeText(CoursePageActivity.this, "No response From server", Toast.LENGTH_LONG).show();
            }
        });
        crsPgByNow = findViewById(R.id.crsPgByNow);

        crsPgByNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ModulesPageActivity.class);
                //Put Value for next intent or Slug
                i.putExtra("pos",p);
                startActivity(i);
            }
        });

        crsPgBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });

        navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.menuhome);
//        nested_content = findViewById(R.id.nested_content);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuhome:
                        return true;
                    case R.id.menusearch:
                        Intent e = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(e);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menufavorite:
                        Intent d = new Intent(getApplicationContext(), FavoriteActivity.class);
                        startActivity(d);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuaccount:
                        Intent c = new Intent(getApplicationContext(), AccountActivity.class);
                        startActivity(c);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mycourse:
                        Intent b = new Intent(getApplicationContext(), MyCourseActivity.class);
                        startActivity(b);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}