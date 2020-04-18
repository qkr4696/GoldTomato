package com.example.goldtomato;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = (CircleProgressView) findViewById(R.id.circleView);
        mCircleView.setOnProgressChangedListener(new CircleProgressView.OnProgressChangedListener() {            @Override
            public void onProgressChanged(float value) {
                Log.d(TAG, "Progress Changed: " + value);
            }
        });

        mCircleView = (CircleProgressView) findViewById(R.id.circleView);
        mCircleView.setOnProgressChangedListener(new CircleProgressView.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(float value) {
                Log.d(TAG, "Progress Changed: " + value);
            }
        });

        //value setting
//        mCircleView.setMaxValue(100);
//        mCircleView.setValue(0);
//        mCircleView.setValueAnimated(24);

        //growing/rotating counter-clockwise
//        mCircleView.setDirection(Direction.CCW)

//        //show unit
//        mCircleView.setUnit("%");
//        mCircleView.setUnitVisible(mShowUnit);
//
//        //text sizes
//        mCircleView.setTextSize(50); // text size set, auto text size off
//        mCircleView.setUnitSize(40); // if i set the text size i also have to set the unit size
//        mCircleView.setAutoTextSize(true); // enable auto text size, previous values are overwritten
//        //if you want the calculated text sizes to be bigger/smaller you can do so via
//        mCircleView.setUnitScale(0.9f);
//        mCircleView.setTextScale(0.9f);
//
//        //custom typeface
//        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/ANDROID_ROBOT.ttf");
//        mCircleView.setTextTypeface(font);
//        mCircleView.setUnitTextTypeface(font);
//
//
//        //color
//        //you can use a gradient
//        mCircleView.setBarColor(getResources().getColor(R.color.primary), getResources().getColor(R.color.accent));
//
//        //colors of text and unit can be set via
//        mCircleView.setTextColor(Color.RED);
//        mCircleView.setTextColor(Color.BLUE);
//        //or to use the same color as in the gradient
//        mCircleView.setTextColorAuto(true); //previous set values are ignored
//
//        //text mode
//        mCircleView.setText("Text"); //shows the given text in the circle view
//        mCircleView.setTextMode(TextMode.TEXT); // Set text mode to text to show text
//
//        //in the following text modes, the text is ignored
//        mCircleView.setTextMode(TextMode.VALUE); // Shows the current value
//        mCircleView.setTextMode(TextMode.PERCENT); // Shows current percent of the current value from the max value

        //spinning
//        mCircleView.spin(); // start spinning
//        mCircleView.stopSpinning(); // stops spinning. Spinner gets shorter until it disappears.
//        mCircleView.setValueAnimated(24); // stops spinning. Spinner spins until on top. Then fills to set value.
    }
}
