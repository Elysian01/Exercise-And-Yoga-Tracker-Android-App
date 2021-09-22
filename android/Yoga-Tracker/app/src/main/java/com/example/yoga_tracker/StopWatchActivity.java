package com.example.yoga_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {


    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timerhere;

    boolean flag = false; // used to reset clock.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);


        // Register widgets
        btnstart = findViewById(R.id.btnstart);
        icanchor = findViewById(R.id.icanchor);
        btnstop = findViewById(R.id.btnstop);
        timerhere = findViewById(R.id.timerhere);

        // Create optional animation
        btnstop.setAlpha(0);

        // load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        // Passing event
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Passing animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationYBy(0).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                // start time
                timerhere.setBase(SystemClock.elapsedRealtime());
                timerhere.start();

                if(!flag){
                    flag = true;
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag) {
                    btnstart.clearAnimation();
                    icanchor.clearAnimation();
                    timerhere.clearAnimation();
                    timerhere.stop();
                    flag = false;
                }else{
                    btnstart.animate().alpha(1).translationYBy(0).setDuration(300).start();
                    btnstop.animate().alpha(0).setDuration(300).start();
                }
            }
        });
    }
}