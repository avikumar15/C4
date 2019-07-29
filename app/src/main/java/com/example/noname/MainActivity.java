package com.example.noname;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    BoardClass b;
    FrameLayout linearLayout;
    float r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayout = (FrameLayout) findViewById(R.id.layout);

        b = new BoardClass(getApplicationContext(),linearLayout);
        linearLayout.addView(b);

        r = b.rad;

    }

    public void dropcoin(coin c)
    {
        c.animate().translationY(3*b.heightt/2f);
    }
}
