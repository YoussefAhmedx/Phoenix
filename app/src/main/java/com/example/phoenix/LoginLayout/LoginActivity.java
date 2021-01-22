package com.example.phoenix.LoginLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.phoenix.R;

public class LoginActivity extends AppCompatActivity {
    //Variables
    public static TextView login_main_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Hook
        login_main_text = findViewById(R.id.login_main_text);
        //SignUpFragment Open
        login_main_text.setText(R.string.login_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new LoginFragment() , "LoginFragment").commit();
    }
}