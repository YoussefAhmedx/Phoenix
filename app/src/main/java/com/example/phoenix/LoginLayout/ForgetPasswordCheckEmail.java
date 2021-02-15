package com.example.phoenix.LoginLayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.phoenix.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ForgetPasswordCheckEmail extends Fragment {

    //Variables
    TextInputEditText email_edit_text;
    Button check_btn;
    Fragment previous_fragment;
DatabaseReference databaseReference;
    public ForgetPasswordCheckEmail() {
        // Required empty public constructor
    }
    FirebaseAuth auth=FirebaseAuth.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FirebaseAuth auth=FirebaseAuth.getInstance();
        View rootView = inflater.inflate(R.layout.fragment_forget_password_check_email, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        email_edit_text = rootView.findViewById(R.id.email_edit_text);
        check_btn = rootView.findViewById(R.id.check_btn);

        check_btn.setOnClickListener(v -> {
            //TODO: Check if E_Mail in Database or not
            databaseReference = FirebaseDatabase.getInstance().getReference("Teachers");
            String e_mail_send=email_edit_text.getText().toString().trim();

            Query checkUser = databaseReference.orderByChild("e_Mail").equalTo(e_mail_send);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        Toast.makeText(getActivity(), "check your email", Toast.LENGTH_SHORT).show();
                        resetPasswordWithEmail(e_mail_send);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            //TODO: if true
            previous_fragment = new ForgetPasswordCheckEmail();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new ForgetPasswordCodeFragment() , "ForgetPasswordCodeFragment")
                    .addToBackStack(previous_fragment.getClass().getName()).commit();

            //TODO: if false (Toast Message Display)
        });
        return rootView;
    }
    protected void resetPasswordWithEmail(  String e_mail_send){

        auth.sendPasswordResetEmail(e_mail_send).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT).show();

            }
        });
}}