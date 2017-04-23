package com.anwesome.ui.horizontaltextbar;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

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
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            if(activity instanceof AppCompatActivity) {
                ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
                actionBar.hide();
            }
            else {
                android.app.ActionBar actionBar = activity.getActionBar();
                actionBar.hide();
            }
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.setContentView(horizontalTextBarView);
            isShown = true;
        }
    }
}
