package com.anwesome.ui.horizontaltextbar;

import android.app.Activity;

/**
 * Created by anweshmishra on 23/04/17.
 */
public class HorizontalTextBarList {
    private Activity activity;
    private boolean isShown = false;
    private HorizontalTextBarView horizontalTextBarView;
    public HorizontalTextBarList(Activity activity) {
        this.activity = activity;
        this.horizontalTextBarView = new HorizontalTextBarView(activity);
    }
    public void addTextBar(String title,OnExpandListener onExpandListener) {
        if(!isShown) {
            horizontalTextBarView.addTextBar(title,onExpandListener);
        }
    }
    public void show() {
        if(!isShown) {
            activity.setContentView(horizontalTextBarView);
            isShown = true;
        }
    }
}
