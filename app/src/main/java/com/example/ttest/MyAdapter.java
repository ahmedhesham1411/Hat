package com.example.ttest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<ListItemAddProg> {
    LayoutInflater inflater;
    ArrayList<ListItemAddProg> objects;
    ViewHolder holder = null;

    public MyAdapter(Context context, int textViewResourceId, ArrayList<ListItemAddProg> objects) {
        super(context, textViewResourceId, objects);
        inflater = ((Activity) context).getLayoutInflater();
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        ListItemAddProg listItemAddProg = objects.get(position);
        View row = convertView;
        if (null == row) {
            holder = new ViewHolder();
            row = inflater.inflate(R.layout.spinner_value_layout, parent, false);
            holder.name = (TextView) row.findViewById(R.id.spinnerTextView);
            holder.img = (ImageView) row.findViewById(R.id.spinnerImages);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        holder.name.setText(listItemAddProg.getName());
        holder.img.setBackgroundResource(listItemAddProg.getLogo());
        return row;
    }

    static class ViewHolder {
        TextView name;
        ImageView img;
    }
}