package com.example.goldtomato;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Testing: ";
    CircleProgressView mCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = findViewById(R.id.circleView);
        mCircleView.setOnProgressChangedListener(new CircleProgressView.OnProgressChangedListener() {            @Override
            public void onProgressChanged(float value) {
                Log.d(TAG, "Progress Changed: " + value);
            }
        });

        mCircleView = findViewById(R.id.circleView);
        mCircleView.setOnProgressChangedListener(new CircleProgressView.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(float value) {
                Log.d(TAG, "Progress Changed: " + value);
            }
        });
    }
}
