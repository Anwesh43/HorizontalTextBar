package com.anwesome.ui.horizontaltextbarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.horizontaltextbar.HorizontalTextBarView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HorizontalTextBarView horizontalTextBarView = new HorizontalTextBarView(this);
        horizontalTextBarView.addTextBar("Hello");
        horizontalTextBarView.addTextBar("Joke");
        horizontalTextBarView.addTextBar("Stir");
        horizontalTextBarView.addTextBar("Cross");
        setContentView(horizontalTextBarView);
    }
}
