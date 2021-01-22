package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewAssistantFragment extends Fragment {
    //Variables
    TextInputEditText name_edit_text , phone_edit_text , whatsAppNumber_edit_text , PIN_edit_text;
    Button submit_btn;


    public AddNewAssistantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_new_assistant, container, false);
        SignUpActivity.sign_up_main_text.setText(R.string.add_assistant_fragment);
        //Hook
        name_edit_text = rootView.findViewById(R.id.name_edit_text);
        phone_edit_text = rootView.findViewById(R.id.phone_edit_text);
        whatsAppNumber_edit_text = rootView.findViewById(R.id.whats_app_number_edit_text);
        PIN_edit_text = rootView.findViewById(R.id.pin_edit_Text);
        submit_btn = rootView.findViewById(R.id.submit_btn);


        submit_btn.setOnClickListener(v -> {
            //TODO Add Assistant info to Class Then get his name and pass it to recyclerView
        });

        return  rootView;
    }
}