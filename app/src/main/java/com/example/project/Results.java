package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;


public class Results extends Activity {

    final int MAIN_ACTIVITY = 100;
    final int DOT_GAME = 200;
    TextView score, accuracy;
    int scorevalue;
    int mouseclicks;
    double accuracyvalue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        score = findViewById(R.id.real_score);
        accuracy = findViewById(R.id.real_accuracy);
        scorevalue = getIntent().getIntExtra("SCORE", 0);
        mouseclicks = getIntent().getIntExtra("MOUSECLICKS", 0);
        accuracyvalue = (double) scorevalue / mouseclicks;
        //Hardcore setting values to check display
        score.setText(String.valueOf(scorevalue));
        accuracy.setText(new StringBuilder().append(String.format(Locale.CANADA, "%.2f", accuracyvalue * 100)).append("%").toString());
    }

    public void onHomeClick(View v) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void onRestartClick(View v) {
        Intent l = new Intent(getApplicationContext(), DotGame.class);
        startActivity(l);
    }
}
