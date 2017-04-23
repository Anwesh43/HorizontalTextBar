package com.anwesome.ui.horizontaltextbar;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class AnimationController {
    private boolean isAnimated = false;
    private List<TextBar> textBars = new ArrayList<>();
    private View view;
    private ConcurrentLinkedQueue<TextBar> tappedBars = new ConcurrentLinkedQueue<>();
    public AnimationController(View view,List<TextBar> textBars) {
        this.view = view;
        this.textBars = textBars;
    }
    public void animate() {
        if(isAnimated) {
            for(TextBar tappedBar:tappedBars) {
                tappedBar.update();
            }
            try {
                Thread.sleep(50);
                view.invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public void startAnimating(float x,float y) {
        if(!isAnimated) {
            for(TextBar textBar:textBars) {
                if(textBar.handleTap(x,y)) {
                    boolean firstTextBar = textBar.handleTap(x,y);
                    tappedBars.add(textBar);
                    if(firstTextBar) {
                        isAnimated = true;
                        view.postInvalidate();
                    }
                }
            }
        }
    }
}
