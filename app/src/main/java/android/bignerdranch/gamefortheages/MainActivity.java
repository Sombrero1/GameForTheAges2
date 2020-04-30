package android.bignerdranch.gamefortheages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements  View.OnTouchListener {


    private ImageView btn;
    private TextView play;
    private  ImageView maincharacter;
    private Activity mainactivity;
    private Context mContext;
    private ConstraintLayout tr;

    private MediaPlayer bg_music;
    private MediaPlayer change;


    int width,height;

    private boolean pressedButton=false;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);





        Display display = getWindowManager().getDefaultDisplay();
         width = display.getWidth();
         height = display.getHeight();




        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setContentView(R.layout.activity_main);


        bg_music = MediaPlayer.create(this, R.raw.bg_music);
        change = MediaPlayer.create(this, R.raw.change);



        maincharacter = (ImageView)findViewById(R.id.maincharacter1);

        btn= (ImageView) findViewById(R.id.imageView2);
        play = (TextView) findViewById(R.id.textView);
        mContext=this;


        tr = (ConstraintLayout) findViewById(R.id.Main);

        Animations.simpleAnimation(btn,R.animator.alpha_main_button, mContext);
        Animations.simpleAnimation(play, R.animator.alpha_main_button,mContext);
        Animations.simpleAnimation(maincharacter, R.animator.main_character, mContext);


        btn.setOnTouchListener(this);



        //




    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!bg_music.isPlaying()) bg_music.start();

        AnimateMainButton(btn, play, R.drawable.square, R.drawable.square_2);

        return false;
    }



    public void  AnimateMainButton(final ImageView Button, TextView textOfBut, final int startPicture, final int endPicture){
        Button.setImageResource(endPicture);

        //get

        AnimatorSet buttonSet = Animations.Animation(Button,R.animator.main_button);
        AnimatorSet textSet = Animations.Animation(textOfBut, R.animator.main_button);

        AnimatorSet togetherAnimationButtonSet = new AnimatorSet(); //объдиняем
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


                change.start();
                //герой смывается вниз
                maincharacter.animate().rotationBy(360f).setDuration(600).start();


                Intent questionIntent = new Intent(MainActivity.this,
                        AfterStartEp1.class);
                startActivityForResult(questionIntent, 1);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);



            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });



    }













 /*   public void Transitions(){
        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.Main);
        View button = sceneRoot.findViewById(R.id.imageView2);



        TransitionManager.beginDelayedTransition(sceneRoot);

        ViewGroup.LayoutParams params = button.getLayoutParams();
        params.width=100;
        params.height=100;//настройки


        button.setLayoutParams(params);







    }*/

}
