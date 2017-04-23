package com.anwesome.ui.horizontaltextbarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.horizontaltextbar.HorizontalTextBarList;
import com.anwesome.ui.horizontaltextbar.HorizontalTextBarView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HorizontalTextBarList horizontalTextBarList = new HorizontalTextBarList(this);
        horizontalTextBarList.addTextBar("Hello");
        horizontalTextBarList.addTextBar("Joke");
        horizontalTextBarList.addTextBar("Stir");
        horizontalTextBarList.addTextBar("Cross");
        horizontalTextBarList.addTextBar("Hello");
        horizontalTextBarList.addTextBar("Joke");
        horizontalTextBarList.addTextBar("Stir");
        horizontalTextBarList.addTextBar("Cross");
        horizontalTextBarList.addTextBar("Hello");
        horizontalTextBarList.addTextBar("Joke");
        horizontalTextBarList.addTextBar("Stir");
        horizontalTextBarList.addTextBar("Cross");
        horizontalTextBarList.show();
    }
}
