package android.bignerdranch.gamefortheages;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {


    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);

    }
    MyThread mMyThread;

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        //вызывается, когда surfaceView появляется на экране
        mMyThread = new MyThread(surfaceHolder);
        mMyThread.setRunning(true);
        mMyThread.start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;

        mMyThread.setRunning(false);
        while (retry){
            try {
                mMyThread.join();
                retry=false;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }



}
