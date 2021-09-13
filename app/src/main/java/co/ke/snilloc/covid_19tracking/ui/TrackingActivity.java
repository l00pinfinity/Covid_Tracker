package co.ke.snilloc.covid_19tracking.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.snilloc.covid_19tracking.R;

public class TrackingActivity extends AppCompatActivity {
    @BindView(R.id.SeeAllButton) Button mSeeAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        ButterKnife.bind(this);

        mSeeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrackingActivity.this,WorldActivity.class);
                startActivity(intent);
            }
        });

    }
}