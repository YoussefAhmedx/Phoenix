package com.example.phoenix.LoginLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.SignUpDataFragment;

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
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_container, new SignUpDataFragment() );
//        fragmentTransaction.commit();



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new LoginFragment() , "LoginFragment").commit();
    }
}