package com.example.oc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.menusearch);
//        nested_content = findViewById(R.id.nested_content);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuhome:
                        Intent a = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(a);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menusearch:
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
//                }
//                if(scrollY > oldScrollY){
//                    animateNavigation(true);
//                }
//
//            }
//        });
    }
}