package com.syncx.spot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    RelativeLayout relativeLayout;
    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null){
           showSnackbar();
            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
        }

    }

    public void goToLogin(View view){
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }

    public void signUp(View view){
        TextInputEditText signupet = findViewById(R.id.email);
        TextInputEditText passwordet = findViewById(R.id.password);
        String email = signupet.getText().toString();
        String password = passwordet.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            showSnackbar();
                            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                        } else {
                            showSnackbar1();
                        }
                    }
                });
    }

    public void showSnackbar(){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"Welcome",Snackbar.LENGTH_LONG).setDuration(2000);
        snackbar.show();
    }
    public void showSnackbar1(){
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"Error",Snackbar.LENGTH_LONG).setDuration(2000);
        snackbar.show();
    }
}
