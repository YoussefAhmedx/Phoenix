package com.example.phoenix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HowToLoginFragment extends Fragment {
    Button login_btn
            , sign_up_btn
            , google_login_btn
            ,facebook_login_btn;

    public HowToLoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_how_to_login, container, false);
        //TODO: Open LoginFragment
        login_btn = rootView.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(v -> {
            FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new LoginFragment() , "LoginFragment").addToBackStack(null).commit();
        });
        // TODO: Open SignUpActivity

        // TODO: Login with Google

        // TODO: Login with Facebook

        return rootView;
    }
}