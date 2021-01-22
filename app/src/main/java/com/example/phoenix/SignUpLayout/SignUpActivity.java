package com.example.phoenix.SignUpLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.TextView;

import com.example.phoenix.R;


public class SignUpActivity extends AppCompatActivity {
    //Variables
    public static TextView sign_up_main_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Hook
        sign_up_main_text = findViewById(R.id.sign_up_main_text);
        //SignUpFragment Open
        sign_up_main_text.setText(R.string.sign_up_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new SignUpFragment() , "SignUpFragment").commit();
    }
}