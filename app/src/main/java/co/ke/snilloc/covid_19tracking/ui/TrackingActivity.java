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

        mSeeAllButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrackingActivity.this,WorldActivity.class);
            startActivity(intent);
        });

    }
}