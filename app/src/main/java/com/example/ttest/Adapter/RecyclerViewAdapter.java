package com.example.ttest.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttest.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    Context context;
    List<String> data;
    RecyclerView recyclerView;

    public RecyclerViewAdapter(Context context, List<String> data,RecyclerView recyclerView) {
        this.context = context;
        this.data = data;
        this.recyclerView=recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.itemNameTV.setText(data.get(position));

        holder.arrow_details.setBackgroundResource(R.drawable.button_down);

        holder.drop_des.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (holder.layout_des.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(holder.card_details, new AutoTransition());
                    holder.layout_des.setVisibility(View.VISIBLE);
                    holder.arrow_details.setBackgroundResource(R.drawable.button_down);
                } else {
                    collapse(holder.layout_des);
                    holder.layout_des.setVisibility(View.GONE);
                }
            }
        });

        holder.itemNameTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  String item = data.get(position);
                Toast.makeText(context, "You clicked " + item, Toast.LENGTH_LONG).show();*/
            }
        });
    }
    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Collapse speed of 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }
    public static void expand(final View v) {
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Expansion speed of 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(String item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public List<String> getData() {
        return data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View container;
        TextView itemNameTV;
        AppCompatImageView btnBack,arrow_details,full_image;
        RelativeLayout layout_des;
        CardView card_details;
        LinearLayoutCompat drop_des,child_layout;


        public ViewHolder(View view) {
            super(view);
            container = view;
            itemNameTV = view.findViewById(R.id.itemNameTV);

            layout_des = view.findViewById(R.id.layout_des);
            card_details = view.findViewById(R.id.card_details);
            drop_des = view.findViewById(R.id.drop_des);
            arrow_details = view.findViewById(R.id.arrow_details);
        }

    }
}
