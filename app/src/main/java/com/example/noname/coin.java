package com.example.noname;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class coin extends View {

    Paint p;
    float cx,cy,rad;

    public coin(Context context,float x,float y,float r) {
        super(context);
        p=new Paint();
        p.setColor(Color.RED);

        cx=x;
        cy=y;
        rad=r;
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        canvas.drawCircle(cx,cy,rad,p);
    }
}
