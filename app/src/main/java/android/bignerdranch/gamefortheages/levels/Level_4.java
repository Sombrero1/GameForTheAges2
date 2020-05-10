package android.bignerdranch.gamefortheages.levels;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.communicationFragmentAndActivity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class Level_4 extends Fragment implements View.OnClickListener, View.OnTouchListener {

    private Activity mActivity;

    private View view;
    private ImageView brok;
    private ImageView maincharacter;
    private ImageView mail;
    private ImageView buttonImage;
    private ImageView buttonImage1;
    private ImageView buttonImage2;
    private ImageView line;
    private TextView dialoge;
    private TextView  buttonText;
    private TextView buttonText1;
    private TextView buttonText2;

    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationDrawableBrok;

    private int k=0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_level_4,container,false);

        if( !((communicationFragmentAndActivity) mActivity).playingMusic(1))
            ((communicationFragmentAndActivity) mActivity).setMusic(1,true,R.raw.bg_music,0, true);

        buttonImage=view.findViewById(R.id.buttonImage);
        buttonText=view.findViewById(R.id.buttonText);

        buttonImage1=view.findViewById(R.id.buttonImage1);
        buttonText1=view.findViewById(R.id.buttonText1);
        buttonImage2=view.findViewById(R.id.buttonImage2);
        buttonText2=view.findViewById(R.id.buttonText2);

        line=view.findViewById(R.id.line);

        mail=view.findViewById(R.id.mail);
        dialoge=view.findViewById(R.id.dialoge);

        dialoge.setText(R.string.level_4_dialoge_brok_1);
        buttonText.setText(R.string.level_4_button_0);
        dialoge.setAlpha(0);
        buttonText.setAlpha(0);

        maincharacter=view.findViewById(R.id.maincharacter);
        maincharacter.setBackgroundResource(R.drawable.morg);


        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();

        brok=view.findViewById(R.id.brok);
        brok.setImageResource(R.drawable.brok);



        AnimatorSet brokJump = Animations.Animation(brok,R.animator.translation);
        AnimatorSet textSet = Animations.Animation(dialoge, R.animator.alpha_main_button);
        AnimatorSet mailLook = Animations.Animation(mail, R.animator.object_animation);
        AnimatorSet buttonImageLook = Animations.Animation(buttonImage,R.animator.alpha_main_button);
        AnimatorSet buttonTextLook= Animations.Animation(buttonText,R.animator.alpha_main_button);


        AnimatorSet togetherAnimationButtonSet = new AnimatorSet(); //объдиняем
        togetherAnimationButtonSet.play(brokJump).before(textSet).before(mailLook).before(buttonImageLook).before(buttonTextLook);
        togetherAnimationButtonSet.start();


        buttonImage.setOnTouchListener(this);
//
//        brok.setImageResource(0);
//        brok.setBackgroundResource(R.drawable.brok_smile);
//        mAnimationDrawableBrok = (AnimationDrawable) brok.getBackground();
//        mAnimationDrawableBrok.start();


    //    Animations.simpleAnimation(brok,R.animator.translation,view.getContext());


        return view;
    }






    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (k){
            case 0:
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                // Animations.simpleAnimation(mail,R.animator.object_animation,view.getContext());
                 mail.animate().rotationBy(720f).setDuration(1200).start();
                 mail.animate().scaleX(0).scaleY(0).translationX(-300).setDuration(1800).start();
                 brok.animate().rotationBy(720f).setDuration(1200).start();
                 brok.animate().scaleX(0).scaleY(0).translationX(1000).setDuration(1800).start();
                buttonImage.setOnTouchListener(null);
                dialoge.setTextColor((int)R.color.colorSimple);
                dialoge.setText(R.string.level_4_dialoge_1);
                Animations.simpleAnimation(dialoge, R.animator.alpha_main_button, view.getContext());
                Animations.simpleAnimation(buttonImage,R.animator.alpha_main_button_reverse, view.getContext());
                Animations.simpleAnimation(buttonText,R.animator.alpha_main_button_reverse, view.getContext());

                Animations.simpleAnimation(buttonImage1,R.animator.alpha_main_button,view.getContext());
                Animations.simpleAnimation(buttonImage2,R.animator.alpha_main_button,view.getContext());
                Animations.simpleAnimation(buttonText1, R.animator.alpha_main_button,view.getContext());
                Animations.simpleAnimation(buttonText2, R.animator.alpha_main_button,view.getContext());
                buttonText1.setText(R.string.level_4_button_1);
                buttonText2.setText(R.string.level_4_button_2);
                buttonImage1.setOnTouchListener(this);
                buttonImage2.setOnTouchListener(this);

                break;
            case 1:
                buttonImage1.setOnTouchListener(null);
                buttonImage2.setOnTouchListener(null);
                if (v.getId() == R.id.buttonImage1) {
                    Animations.AnimateMainButton(buttonImage1,buttonText1,R.drawable.big_button_1,R.drawable.big_button_2);
                    Animations.simpleAnimation(dialoge, R.animator.alpha_main_button, view.getContext());
                    dialoge.setText(R.string.level_4_answer_1);

                }
                if (v.getId() == R.id.buttonImage2) {
                    Animations.AnimateMainButton(buttonImage2,buttonText2,R.drawable.big_button_1,R.drawable.big_button_2);
                    Animations.simpleAnimation(dialoge, R.animator.alpha_main_button, view.getContext());
                    dialoge.setText(R.string.level_4_answer_2);

                }
                Animations.simpleAnimation(buttonImage1,R.animator.alpha_main_button_reverse,view.getContext());
                Animations.simpleAnimation(buttonImage2,R.animator.alpha_main_button_reverse,view.getContext());
                Animations.simpleAnimation(buttonText1, R.animator.alpha_main_button_reverse,view.getContext());
                Animations.simpleAnimation(buttonText2, R.animator.alpha_main_button_reverse,view.getContext());

                buttonText.setText(R.string.next);
                Animations.simpleAnimation(buttonImage,R.animator.alpha_main_button,view.getContext());
                Animations.simpleAnimation(buttonText,R.animator.alpha_main_button,view.getContext());

                buttonImage.setOnTouchListener(this);
                break;
            case 2:
                dialoge.animate().alpha(0).setDuration(0);
                dialoge.setText(R.string.level_4_dialoge_2);
                Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
                line.animate().translationX(-2500).setDuration(2000);
                maincharacter.animate().translationX(100).translationY(-250).rotationBy(360f).setDuration(3000);

                AnimatorSet characterJump = Animations.Animation(maincharacter,R.animator.main_character_jump);
                AnimatorSet dialogeShow= Animations.Animation(dialoge,R.animator.alpha_main_button);


                AnimatorSet togetherAnimation = new AnimatorSet(); //объдиняем
                togetherAnimation.play(characterJump).before(dialogeShow);
                togetherAnimation.start();


                //звук фиаско

                break;
            case 3:


        }
        k++;



        return false;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) mActivity=(Activity)context;

    }
}
