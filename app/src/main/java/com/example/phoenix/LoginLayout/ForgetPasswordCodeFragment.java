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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;


public class ForgetPasswordCodeFragment extends Fragment {

    //Variables
    TextInputEditText phone_edit_text , code_edit_text;
    Button send_btn , check_btn;
    Fragment previous_fragment;
    String codeBySystem;
    public ForgetPasswordCodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forget_password_code, container, false);
        LoginActivity.login_main_text.setText(R.string.set_password_fragment);
        //Hook
        phone_edit_text = rootView.findViewById(R.id.phone_edit_text);
        code_edit_text = rootView.findViewById(R.id.code_edit_text);

        send_btn = rootView.findViewById(R.id.send_btn);
        check_btn = rootView.findViewById(R.id.check_btn);

        send_btn.setOnClickListener(v -> {
        //TODO: send code to User Phone
            String phone=phone_edit_text.getText().toString().trim();
            if(phone.isEmpty()){
                Toast.makeText(getActivity(), "code is Empty ", Toast.LENGTH_SHORT).show();
            }else {
                     sendVerificationCode(phone);

                }  });
        check_btn.setOnClickListener(v ->{
          //TODO Check if code user insert match code that send
        //    String code=code_edit_text.getText().toString().trim();
            String code=code_edit_text.getText().toString().trim();

            //TODO: if true
            verifyCode2(code);

            //TODO: if false (Toast Message display)
        });

        return rootView;

    }
    private void sendVerificationCode(String number) {
      //  String city =countryCodePicker.getSelectedCountryCodeWithPlus()+number;;
        Toast.makeText(getActivity(), number, Toast.LENGTH_SHORT).show();
        //  String number2="+923329121290";
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,        // Phone number to verify
                120,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
               getActivity() ,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    private  PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeBySystem = s;
            Toast.makeText(getActivity(), "GY", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {

                code_edit_text.setText(code);
                verifyCode2(code);
            }
        }



        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    };
    private void verifyCode2(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        signInWithPhoneAuthCredential(credential);

    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                 firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             String code=code_edit_text.getText().toString().trim();

                             ForgetPasswordSetPasswordFragment forgetPasswordSetPasswordFragment=new ForgetPasswordSetPasswordFragment();
                             Bundle args = new Bundle();
                             args.putString("phoneNumber", code);
                             forgetPasswordSetPasswordFragment.setArguments(args);
                             getFragmentManager().beginTransaction().replace(R.id.container_fragment,forgetPasswordSetPasswordFragment).commit();
                         } else {
                             if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                 Toast.makeText(getActivity(), "wrong code ! ", Toast.LENGTH_SHORT).show();
                             }
                         }
                     }
                 });


    }




}