package com.example.phoenix.SignUpLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class AddNewAssistantFragment extends Fragment {
    //Variables
    TextInputEditText name_edit_text , phone_edit_text , whatsAppNumber_edit_text , PIN_edit_text;
    Button submit_btn;


    public AddNewAssistantFragment() {
        // Required empty public constructor
    }
    DatabaseReference databaseReference;
    FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_add_new_assistant, container, false);
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
        String assistantName = name_edit_text.getText().toString().trim();
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
            AssistantFragment fragment=new AssistantFragment();
            Bundle args = new Bundle();
            args.putString("assistantName", assistantName);
            args.putString("assistantPhone", assistantPhone);
            args.putString("assistantWhatsAppNumber", assistantWhatsAppNumber);
            args.putString("assistantPIN", assistantPIN);
            fragment.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
        }

}


}