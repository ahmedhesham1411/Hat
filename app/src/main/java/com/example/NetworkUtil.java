package com.example;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class NetworkUtil {
    public final static String BASE_URL =  "http://85.194.65.236:700/";


    public static NetworkInterface getRetrofitByToken(String token) {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        final String newToken= "Bearer " + token;

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request.Builder builder = original.newBuilder()
                        .addHeader("Authorization", newToken)
                        .method(original.method(), original.body());
                return chain.proceed(builder.build());
            }
        });

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NetworkInterface.class);
    }

}
