package com.example.root.corporate3pe.SeplesScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.root.corporate3pe.MainActivity;
import com.example.root.corporate3pe.R;

import java.util.Timer;
import java.util.TimerTask;

public class SeplashScreen extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;
    TextView textView;
    ImageView logo3pe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seplash_screen);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText("");

        final long period = 100;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i)+"%");
                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(SeplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);


        ///////////

        logo3pe = (ImageView) findViewById(R.id.logo3pe);
        final Animation myAnim = AnimationUtils.loadAnimation(this,R.anim.bounce_logo3pe);
        logo3pe.startAnimation(myAnim);
    }

}