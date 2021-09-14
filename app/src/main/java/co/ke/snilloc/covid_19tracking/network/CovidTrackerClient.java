package co.ke.snilloc.covid_19tracking.network;

import co.ke.snilloc.covid_19tracking.Constants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidTrackerClient {
    private static Retrofit retrofit = null;

    public static CovidTrackerApi getClient(){
        if (retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request request = chain.request().newBuilder()
                                .addHeader("x-rapidapi-key", Constants.COVID_TRACKER_API_KEY)
                                .addHeader("x-rapidapi-host","covid-19-tracking.p.rapidapi.com")
                                .build();
                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidTrackerApi.class);
    }
}
