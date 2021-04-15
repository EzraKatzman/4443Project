package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class PaintCircle extends View {


    private static final int INVALID_POINTER_ID = -1;
    public float scaleFactor;
    private final Paint paint;
    private final long startTime;


    public PaintCircle(Context context) {
        super(context);

        // create the Paint circle and set its color
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        startTime = System.currentTimeMillis();
    }


    @Override
    public void onDraw(Canvas canvas) {
        //For now color is set to Dark Gray and will change it to other later.
        canvas.drawColor(Color.DKGRAY);
        //canvas.drawARGB(0, 45, 45, 45);


        long timeNow = System.currentTimeMillis();
        long timeToGo = 30 - (timeNow - startTime) / 1000;
        int score = 0;
        String Score = Integer.toString(score);
        String poggers = Long.toString(timeToGo);
        canvas.drawText("Time: ", 350, 100, paint);
        canvas.drawText("Score: ", 600, 100, paint);
        if (timeToGo >= 0) {
            canvas.drawText(poggers, 475, 100, paint);
            canvas.drawText(Score, 750, 100, paint);
        }
        invalidate();
    }

    public void drawCircle(Canvas canvas) {
        Random random = new Random();
        int minimum_y = 200;
        int maximum_y = 1000;
        int random_y = (int) Math.floor(Math.random() * (maximum_y - minimum_y + 1) + minimum_y);
        canvas.drawCircle(500, random_y, 50, paint);
    }

    public void drawNextCircle(Canvas canvas) {

    }

}
