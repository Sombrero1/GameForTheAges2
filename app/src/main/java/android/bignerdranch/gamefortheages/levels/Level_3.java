package android.bignerdranch.gamefortheages.levels;

import android.animation.TimeInterpolator;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;


public class Level_3 extends Fragment implements View.OnClickListener, View.OnTouchListener {
    private View view;

    private ImageView maincharacter;
    private ImageView bob;
    private ImageView table_of_results;
    private ImageView buttonImage;

    private TextView dialoge;
    private TextView buttonText;
    private TextView tableResultYou;
    private TextView tableResultBob;

    private GraphView graphPlayer;
    private GraphView graphBob;



    private int k=0;
    private int []game;


    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationDrawableBob;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_3,container,false);


        maincharacter = view.findViewById(R.id.maincharacter);
        bob = view.findViewById(R.id.bob);


        maincharacter.setBackgroundResource(R.drawable.morg);//кадровая анимация героя
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();

        bob.setBackgroundResource(R.drawable.morg_bob);
        mAnimationDrawableBob = (AnimationDrawable) bob.getBackground();
        mAnimationDrawableBob.start();

        table_of_results=view.findViewById(R.id.table_of_results);
        table_of_results.setVisibility(View.INVISIBLE);

        dialoge=view.findViewById(R.id.dialoge);
        dialoge.setText(R.string.level_3_dialoge_1);

        buttonImage=view.findViewById(R.id.buttonImage);
        buttonText=view.findViewById(R.id.buttonText);
        buttonText.setText(R.string.level_3_drop);

        tableResultBob=view.findViewById(R.id.table_result_bob);
        tableResultYou=view.findViewById(R.id.table_result_you);



        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button,view.getContext());


        maincharacter.animate().translationY(500.5f).setDuration(2000).setInterpolator(new BounceInterpolator());

       bob.animate().translationXBy(-30).setDuration(2000);
       bob.animate().translationX(100).setDuration(2000);




       buttonImage.setOnTouchListener(this);



       game= Generation(game);




        graphPlayer = (GraphView) view.findViewById(R.id.graphPlayer);
        graphPlayer.setVisibility(View.INVISIBLE);
        graphBob=(GraphView) view.findViewById(R.id.graphBob);
        graphBob.setVisibility(View.INVISIBLE);




        return view;
    }



    int []  Generation(int game[]){
        Random rand=new Random();
        int chet1,chet2;
        game=new int[200];
        for (int j=0;j<200;j+=2) {
            chet1=0;
            chet2=0;
            for (int i = 0; i < 10; i++) {
                if (rand.nextBoolean()) chet1++;


            }



            for (int i = 0; i < 1000; i++) {
                if (rand.nextBoolean()) chet2++;
            }

            game[j]=chet1;
            game[j+1]=chet2;
        }
        return game;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        k++;
        switch (k){
            case 1:

        Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
        dialoge.setText(R.string.level_3_com_1);
        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
        table_of_results.setVisibility(View.VISIBLE);
        Animations.simpleAnimation(table_of_results,R.animator.alpha_main_button, view.getContext());
        tableResultYou.setText(game[0]+"/10\n");
        Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button, view.getContext());
        tableResultBob.setText(game[1]+"/1000\n");
        Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button, view.getContext());


        break;

             case 2:
        Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
        dialoge.setText(R.string.level_3_com_2);
        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
        tableResultYou.append(game[2]+"/10\n");
        Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button, view.getContext());
        tableResultBob.append(game[3]+"/1000\n");
        Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button, view.getContext());
        break;

              case 3:
         Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
         dialoge.setText(R.string.level_3_com_3);
         buttonText.setText(R.string.next);
        tableResultYou.append(game[4]+"/10");
        Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button, view.getContext());
        tableResultBob.append(game[5]+"/1000");
        Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button, view.getContext());

        break;

            case 4:



        DataPoint[] player=new DataPoint[100];

        for(int i=0,j=0;i<100; i++,j+=2)
            player[i]=new DataPoint(i+1,(float)game[j]/10);
        LineGraphSeries<DataPoint> seriesPlayer = new LineGraphSeries<DataPoint>(player);

        DataPoint[] bob=new DataPoint[100];
        for(int i=0,j=1;i<100; i++,j+=2)
            bob[i]=new DataPoint(i+1,(float)game[j]/1000%10);
        LineGraphSeries<DataPoint> seriesBob = new LineGraphSeries<DataPoint>(bob);
        LineGraphSeries<DataPoint> os = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0,0),
                new DataPoint(0,1)

            });


        graphPlayer.setVisibility(View.VISIBLE);
        graphPlayer.addSeries(seriesPlayer);
        graphPlayer.addSeries(os);
        graphBob.setVisibility(View.VISIBLE);
        graphBob.addSeries(seriesBob);
        graphBob.addSeries(os);

        break;



        }



        return false;
    }
}
