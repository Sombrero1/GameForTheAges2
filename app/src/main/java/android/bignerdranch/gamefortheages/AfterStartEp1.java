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


import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.ArrayList;

public class AfterStartEp1 extends AppCompatActivity implements communicationFragmentAndActivity {


   private ArrayList<Fragment> fragments= new ArrayList<Fragment>();
   private  Fragment ActivityFragment;
   private int numberOfFragment=4;



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
        this.numberOfFragment=numberOfFragment;


        ActivityFragment = (Fragment)fragments.get(numberOfFragment);
        replaceFragment(ActivityFragment);







    }
}
