package com.example.task3peoplemvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import com.example.task3peoplemvvm.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //start MainActivity after 2 second
                startActivity(new Intent(SplashActivity.this, PeopleActivity.class));
                finish();
            }
        }, 3000);
    }
}