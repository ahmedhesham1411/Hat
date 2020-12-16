package com.example.ttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.SwipeHelper;
import com.example.ttest.Adapter.MyListAdapter;
import com.example.ttest.Adapter.RecyclerViewAdapter;
import com.example.ttest.Model.MyListData;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    RecyclerView itemsContainerRV;
    RecyclerViewAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);





        MyListData[] myListData = new MyListData[] {
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        List<String> data = new ArrayList();
        for (int i = 1; i <= 20; i++) {
            data.add("Item " + i);
        }


        itemsContainerRV = findViewById(R.id.itemsContainerRV);
        itemAdapter = new RecyclerViewAdapter(this, data,itemsContainerRV);
        itemAdapter.notifyDataSetChanged();
        itemsContainerRV.setAdapter(itemAdapter);



        SwipeHelper swipeHelper = new SwipeHelper(this) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        getApplicationContext(),
                        "",
                                getResources().getDrawable(R.drawable.notification),
                        R.color.colorAccent1,
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                int aa = pos+1;
                                Toast.makeText(getApplicationContext(), "You clicked share on item position " + aa, Toast.LENGTH_LONG).show();
                            }
                        }
                ));
            }

        };
        swipeHelper.attachToRecyclerView(itemsContainerRV);
    }
}