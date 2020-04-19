package com.example.goldtomato;

import java.util.Timer;
import java.util.TimerTask;

import at.grabner.circleprogress.CircleProgressView;

import static java.lang.Math.floor;

class TomatoTimer {

    private boolean isTimerRunning = false;
    private CircleProgressView mCircleView;
    private boolean isGold = true;
    private Timer mTimer;
    private WorkTask mTimerTask;
    
    TomatoTimer(CircleProgressView myCircleView){
        mCircleView = myCircleView;
        mTimer = new Timer();
    }

    boolean getIsTimerRunning(){
        return isTimerRunning;
    }

    void startTimerTask() {
        stopTimerTask();
        isTimerRunning = true;
        mTimerTask = new WorkTask();
        mTimer.schedule(mTimerTask, 0, 1000);
    }

    class WorkTask extends TimerTask {
        int count = 0;
        @Override
        public void run(){
            count++;
            if (count > (15 * 60) ){
                timerEnd();
           }
            mCircleView.setValue((int)(floor((count)*10.0f/60.0f))/10.0f); // 현재 count의 값을 원형 타이머에 반영
        }
    }

    // 처음부터 30초 테스트 vs ???시간을 줄이는??? 1초마다... 빠른 테스트 주기

    // 어떤 버그가 날 수 있을까? -> 부등호 방향, 지난 버그 경험들을 떠올리면서
    // 교재에 어떤 오류...
    // 어떤 구조로 코드를 짜야할까?

    // 디버깅
    // 에러 코드 cancel, -> null cancel -> 중간중간에 프린트 문이나, Log.d()

    private void stopTimerTask(){
        if(mTimerTask != null)
        {
            mTimerTask.cancel(); //타이머를 멈추고 초기화한다
            mTimerTask = null;
        }
    }
    private void suspendTimerTask(){

    }

    private void timerEnd(){
        stopTimerTask();

        isTimerRunning = false;

        //배운 점, 발견한 문제 기록
        //도전문구와 함께 토마토 저장.
        //처음이면 황금 토마토를 얻고, 화면을 빨강 토마토로 바꾸기.
        if(isGold){isGold = false;};
    }

     String tomatoText(){
        String alarmTomato;
        if(isGold){ alarmTomato = "황금";
        } else { alarmTomato = "빨강";}
        return alarmTomato;
    }
}
