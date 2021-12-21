package com.boitdroid.covid19.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.boitdroid.covid19.R;
import com.boitdroid.covid19.adapter.TrackerAdapter;
import com.boitdroid.covid19.models.Tracker;
import com.boitdroid.covid19.network.CovidTrackerClient;
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
                openTrackActivity();
            }
        });
    }

    private void openTrackActivity() {
        startActivity(new Intent(WorldActivity.this,TrackingActivity.class));
    }

    //search menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.ActionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}