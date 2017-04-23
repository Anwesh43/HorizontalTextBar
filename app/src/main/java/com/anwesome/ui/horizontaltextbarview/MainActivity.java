package com.anwesome.ui.horizontaltextbarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.anwesome.ui.horizontaltextbar.HorizontalTextBarList;
import com.anwesome.ui.horizontaltextbar.HorizontalTextBarView;
import com.anwesome.ui.horizontaltextbar.OnExpandListener;

public class MainActivity extends AppCompatActivity {
    private String titles[] = {"Hello","Joke","Cheer","Stick","Crossed"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HorizontalTextBarList horizontalTextBarList = new HorizontalTextBarList(this);
        for(int i=0;i<titles.length;i++) {
            final String title = titles[i];
            horizontalTextBarList.addTextBar(title, new OnExpandListener() {
                @Override
                public void onExpand() {
                    Toast.makeText(MainActivity.this, title+" expanded", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onShrink() {
                    Toast.makeText(MainActivity.this, title+" shrinked", Toast.LENGTH_SHORT).show();
                }
            });
        }
        horizontalTextBarList.show();
    }
}
