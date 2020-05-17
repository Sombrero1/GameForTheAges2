package android.bignerdranch.gamefortheages.levels;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.DrawView.MyThread;
import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.communicationFragmentAndActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Level_2 extends Fragment implements View.OnClickListener {
    private View view;
    private Activity mActivity;


    private ImageView maincharacter;
    private ImageView cloud_dialoge_1;


    private ImageView Button0;
    private ImageView Button1;
    private ImageView Button2;
    private ImageView Button3;

    private  TextView CloudText;
    private TextView CloudTextn;

    private TextView Button0Text;
    private  TextView Button1Text;
    private TextView Button2Text;
    private TextView Button3Text;


    private ImageView Plane;
    private ImageView Table1;
    private ImageView dolphine;

    private ConstraintLayout mLayout;




    private AnimationDrawable mAnimationDrawable;
    private int k=0;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_2,container,false);

        if(! ((communicationFragmentAndActivity) mActivity).playingMusic(1))
            ((communicationFragmentAndActivity) mActivity).setMusic(1,true,R.raw.bg_music,0, true);

        CloudText = view.findViewById(R.id.CloudText);
        CloudTextn=view.findViewById(R.id.CloudTextn);
        CloudText.setText(R.string.level_2_dialoge_1);
     //   cloud_dialoge_1 = (ImageView) view.findViewById(R.id.cloud_dialoge_first);

        maincharacter = view.findViewById(R.id.maincharacter);
        Plane = view.findViewById(R.id.Plane);
        Table1 = view.findViewById(R.id.Table1);
        dolphine=view.findViewById(R.id.dolphine);

        Button0Text=view.findViewById(R.id.Button0Text);
        Button1Text=view.findViewById(R.id.Button1Text);
        Button2Text=view.findViewById(R.id.Button2Text);
        Button3Text=view.findViewById(R.id.Button3Text);

        Button0=view.findViewById(R.id.Button0);
        Button1=view.findViewById(R.id.Button1);
        Button2=view.findViewById(R.id.Button2);
        Button3=view.findViewById(R.id.Button3);

        Button0.setOnClickListener(this);
        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);


        Animations.HideButton(Button1, Button1Text, true, view.getContext());
        Animations.HideButton(Button2, Button2Text, true, view.getContext());
        Animations.HideButton(Button3, Button3Text, true,view.getContext());
        Plane.setVisibility(View.INVISIBLE);
        Table1.setVisibility(View.INVISIBLE);



        // TEST
      //  ConstraintLayout fff= (ConstraintLayout) view.findViewById(R.id.level_1);
       // fff.setBackgroundColor(Color.WHITE);
//
            // 1 step
        Animations.simpleAnimation(CloudText,R.animator.alpha_main_button,view.getContext());


        maincharacter.setBackgroundResource(R.drawable.morg);//кадровая анимация героя
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();


        Animations.simpleAnimation(cloud_dialoge_1,R.animator.alpha_main_button,view.getContext());
        Animations.simpleAnimation(Button0Text,R.animator.alpha_main_button,view.getContext());
        Animations.simpleAnimation(Button0,R.animator.alpha_main_button,view.getContext());
        Button0Text.setText(R.string.level_2_button0);
        dolphine.setVisibility(View.INVISIBLE);
        //cloud_dialoge_1.setImageResource(R.drawable.cloud_dialoge);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (k){

            case 0://всё для вопроса
              /*  new Handler().post(new Runnable() { @Override public void run() {
                 //кнопка + пропадание текста через другой поток

                    Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                } });*/

             //       mThread.simpleAnimation(CloudTextn,R.animator.alpha_main_button_reverse, view.getContext());
                 //   mThread.AnimateMainButton(Button0,Button0Text,R.drawable.big_button_1,R.drawable.big_button_2);
             //   Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);

                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                Button0.setEnabled(false);
                Animations.simpleAnimation(Button0,R.animator.alpha_main_button_reverse,view.getContext());
                Animations.simpleAnimation(Button0Text,R.animator.alpha_main_button_reverse,view.getContext());

                CloudTextn.setText(R.string.level_2_dialoge_2);


                Animations.simpleAnimation(CloudText, R.animator.alpha_main_button_reverse, view.getContext());
                  //  Animations.HideButton(Button0Text, Button0, true, view.getContext());
                 maincharacter.animate().rotationBy(360f).setDuration(600).start();
                 Animations.HideButton(Button1, Button1Text, false, view.getContext());
                 Animations.HideButton(Button2, Button2Text, false, view.getContext());
                 Animations.HideButton(Button3, Button3Text, false, view.getContext());
                 Plane.setVisibility(View.VISIBLE);
                 Animations.simpleAnimation(Plane, R.animator.alpha_main_button, view.getContext());
                 Table1.setVisibility(View.VISIBLE);
                 Animations.simpleAnimation(Plane, R.animator.alpha_main_button, view.getContext());
                 Animations.simpleAnimation(Table1, R.animator.alpha_main_button, view.getContext());

                 k++;

                break;


            case 1://определение ответа игрока
                switch (v.getId()){
                    case R.id.Button1:

                        Animations.AnimateMainButton(Button1,Button1Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(CloudTextn,R.animator.alpha_main_button,view.getContext());
                        CloudTextn.setText(R.string.level_2_answer1);




                        break;

                    case R.id.Button2:
                        Animations.AnimateMainButton(Button2,Button2Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(CloudTextn,R.animator.alpha_main_button,view.getContext());
                        CloudTextn.setText(R.string.level_2_answer2);

                        break;



                    case R.id.Button3:
                        Animations.AnimateMainButton(Button3,Button3Text,R.drawable.big_button_1,R.drawable.big_button_2);
                        Animations.simpleAnimation(CloudTextn,R.animator.alpha_main_button,view.getContext());
                        CloudTextn.setText(R.string.level_2_answer3);

                        break;
                        }

                        //После событий кнопок выбора, подготавливаем кнопку next
                 disEnable(Button1,Button1Text);
                 disEnable(Button2,Button2Text);
                 disEnable(Button3,Button3Text);
                 k++;
                 Button0.setEnabled(true);
                 Animations.simpleAnimation(Button0,R.animator.alpha_main_button,view.getContext());
                 Animations.simpleAnimation(Button0Text,R.animator.alpha_main_button,view.getContext());
                 Button0Text.setText(R.string.next);

                 break;


            case 2://ответ
                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                CloudTextn.setText(R.string.level_2_dialoge_3);
                Plane.setImageResource(R.drawable.power);
                Plane.animate().translationY(-view.getHeight()/4).setDuration(0).start();
                Plane.animate().translationY(view.getHeight()/6).setDuration(4000).setInterpolator(new OvershootInterpolator()).start();
                CloudTextn.animate().translationX(view.getWidth()/4).setDuration(0).start();
                CloudTextn.setAlpha(0);
                CloudTextn.animate().translationX(-view.getWidth()/60).setDuration(6000).setInterpolator(new LinearOutSlowInInterpolator()).start();
                CloudTextn.animate().alpha(1).setDuration(7000).setInterpolator(new FastOutSlowInInterpolator()).start();
                MediaPlayer.create(view.getContext(),R.raw.drumroll).start();
                k++;

                break;
            case 3: // dolphin
                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                CloudTextn.setText(R.string.level_2_dialoge_4);

                mLayout=view.findViewById(R.id.level_2);
                ObjectAnimator background = ObjectAnimator.ofObject(mLayout,
                        "backgroundColor",
                        new ArgbEvaluator(),
                        ContextCompat.getColor(view.getContext(), R.color.WhiteSmoke),
                        ContextCompat.getColor(view.getContext(),R.color.CornflowerBlue));
                background.setDuration(1500).setInterpolator(new FastOutLinearInInterpolator());

                Animations.simpleAnimation(Plane,R.animator.alpha_main_button_reverse,view.getContext());
                Animations.simpleAnimation(Table1,R.animator.alpha_main_button_reverse,view.getContext());

                background.addListener(beforeDolphine);//после слушатель
                ((communicationFragmentAndActivity)mActivity).setMusic(2,true,R.raw.dolphin,6000,false);
                background.start();
                CloudTextn.setVisibility(View.INVISIBLE);

                k++;


                break;
            case 4:
                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                CloudTextn.setText(R.string.level_2_dialoge_5);
                Animations.simpleAnimation(CloudTextn,R.animator.alpha_main_button,view.getContext());
                k++;
                break;
            case 5:
                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);
                ((communicationFragmentAndActivity) mActivity).MailFromFragment(3);




        }






    }
    void disEnable(View button,View text){
        button.setEnabled(false);
        Animations.simpleAnimation(button,R.animator.alpha_main_button_reverse,view.getContext());
        Animations.simpleAnimation(text,R.animator.alpha_main_button_reverse,view.getContext());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) mActivity=(Activity)context;




    }

    Animator.AnimatorListener beforeDolphine=new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {


            dolphine.setVisibility(View.VISIBLE);
            CloudTextn.setVisibility(View.VISIBLE);
            Animations.simpleAnimation(CloudTextn,R.animator.alpha_main_button,view.getContext());
            dolphine.animate().translationY(view.getHeight()).setDuration(0);
            Animations.simpleAnimation(dolphine,R.animator.dolphin_up,view.getContext());



        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }

    };


    }
