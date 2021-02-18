package com.example.phoenix.SignUpLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class AddNewAssistantFragment extends Fragment {
    //Variables
    TextInputEditText name_edit_text , phone_edit_text , whatsAppNumber_edit_text , PIN_edit_text;
    Button submit_btn;


    public AddNewAssistantFragment() {
        // Required empty public constructor
    }
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
    public static AddNewAssistantFragment newInstance(String param1, String param2) {
        AddNewAssistantFragment fragment = new AddNewAssistantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    DatabaseReference databaseReference;
    FirebaseAuth auth;


    ArrayList<assistant_model> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_add_new_assistant, container, false);
        Bundle args = getArguments();

        if (args != null && args.containsKey("list")) {
            list = (ArrayList<assistant_model>) args.getSerializable("list");

        }
        auth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        SignUpActivity.sign_up_main_text.setText(R.string.add_assistant_fragment);
        //Hook
        name_edit_text = rootView.findViewById(R.id.name_edit_text);
        phone_edit_text = rootView.findViewById(R.id.phone_edit_text);
        whatsAppNumber_edit_text = rootView.findViewById(R.id.whats_app_number_edit_text);
        PIN_edit_text = rootView.findViewById(R.id.pin_edit_Text);
        submit_btn = rootView.findViewById(R.id.submit_btn);



        submit_btn.setOnClickListener(v -> {
            //TODO Add Assistant info to Class Then get his name and pass it to recyclerView
            uploadDate();



        });

        return  rootView;
    }
    protected void uploadDate() {
        String assistantName = Objects.requireNonNull(name_edit_text.getText()).toString().trim();
        String assistantPhone = phone_edit_text.getText().toString().trim();
        String assistantWhatsAppNumber = whatsAppNumber_edit_text.getText().toString().trim();
        String assistantPIN = PIN_edit_text.getText().toString().trim();
        if (assistantName.isEmpty()
                ||assistantPhone.isEmpty()
                ||assistantWhatsAppNumber.isEmpty()
                ||assistantPIN.isEmpty()
                )
        { Toast.makeText(getActivity(),"check your date",Toast.LENGTH_LONG).show(); }
        String checkspaces = "[+-](201)[0-9]{9}";

        if (!assistantPhone.matches(checkspaces)) {
            phone_edit_text.setError("No White spaces are allowed!");

        }
        if (!assistantWhatsAppNumber.matches(checkspaces)) {
            whatsAppNumber_edit_text.setError("No White spaces are allowed!");

        }
        else {

            phone_edit_text.setError(null);
            whatsAppNumber_edit_text.setError(null);
            list.add(new assistant_model(assistantName,assistantPhone,assistantWhatsAppNumber,assistantPIN));

            Bundle args = getArguments();
            String firstName =args.getString("firstName");
            String e_Mail =args.getString("e_Mail");
            String Password =args.getString("Password");
            String phone =args.getString("phone");
            String whats_app_num =args.getString("whats_app_num");
            String date =args.getString("date");
            String select_type ="Teacher";
            args.putString("firstName", firstName);
            args.putString("e_Mail", e_Mail);
            args.putString("date", date);
            args.putString("Password", Password);
            args.putString("whats_app_num", whats_app_num);
            args.putString("phone", phone);
            args.putSerializable("list", list);

            AssistantFragment fragment=new AssistantFragment();


            fragment.setArguments(args);
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
        }

}


}