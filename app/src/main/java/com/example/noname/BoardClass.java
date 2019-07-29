package com.example.noname;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class BoardClass extends View {
    Paint board;
    Paint holes;

    public FrameLayout lin;

    int rows,columns;
    public float rad;

    public float heightt;

    Context context;

    BoardClass(Context c, FrameLayout l)
    {
        super(c);

        board = new Paint();
        holes = new Paint();

        rows = 6;
        columns = 7;

        board.setColor(Color.parseColor("#00004d"));
        holes.setColor(Color.parseColor("#80ADD8E6"));


        float widthhh = getWidth()-20;
        float heightt = getHeight()/2f;

        context = c;

        lin=l;

        float dia=(widthhh/rows) < (heightt/columns) ? (widthhh/rows):(heightt/columns);
        rad=dia/2-10;

    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        System.out.println("Inside Canvas");



        float widthhh = getWidth()-20;
        heightt = getHeight()/2f;

        float dia=(widthhh/rows) < (heightt/columns) ? (widthhh/rows):(heightt/columns);
        rad=dia/2-10;

        canvas.drawRect(10,getHeight()/4f,getWidth()-10,3*getHeight()/4f,board);

        for(float i=1;i<=columns;i+=1)
        {
            for (float j = 1; j <= rows; j+=1)
            {
                canvas.drawCircle(((2*j-1)/(2*rows))*widthhh, getHeight()/4f+((2*i-1)/(2*columns))*heightt,rad, holes);
            }
        }

    }

    @Override
    public boolean onTouchEvent (MotionEvent event)
    {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float cx,cy;
            coin c1;

            cx = event.getX();
            cy = event.getY();

            System.out.println("cx and cy are "+cx+"  &  "+cy);

            c1 = new coin(getContext(),cx,cy,rad);
            lin.addView(c1);

            dropcoin(c1,cy);

        }

        return false;
    }

    public void dropcoin(coin c, float cy)
    {
        c.animate().translationY(-cy+3*getHeight()/4f-10);
        c.animate().setDuration(1000);
        c.animate().start();
    }
}
