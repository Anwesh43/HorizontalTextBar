package com.anwesome.ui.horizontaltextbar;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class TextBar {
    private String title;
    private float x,y,w,h;
    public TextBar(String title) {
        this.title = title;
    }
    public void setDimension(float x,float y,float w,float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas, Paint paint) {

    }
    public boolean handleTap(float x,float y) {
        return false;
    }

}
