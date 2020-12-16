package com.example.ttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ttest.Network.GPSTracker;
import com.example.ttest.Network.GPSTracking;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity  {
    String[] country = {"India", "USA", "China", "Japan", "Other"};
    private Spinner spinner,spinner1;
    private TextView textView;
    String[] textArray = { "clouds", "mark", "techcrunch", "times" };
    Integer[] imageArray = { R.drawable.ic_android_black_24dp, R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp, R.drawable.ic_android_black_24dp };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //textView = (TextView) this.findViewById(R.id.textView);

        spinner = findViewById(R.id.spinner1);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_value_layout, textArray, imageArray);
        spinner.setAdapter(adapter);


        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




/*        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("BCD");
        list.add("CDE");
        list.add("DEF");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //textView.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    public ArrayList<ListItemAddProg> getAllList() {


        ArrayList<ListItemAddProg> allList = new ArrayList<ListItemAddProg>();
        ListItemAddProg item = new ListItemAddProg();
        item.setData("Brench Presses", R.drawable.ic_android_black_24dp);
        allList.add(item);
        item = new ListItemAddProg();
        item.setData("Incline Presses", R.drawable.ic_android_black_24dp);
        allList.add(item);
        item = new ListItemAddProg();
        item.setData("Decline Presses", R.drawable.ic_android_black_24dp);
        allList.add(item);

        return allList;
    }
}

/*        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, 123);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
        showLocation = findViewById(R.id.textview1);
        showLocation.setText((int) gpsTracker.getLocation().getLongitude());
    }*/
