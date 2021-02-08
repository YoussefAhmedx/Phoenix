package com.example.phoenix.SignUpLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phoenix.MainActivity;
import com.example.phoenix.R;
import com.example.phoenix.utils.TeacherData;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SignUpFragment extends Fragment {

    private static final String TAG = "test";
    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 1;


    Uri uri;
    //firebase
    StorageReference storage = FirebaseStorage.getInstance().getReference();
    FirebaseAuth mAuth;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    StorageReference ref = FirebaseStorage.getInstance().getReference();
    //Variables
    Fragment previous_fragment;
    CardView email_sign_up_btn,google_sign_up_btn,facebook_sign_up_btn;

    public SignUpFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //google sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        


        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        //Hook
        email_sign_up_btn = rootView.findViewById(R.id.login_with_e_mail_btn);
        google_sign_up_btn = rootView.findViewById(R.id.login_with_google_btn);
        facebook_sign_up_btn = rootView.findViewById(R.id.login_with_facebook_btn);
        //Open SignUp Insert Data Fragment
        previous_fragment = new SignUpFragment();
        email_sign_up_btn.setOnClickListener(v -> {
           getActivity().getSupportFragmentManager().beginTransaction()
                   .replace(R.id.container_fragment , new SignUpDataFragment() , "SignUpDataFragment")
                   .addToBackStack(previous_fragment.getClass().getName()).commit();
        });
        //TODO: Get Google Data Then Open SignUp Insert Data Fragment
        google_sign_up_btn.setOnClickListener(v -> {
            signIn();
        });
        //TODO: Get Facebook Data Then Open SignUp Insert Data Fragment
        facebook_sign_up_btn.setOnClickListener(v -> {

        });
        return rootView;
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Log.e(TAG, "handleSignInResult: " + "success");
            startActivity(new Intent(getActivity(), MainActivity.class));
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void uploadData() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            Uri photoUrl = user.getPhotoUrl();
            TeacherData teacherData = new TeacherData();
            teacherData.setFirstName(user.getDisplayName());
            //teacherData.setLastName(account.getFamilyName());
            teacherData.setEmail(user.getEmail());
            teacherData.setImageUrl(String.valueOf(photoUrl));
            teacherData.setId(mAuth.getCurrentUser().getUid());
            databaseReference.child("teachers").child(teacherData.getId()).setValue(teacherData);
            Log.e(TAG, "uploadData: "+teacherData.getEmail()+teacherData
                    .getFirstName()+teacherData.getImageUrl() );
        }

    }
}