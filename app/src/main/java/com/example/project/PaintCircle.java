package com.example.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class PaintCircle extends View {


    private static final int INVALID_POINTER_ID = -1;
    public float scaleFactor;
    private final Paint paint;


    public PaintCircle(Context context, AttributeSet attrs, int defStyle, Paint paint) {
        super(context, attrs, defStyle);
        this.paint = paint;
        initialize();
    }

    public PaintCircle(Context context, AttributeSet attrs, Paint paint) {
        super(context, attrs);
        this.paint = paint;
        initialize();
    }

    public PaintCircle(Context context) {
        super(context);

        // create the Paint circle and set its color
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);

    }


    private void initialize() {
        setFocusableInTouchMode(true);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Random random = new Random();
        int minimum_y = 200;
        int maximum_y = 1000;

        canvas.drawCircle(25, 400, 25, paint);
    }

}
