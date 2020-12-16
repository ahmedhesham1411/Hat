package com.example;

import com.example.ttest.GoogleStoresModel;
import com.example.ttest.StoryResponse;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkInterface {

    @POST("Authorization/Login")
    Observable<List<String>> GetMarqee();

    @POST("Authorization/Login")
    Observable<TestResponse> LoginTest(@Body Rate_request rate_request);


    @GET("Data/GetStors")
    Observable<StoryResponse> GetStory(@Query("lat") Double latitude,
                                        @Query("lng") Double longitude);

    @GET("nearbysearch/json")
    Observable<GoogleStoresModel> GetSubCategories(
            @Query("key") String key,
            @Query("location") String location,
            @Query("rankby") String distance,
            @Query("type") String type,
            @Query("language") String language);

}
