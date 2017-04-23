package com.anwesome.ui.horizontaltextbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class HorizontalTextBarView extends View {
    private float maxW = 0,w;
    private Screen screen = new Screen();
    private List<TextBar> textBars = new ArrayList<>();
    private AnimationController animationController;
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private GestureDetector gestureDetector;
    private ConcurrentLinkedQueue<TextBar> bars = new ConcurrentLinkedQueue<>();
    public HorizontalTextBarView(Context context) {
        super(context);
        gestureDetector = new GestureDetector(context,new ScreenGestureListener());
    }
    public void addTextBar(String title,OnExpandListener onExpandListener) {
        textBars.add(new TextBar(title,onExpandListener));
    }
    public void onDraw(Canvas canvas) {
        w = canvas.getWidth();
        float h = canvas.getHeight()/2,gap = w/7,textBarH = h*3/5,x = 3*gap/2,y = h/5;
        if(time == 0) {
            maxW = x;
            animationController = new AnimationController(this,textBars);
            for(TextBar textBar:textBars) {
                textBar.setDimension(x,y,w/7,textBarH);
                x+=2*gap;
                maxW+=2*gap;
            }
            maxW += gap/2;

        }
        canvas.save();
        canvas.translate(screen.x,0);
        for(TextBar textBar:textBars) {
            textBar.draw(canvas,paint);
        }
        canvas.restore();
        time++;
        if(animationController!=null) {
            animationController.animate();
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    private class Screen {
        private float x = 0;
    }
    private class ScreenGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            if(animationController!=null) {
                animationController.startAnimating(event.getX()-screen.x,event.getY());
            }
            return true;
        }
        public boolean onScroll(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            if(screen.x<=0 && screen.x>= -maxW+w) {
                screen.x -= velx;
                postInvalidate();
                if(screen.x>0) {
                    screen.x = 0;
                }
                if(screen.x < -maxW+w)
                    screen.x = -maxW+w;
            }
            return true;
        }
    }
}
