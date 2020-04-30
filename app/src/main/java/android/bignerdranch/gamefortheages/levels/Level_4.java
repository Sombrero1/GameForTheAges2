package android.bignerdranch.gamefortheages.levels;

import android.animation.AnimatorSet;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Level_4 extends Fragment implements View.OnClickListener, View.OnTouchListener {

    private View view;
    private ImageView brok;
    private ImageView maincharacter;
    private ImageView mail;
    private ImageView buttonImage;
    private TextView dialoge;
    private TextView  buttonText;

    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationDrawableBrok;

    private int k=0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_level_4,container,false);

        buttonImage=view.findViewById(R.id.buttonImage);
        buttonText=view.findViewById(R.id.buttonText);

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
        Animations.AnimateMainButton(buttonImage,buttonText,R.drawable.big_button_1,R.drawable.big_button_2);
        switch (0){
            case 0:
                // Animations.simpleAnimation(mail,R.animator.object_animation,view.getContext());
                 mail.animate().rotationBy(720f).setDuration(1200).start();
                 mail.animate().scaleX(0).scaleY(0).translationX(-300).setDuration(1800).start();
                 brok.animate().alpha(0).setDuration(3000);
                 break;
            case 1:



        }
        k++;



        return false;
    }
}
