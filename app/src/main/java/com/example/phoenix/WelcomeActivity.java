package com.example.phoenix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button sign_up_btn,
    login_btn;
    void initView(){
        sign_up_btn = findViewById(R.id.sign_up_btn);
        login_btn = findViewById(R.id.login_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        sign_up_btn.setOnClickListener(v -> {
            //Open Sign Up Activity
            startActivity(new Intent(WelcomeActivity.this , SignUpActivity.class));
        });
        login_btn.setOnClickListener(v -> {
            //TODO: Open Login Activity
        });
    }
}