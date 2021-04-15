package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

public class DotGame extends Activity implements View.OnTouchListener {

    final int MAIN_ACTIVITY = 100;
    TextView timer;
    TextView scoreCount;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 30000;
    PaintCircle paintcircle;
    RelativeLayout circlepanel;
    int score;
    int seconds;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        circlepanel = findViewById(R.id.circlepanel);
        circlepanel.setOnTouchListener(this);


        scoreCount = findViewById(R.id.clickcount1);
        timer = findViewById(R.id.timers);

        seconds = 0;
        score = 0;


        scoreCount.setText(String.format(Locale.CANADA, "%s%d", getResources().getString(R.string.score_count)
                , score));
        timer.setText(String.format(Locale.CANADA, "%s%d", getResources().getString(R.string.time)
                , timeLeftInMilliseconds));

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
        //   int seconds = (int) timeLeftInMilliseconds % 600000 / 1000;
        //  String timeLeft;
        //  timeLeft = "0 : ";
        //   if (seconds < 10) {
        //      timeLeft += "0";
        //  }
        //   timeLeft += seconds;
        timer.setText(String.format(Locale.CANADA, "%s%d", getResources().getString(R.string.time)
                , timeLeftInMilliseconds % 600000 / 1000));

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
