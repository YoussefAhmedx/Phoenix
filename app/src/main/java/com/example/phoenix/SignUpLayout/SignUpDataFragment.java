package com.example.phoenix.SignUpLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.phoenix.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SignUpDataFragment extends Fragment {
    public SignUpDataFragment() {
        // Required empty public constructor
    }
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


            //TODO: Save User Data into class until he insert other data


            //TODO:Sign Up as Teacher
            if(select_type_act.getText().toString().equals("Teacher")){
                select_type_act.setText("");
                
                //TODO: Open Assistant Fragment
                previous_fragment = new SignUpDataFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment , new AssistantFragment() , "AssistantFragment")
                        .addToBackStack(previous_fragment.getClass().getName()).commit();
            }
            //TODO:Sign Up as Student
            else if (select_type_act.getText().toString().equals("Student")){
                select_type_act.setText("");
                //TODO: Create Account
                Toast.makeText(getActivity(), "Student", Toast.LENGTH_SHORT).show();

            }
            //Select Type Empty
            else
                Toast.makeText(getActivity(), R.string.type_empty, Toast.LENGTH_SHORT).show();
        });

        return rootView;
    }
}