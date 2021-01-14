package com.example.phoenix;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

public class SignUpActivity extends AppCompatActivity {

    public static String tag;
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Turn Night Mode Off
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //SignUpFragment Open
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new SignUpFragment() , "SignUpFragment").commit();

    }


}