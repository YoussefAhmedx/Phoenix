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
import com.example.phoenix.SignUpLayout.AssistantFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class ForgetPasswordSetPasswordFragment extends Fragment {

    //Variables
    TextInputEditText password_edit_text , verification_password_edit_text;
    Button set_Password;

    public ForgetPasswordSetPasswordFragment() {
        // Required empty public constructor
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    public static ForgetPasswordSetPasswordFragment newInstance(String param1, String param2) {
        ForgetPasswordSetPasswordFragment ForgetPasswordSetPasswordFragment = new ForgetPasswordSetPasswordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        ForgetPasswordSetPasswordFragment.setArguments(args);
        return ForgetPasswordSetPasswordFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forget_passowrd_set_passowrd, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        password_edit_text = rootView.findViewById(R.id.password_edit_text);
        verification_password_edit_text = rootView.findViewById(R.id.verification_password_edit_text);
        set_Password = rootView.findViewById(R.id.set_password_btn);
String firstPass =password_edit_text.getText().toString().trim();
        String secondPass =verification_password_edit_text.getText().toString().trim();
        set_Password.setOnClickListener(v -> {
          //TODO: Check if Password and Verification Password Match

        if (firstPass.equals(secondPass))
        {

    updatePassword(firstPass);
  //TODO if true update password
   getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment , new LoginFragment() , "LoginFragment")
                    .addToBackStack(null)
                    .commit();}
else { Toast.makeText(getActivity(), "Password and confirm password does not match", Toast.LENGTH_SHORT).show();}


        //TODO if false (Toast Message display)

        });
        return rootView;
    }



    private void updatePassword(String phone) {
        DatabaseReference databaseReference;

        // Bundle bundle = getIntent().getExtras();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
//        String city = phoneNumber.getText().toString().trim();
//        String numberr =countryCodePicker.getSelectedCountryCodeWithPlus()+city;
        Bundle args = getArguments();
        assert args != null;
        String number =args.getString("phoneNumber");
        Query checkUser = databaseReference.orderByChild("Phone").equalTo(number);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {


                    String email = snapshot.child(number).child("e_Mail").getValue(String.class);
                    String password = snapshot.child(number).child("Password").getValue(String.class);
                    Toast.makeText(getActivity(), email, Toast.LENGTH_SHORT).show();
                    updatePassword2(email, password,phone);
                   
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void updatePassword2(String teacher_E_Mail,String teacher_Password,String newPassword) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Toast.makeText(getActivity(), teacher_E_Mail, Toast.LENGTH_SHORT).show();
        firebaseAuth.signInWithEmailAndPassword(teacher_E_Mail,teacher_Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);



                user.updatePassword(newPassword)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "update password successful", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Email or password incorrect", Toast.LENGTH_SHORT).show();
            }
        });




    }
}