package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class DotGame extends Activity implements View.OnTouchListener {

    final int MAIN_ACTIVITY = 100;
    TextView timer;
    TextView scoreCount;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 30000;
    RelativeLayout circlepanel;
    LinearLayout game;


    int score;
    int seconds;
    Random random = new Random();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        game = findViewById(R.id.games);
        circlepanel = findViewById(R.id.circlepanel);
        circlepanel.setOnTouchListener(this);


        scoreCount = findViewById(R.id.clickcount1);
        timer = findViewById(R.id.timers);

        seconds = 0;
        score = 0;

        ImageView imageview = new ImageView(DotGame.this);
        RelativeLayout relativelayout = findViewById(R.id.circlepanel);
        LinearLayout game = findViewById(R.id.games);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        // Add image path from drawable folder.
        imageview.setImageResource(R.drawable.redcircle);
        imageview.setLayoutParams(params);
        relativelayout.addView(imageview);
        imageview.getLayoutParams().height = 125;
        imageview.requestLayout();

        imageview.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        score = 1;
                        scoreCount.setText(String.format(Locale.CANADA, "%s%d", getResources().getString(R.string.score_count)
                                , score));
                        circlepanel.invalidate();
                        break;
                }
                return false;
            }
        });


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

    public void DrawCircle() {
        ImageView imageview = new ImageView(DotGame.this);

        RelativeLayout relativelayout = findViewById(R.id.circlepanel);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        imageview.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        DrawCircle();
                        score += 1;
                        scoreCount.setText(String.format(Locale.CANADA, "%s%d", getResources().getString(R.string.score_count)
                                , score));
                        circlepanel.invalidate();
                        break;
                }
                return false;
            }
        });

        imageview.setImageResource(R.drawable.redcircle);
        imageview.setLayoutParams(params);
        relativelayout.addView(imageview);
        imageview.getLayoutParams().height = 125;
        imageview.requestLayout();
        // these values need to change so they don't go out of bounds
        imageview.setLeft(random.nextInt(circlepanel.getWidth()));
        imageview.setRight(random.nextInt(circlepanel.getWidth()));
        imageview.setTop(random.nextInt(circlepanel.getHeight()));
        imageview.setBottom(random.nextInt(circlepanel.getHeight()));
        imageview.setX(random.nextInt(circlepanel.getHeight()));
        imageview.setY(random.nextInt(circlepanel.getWidth()));
        relativelayout.removeAllViews();
        relativelayout.addView(imageview);
        imageview.requestLayout();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                DrawCircle();
                circlepanel.invalidate();
                break;
        }
        return false;
    }
    }

