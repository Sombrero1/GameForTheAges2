package android.bignerdranch.gamefortheages.levels;

import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class level_3 extends Fragment implements View.OnClickListener {
    View view;


    ImageView maincharacter;
    ImageView cloud_dialoge_1;

    ImageView Button1;
    ImageView Button2;
    ImageView Button3;

    TextView CloudText;

    TextView Button1Text;
    TextView Button2Text;
    TextView Button3Text;





    boolean pressedButton=false;


    private AnimationDrawable mAnimationDrawable;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_2,container,false);



        CloudText = view.findViewById(R.id.CloudTextn);
        cloud_dialoge_1 = (ImageView) view.findViewById(R.id.cloud_dialoge_first);
        maincharacter = view.findViewById(R.id.maincharacter);

        Button1Text=view.findViewById(R.id.Button1Text);
        Button2Text=view.findViewById(R.id.Button2Text);
        Button3Text=view.findViewById(R.id.Button3Text);

        Button1=view.findViewById(R.id.Button1);
        Button2=view.findViewById(R.id.Button2);
        Button3=view.findViewById(R.id.Button3);

        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);










        maincharacter.setBackgroundResource(R.drawable.morg);//кадровая анимация героя
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();


        Animations.simpleAnimation(cloud_dialoge_1,R.animator.alpha_main_button,view.getContext());


        //cloud_dialoge_1.setImageResource(R.drawable.cloud_dialoge);


        Animations.simpleAnimation(CloudText,R.animator.alpha_main_button,view.getContext());










        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){



            case R.id.Button1:

                Animations.AnimateMainButton(Button1,Button1Text,R.drawable.big_button_1,R.drawable.big_button_2);


                break;

            case R.id.Button2:
                Animations.AnimateMainButton(Button2,Button2Text,R.drawable.big_button_1,R.drawable.big_button_2);

                break;



            case R.id.Button3:
                Animations.AnimateMainButton(Button3,Button3Text,R.drawable.big_button_1,R.drawable.big_button_2);


                break;




        }
        /* блок кнопки
        Button1.setClickable(false);
        Button2.setClickable(false);
        Button3.setClickable(false);

*/



        //продолжение

    }
}
