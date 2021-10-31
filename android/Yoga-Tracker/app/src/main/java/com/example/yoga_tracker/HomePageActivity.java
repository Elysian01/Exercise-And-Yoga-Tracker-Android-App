package com.example.yoga_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;
//import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePageActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private Button knowMoreBtn;
    private  Button start_1;
    private Button start_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        firebaseAuth=FirebaseAuth.getInstance();

        knowMoreBtn = findViewById(R.id.button);
        start_1 = findViewById(R.id.button1);
        start_2 = findViewById(R.id.button2);


        knowMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this,MainActivity.class));
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://seattleyoganews.com/15-yoga-poses-and-their-benefits-to-your-body/"));
                startActivity(intent);
            }
        });

        start_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( HomePageActivity.this, ClassifyYogaSet1Activity.class));
            }
        });

        start_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( HomePageActivity  .this, ClassifyYogaSet2Activity.class));
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser==null){
            startActivity(new Intent(HomePageActivity.this,SignInActivity.class));
        }
    }
}