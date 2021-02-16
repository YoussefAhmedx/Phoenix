package com.example.phoenix.SignUpLayout;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.phoenix.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SignUpDataFragment extends Fragment {
    public SignUpDataFragment() {
        // Required empty public constructor
    }
    //firebase
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth ;

    //Variables
    TextInputLayout select_type_edit_text;
    AutoCompleteTextView select_type_act;
    ArrayList<String> arrayList_type;
    ArrayAdapter<String> arrayAdapter_type;
    TextInputEditText name_edit_text , email_edit_text , password_edit_text , phone_edit_text , whatsAppNumber_edit_text , date_edit_text;
    Button submit_btn;
    final Calendar calendar = Calendar.getInstance();
    Fragment previous_fragment;
    //Open DatePicker Function
    DatePickerDialog.OnDateSetListener date = (view, year, month, dayOfMonth) -> {
        //Auto-generated method stub
        calendar.set(Calendar.YEAR , year);
        calendar.set(Calendar.MONTH , month);
        calendar.set(Calendar.DAY_OF_MONTH , dayOfMonth);
        setDateToEditText();
    };

    void setDateToEditText(){
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format , Locale.US);
        date_edit_text.setText(sdf.format(calendar.getTime()));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sign_up_data, container, false);
        //Set Main Text
        SignUpActivity.sign_up_main_text.setText(R.string.sign_up_fragment);
        //Hook
        name_edit_text = rootView.findViewById(R.id.name_edit_text);
        email_edit_text = rootView.findViewById(R.id.email_edit_text);
        password_edit_text = rootView.findViewById(R.id.password_edit_text);
        phone_edit_text = rootView.findViewById(R.id.phone_edit_text);
        whatsAppNumber_edit_text = rootView.findViewById(R.id.whats_app_number_edit_text);
        select_type_edit_text = rootView.findViewById(R.id.select_type_edit_text);
        select_type_act = rootView.findViewById(R.id.select_type_act);
        date_edit_text = rootView.findViewById(R.id.date_picker);
        submit_btn = rootView.findViewById(R.id.submit_btn);
             //Get&Set DatePicker
        date_edit_text.setOnClickListener(v -> {
            new DatePickerDialog(getActivity() , date , calendar
            .get(Calendar.YEAR) ,
                    calendar.get(Calendar.MONTH) ,
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        //Set ArrayList For SelectType EditText
        arrayList_type = new ArrayList<>();
        arrayList_type.add("Teacher");
        arrayList_type.add("Student");
        arrayAdapter_type = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,arrayList_type);
        select_type_act.setAdapter(arrayAdapter_type);
        select_type_act.setThreshold(1);
        submit_btn.setOnClickListener(v -> {


                    //TODO: Check there no empty Text
                     checkUserDate();


            //TODO: Save User Data into class until he insert other data


            //TODO:Sign Up as Teacher
//            if(select_type_act.getText().toString().equals("Teacher")){
//                select_type_act.setText("");
//
//                //TODO: Open Assistant Fragment
//                previous_fragment = new SignUpDataFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container_fragment , new AssistantFragment() , "AssistantFragment")
//                        .addToBackStack(previous_fragment.getClass().getName()).commit();
//            }
//            //TODO:Sign Up as Student
//            else if (select_type_act.getText().toString().equals("Student")){
//                select_type_act.setText("");
//                //TODO: Create Account
//                Toast.makeText(getActivity(), "Student", Toast.LENGTH_SHORT).show();
//
//            }
//            //Select Type Empty
//            else
//                Toast.makeText(getActivity(), R.string.type_empty, Toast.LENGTH_SHORT).show();
       });

        return rootView;
    }

    protected void checkUserDate() {

        String firstName = name_edit_text.getText().toString().trim();
        String e_Mail = email_edit_text.getText().toString().trim();
        String Password = password_edit_text.getText().toString().trim();
        String phone = phone_edit_text.getText().toString().trim();
        String whats_app_num = whatsAppNumber_edit_text.getText().toString().trim();
        String date = date_edit_text.getText().toString().trim();
        String select_type = select_type_act.getText().toString();
        if (firstName.isEmpty()
                || e_Mail.isEmpty()
                || Password.isEmpty()
                || phone.isEmpty()
                || whats_app_num.isEmpty()
                || date.isEmpty()
                || select_type.isEmpty()) {
            Toast.makeText(getActivity(), "check your date", Toast.LENGTH_LONG).show();
        }
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        String checkspaces = "[+-](201)[0-9]{9}";
        String checkPassword = "^" +
                "(?=.*[0-9]{8})" +         //at least 1 digi
                "(?=.*[a-z])" +         //at least 1 lower case letter
                //  "(?=.*[A-Z])" +         //at least 1 upper case letter
                //      "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                //"(?=S+$)" +           //no white spaces
                // ".{4,}" +               //at least 4 characters
                "$";
        if (!phone.matches(checkspaces)) {
            phone_edit_text.setError("No White spaces are allowed!");

        }
        if (!whats_app_num.matches(checkspaces)) {
            whatsAppNumber_edit_text.setError("No White spaces are allowed!");

        }
        if (Password.matches(checkPassword)) {
            password_edit_text.setError("Password should contain at least 1 upper case letter and 1 number!");
            //     Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
        }
//        int currentYear = android.icu.util.Calendar.getInstance().get(android.icu.util.Calendar.YEAR);
//        int userAge = Integer.parseInt(date);
//        int isAgeValid = currentYear - userAge;
        if (!e_Mail.matches(checkEmail)) {
            email_edit_text.setError("Invalid Email!");
        }


        else {
            password_edit_text.setError(null);
            phone_edit_text.setError(null);
            email_edit_text.setError(null);
            whatsAppNumber_edit_text.setError(null);

            if(select_type_act.getText().toString().equals("Teacher")) {
                AssistantFragment fragment = new AssistantFragment();
                Bundle args = new Bundle();
                args.putString("firstName", firstName);
                args.putString("e_Mail", e_Mail);
                args.putString("date", date);
                args.putString("Password", Password);
                args.putString("whats_app_num", whats_app_num);
                args.putString("phone", phone);
                fragment.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();}


                //TODO: Open Assistant Fragment
//                previous_fragment = new SignUpDataFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container_fragment , new AssistantFragment() , "AssistantFragment")
//                        .addToBackStack(previous_fragment.getClass().getName()).commit();

            //TODO:Sign Up as Student
             if (select_type_act.getText().toString().equals("Student")){
                select_type_act.setText("");
                //Create Account
                signUp(select_type, firstName, e_Mail,  Password, phone,  whats_app_num, date);
                Toast.makeText(getActivity(), "Student", Toast.LENGTH_SHORT).show();


        }}}



    protected void signUp(String select_type,String firstName, String e_Mail, String Password, String phone,
                           String   whats_app_num,String date){
        DatabaseReference databaseReference;
   databaseReference= FirebaseDatabase.getInstance().getReference(select_type);
   final String id=  databaseReference.child(select_type).push().getKey();

            databaseReference.child(phone).setValue(new User(
                    id,select_type, firstName, e_Mail,  Password, phone,  whats_app_num, date));
                            createUser(e_Mail,Password);
    }

    protected void createUser(String email,String password) {
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @SuppressLint("ShowToast")
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getActivity(), "LOGIN Success", Toast.LENGTH_SHORT);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Failure", Toast.LENGTH_SHORT);
            }
        });

}}