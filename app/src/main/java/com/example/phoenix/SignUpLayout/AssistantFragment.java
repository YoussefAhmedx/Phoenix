package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.phoenix.LoginLayout.ForgetPasswordSetPasswordFragment;
import com.example.phoenix.R;
import com.example.phoenix.SignUpLayout.RecyclerView.RecyclerViewAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.protobuf.StringValue;
import com.google.protobuf.StringValueOrBuilder;

import java.io.Serializable;
import java.util.ArrayList;


public class AssistantFragment extends Fragment {
    //Variables
    String[] assistants;
    String[] teachers;
    int image = R.drawable.avatar;
    RecyclerView recyclerView;
    Button  submit_btn;
    CardView add_assistant_btn;
    Fragment previous_fragment;
    public AssistantFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment3.
     */
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    // TODO: Rename and change types and number of parameters
    public static AssistantFragment newInstance(String param1, String param2) {
        AssistantFragment fragment = new AssistantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }





    DatabaseReference databaseReference2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_assistant, container, false    );
        Bundle args = getArguments();
        assert args != null;

        String firstName =args.getString("firstName");
        String e_Mail =args.getString("e_Mail");
        String Password =args.getString("Password");
        String phone =args.getString("phone");
        String whats_app_num =args.getString("whats_app_num");
        String date =args.getString("date");
        String select_type ="Teacher";

        //Set Main Text
    //    SignUpActivity.sign_up_main_text.setText(R.string.assistant_fragment);
        //Hook
        recyclerView = rootView.findViewById(R.id.assistant_recycler_view);
        assistants = getResources().getStringArray(R.array.Assistant_Name);
        teachers = getResources().getStringArray(R.array.Teacher_Name);
        add_assistant_btn = rootView.findViewById(R.id.add_assistant_btn);
        submit_btn = rootView.findViewById(R.id.submit_btn);
        add_assistant_btn.setOnClickListener(v -> {
            //TODO: Open AddNewAssistantFragment
            previous_fragment = new AssistantFragment();

            args.putString("firstName", firstName);
            args.putString("e_Mail", e_Mail);
            args.putString("date", date);
            args.putString("Password", Password);
            args.putString("whats_app_num", whats_app_num);
            args.putString("phone", phone);
            AddNewAssistantFragment addNewAssistantFragment = new AddNewAssistantFragment();
            addNewAssistantFragment.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.container_fragment,addNewAssistantFragment ).commit();
        });

        //TODO: I use temporary data After Assistant Data insert into database u should show thar data into recyclerView
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext() ,assistants,teachers,image);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignUpDataFragment signUpDataFragment=new SignUpDataFragment();

                signUpDataFragment.signUp(
                        select_type, firstName,  e_Mail,  Password,  phone,
                        whats_app_num, date);
                uploadAssistantDate(phone);
            }
        });

        return rootView;

    }


    private void uploadAssistantDate(String number){

        Bundle args = getArguments();
        assert args != null;

        Serializable list=args.getSerializable("list");

        databaseReference2= FirebaseDatabase.getInstance().getReference("Teacher");

        databaseReference2.child(number).child("assistant").setValue(list );

    }
}
