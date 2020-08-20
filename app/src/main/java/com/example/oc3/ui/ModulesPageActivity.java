package com.example.oc3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.os.Bundle;
import android.widget.Toast;

import com.example.oc3.HomeActivity;
import com.example.oc3.R;
import com.example.oc3.adapter.ModulesAdapter;
import com.example.oc3.api.auth.ApiClient;
import com.example.oc3.api.main.APICourse;
import com.example.oc3.model.Courses;
import com.example.oc3.model.Datum;
import com.example.oc3.model.Moduels;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModulesPageActivity extends AppCompatActivity {
    RecyclerView MdlRclcVw;
    ModulesAdapter modulesAdapter;
    APICourse apiCourse;
    RecyclerView moduleRecycleView;
    Bundle position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_page);
        position = getIntent().getExtras();
        Integer p = position.getInt("pos");

        String tk = getSharedPreferences("OC3",MODE_PRIVATE).getString("token","");
        String token = "Token "+ tk;
        apiCourse = ApiClient.getClient().create(APICourse.class);
        moduleRecycleView = findViewById(R.id.coursesRecyclerView);

        Call<Moduels> call = apiCourse.getAllModules( token,p
//                "","",1
        );
        call.enqueue(new Callback<Moduels>() {
            @Override
            public void onResponse(Call<Moduels> call, Response<Moduels> response) {
                Moduels modulesLists = response.body();
                getAllModules(modulesLists);
            }

            @Override
            public void onFailure(Call<Moduels> call, Throwable t) {
                Toast.makeText(ModulesPageActivity.this, "No response From server", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void getAllModules(Moduels modulesLists){
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        MdlRclcVw.setLayoutManager(layoutManager);
        modulesAdapter = new ModulesAdapter(this,modulesLists);
        MdlRclcVw.setAdapter(modulesAdapter);
        modulesAdapter.notifyDataSetChanged();


    }
}