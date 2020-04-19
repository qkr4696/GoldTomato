package com.example.goldtomato;

import at.grabner.circleprogress.CircleProgressView;

import static java.lang.Math.floor;

class TomatoTimer {

    private boolean isTimerRunning = false;
    private CircleProgressView mCircleView;
    private boolean isGold = true;
    private Timer mTimer;
    
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
        private int count = 0;
        mTimer.schedule(new WorkTask(), 0, 1000);

        public static class WorkTask extends TimerTask{
            @Override
            public void run(){
                this.mCircleView.setValue((int)(floor((count)*10.0f/60.0f))/10.0f); // 현재 count의 값을 원형 타이머에 반영
                count++;
                if (count < (15 * 60) ){
                    timerEnd();
                }
            }
        }
    }
    private void stopTimerTask(){
        mTimer.cancel(); //타이머를 멈추고 초기화한다
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
