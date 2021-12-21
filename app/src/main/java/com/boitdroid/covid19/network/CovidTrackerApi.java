package com.boitdroid.covid19.network;

import java.util.List;

import com.boitdroid.covid19.models.Tracker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidTrackerApi {

    //get all world data
    @GET("/v1")
    Call<List<Tracker>> getAllWorldCovidData();

    //get all world data
    @GET("/v1/world")
    Call<Tracker> getWorldCovidData();

    //get country data
    @GET("/v1/{country}")
    Call<List<Tracker>> getCountryCovidData(@Path("country") String country);

}
