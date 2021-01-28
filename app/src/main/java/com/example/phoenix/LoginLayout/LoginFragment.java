package com.example.phoenix.LoginLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.phoenix.MainActivity;
import com.example.phoenix.R;
import com.example.phoenix.utils.StudentData;
import com.example.phoenix.utils.TeacherData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;
import java.util.concurrent.Executor;

public class LoginFragment extends Fragment {
    private static final String TAG = "test";
    //Variables
    CardView login_with_email_btn, login_with_google_btn, login_with_facebook_btn;
    Fragment previous_fragment;

    Fragment fragment;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        //Hook
        login_with_email_btn = rootView.findViewById(R.id.login_with_e_mail_btn);
        login_with_google_btn = rootView.findViewById(R.id.login_with_google_btn);
        login_with_facebook_btn = rootView.findViewById(R.id.login_with_facebook_btn);
        // Initialize Firebase Auth
        login_with_email_btn.setOnClickListener(v -> {
            //Login With E_mail
            previous_fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, new LoginWithEmailFragment(), "LoginWithEmailFragment")
                    .addToBackStack(previous_fragment.getClass().getName()).commit();
        });
        login_with_google_btn.setOnClickListener(v -> {

            // TODO: LOGIN with google
        });
        login_with_facebook_btn.setOnClickListener(v -> {
            //TODO: Login with Facebook
        });

        //TODO: Override  BackButton Event


        return rootView;
    }




}