package com.example.phoenix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button sign_up_btn, login_btn;
//    private BroadcastReceiver MyReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//        MyReceiver = new MyReceiver();
//        broadcastIntent();

        // instantiating ViewPager
        ViewPager viewPager = findViewById(R.id.viewpager_container);
        //Setting the Adapter
        viewPager.setAdapter(new CustomPagerAdapter(this));

        //Open SignUp Activity
        sign_up_btn = findViewById(R.id.sign_up_btn);
        sign_up_btn.setOnClickListener(v -> startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class)));
    }
//    public void broadcastIntent() {
//        registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(MyReceiver);
//    }


}