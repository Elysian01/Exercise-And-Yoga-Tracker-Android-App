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

public class SignInActivity extends AppCompatActivity {


    private EditText emailSignin , passSignin;
    private Button signinBtn;
    private TextView signUpNext;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        emailSignin = findViewById(R.id.sign_in_email);
        passSignin = findViewById(R.id.sign_in_password);
        signinBtn = findViewById(R.id.sign_up_button);
        signUpNext = findViewById(R.id.sign_up_text);

        signUpNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this,SignupActivity.class));
            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailSignin.getText().toString();
                String pass = passSignin.getText().toString();

                if(!email.isEmpty() && !pass.isEmpty()){
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                startActivity(new Intent(SignInActivity.this,HomePageActivity.class));
                                finish();
                            }else {
                                Toast.makeText(SignInActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignInActivity.this,"Please Enter Email and Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}