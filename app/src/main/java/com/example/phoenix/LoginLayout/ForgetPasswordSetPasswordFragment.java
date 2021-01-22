package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;


public class ForgetPasswordSetPasswordFragment extends Fragment {

    //Variables
    TextInputEditText password_edit_text , verification_password_edit_text;
    Button set_Password;

    public ForgetPasswordSetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forget_passowrd_set_passowrd, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        password_edit_text = rootView.findViewById(R.id.password_edit_text);
        verification_password_edit_text = rootView.findViewById(R.id.verification_password_edit_text);
        set_Password = rootView.findViewById(R.id.set_password_btn);

        set_Password.setOnClickListener(v -> {
          //TODO: Check if Password and Verification Password Match
          //TODO if true update password



            //After Password Updated
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new LoginFragment() , "LoginFragment")
                    .addToBackStack(null)
                    .commit();


            //TODO if false (Toast Message display)

        });
        return rootView;
    }
}