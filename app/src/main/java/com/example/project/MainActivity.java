package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    final int MAIN_ACTIVITY = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        //Trying to see if we can start the other activity after we press start button.
        Intent i = new Intent(getApplicationContext(), DotGame.class);
        startActivityForResult(i, MAIN_ACTIVITY);
    }

}