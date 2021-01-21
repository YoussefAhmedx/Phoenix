package com.example.phoenix.SignUpLayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.phoenix.R;
import com.example.phoenix.WelcomeLayouts.WelcomeActivity;

public class SignUpFragment extends Fragment {

    //Variables
    Fragment previous_fragment;
    CardView email_sign_up_btn,google_sign_up_btn,facebook_sign_up_btn;

    public SignUpFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        //Hook
        email_sign_up_btn = rootView.findViewById(R.id.sign_up_with_e_mail_btn);
        google_sign_up_btn = rootView.findViewById(R.id.sign_up_with_google_btn);
        facebook_sign_up_btn = rootView.findViewById(R.id.sign_up_with_facebook_btn);
        //Open SignUp Insert Data Fragment
        previous_fragment = new SignUpFragment();
        email_sign_up_btn.setOnClickListener(v -> {
           getActivity().getSupportFragmentManager().beginTransaction()
                   .replace(R.id.container_fragment , new SignUpDataFragment() , "SignUpDataFragment")
                   .addToBackStack(previous_fragment.getClass().getName()).commit();
        });
        //TODO: Get Google Data Then Open SignUp Insert Data Fragment
        google_sign_up_btn.setOnClickListener(v -> {

        });
        //TODO: Get Facebook Data Then Open SignUp Insert Data Fragment
        facebook_sign_up_btn.setOnClickListener(v -> {

        });
        return rootView;
    }
}