package com.example.phoenix.WelcomeLayouts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phoenix.R;

public class WelcomeSplashScreen extends AppCompatActivity {

    //Splash Screen Delay
    private static int SPLASH_SCREEN = 2000;
    //Animation Variables
    Animation animation_opacity;
    //Widget Variables
    TextView welcome_logo;
    ProgressBar welcome_progress_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_splash_screen);
        //Hide Navigation Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Hook
        welcome_logo = findViewById(R.id.welcome_logo);
        welcome_progress_bar = findViewById(R.id.welcome_progress_bar);
        //Animation
        animation_opacity = AnimationUtils.loadAnimation(this , R.anim.animation_opacity);
        welcome_logo.setAnimation(animation_opacity);
        new Handler().postDelayed(() ->{
            welcome_progress_bar.setVisibility(View.VISIBLE);
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        },SPLASH_SCREEN);
        }
    }


