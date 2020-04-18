package com.example.goldtomato;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear_timer;
    CircleProgressView mCircleView;
    static TomatoTimer mTomatoTimer;
    static PendingIntent mPendingIntent;

    @SuppressLint("ClickableViewAccessibility")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = findViewById(R.id.circleView);
        mTomatoTimer = new TomatoTimer(mCircleView);
        linear_timer = findViewById(R.id.linearTimer);
        initialize_size();

        mPendingIntent = PendingIntent.getActivity(MainActivity.this, 0,
                new Intent(getApplicationContext(), MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        mCircleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(!mTomatoTimer.getIsTimerRunning()){
                    //도전 문구를 적게 한다.
                    mTomatoTimer.startTimerTask();
                }
                return false;
            }
        });

        mCircleView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // 일시 정지
                return false;
            }
        });

    }

    static void notifyAlarm(String content){
        //푸시 알림 보내기
    };

    private void initialize_size(){
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        android.view.ViewGroup.LayoutParams layoutParams= linear_timer.getLayoutParams();
        if(height > width) {
            layoutParams.height = (int)(width * 1.05);
        } else {
            layoutParams.width = (int)(height * 1.05);
        }
        linear_timer.setLayoutParams(layoutParams);
    }

}
