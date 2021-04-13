package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Results extends Activity {

    final int MAIN_ACTIVITY = 100;
    final int DOT_GAME = 200;
    TextView score, accuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        score = findViewById(R.id.real_score);
        accuracy = findViewById(R.id.real_accuracy);
        //Hardcore setting values to check display
        score.setText("30");
        accuracy.setText("85%");

    }

    public void onHomeClick(View v) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(i, MAIN_ACTIVITY);
    }

    public void onRestartClick(View v) {
        Intent i = new Intent(getApplicationContext(), DotGame.class);
        startActivityForResult(i, DOT_GAME);
    }
}
