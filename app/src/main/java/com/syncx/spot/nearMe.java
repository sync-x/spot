package com.syncx.spot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class nearMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_me);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_nearme:
                        startActivity(new Intent(nearMe.this, nearMe.class));
                        break;
                    case R.id.action_weather:
                        startActivity(new Intent(nearMe.this, weather.class));
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(nearMe.this, profile.class));
                        break;
                }
                return true;
            }
        });

    }
}
