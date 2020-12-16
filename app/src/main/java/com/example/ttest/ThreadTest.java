package com.example.ttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.imageloader.ImageLoader;
import com.budiyev.android.imageloader.LoadCallback;
import com.example.LoadingDialog;
import com.example.NetworkUtil;
import com.example.NetworkUtil2;
import com.example.Rate_request;
import com.example.TestResponse;
import com.example.TestResponse2;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ThreadTest extends AppCompatActivity {
    private CompositeSubscription mSubscriptions = new CompositeSubscription();
    AlertDialog alertDialog;
    TextView textView;
    ImageView imageView;
    final LoadingDialog loadingDialog = new LoadingDialog();
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);

        activity = this;
        //GetMarqee("tynptgwrcmwlbzgpnljnyutuavshfdtomfzcqguepipcstptzh78698479TYNPTGWRCMWLBZGPNLJNYUTUAVSHFDTOMFZCQGUEPIPCSTPTZH30");
        GetStory();
      /*  //new MyTask().execute("my string parameter");
        imageView = findViewById(R.id.aaa);

        ImageLoader.with(this).from("https://lh3.googleusercontent.com/e9ODjos_2DbvyIU-H15chBjJ-W1BrtKsmVQcZi1cFx2Xa7zTJZGkrojAq5CS4Rxua0DNLBQW3LSympd3fS5HP5cS8BUkNxLNP4VavA=w600").onLoaded(new LoadCallback() {
            @Override
            public void onLoaded(@NonNull Bitmap image) {
                // Do something with image here
                //imageView.setImageBitmap(image);
            }
        }).load(imageView);*/

    }

    void GetStory() {
        Rate_request rate_request = new Rate_request("00000000");
        showLoading(activity,loadingDialog);
        mSubscriptions.add(NetworkUtil2.getRetrofitNoHeader()
                .GetStory(0.00,0.00)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponsee, this::handleErrorr));
    }

    private void handleErrorr(Throwable throwable) {
    }

    private void handleResponsee(StoryResponse storyResponse) {
        dismissLoading(loadingDialog);
        Toast.makeText(activity, storyResponse.getStoryDetails().get(1).getName(), Toast.LENGTH_SHORT).show();
    }

    void GetMarqee(String token) {
        Rate_request rate_request = new Rate_request("00000000");
        showLoading(activity,loadingDialog);
        mSubscriptions.add(NetworkUtil2.getRetrofitNoHeader()
                .LoginTest(rate_request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponsee, this::handleError));
    }

    private void handleResponsee(TestResponse testResponse) {
       dismissLoading(loadingDialog);
        Toast.makeText(this, testResponse.getResult().getCode(), Toast.LENGTH_SHORT).show();
    }

    private void handleError(Throwable throwable) {
        dismissLoading(loadingDialog);
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


    private class MyTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Do something like display a progress bar
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            // get the string from params, which is an array
            String myString = params[0];

            // Do something that takes a long time, for example:
            for (int i = 0; i <= 100; i++) {

                // Do things

                // Call this to update your progress
                publishProgress(i);
                textView = findViewById(R.id.ggg);


            }

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            new Thread(new Runnable() {
                @Override
                public void run() {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("ahmeasdd");
                        }
                    });
                }
            }).start();
            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // Do things like hide the progress bar or change a TextView
        }
    }
}