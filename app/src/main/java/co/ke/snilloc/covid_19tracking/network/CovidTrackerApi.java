package co.ke.snilloc.covid_19tracking.network;

import java.util.List;

import co.ke.snilloc.covid_19tracking.models.Tracker;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidTrackerApi {

    //get all world data
    @GET("/v1")
    Call<List<Tracker>> getAllWorldCovidData();

    //get all world data
    @GET("/v1/world")
    Call<Tracker> getWorldCovidData();

    //get country data
    //@GET("/v1/")
    //Call<Tracker> getCountryCovidData();


}
