package com.example.ttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.TabItem;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

public class Bar_test extends AppCompatActivity {
    private FragmentTransaction transaction;
    TabItem tabItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_test);

        tabItem = findViewById(R.id.tab_camera);
        BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new BlankFragment());
                        break;
                    case R.id.tab_images:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new BlankFragment2());
                        break;
                    case R.id.tab_camera:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new BlankFragment3());
                        break;
                    case R.id.tab_products:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new BlankFragment4());

                        break;
                    case R.id.tab_more:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new BlankFragment5());
                        break;
                }
                transaction.commit();
            }
        });
    }
}
