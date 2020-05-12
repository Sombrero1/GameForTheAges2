package android.bignerdranch.gamefortheages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.communicationFragmentAndActivity;
import android.bignerdranch.gamefortheages.levels.Level_1;
import android.bignerdranch.gamefortheages.levels.Level_2;
import android.bignerdranch.gamefortheages.levels.Level_3;
import android.bignerdranch.gamefortheages.levels.Level_4;


import android.bignerdranch.gamefortheages.levels.Thread;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

public class AfterStartEp1 extends AppCompatActivity implements communicationFragmentAndActivity {


   private ArrayList<Fragment> fragments= new ArrayList<Fragment>();
   private  Fragment ActivityFragment;
   private int numberOfFragment=1;
   private Thread thread1;
   private Thread thread2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setContentView(R.layout.activity_after_start_ep1);



        fragments.add(new Level_1());
        fragments.add(new Level_2());
        fragments.add(new Level_3());
        fragments.add(new Level_4());


        ActivityFragment = (Fragment)fragments.get(--numberOfFragment);
        replaceFragment(ActivityFragment);


        thread1=new Thread(); //фоновая музыка
        thread2=new Thread();
        thread1.start();
        thread2.start();


    }



    private void replaceFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.diagonaltranslate,R.anim.alpha);
        fragmentTransaction.replace(R.id.replace_, f);
        fragmentTransaction.commit();




    }

    @Override
    public void MailFromFragment(int numberOfFragment)
    {
        this.numberOfFragment=--numberOfFragment;


        ActivityFragment = (Fragment)fragments.get(numberOfFragment);
        replaceFragment(ActivityFragment);






    }


    @Override
    public void setMusic(int number, boolean playOnOff, int name, int duration, boolean looping){
        switch(number) {
            case 1:


                    thread1.setMusic(playOnOff,  getBaseContext(), name, duration,looping);




//            backMusic.stop();
//            backMusic=MediaPlayer.create(this.getBaseContext(),name);
//           backMusic.setLooping(true);
//           backMusic.start();


                break;
            case 2:
                    thread2.setMusic(true,  getBaseContext(),name, duration,looping);

                }
    }

    @Override
    public boolean playingMusic(int number){
        switch (number){
            case 1:
                return thread1.playingMusic();

            case 2:
                return thread2.playingMusic();

        }
        return false;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread1.setMusic(false, null, 0, 0, false);
        thread1.interrupt();
        thread2.setMusic(false, null, 0, 0, false);
        thread2.interrupt();

    }


}
