package com.example.phoenix.WelcomeLayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

import com.example.phoenix.CustomPagerAdapter;
import com.example.phoenix.LoginLayout.LoginActivity;
import com.example.phoenix.MainActivity;
import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.SignUpActivity;
import com.example.phoenix.SignUpLayout.SignUpDataFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
    //Variables
    Dialog dialog;
    Button sign_up_btn, login_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_welcome);

        //  getSupportFragmentManager().beginTransaction().replace(R.id.container,new SignUpDataFragment()).commit();

        //Dialog
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.progress_bar);
        dialog.setOnKeyListener((arg0, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                //Do Nothing
            }
            return true;
        });
        //Hook
        sign_up_btn = findViewById(R.id.sign_up_btn);
        login_btn = findViewById(R.id.login_btn);
        //Open SignUp Activity
        sign_up_btn.setOnClickListener(v -> {
            dialog.show();
            startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
            dialog.dismiss();
        });
        //Open Login Activity
        login_btn.setOnClickListener(v -> {
            dialog.show();
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            dialog.dismiss();
        });
        // instantiating ViewPager
        ViewPager viewPager = findViewById(R.id.viewpager_container);
        //Setting the Adapter
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
    //if user already loged in go home
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            startActivity(new Intent(this, MainActivity.class));
        }

    }

}