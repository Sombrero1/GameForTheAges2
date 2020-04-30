package android.bignerdranch.gamefortheages.levels;

import android.app.Activity;
import android.bignerdranch.gamefortheages.Animations;
import android.bignerdranch.gamefortheages.R;
import android.bignerdranch.gamefortheages.communicationFragmentAndActivity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Level_1 extends Fragment implements  View.OnTouchListener{
    private View view;
    private Activity mActivity;


    private ImageView maincharacter;
    private ImageView cloud_dialoge_1;
    private ImageView Button;
    private TextView CloudText;
    private TextView ButtonText;

    private Context mContext;



    private AnimationDrawable mAnimationDrawable;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_level_1,container,false);


        CloudText = view.findViewById(R.id.CloudTextn);
        // TEST
      //  ConstraintLayout fff= (ConstraintLayout) view.findViewById(R.id.level_1);
        //fff.setBackgroundColor(Color.WHITE);


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

        ((communicationFragmentAndActivity) mActivity).MailFromFragment(1);


        return false;
    }

}
