package com.example.ttest;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttest.Adapter.RecyclerViewAdapter;

import java.text.BreakIterator;
import java.util.List;
import java.util.Locale;

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.StoresViewHolder> {

    private Activity activity;
    private List<GoogleStoresModel.ResultsBean> incomingList;
    String  layout_name;
    private String photoUrl;

    public StoresAdapter(Activity activity, List<GoogleStoresModel.ResultsBean> incomingList,String layout_name) {
        this.activity = activity;
        this.incomingList = incomingList;
        this.layout_name = layout_name;
    }

    @Override
    public StoresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new StoresViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final StoresViewHolder holder, final int position) {


        if (layout_name.equals("ver")){
            holder.layoutVertical.setVisibility(View.VISIBLE);
            holder.layoutHorizontal.setVisibility(View.GONE);
        }else {
            holder.layoutVertical.setVisibility(View.GONE);
            holder.layoutHorizontal.setVisibility(View.VISIBLE);
        }
        holder.storeName.setText(incomingList.get(position).getName());
        holder.storeNameHori.setText(incomingList.get(position).getName());

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {


        }



     /*   try {
            photoUrl = "https://maps.googleapis.com/maps/api/place/photo?photoreference=" +
                    incomingList.get(position).getPhotos().get(0).getPhoto_reference()
                    + "&maxheight=400&maxwidth=400&key=AIzaSyAmD_A7N-SI2JbkhGh4xY_OFip7GtQRZfg";

            Picasso.get().load(photoUrl).fit().centerCrop().into(holder.binding.storeImg);
        } catch (Exception e) {
            photoUrl = incomingList.get(position).getIcon();
            e.printStackTrace();
        }

        //Picasso.get().load(photoUrl).fit().centerCrop().into(holder.binding.storeImg);
        Glide.with(activity)
                .load(photoUrl)
                .override(400, 400)
                .into(holder.binding.storeImg);
       Glide.with(activity)
                .load(photoUrl)
                .override(400, 400)
                .into(holder.binding.storeImgHori);*/


/*        ImageLoader.with(activity).from(photoUrl).onLoaded(new LoadCallback() {
            @Override
            public void onLoaded(@NonNull Bitmap image) {
                // Do something with image here
                //imageView.setImageBitmap(image);
            }
        }).load(holder.binding.storeImgHori)*/;


        //Picasso.get().load(photoUrl).fit().into(holder.binding.storeImgHori);


    }


    @Override
    public int getItemCount() {
        return incomingList.size();
    }

    public class StoresViewHolder extends RecyclerView.ViewHolder {


        public LinearLayout layoutVertical,layoutHorizontal;
        public TextView storeName,storeNameHori;

        public StoresViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutVertical = itemView.findViewById(R.id.layout_vertical);
            layoutHorizontal = itemView.findViewById(R.id.layout_horizontal);
            storeName = itemView.findViewById(R.id.store_name);
            storeNameHori = itemView.findViewById(R.id.store_name_hori);

        }
    }
}