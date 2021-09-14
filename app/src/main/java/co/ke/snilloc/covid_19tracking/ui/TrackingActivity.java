package co.ke.snilloc.covid_19tracking.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        ButterKnife.bind(this);

        fetchWorldData();
        mSeeAllButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrackingActivity.this,WorldActivity.class);
            startActivity(intent);
        });

    }

    private void fetchWorldData() {
        CovidTrackerClient.getClient().getWorldCovidData().enqueue(new Callback<Tracker>() {
            @Override
            public void onResponse(Call<Tracker> call, Response<Tracker> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    mGlobalCases.setText(response.body().getTotalCasesText());
                }
            }

            @Override
            public void onFailure(Call<Tracker> call, Throwable t) {
            }
        });
    }
}