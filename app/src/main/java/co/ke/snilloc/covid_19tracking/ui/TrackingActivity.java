package co.ke.snilloc.covid_19tracking.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.covid_19tracking.R;
import co.ke.snilloc.covid_19tracking.models.Tracker;
import co.ke.snilloc.covid_19tracking.network.CovidTrackerClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackingActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.SeeAllButton) Button mSeeAllButton;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.GlobalCases) TextView mGlobalCases;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.TrackingProgressBar) ProgressBar mTrackingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        ButterKnife.bind(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView = new AdView(this);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
// TODO: Add adView to your view hierarchy.

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        fetchWorldData();
        mSeeAllButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrackingActivity.this,WorldActivity.class);
            startActivity(intent);
        });

        //show progressbar
        mTrackingProgressBar.setVisibility(View.VISIBLE);

    }


    private void fetchWorldData() {
        CovidTrackerClient.getClient().getWorldCovidData().enqueue(new Callback<Tracker>() {
            @Override
            public void onResponse(@NonNull Call<Tracker> call, @NonNull Response<Tracker> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    //hide progress bar
                    mTrackingProgressBar.setVisibility(View.GONE);
                    mGlobalCases.setText(response.body().getTotalCasesText());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Tracker> call, @NonNull Throwable t) {
                Toast.makeText(TrackingActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                //stop progress bar
                mTrackingProgressBar.setVisibility(View.GONE);
            }
        });
    }
}