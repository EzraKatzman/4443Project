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
    TextView timer;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 30000;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PaintCircle(this));
        timer = findViewById(R.id.timer);
        startTimer();
    }

    //This timer is set to make sure that activity stops and switches to results.
    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Nothing needed on tick
            }

            @Override
            public void onFinish() {
                //Code to ensure that you go to results activity when time = 0
                Intent i = new Intent(getApplicationContext(), Results.class);
                startActivityForResult(i, MAIN_ACTIVITY);
            }
        }.start();
    }



}
