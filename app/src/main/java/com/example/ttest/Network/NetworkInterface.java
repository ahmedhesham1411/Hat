package com.example.covid_19.Network;

import com.example.covid_19.Model.Example;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkInterface {

    @GET("v2/countries")
    Observable<List<Example>> GetData();

}
