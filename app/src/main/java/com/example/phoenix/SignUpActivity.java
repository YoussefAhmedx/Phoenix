package com.example.phoenix;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SignUpActivity extends AppCompatActivity {

    String tag;
    protected void ShowFragment (Fragment fragment , String tag){
        this.tag = tag;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, fragment , tag).addToBackStack(null).commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(tag.equals("SignUpFirstFragment"))
                    finish();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);
        //SignUpFirstFragment Open
        ShowFragment(new SignUpFirstFragment() , "SignUpFirstFragment");
    }
}