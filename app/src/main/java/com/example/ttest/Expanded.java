package com.example.ttest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ttest.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Expanded extends AppCompatActivity {
    RecyclerView MainCatRecycler,Sub_cat_recycler,ListImagesRecycler,recyclerViewComments,recyclerViewComments1,SubResaultAdapteRecycler;
    TextView Cat_name,title_name;
    AppCompatImageView btnBack,arrow_details,full_image;
    RelativeLayout layout_des;
    CardView card_details;
    LinearLayoutCompat drop_des,child_layout;
    FrameLayout video_view_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded);

        layout_des = findViewById(R.id.layout_des);
        card_details = findViewById(R.id.card_details);
        drop_des = findViewById(R.id.drop_des);
        arrow_details = findViewById(R.id.arrow_details);

        List<String> data = new ArrayList();
        for (int i = 1; i <= 20; i++) {
            data.add("Item " + i);
        }

        RecyclerView itemsContainerRV = findViewById(R.id.rec);
        RecyclerViewAdapter itemAdapter = new RecyclerViewAdapter(this, data,itemsContainerRV);
        itemsContainerRV.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter.notifyDataSetChanged();
        itemsContainerRV.setAdapter(itemAdapter);

/*

        arrow_details.setBackgroundResource(R.drawable.button_down);

        drop_des.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (layout_des.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card_details, new AutoTransition());
                    layout_des.setVisibility(View.VISIBLE);
                    arrow_details.setBackgroundResource(R.drawable.button_down);
                } else {
                    TransitionManager.beginDelayedTransition(card_details, new AutoTransition());
                    layout_des.setVisibility(View.GONE);
                    arrow_details.setBackgroundResource(R.drawable.button_down);
                }
            }
        });
*/

    }
}