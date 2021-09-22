package com.example.yoga_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {


    private EditText emailSignup , passSignup;
    private Button signupBtn;
    private TextView signInNext;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        emailSignup = findViewById(R.id.sign_in_email);
        passSignup = findViewById(R.id.sign_in_password);
        signupBtn = findViewById(R.id.sign_up_button);
        signInNext = findViewById(R.id.sign_up_text);

        signInNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,SignInActivity.class));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailSignup.getText().toString();
                String pass = passSignup.getText().toString();

                if(!email.isEmpty() && !pass.isEmpty()){
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(SignupActivity.this,SignInActivity.class));
                                finish();
                            }else {
                                Toast.makeText(SignupActivity.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignupActivity.this,"Please Enter Email and Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}