package android.bignerdranch.gamefortheages;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Animations {







     static public AnimatorSet Animation (View v, int xmlAnimation){
        AnimatorSet Anim = (AnimatorSet) AnimatorInflater.loadAnimator(v.getContext(), xmlAnimation);
        Anim.setTarget(v);


        return  Anim;
    }



    static public void simpleAnimation(View v, int xmlAnimation, Context mContext){
        AnimatorSet beginImageSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, xmlAnimation);
        beginImageSet.setTarget(v);
        beginImageSet.start();
    }

    static public void HideButton(View v, View y, boolean choice,Context mContext){
            if(choice) {
                v.setVisibility(View.INVISIBLE);
                y.setVisibility(View.INVISIBLE);
            }
            else{
                v.setVisibility(View.VISIBLE);
                y.setVisibility(View.VISIBLE);
                Animations.simpleAnimation(v,R.animator.alpha_main_button,mContext);
                Animations.simpleAnimation(y,R.animator.alpha_main_button,mContext);

            }


    }






    public static boolean  AnimateMainButton(final ImageView Button, TextView textOfBut, final int startPicture, final int endPicture){
        Button.setImageResource(endPicture);


        //get

        AnimatorSet buttonSet = Animation(Button,R.animator.main_button);
        AnimatorSet textSet = Animation(textOfBut, R.animator.main_button);

        final AnimatorSet togetherAnimationButtonSet = new AnimatorSet(); //объдиняем
        togetherAnimationButtonSet.playTogether(buttonSet, textSet);
        togetherAnimationButtonSet.start();

        //





        buttonSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {


                Button.setImageResource(startPicture);



            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


        return  true;
    }








}
