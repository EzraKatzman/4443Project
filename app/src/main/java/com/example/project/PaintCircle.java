package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class PaintCircle extends View {


    private static final int INVALID_POINTER_ID = -1;
    public float scaleFactor;
    private Paint paint;
    private long startTime;




    public PaintCircle(Context context) {
        super(context);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setTextSize(50);
        startTime = System.currentTimeMillis();
    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200, 200, 100, paint);
        long timeNow = System.currentTimeMillis();
        long timeToGo = 30 - (timeNow - startTime) / 1000;
        int score = 0;
        String Score = Integer.toString(score);
        String poggers = Long.toString(timeToGo);
        canvas.drawText("Time:", 350, 395,paint);
        canvas.drawText("Score:", 600,400,paint);
        if (timeToGo >= 0) {
            canvas.drawText(poggers, 475, 400, paint);
            canvas.drawText(Score,  750, 400, paint);
        }
            invalidate();
    }

}
