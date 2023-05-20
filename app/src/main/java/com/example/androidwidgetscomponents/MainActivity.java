package com.example.androidwidgetscomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4;

    Button pickTime,pickDate,save;
    ProgressBar progressBar;
    RadioGroup radioGroup;
    TextView gender,time,date,t1,t2,t3,t4;

    Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        c = Calendar.getInstance();





        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hrs = c.get(Calendar.HOUR);
                int min = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hrs, int min) {
                        time.setText(hrs+":"+min);
                    }
                },hrs,min,false);
                timePickerDialog.show();
            }
        });

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DATE);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month,int day) {
                        date.setText(day+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group,int checkedId){
                RadioButton radioButton = findViewById(checkedId);
                gender.setText(radioButton.getText().toString());
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                    t1.setVisibility(View.VISIBLE);
                }else{

                }
                if (c2.isChecked()) {
                    t2.setVisibility(View.VISIBLE);
                } else{

                }
                if (c3.isChecked()) {
                    t3.setVisibility(View.VISIBLE);
                }else{

                }
                if (c4.isChecked()) {
                    t4.setVisibility(View.VISIBLE);
                }else {

                }
            }
        });

        //progress bar
        progressBar.setProgress(50);

    }


    private void initComponent() {
        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);
        c3 = findViewById(R.id.cb3);
        c4 = findViewById(R.id.cb4);
        radioGroup = findViewById(R.id.radioGrp);
        pickTime = findViewById(R.id.pickTimeBtn);
        pickDate = findViewById(R.id.pickDateBtn);
        progressBar = findViewById(R.id.pgb);
        gender = findViewById(R.id.txt_gender);
        time = findViewById(R.id.txt_time);
        date = findViewById(R.id.txt_date);
        save =  findViewById(R.id.saveCourse);
        t1 = findViewById(R.id.txtPython);
        t2 = findViewById(R.id.txtJava);
        t3 = findViewById(R.id.txtAndroid);
        t4 = findViewById(R.id.txtFlutter);

    }
}