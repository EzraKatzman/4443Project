package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DotGame extends Activity {

    final int MAIN_ACTIVITY = 100;
    int score;
    TextView timer;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 30000;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        timer = findViewById(R.id.timer);
        startTimer();
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(getApplicationContext(), Results.class);
                startActivityForResult(i, MAIN_ACTIVITY);
            }
        }.start();
    }

    public void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds % 600000 / 1000;
        String timeLeft;
        timeLeft = "0 : ";
        if(seconds < 10) {
            timeLeft += "0";
        }
        timeLeft += seconds;
        timer.setText(timeLeft);
    }


}
