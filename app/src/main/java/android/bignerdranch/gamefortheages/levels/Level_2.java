package android.bignerdranch.gamefortheages.levels;

import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.DrawView.MyThread;
import android.bignerdranch.gamefortheages.R;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



    private AnimationDrawable mAnimationDrawable;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_2,container,false);



        CloudText = view.findViewById(R.id.CloudText);
        CloudTextn=view.findViewById(R.id.CloudTextn);
        CloudText.setText(R.string.level_2_dialoge_1);
     //   cloud_dialoge_1 = (ImageView) view.findViewById(R.id.cloud_dialoge_first);

        maincharacter = view.findViewById(R.id.maincharacter);
        Plane = view.findViewById(R.id.Plane);
        Table1 = view.findViewById(R.id.Table1);

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


        //cloud_dialoge_1.setImageResource(R.drawable.cloud_dialoge);







        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Button0:


              /*  new Handler().post(new Runnable() { @Override public void run() {
                 //кнопка + пропадание текста через другой поток


                    Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);


                } });*/

             //       mThread.simpleAnimation(CloudTextn,R.animator.alpha_main_button_reverse, view.getContext());
                 //   mThread.AnimateMainButton(Button0,Button0Text,R.drawable.big_button_1,R.drawable.big_button_2);
             //   Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);//кнопка + пропадание текста через другой поток



                Animations.AnimateMainButton(Button0, Button0Text, R.drawable.big_button_1, R.drawable.big_button_2);

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


                break;



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

       //  ((communicationFragmentAndActivity) mActivity).MailFromFragment(0); //следующий левел

        /*
        Button1.setClickable(false);
        Button2.setClickable(false);
        Button3.setClickable(false);

*/

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) mActivity=(Activity)context;




    }
}
