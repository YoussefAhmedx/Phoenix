package com.example.phoenix;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyReceiver extends BroadcastReceiver {
    Dialog dialog;
    TextView no_internet_text;


    @Override
    public void onReceive(final Context context, final Intent intent) {

        String status = NetworkUtil.getConnectivityStatusString(context);
        dialog = new Dialog(context,android.R.style.Theme_Black_NoTitleBar);
        dialog.setContentView(R.layout.activity_no_internet);
        Button restart_btn = (Button)dialog.findViewById(R.id.restart_btn);
        no_internet_text =(TextView)dialog.findViewById(R.id.no_internet_text);
        dialog.setOnKeyListener((arg0, keyCode, event) -> {
            // TODO Auto-generated method stub
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                onReceive(context , intent);
                dialog.dismiss();
            }
            return true;
        });
        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
                Intent i = new Intent(context, WelcomeActivity.class);
                context.startActivity(i);

            }
        });
        Log.d("network",status);
        if(status.isEmpty()||status.equals("No internet is available")||status.equals("No Internet Connection")) {
            status="No Internet Connection";
            dialog.show();
        }
    }
}