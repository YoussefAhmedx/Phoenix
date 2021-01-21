package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class SignUpDataFragment extends Fragment {
    public SignUpDataFragment() {
        // Required empty public constructor
    }
    //Variables
    TextInputLayout select_type_edit_text;
    AutoCompleteTextView select_type_act;
    ArrayList<String> arrayList_type;
    ArrayAdapter<String> arrayAdapter_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up_data, container, false);
        //Hook
        select_type_edit_text = (TextInputLayout) rootView.findViewById(R.id.select_type_edit_text);
        select_type_act = (AutoCompleteTextView) rootView.findViewById(R.id.select_type_act);

        //Set ArrayList For SelectType EditText
        arrayList_type = new ArrayList<>();
        arrayList_type.add("Teacher");
        arrayList_type.add("Student");
        arrayAdapter_type = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,arrayList_type);
        select_type_act.setAdapter(arrayAdapter_type);
        select_type_act.setThreshold(1);
        //TODO:Sign Up as Teacher
        if(select_type_act.getText().equals("Teacher")){

        }
        //TODO:Sign Up as Student
        else if (select_type_act.getText().equals("Student")){

        }
        return rootView;
    }
}