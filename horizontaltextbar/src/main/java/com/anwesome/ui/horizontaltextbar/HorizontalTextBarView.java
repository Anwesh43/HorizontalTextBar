package com.anwesome.ui.horizontaltextbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class HorizontalTextBarView extends View {
    private List<TextBar> textBars = new ArrayList<>();
    private ConcurrentLinkedQueue<TextBar> bars = new ConcurrentLinkedQueue<>();
    public HorizontalTextBarView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            for(TextBar textBar:textBars) {

            }
        }
        return true;
    }
}
