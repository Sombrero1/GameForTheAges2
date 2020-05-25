package android.bignerdranch.gamefortheages.levels;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.CommunicationFragmentAndActivity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;


public class Level_3 extends Fragment implements View.OnClickListener, View.OnTouchListener {
    private Activity mActivity;

    private View view;

    private ImageView maincharacter;
    private ImageView bob;
    private ImageView table_of_results;
    private ImageView buttonImage;
    private ImageView button1Image;
    private ImageView button2Image;
    private ImageView button3Image;
    private ImageView tableBiatlon;
    private ImageView biatlonist;
    private ImageView tableBiatlonReal;

    private TextView dialoge;
    private TextView buttonText;
    private TextView tableResultYou;
    private TextView tableResultBob;
    private TextView button1Text;
    private TextView button2Text;
    private TextView button3Text;

    private GraphView graphPlayer;
    private GraphView graphBob;

    private ConstraintLayout mLayout;

    private int k=0;
    private int []game;


    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationDrawableBob;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       if( !((CommunicationFragmentAndActivity) mActivity).playingMusic(1)){
           ((CommunicationFragmentAndActivity) mActivity).setMusic(1,true,R.raw.bg_music,0, true);}

        view = inflater.inflate(R.layout.fragment_level_3,container,false);

        mLayout=view.findViewById(R.id.level_3);

        MediaPlayer.create(getContext(),R.raw.coin_get).start();

        maincharacter = view.findViewById(R.id.maincharacter);
        bob = view.findViewById(R.id.bob);

        button1Image=view.findViewById(R.id.Button1);
        button2Image=view.findViewById(R.id.Button2);
        button3Image=view.findViewById(R.id.Button3);
        button1Text=view.findViewById(R.id.Button1Text);
        button2Text=view.findViewById(R.id.Button2Text);
        button3Text=view.findViewById(R.id.Button3Text);
        Animations.HideButton(button1Image,button1Text,true,getContext());
        Animations.HideButton(button2Image,button2Text,true,getContext());
        Animations.HideButton(button3Image,button3Text,true,getContext());

        tableBiatlon=view.findViewById(R.id.table_biatlon);
        tableBiatlonReal=view.findViewById(R.id.table_biatlon_real);
        tableBiatlonReal.setVisibility(View.INVISIBLE);
        tableBiatlon.setVisibility(View.INVISIBLE);

        maincharacter.setBackgroundResource(R.drawable.morg);//кадровая анимация героя
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();

        bob.setBackgroundResource(R.drawable.morg_bob);
        mAnimationDrawableBob = (AnimationDrawable) bob.getBackground();
        mAnimationDrawableBob.start();

        table_of_results=view.findViewById(R.id.table_of_results);
        table_of_results.setVisibility(View.INVISIBLE);

        biatlonist=view.findViewById(R.id.biatlonist);
        biatlonist.setVisibility(View.INVISIBLE);

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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) mActivity=(Activity)context;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        k++;
        switch (k){
            case 1:
                MediaPlayer.create(getContext(),R.raw.bonk).start();
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
                MediaPlayer.create(getContext(),R.raw.bonk).start();
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                dialoge.setText(R.string.level_3_com_2);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
                tableResultYou.append(game[2]+"/10\n");
                Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button, view.getContext());
                tableResultBob.append(game[3]+"/1000\n");
                Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button, view.getContext());
                break;

              case 3:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                 MediaPlayer.create(getContext(),R.raw.bonk).start();
                 Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
                 dialoge.setText(R.string.level_3_com_3);
                 buttonText.setText(R.string.next);
                tableResultYou.append(game[4]+"/10");
                Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button, view.getContext());
                tableResultBob.append(game[5]+"/1000");
                Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button, view.getContext());
                break;

            case 4:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
                 dialoge.setText(R.string.level_3_com_4);
                 buttonText.setText(R.string.next);


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
                Animations.simpleAnimation(graphPlayer,R.animator.alpha_main_button,getContext());
                graphPlayer.addSeries(seriesPlayer);
                graphPlayer.addSeries(os);
                graphBob.setVisibility(View.VISIBLE);
                Animations.simpleAnimation(graphBob,R.animator.alpha_main_button,getContext());
                graphBob.addSeries(seriesBob);
                graphBob.addSeries(os);
                graphPlayer.setTitle("(Ты) % орлов от ходов");
                graphPlayer.setTitleTextSize(13);
                graphBob.setTitle("(Боб) % орлов от ходов");
                graphBob.setTitleTextSize(13);
                break;

            case 5:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, view.getContext());
                dialoge.setText(R.string.level_3_dialoge_2);
                buttonImage.setEnabled(false);
                Animations.simpleAnimation(buttonImage,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(buttonText,R.animator.alpha_main_button_reverse,getContext());
                //Выбора варианта
                Animations.HideButton(button1Image,button1Text,false,getContext());
                Animations.HideButton(button2Image,button2Text,false,getContext());
                Animations.HideButton(button3Image,button3Text,false,getContext());
                button1Image.setOnTouchListener(this);
                button2Image.setOnTouchListener(this);
                button3Image.setOnTouchListener(this);
                break;

            case 6:
                switch (v.getId()){
                    case R.id.Button1:
                        Animations.AnimateMainButton(button1Image,button1Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, getContext());
                        dialoge.setText(R.string.level_3_answer_1);



                        break;
                    case R.id.Button2:
                        Animations.AnimateMainButton(button2Image,button2Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, getContext());
                        dialoge.setText(R.string.level_3_answer_2);


                        break;
                    case R.id.Button3:
                        Animations.AnimateMainButton(button3Image,button3Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(dialoge,R.animator.alpha_main_button, getContext());
                        dialoge.setText(R.string.level_3_answer_3);

                        break;

                }
                button1Image.setEnabled(false);
                button2Image.setEnabled(false);
                button3Image.setEnabled(false);
                Animations.simpleAnimation(button1Image,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(button2Image,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(button1Text,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(button2Text,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(button3Text,R.animator.alpha_main_button_reverse,getContext());
//                AnimatorSet buttonImageHide = Animations.Animation(button3Image,R.animator.alpha_main_button_reverse);
//                AnimatorSet buttonTextHide = Animations.Animation(button3Text,R.animator.alpha_main_button_reverse);
//                AnimatorSet buttonImageLook= Animations.Animation(buttonImage,R.animator.alpha_main_button);
//                AnimatorSet buttonTextLook= Animations.Animation(buttonText,R.animator.alpha_main_button);
                AnimatorSet afterAnimation=Animations.Animation(button3Image,R.animator.alpha_main_button_reverse);
                afterAnimation.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        buttonImage.setEnabled(true);
                        Animations.simpleAnimation(buttonImage,R.animator.alpha_main_button,getContext());
                        Animations.simpleAnimation(buttonText,R.animator.alpha_main_button,getContext());


                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                afterAnimation.start();

                break;
            case 7:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                dialoge.setText(R.string.level_3_dialoge_3);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button,getContext());
                buttonText.setText(R.string.yes);
                Animations.simpleAnimation(buttonText,R.animator.alpha_main_button,getContext());
                break;

            case 8:
                dialoge.setText(R.string.level_3_dialoge_4);
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                Animations.simpleAnimation(graphPlayer,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(graphBob,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(table_of_results,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(tableResultYou,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(tableResultBob,R.animator.alpha_main_button_reverse,getContext());
                Animations.simpleAnimation(this.bob,R.animator.bob_right,getContext());//звук

                biatlonist.setVisibility(View.VISIBLE);
                biatlonist.animate().alpha(0).setDuration(0).start();
                biatlonist.animate().alpha(1).setDuration(5000);
                //появление биатлонитса
             break;

            case 9://биатлон
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                dialoge.setText(R.string.level_3_dialoge_5);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button,getContext());
                tableBiatlon.setVisibility(View.VISIBLE);
                Animations.simpleAnimation(tableBiatlon,R.animator.alpha_main_button,getContext());
             break;

            case 10:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                dialoge.setText(R.string.level_3_dialoge_6);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button,getContext());
                tableBiatlonReal.setVisibility(View.VISIBLE);
                tableBiatlonReal.animate().translationX(500).setDuration(0).start();
                tableBiatlonReal.animate().translationX(-18).setDuration(2000).setInterpolator(new LinearInterpolator()).start();
             break;
            case 11:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                dialoge.setText(R.string.level_3_dialoge_7);
                Animations.simpleAnimation(dialoge,R.animator.alpha_main_button,getContext());
                buttonText.setText(R.string.yes);
                Animations.simpleAnimation(buttonText,R.animator.alpha_main_button,getContext());
                break;
            case 12:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);

                ((CommunicationFragmentAndActivity)
                        mActivity).MailFromFragment(4);




        }



        return false;
    }


}
