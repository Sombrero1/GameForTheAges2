package android.bignerdranch.gamefortheages.levels;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;



public class Thread extends java.lang.Thread {
   MediaPlayer player;
    Context mContext;
    int name;
    int duration;
    boolean loop;
    boolean playOnOff;

    public Thread(){
        super();
    }

    public void setMusic(boolean play, Context context, int name, int duration, boolean loop){
        this.playOnOff=play;
        this.mContext=context;
        this.name=name;
        this.duration=duration;
        this.loop = loop;

        if(player==null && context!=null) player=MediaPlayer.create(mContext,name);





    }

    public void loopingMusic(boolean loop){
        this.loop=loop; //скорее нет необходимости


    }

    public boolean playingMusic(){
        try{
            return player.isPlaying();
        }
        catch (NullPointerException e){
            return false;
        }

    }

    @Override
    public void run() {

        Log.e("ff", "run: "+player );
        // super.run();\
        if(player!=null) {
            if(playOnOff){
            if(duration==0){
                while(loop){
                  player.start();
                    try {
                        this.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            else{

                player.start();
                try {
                    this.sleep(duration);
                    player.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }

            else{
                player.stop();
            }

        }


            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }




}
