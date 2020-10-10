package com.lnt.timeticker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewDatePicker extends AppCompatActivity {

    DatePicker newDatePicker;
    TextView date;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_date_picker);

        date = (TextView) findViewById(R.id.date);
        newDatePicker= (DatePicker) findViewById(R.id.DatePicker);
        submit = (Button) findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day ="+ newDatePicker.getDayOfMonth();
                String month = "Month =" + (newDatePicker.getMonth() + 1);
                String year = "Year =" + newDatePicker.getYear();

                Toast.makeText(getApplicationContext(), day + "\n"+ month + "\n"+ year+"\n",Toast.LENGTH_SHORT).show();
                date.setText("Date is  "+newDatePicker.getDayOfMonth()+" / "+ (newDatePicker.getMonth() + 1) + " / " + newDatePicker.getYear());
            }
        });



    }
}