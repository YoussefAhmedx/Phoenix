package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;


public class ForgetPasswordCodeFragment extends Fragment {

    //Variables
    TextInputEditText phone_edit_text , code_edit_text;
    Button send_btn , check_btn;
    Fragment previous_fragment;

    public ForgetPasswordCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forget_password_code, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        phone_edit_text = rootView.findViewById(R.id.phone_edit_text);
        code_edit_text = rootView.findViewById(R.id.code_edit_text);
        send_btn = rootView.findViewById(R.id.send_btn);
        check_btn = rootView.findViewById(R.id.check_btn);

        send_btn.setOnClickListener(v -> {
        //TODO: send code to User Phone
        });

        check_btn.setOnClickListener(v ->{
          //TODO Check if code user insert match code that send

            //TODO: if true
            previous_fragment = new ForgetPasswordCodeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new ForgetPasswordSetPasswordFragment() , "ForgetPasswordSetPasswordFragment")
                    .addToBackStack(previous_fragment.getClass().getName()).commit();

            //TODO: if false (Toast Message display)
        });

        return rootView;

    }
}