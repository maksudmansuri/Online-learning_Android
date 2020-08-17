package com.example.oc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.oc3.api.auth.ApiClient;
import com.example.oc3.api.auth.TokenResponse;
import com.example.oc3.api.main.APICourse;
import com.example.oc3.api.main.CourseList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    APICourse apiCourse;
//    NestedScrollView nested_content;
    boolean isNavigationHide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        String ResponseJson = response.body().string();
//        Gson objGson = new Gson();
//        TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
//        getSharedPreferences("OC3",MODE_PRIVATE).edit().putString("token",objResp.getToken()).commit();
        apiCourse = ApiClient.getClient().create(APICourse.class);
        Call<List<CourseList>> call = apiCourse.getAllCourseList(sharedPreferences.getString("token"));

        call.enqueue(new Callback<List<CourseList>>() {
            @Override
            public void onResponse(Call<List<CourseList>> call, Response<List<CourseList>> response) {

                List<CourseList> courseLists = response.body();
                List<CourseList> courseLists1 = response.body();

            }

            @Override
            public void onFailure(Call<List<CourseList>> call, Throwable t) {

                Toast.makeText(HomeActivity.this, "No response From server", Toast.LENGTH_SHORT).show();
            }
        });



//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_home_24), 0);
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_youtube_searched_for_24), 1);
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_favorite_24), 2);
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_account_circle_24), 3);
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_baseline_home_24), 4);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()){
//                    case 0:
//                        Toast.makeText(HomeActivity.this,"Home Page",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//                        Toast.makeText(HomeActivity.this,"Search Page",Toast.LENGTH_SHORT).show();
//                        break ;
//                    case 2:
//                        Toast.makeText(HomeActivity.this,"favorite Page",Toast.LENGTH_SHORT).show();
//                        break ;
//                    case 3:
//                        Toast.makeText(HomeActivity.this,"Account Page",Toast.LENGTH_SHORT).show();
//                        break ;
//                    case 4:
//                        Toast.makeText(HomeActivity.this,"Home Page1",Toast.LENGTH_SHORT).show();
//                        break ;
//                }
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

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
        //navigation animation updown hide and unhide
//        nested_content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                if(scrollY < oldScrollY){
//                    animateNavigation(false);
//               FR589OLM M }nm
//                if(scrollY > oldScrollY){
//                    animateNavigation(true);
//                }
//
//            }
//        });
    }

//    //function for animation bottom navigation
//    private void animateNavigation(final boolean hide){
//
//        if(isNavigationHide && hide || !isNavigationHide && !hide) return;
//        isNavigationHide = hide;
//
//        int movey = hide?(2*navigation.getHeight()):0;
//        navigation.animate().translationY(movey).setStartDelay(100).setDuration(300).start();
//    }

}