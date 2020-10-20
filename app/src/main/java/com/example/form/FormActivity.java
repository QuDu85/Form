package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editBirthday, firstName, lastName, address, email;
    TextView notif;
    RadioButton male,female;
    CheckBox agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.date_picker);
        editBirthday = findViewById(R.id.edit_birthday);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        agree = findViewById(R.id.agree);
        notif = findViewById(R.id.notif);

        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datePicker.getVisibility() == View.GONE) {
                    datePicker.setVisibility(View.VISIBLE);
                } else {
                    datePicker.setVisibility(View.GONE);

                    int day = datePicker.getDayOfMonth();
                    int month = datePicker.getMonth() + 1;
                    int year = datePicker.getYear();

                    editBirthday.setText(String.format("%d/%d/%d", day, month, year));
                }
            }
        });

        findViewById(R.id.regist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notif.setVisibility(View.VISIBLE);
                if(firstName.getText().toString().matches(""))
                    notif.setText("Please enter first name");
                else if(lastName.getText().toString().matches(""))
                    notif.setText("Please enter last name");
                else if(!male.isChecked() && !female.isChecked())
                    notif.setText("Please select gender");
                else if(editBirthday.getText().toString().matches(""))
                    notif.setText("Please enter birthday");
                else if(email.getText().toString().matches(""))
                    notif.setText("Please enter email");
                else if(!agree.isChecked())
                    notif.setText("Please agree to terms of use");
                else
                    notif.setText("Registered successfully");
            }
        });
    }
}