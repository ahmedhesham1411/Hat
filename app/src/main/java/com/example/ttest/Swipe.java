package com.example.ttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.SwipeHelper;
import com.example.ttest.Adapter.MyListAdapter;
import com.example.ttest.Model.MyListData;

import java.util.List;

import static java.security.AccessController.getContext;

public class Swipe extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        recyclerView = findViewById(R.id.recyclerViewaaa);


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
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        initSwipe2("ar");
    }


    private void initSwipe2(String language){
        SwipAdapter22 swipeHelper = new SwipAdapter22(getApplicationContext(),"en") {

            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipAdapter22.UnderlayButton(
                        getApplicationContext(),
                        "",
                        getResources().getDrawable(R.drawable.notification),
                        R.color.colorAccent1,
                        new SwipAdapter22.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                int aa = pos+1;
                                Toast.makeText(getApplicationContext(), "You clicked share on item position " + aa, Toast.LENGTH_LONG).show();
                            }
                        }
                ));
            }

        };
        swipeHelper.attachToRecyclerView(recyclerView);

    }
}