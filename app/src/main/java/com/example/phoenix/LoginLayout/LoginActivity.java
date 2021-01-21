package com.example.phoenix.LoginLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.SignUpFragment;

public class LoginActivity extends AppCompatActivity {
    //Variables
    TextView sign_up_main_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Hook
        sign_up_main_text = findViewById(R.id.sign_up_main_text);
        //SignUpFragment Open
        sign_up_main_text.setText(R.string.login_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new LoginFragment() , "LoginFragment").commit();
    }
}