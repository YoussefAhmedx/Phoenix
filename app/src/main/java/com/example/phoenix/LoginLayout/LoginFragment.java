package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.AssistantFragment;
import com.example.phoenix.SignUpLayout.SignUpDataFragment;

public class LoginFragment extends Fragment {
    //Variables
    CardView login_with_email_btn, login_with_google_btn , login_with_facebook_btn;
    Fragment previous_fragment;
    public LoginFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        //Hook
        login_with_email_btn = rootView.findViewById(R.id.login_with_e_mail_btn);
        login_with_google_btn = rootView.findViewById(R.id.login_with_google_btn);
        login_with_facebook_btn = rootView.findViewById(R.id.login_with_facebook_btn);

        login_with_email_btn.setOnClickListener(v -> {
            //Login With E_mail
            previous_fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new LoginWithEmailFragment() , "LoginWithEmailFragment")
                    .addToBackStack(previous_fragment.getClass().getName()).commit();
        });
        login_with_google_btn.setOnClickListener(v -> {
            //TODO: Login With Google
        });
        login_with_facebook_btn.setOnClickListener(v -> {
            //TODO: Login with Facebook
        });






        return  rootView;
    }
}