package android.bignerdranch.gamefortheages;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class Animations {







     static AnimatorSet Animation (View v, int xmlAnimation){
        AnimatorSet Anim = (AnimatorSet) AnimatorInflater.loadAnimator(v.getContext(), R.animator.main_button);
        Anim.setTarget(v);

        return  Anim;
    }



    static void simpleAnimation(View v, int xmlAnimation, Context mContext){
        AnimatorSet beginImageSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, xmlAnimation);
        beginImageSet.setTarget(v);
        beginImageSet.start();
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
