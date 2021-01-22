package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phoenix.R;


public class AssistantFragment extends Fragment {
    //Variables
    TextView sign_up_main_text;
    public AssistantFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_assistant, container, false);
        //Hook
        sign_up_main_text = rootView.findViewById(R.id.sign_up_main_text);

        //Set Main Text
        sign_up_main_text.setText(R.string.assistant_fragment);

        return rootView;

    }
}