package android.bignerdranch.gamefortheages;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;



public class level_1 extends Fragment implements  View.OnTouchListener{
    View view;
    Activity mActivity;


    ImageView maincharacter;
    ImageView cloud_dialoge_1;
    ImageView Button;
    TextView CloudText;
    TextView ButtonText;

    Context mContext;



    boolean pressedButton=false;


    private AnimationDrawable mAnimationDrawable;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_1,container,false);


        CloudText = view.findViewById(R.id.CloudText);



        cloud_dialoge_1 = (ImageView) view.findViewById(R.id.cloud_dialoge_first);
        Button = (ImageView) view.findViewById(R.id.Button);
        ButtonText = (TextView)view.findViewById(R.id.ButtonText);



        mContext=getContext();


        maincharacter = view.findViewById(R.id.maincharacter);

            maincharacter.setBackgroundResource(R.drawable.morg);
            mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
            mAnimationDrawable.start();



            Animations.simpleAnimation(cloud_dialoge_1,R.animator.alpha_main_button, view.getContext());

          //  cloud_dialoge_1.setImageResource(R.drawable.cloud_dialoge);

            Animations.simpleAnimation(CloudText,R.animator.alpha_main_button,view.getContext());


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
        Animations.AnimateMainButton(Button,ButtonText,R.drawable.square,R.drawable.square_2);

        (( communicationFragmentAndActivity) mActivity).MailFromFragment(1);


        return false;
    }

}
