package android.bignerdranch.gamefortheages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
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
    private ImageView save_level_1;
    private ImageView save_level_2;
    private ImageView save_level_3;
    private ImageView save_level_4;

    private MediaPlayer change;


    int width,height;
    private int levelOfSave=0;


    private AnimationDrawable mAnimationDrawable;


    public static final String APP_PREFERENCES = "progress";
    public static final String APP_PREFERENCES_LEVEL="level";
    public static SharedPreferences mProgress;




    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setContentView(R.layout.activity_main);



        save_level_1=(ImageView)findViewById(R.id.save_level_1);
        save_level_2=(ImageView)findViewById(R.id.save_level_2);
        save_level_3=(ImageView)findViewById(R.id.save_level_3);
        save_level_4=(ImageView)findViewById(R.id.save_level_4);
        save_level_1.setVisibility(View.INVISIBLE);
        save_level_2.setVisibility(View.INVISIBLE);
        save_level_3.setVisibility(View.INVISIBLE);
        save_level_4.setVisibility(View.INVISIBLE);

        //onResume


        Display display = getWindowManager().getDefaultDisplay();
         width = display.getWidth();
         height = display.getHeight();




        change = MediaPlayer.create(this, R.raw.change);

        maincharacter = (ImageView)findViewById(R.id.maincharacter);
        maincharacter.setBackgroundResource(R.drawable.morg);
        mAnimationDrawable = (AnimationDrawable) maincharacter.getBackground();
        mAnimationDrawable.start();

        btn= (ImageView) findViewById(R.id.button);
        play = (TextView) findViewById(R.id.textView);
        mContext=this;


        tr = (ConstraintLayout) findViewById(R.id.Main);

        Animations.simpleAnimation(btn,R.animator.alpha_main_button, mContext);
        Animations.simpleAnimation(play, R.animator.alpha_main_button,mContext);
        Animations.simpleAnimation(maincharacter, R.animator.main_character, mContext);
        
        btn.setOnTouchListener(this);
        //Bundle arguments = getIntent().getExtras();
//        if(arguments!=null &&  arguments.getBoolean("update")){ //при выходе с уровня, сохраняем и отображаем сразу прогресс
//            onResume(); Плохо сказывается на горизонтальном приложении, т.к. вначале запускается вертикальное положение при любом случае
//        }
        //

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent questionIntent;
        switch (v.getId()){
            case R.id.save_level_1:
                questionIntent = new Intent(MainActivity.this,
                        AfterStartEp1.class);
                questionIntent.putExtra("level", 1);
                startActivityForResult(questionIntent, 1);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
                MediaPlayer.create(this,R.raw.change).start();



                break;
                case R.id.save_level_2:
                questionIntent = new Intent(MainActivity.this,
                        AfterStartEp1.class);
                questionIntent.putExtra("level", 2);
                startActivityForResult(questionIntent, 1);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
                    MediaPlayer.create(this,R.raw.change).start();


                    break;

                case R.id.save_level_3:
                questionIntent = new Intent(MainActivity.this,
                        AfterStartEp1.class);
                questionIntent.putExtra("level", 3);
                startActivityForResult(questionIntent, 1);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);

                break;

                case R.id.save_level_4:
                questionIntent = new Intent(MainActivity.this,
                        AfterStartEp1.class);
                questionIntent.putExtra("level", 4);
                startActivityForResult(questionIntent, 1);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
                MediaPlayer.create(this,R.raw.change).start();


                    break;

            case R.id.button:
                 AnimateMainButton(btn, play, R.drawable.big_button_1, R.drawable.big_button_2);
                 break;
        }
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

    @Override
    protected void onResume() {
        super.onResume();

        mProgress=getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
       //SharedPreferences.Editor m= mProgress.edit();m.remove("level");m.apply(); //стереть прогресс
        if(mProgress.contains(APP_PREFERENCES_LEVEL))
            levelOfSave=mProgress.getInt(APP_PREFERENCES_LEVEL,0);//если имеются пройденные уровни
        Log.e("FFFFFFFFFFFFFF",""+levelOfSave );

        switch (levelOfSave){
            case 4:
                save_level_4.setVisibility(View.VISIBLE);
                save_level_4.setOnTouchListener(this);

            case 3:
                save_level_3.setVisibility(View.VISIBLE);
                save_level_3.setOnTouchListener(this);

            case 2:
                save_level_2.setVisibility(View.VISIBLE);
                save_level_2.setOnTouchListener(this);

            case 1:
                save_level_1.setVisibility(View.VISIBLE);
                save_level_1.setOnTouchListener(this);

            default:
                //нет уровней


        }


    }
}
