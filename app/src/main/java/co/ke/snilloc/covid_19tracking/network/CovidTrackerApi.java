package co.ke.snilloc.covid_19tracking.network;

import co.ke.snilloc.covid_19tracking.models.Tracker;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidTrackerApi {

    //get all data
    @GET("/v1")
    Call<Tracker> getWorldCovidStat();

    //get data by county

}
