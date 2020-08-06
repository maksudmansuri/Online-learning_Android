package com.example.oc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigation;
//    NestedScrollView nested_content;
    boolean isNavigationHide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
//        nested_content = findViewById(R.id.nested_content);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuhome:
                        homepage();
                        return true;
                    case R.id.menusearch:
                        searchpage();
                        Toast.makeText(HomeActivity.this,"Search Page",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menufavorite:
                        favoritepage();
                        Toast.makeText(HomeActivity.this,"favorite Page",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuaccount:
                        accountpage();
                        Toast.makeText(HomeActivity.this,"Account Page",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.mycourse:
                        mycoursepage();
                        Toast.makeText(HomeActivity.this,"MyCourse Page",Toast.LENGTH_SHORT).show();
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
//                }
//                if(scrollY > oldScrollY){
//                    animateNavigation(true);
//                }
//
//            }
//        });
    }
    private void homepage(){
        Intent a = new Intent(HomeActivity.this, HomeActivity.class);
        startActivity(a);
    }
    private void mycoursepage(){
        Intent b = new Intent(HomeActivity.this, SingUp.class);
        startActivity(b);
    }
    private void accountpage(){
        Intent c = new Intent(HomeActivity.this, SingUp.class);
        startActivity(c);
    }
    private void favoritepage(){
        Intent d = new Intent(HomeActivity.this, SingUp.class);
        startActivity(d);
    }
    private void searchpage(){
        Intent e = new Intent(HomeActivity.this, SingUp.class);
        startActivity(e);
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