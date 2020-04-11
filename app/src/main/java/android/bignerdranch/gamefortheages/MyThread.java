package android.bignerdranch.gamefortheages;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyThread extends Thread {
    //
    private final int REDRAW_TIME = 500;
    private final int ANIMATION_TIME = 2000;
    private boolean flag;

    private long startTime;

    private float x=0,y=0;

    //предыдущее время перерисовки
    private long prevRedrawTime;



    private Paint paint;

    private ArgbEvaluator argbEvaluator; // объект для интерполирования


    private SurfaceHolder surfaceHolder; // Указатель на holder для получения canvas



    MyThread(SurfaceHolder holder){

        surfaceHolder=holder;
        flag=false;
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        argbEvaluator = new ArgbEvaluator();







    }


    @Override
    public void run() {
       // super.run();


        Canvas canvas;

        startTime=getTime();

        while (true){
            long currentTime = getTime();
            long elapsedTime= currentTime - prevRedrawTime;


            if(elapsedTime<REDRAW_TIME){
                continue;

            }


            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            canvas=null;
            canvas=surfaceHolder.lockCanvas(); //получаем  результат из Canvas
            draw(canvas);
            surfaceHolder.unlockCanvasAndPost(canvas);//очищаем canvas



           // prevRedrawTime=getTime();//обновляем время


        if(y>= canvas.getHeight()&& x>=canvas.getWidth()) break;

        }


    }

    public long getTime(){



        return System.nanoTime()/1000; // микросек
    }


    public void draw(Canvas c){
        long currTime = getTime()-startTime;
        int width=c.getWidth();
        int height=c.getHeight();

    //    c.drawColor(Color.GRAY);
        c.drawColor(Color.TRANSPARENT); // прозрачный фон


        c.drawLine(x,0,0,y,paint);







    }


    public void setRunning(boolean b) {
        flag = b;
        prevRedrawTime = getTime();

    }
}
