package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;


public class LoginWithEmailFragment extends Fragment {
    //Variables
    TextInputEditText email_edit_text , password_edit_text;
    Button login_btn;
    TextView wrong_password;

    public LoginWithEmailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login_with_email, container, false);
        //Hook
        login_btn = rootView.findViewById(R.id.login_btn);
        email_edit_text = rootView.findViewById(R.id.email_edit_text);
        password_edit_text = rootView.findViewById(R.id.password_edit_text);
        wrong_password = rootView.findViewById(R.id.wrong_password);


        login_btn.setOnClickListener(v -> {
            //TODO: Check E_mail And Password (if Matched Login)
        });
        return rootView;
    }
}