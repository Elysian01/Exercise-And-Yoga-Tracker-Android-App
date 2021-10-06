package com.example.yoga_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvSplash, tvSubSplash;
    Button btnget;
    Animation alphatogo, btgone, btgtwo;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register widgets
        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnget = findViewById(R.id.btnget);
        ivSplash = findViewById(R.id.ivSplash);

        // load animation
        alphatogo = AnimationUtils.loadAnimation(this, R.anim.alphatogo);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        // Passing animation
        ivSplash.startAnimation(alphatogo);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgtwo);
        btnget.startAnimation(btgtwo);

        // Passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
//                Intent intent = new Intent(MainActivity.this, ClassifyYogaSet1Activity.class);
//                Intent intent = new Intent(MainActivity.this, ClassifyYogaSet2Activity.class);
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
}
