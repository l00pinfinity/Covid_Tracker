package co.ke.snilloc.covid_19tracking.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.covid_19tracking.R;
import co.ke.snilloc.covid_19tracking.adapter.TrackerAdapter;
import co.ke.snilloc.covid_19tracking.models.Tracker;
import co.ke.snilloc.covid_19tracking.network.CovidTrackerClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.WorldProgressBar) ProgressBar mWorldProgressBar;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.WorldRecyclerView) RecyclerView mWorldRecyclerView;
    LinearLayoutManager layoutManager;
    TrackerAdapter adapter;
    List<Tracker> trackerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        mWorldRecyclerView.setLayoutManager(layoutManager);
        adapter = new TrackerAdapter(trackerList);
        mWorldRecyclerView.setAdapter(adapter);

        mWorldProgressBar.setVisibility(View.VISIBLE);
        fetchData();

    }

    private void fetchData() {
        CovidTrackerClient.getClient().getAllWorldCovidData().enqueue(new Callback<List<Tracker>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<Tracker>> call, @NonNull Response<List<Tracker>> response) {
                if (response.isSuccessful() && response.body() != null){
                    trackerList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    mWorldProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Tracker>> call, @NonNull Throwable t) {
                mWorldProgressBar.setVisibility(View.GONE);
                Toast.makeText(WorldActivity.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}