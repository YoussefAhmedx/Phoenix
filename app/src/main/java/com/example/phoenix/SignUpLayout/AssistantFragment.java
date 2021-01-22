package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenix.R;


public class AssistantFragment extends Fragment {
    //Variables
    public AssistantFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_assistant, container, false);

        //Set Main Text
        SignUpActivity.sign_up_main_text.setText(R.string.assistant_fragment);
        return rootView;

    }
}