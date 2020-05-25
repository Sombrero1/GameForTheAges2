package android.bignerdranch.gamefortheages.levels;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.CommunicationFragmentAndActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;


public class Level_1 extends Fragment implements  View.OnTouchListener{
    private View view;
    private ConstraintLayout  mLayout;

    private Activity mActivity;


    private ImageView maincharacter;
    private ImageView cloud_dialoge_1;
    private ImageView Button;
    private TextView CloudText;
    private TextView ButtonText;



    private MediaPlayer backMusic;
    private MediaPlayer backMusicNext;
    private MediaPlayer drumroll;



    private AnimationDrawable mAnimationDrawable;

    private int k=0;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        view = inflater.inflate(R.layout.fragment_level_1,container,false);


        CloudText = view.findViewById(R.id.CloudText);
        // TEST
      //  ConstraintLayout fff= (ConstraintLayout) view.findViewById(R.id.level_1);
        //fff.setBackgroundColor(Color.WHITE);
        cloud_dialoge_1 = (ImageView) view.findViewById(R.id.cloud_dialoge_first);
        Button = (ImageView) view.findViewById(R.id.Button);
        ButtonText = (TextView)view.findViewById(R.id.ButtonText);



        maincharacter = view.findViewById(R.id.maincharacter);
        maincharacter.setBackgroundResource(R.drawable.morg);
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();


        Animations.simpleAnimation(cloud_dialoge_1,R.animator.alpha_main_button, view.getContext());
          //  cloud_dialoge_1.setImageResource(R.drawable.cloud_dialoge);
        Animations.simpleAnimation(CloudText,R.animator.alpha_main_button,view.getContext());




        Button.setVisibility(View.INVISIBLE);
        ButtonText.setVisibility(View.INVISIBLE);

        mLayout=view.findViewById(R.id.save_level_1);
        ObjectAnimator background = ObjectAnimator.ofObject(mLayout,
                "backgroundColor",
                new ArgbEvaluator(),
                ContextCompat.getColor(view.getContext(), R.color.colorAccent),
                ContextCompat.getColor(view.getContext(),R.color.colorPrimaryDark));
        background.setDuration(6000);
        background.setRepeatMode(ValueAnimator.REVERSE);
        background.start();

        Animations.simpleAnimation(maincharacter,R.animator.level_1_maincharacter,view.getContext());

        backMusic=MediaPlayer.create(view.getContext(),R.raw.space);
        backMusicNext = MediaPlayer.create(view.getContext(),R.raw.bg_music);
        backMusic.start();
        drumroll= MediaPlayer.create(view.getContext(),R.raw.drumroll);
        CloudText.setText(R.string.level_1_dialoge_1);
        //Animations.simpleAnimation(CloudText, R.animator.alpha_main_button, view.getContext());
        CloudText.setAlpha(0);


        CloudText.animate().setDuration(6000).alpha(1).setListener(button).start();
        Button.setOnTouchListener(this);

        return view;
    }





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) mActivity=(Activity)context;




    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        switch(k) {
            case 0:
                Animations.AnimateMainButton(Button, ButtonText, R.drawable.big_button_1, R.drawable.big_button_2);
                mLayout.setBackgroundColor(Color.WHITE);
                backMusic.stop();

                drumroll.start();
                drumroll.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {//слушатель на барабаны для запуска фоновой музыки
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ((CommunicationFragmentAndActivity) mActivity).setMusic(1,true,R.raw.bg_music,0, true);
                        drumroll.setOnCompletionListener(null);
                    }
                });
              //  drumroll.setNextMediaPlayer(backMusicNext); теперь через поток
                // backMusicNext.start();

                Animations.HideButton(Button, ButtonText, true, view.getContext());
                CloudText.setText(R.string.level_1_dialoge_3);
                CloudText.setTextColor((int) R.color.colorSimple);
                CloudText.setAlpha(0);

                Animations.simpleAnimation(maincharacter, R.animator.level_1_translation, view.getContext());

                Button.setVisibility(View.VISIBLE);
                Button.animate().translationX(view.getHeight() / 2);
                ButtonText.animate().translationX(view.getHeight()/2+110).setDuration(0);

                Button.setEnabled(false);

                CloudText.animate().alpha(1).setDuration(4000).setInterpolator(new BounceInterpolator()).setListener(CloudTextListener); // после слушатель

                Button.setOnTouchListener(this);


                k++;
                break;

            case 1:
                Animations.AnimateMainButton(Button, ButtonText, R.drawable.big_button_1, R.drawable.big_button_2);
                Animations.simpleAnimation(CloudText,R.animator.alpha_main_button,view.getContext());
                Animations.simpleAnimation(ButtonText,R.animator.alpha_main_button,view.getContext());
                CloudText.setText(R.string.level_1_dialoge_4);
                ButtonText.setText(R.string.level_1_answer_3);
               k++;
               break;
            case 2:
                Animations.AnimateMainButton(Button, ButtonText, R.drawable.big_button_1, R.drawable.big_button_2);

               ((CommunicationFragmentAndActivity) mActivity).MailFromFragment(2);


        }



        return false;
    }



    Animator.AnimatorListener button=new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            CloudText.setText(R.string.level_1_dialoge_2);
            CloudText.setAlpha(0);
            CloudText.animate().setDuration(6000).alpha(1).setListener(null).start();
            Button.setVisibility(View.VISIBLE);
            ButtonText.setVisibility(View.VISIBLE);
            ButtonText.setText(R.string.level_1_answer_1);

            Button.setImageResource(R.drawable.big_button_1);
            Button.animate().alpha(1).setDuration(2000).start();
            ButtonText.animate().alpha(1).setDuration(2000).start();
            Animations.simpleAnimation(Button,R.animator.main_button_test,view.getContext());
            Animations.simpleAnimation(ButtonText,R.animator.main_button_test,view.getContext());

        }
        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };



    Animator.AnimatorListener CloudTextListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            ButtonText.setVisibility(View.VISIBLE);
            ButtonText.setText(R.string.level_1_answer_2);
            ButtonText.setAlpha(0);
            ButtonText.animate().setDuration(4500).alpha(1).setInterpolator(new DecelerateInterpolator()).start();
            Button.setEnabled(true);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    };

    @Override
    public void onDestroy() {
        backMusic.stop();
//        drumroll.stop();
        super.onDestroy();
    }
}
