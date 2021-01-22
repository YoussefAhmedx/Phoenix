package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;

public class ForgetPasswordCheckEmail extends Fragment {

    //Variables
    TextInputEditText email_edit_text;
    Button check_btn;
    Fragment previous_fragment;

    public ForgetPasswordCheckEmail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forget_password_check_email, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        email_edit_text = rootView.findViewById(R.id.email_edit_text);
        check_btn = rootView.findViewById(R.id.check_btn);

        check_btn.setOnClickListener(v -> {
            //TODO: Check if E_Mail in Database or not

            //TODO: if true
            previous_fragment = new ForgetPasswordCheckEmail();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new ForgetPasswordCodeFragment() , "ForgetPasswordCodeFragment")
                    .addToBackStack(previous_fragment.getClass().getName()).commit();

            //TODO: if false (Toast Message Display)
        });
        return rootView;
    }
}