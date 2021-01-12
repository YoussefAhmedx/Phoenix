package com.example.phoenix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SignUpFragment extends Fragment {

    Button sign_up_with_e_mail_btn;
    ImageView sign_up_with_google_btn
            , sign_up_with_facebook_btn;



    public SignUpFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_sign_up, container, false);

        //SignUp With E-mail
        sign_up_with_e_mail_btn = rootView.findViewById(R.id.sign_up_with_e_mail_btn);
        sign_up_with_e_mail_btn.setOnClickListener(v -> {
         //TODO: SignUpSelectTypeFragment Open

        });

        //SignUp With Google
        sign_up_with_google_btn = rootView.findViewById(R.id.sign_up_with_google_btn);
        sign_up_with_google_btn.setOnClickListener(v -> {
           //TODO: SignUpSelectTypeFragment (Get Google Account Information Then Open SignUpSelectTypeFragment)

        });

        //SignUp with FaceBook
        sign_up_with_facebook_btn = rootView.findViewById(R.id.sign_up_with_facebook_btn);
        sign_up_with_facebook_btn.setOnClickListener(v -> {
            //TODO: SignUpSelectTypeFragment (Get Facebook Account Information Then Open SignUpSelectTypeFragment)

        });
        return rootView;
    }
}