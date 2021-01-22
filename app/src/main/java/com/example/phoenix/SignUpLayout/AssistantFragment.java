package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.RecyclerView.RecyclerViewAdapter;


public class AssistantFragment extends Fragment {
    //Variables
    String[] assistants;
    String[] teachers;
    int image = R.drawable.avatar;
    RecyclerView recyclerView;
    Button  submit_btn;
    CardView add_assistant_btn;
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

        //Hook
        recyclerView = rootView.findViewById(R.id.assistant_recycler_view);
        assistants = getResources().getStringArray(R.array.Assistant_Name);
        teachers = getResources().getStringArray(R.array.Teacher_Name);
        add_assistant_btn = rootView.findViewById(R.id.add_assistant_btn);
        submit_btn = rootView.findViewById(R.id.submit_btn);


        add_assistant_btn.setOnClickListener(v -> {
            //TODO: Open AddNewAssistantFragment
        });

        //TODO: I use temporary data After Assistant Data insert into database u should show thar data into recyclerView
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() ,assistants,teachers,image);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        submit_btn.setOnClickListener(v -> {
            //TODO: Upload All Data of User from SignUpDataFragment and AssistantFragment Into DataBase
        });

        return rootView;

    }
}