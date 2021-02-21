package com.policingapp.mobilepolicing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 3000; //splash screen timer set to 3sec

    SharedPreferences onBoarding; //to check whether user is using app for the first time or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //removing  status bar

        //handler to move to login screen after splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoarding = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                Boolean isFirstTime = onBoarding.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoarding.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), Onboarding.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIMER);
    }
}