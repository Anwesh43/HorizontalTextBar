package com.anwesome.ui.horizontaltextbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class HorizontalTextBarView extends View {
    private float maxW = 0;
    private Screen screen = new Screen();
    private List<TextBar> textBars = new ArrayList<>();
    private AnimationController animationController;
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ConcurrentLinkedQueue<TextBar> bars = new ConcurrentLinkedQueue<>();
    public HorizontalTextBarView(Context context) {
        super(context);
    }
    public void addTextBar(String title) {
        textBars.add(new TextBar(title));
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(),h = canvas.getHeight()/2,gap = w/7,textBarH = h*3/5,x = 3*gap/2,y = h/5;
        maxW = x;
        if(time == 0) {
            animationController = new AnimationController(this,textBars);
            for(TextBar textBar:textBars) {
                textBar.setDimension(x,y,w/7,textBarH);
                x+=2*gap;
            }
            maxW+=2*gap+3*gap/2;

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
        if(event.getAction() == MotionEvent.ACTION_DOWN && animationController!=null) {
            animationController.startAnimating(event.getX(),event.getY());
        }
        return true;
    }
    private class Screen {
        private float x = 0;
    }
}
