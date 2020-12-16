package com.example.ttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.LoadingDialog;
import com.example.NetworkUtil2;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class Stores extends AppCompatActivity {
    private CompositeSubscription mSubscriptions = new CompositeSubscription();
    final LoadingDialog loadingDialog = new LoadingDialog();
    private StoresAdapter storesAdapter,StoresAdapterHorizontal;
    private LinearLayoutManager layoutManager;
    private List<GoogleStoresModel.ResultsBean> storesList = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);

        recyclerView = findViewById(R.id.stores_recycler);
        GetStory("cafe");

    }


    public void GetStory(final String catType) {
        showLoading(this,loadingDialog);
        String urlType = "";
        if (!catType.equals(""))
            urlType = "&type=" + catType;
        double lat = 29.943446;
        double lng = 31.2731393;
        String location = lat + "," + lng;
        mSubscriptions.add(NetworkUtil2.getRetrofitNoHeader2()
                .GetSubCategories("AIzaSyAmD_A7N-SI2JbkhGh4xY_OFip7GtQRZfg",location,"distance",catType,"ar")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponsee, this::handleError));
    }

    private void handleError(Throwable throwable) {
        dismissLoading(loadingDialog);
    }

    private void handleResponsee(GoogleStoresModel googleStoresModel) {
        dismissLoading(loadingDialog);
        Toast.makeText(this, "cvxbcvb", Toast.LENGTH_SHORT).show();

        storesAdapter = new StoresAdapter(this, storesList,"ver");
        StoresAdapterHorizontal = new StoresAdapter(this, storesList,"hor");
        //storesAdapterHorizontal = new StoresAdapter(this,storesList,R.layout.item_store_horizontal);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(storesAdapter);
        storesList.clear();
        storesList.addAll(googleStoresModel.getResults());
        storesAdapter.notifyDataSetChanged();
    }

    public static void showLoading(Activity activity, LoadingDialog loadingDialog) {
        try {
            loadingDialog.show(((AppCompatActivity) activity).getSupportFragmentManager(), "showLoading");

        } catch (Exception e) {
        }
    }

    public static void dismissLoading(LoadingDialog loadingDialog) {
        try {
            if (loadingDialog != null)
                loadingDialog.dismiss();
            loadingDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}