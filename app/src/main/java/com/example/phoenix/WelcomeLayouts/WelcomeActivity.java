package com.example.phoenix.WelcomeLayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

import com.example.phoenix.CustomPagerAdapter;
import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.SignUpActivity;

public class WelcomeActivity extends AppCompatActivity {

    //Variables
    Dialog dialog;
    Button sign_up_btn, login_btn;

//    private BroadcastReceiver MyReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
        //TODO: Open Login Activity
        login_btn.setOnClickListener(v -> {

        });
        // instantiating ViewPager
        ViewPager viewPager = findViewById(R.id.viewpager_container);
        //Setting the Adapter
        viewPager.setAdapter(new CustomPagerAdapter(this));


    }

}