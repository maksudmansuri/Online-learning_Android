package com.example.oc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.oc3.adapter.CourseAdapter;
import com.example.oc3.api.auth.ApiClient;
import com.example.oc3.api.main.APICourse;
import com.example.oc3.model.Courses;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    RecyclerView coursesRecyclerView;
    RecyclerView catCoursesRecyclerView1;
    RecyclerView catCoursesRecyclerView2;
    RecyclerView catCoursesRecyclerView3;
    CourseAdapter courseAdapter;
    BottomNavigationView navigation;
    SharedPreferences sharedPreferences;
    APICourse apiCourse;
//    NestedScrollView nested_content;
    boolean isNavigationHide = false;
    String query = "";
    String order = "";
    Integer page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        String ResponseJson = response.body().string();
//        Gson objGson = new Gson();
//        TokenResponse objResp = objGson.fromJson(ResponseJson,TokenResponse.class);
//        getSharedPreferences("OC3",MODE_PRIVATE).edit().putString("token",objResp.getToken()).commit();
//        = sharedPreferences.getString("token","");
        String tk = getSharedPreferences("OC3",MODE_PRIVATE).getString("token","");
        String token = "Token "+ tk;
        apiCourse = ApiClient.getClient().create(APICourse.class);
        coursesRecyclerView = findViewById(R.id.coursesRecyclerView);
//        catCoursesRecyclerView1 = findViewById(R.id.catCourseRecycleView1);
//        catCoursesRecyclerView2 = findViewById(R.id.catCourseRecycleView2);
//        catCoursesRecyclerView3 = findViewById(R.id.catCourseRecycleView3);

        Call<Courses> call = apiCourse.getAllCourses( token
//                "","",1
        );
        call.enqueue(new Callback<Courses>() {
            @Override
            public void onResponse(Call<Courses> call, Response<Courses> response) {
//                System.out.println("onResponse");
//                System.out.println(response.body().toString());
                Courses courseLists = response.body();
                getAllCourses(courseLists);

            }

            @Override
            public void onFailure(Call<Courses> call, Throwable t) {

//                System.out.println("onResponse");
//                System.out.println(t.fillInStackTrace());
                Toast.makeText(HomeActivity.this, "No response From server", Toast.LENGTH_LONG).show();
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


    private void getAllCourses(Courses courseLists){

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        RecyclerView.LayoutManager layoutManager1 = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
//        RecyclerView.LayoutManager layoutManager2 = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
//        RecyclerView.LayoutManager layoutManager3 = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        coursesRecyclerView.setLayoutManager(layoutManager);
//        catCoursesRecyclerView1.setLayoutManager(layoutManager1);
//        catCoursesRecyclerView2.setLayoutManager(layoutManager2);
//        catCoursesRecyclerView3.setLayoutManager(layoutManager3);

        courseAdapter = new CourseAdapter(this,courseLists);
        coursesRecyclerView.setAdapter(courseAdapter);
//        catCoursesRecyclerView1.setAdapter(courseAdapter);
//        catCoursesRecyclerView2.setAdapter(courseAdapter);
//        catCoursesRecyclerView3.setAdapter(courseAdapter);
        courseAdapter.notifyDataSetChanged();
    }

}