package com.syncx.spot;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    RelativeLayout relativeLayout;
    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.layoutSnackbar);
    }

    public void logOutUser(View view){
        mAuth.getInstance().signOut();
        // add snackbar
        showSnackbar();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
    public void showSnackbar(){
        Snackbar snackbar = Snackbar.make(relativeLayout,"Log Out successful",Snackbar.LENGTH_LONG).setDuration(2000);
        snackbar.show();
    }
    public void goToProfile(View view){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }
    public void goToNearMe(View view){
        startActivity(new Intent(MainActivity.this, NearMeActivity.class));
    }
    public void goToWeather(View view){
        startActivity(new Intent(MainActivity.this, WeatherActivity.class));
    }
    public void goToClassify(View view){
        startActivity(new Intent(MainActivity.this, ClassifierActivity.class));
    }
}
