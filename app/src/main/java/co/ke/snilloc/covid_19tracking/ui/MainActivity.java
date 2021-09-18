package co.ke.snilloc.covid_19tracking.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import co.ke.snilloc.covid_19tracking.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //delay the splash screen a bit
        //for how long?
        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this, TrackingActivity.class));
            //destroy the activity
            finish();
        },5000);
    }
}