package android.bignerdranch.gamefortheages.DrawView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

class DrawView extends View {

    Paint mPaint;
    Rect mRect;


    public DrawView(Context context) {
        super(context);


        mRect=new  Rect();

        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {



        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPoint(50,50,mPaint);
        canvas.drawLine(100,100,500,50,mPaint);
        canvas.drawCircle(100,200,50,mPaint);
        canvas.drawRect(200,150,400,200,mPaint);




        mRect.set(250,300,350,500);
        canvas.drawRect(mRect, mPaint);


    }

}
