package com.example.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class DotGame extends Activity {

    int timer;
    int score;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        //Testing to see if dot class works after switching view from Main Activity to here.
        Toast.makeText(this, "Dot Class works", Toast.LENGTH_SHORT).show();
    }
}
