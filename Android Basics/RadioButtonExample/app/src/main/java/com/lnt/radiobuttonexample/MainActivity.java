package com.lnt.radiobuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton Op1,Op2,Op3,Op4,Op5;
    Button submitButton;
    String selectedOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Op1 = (RadioButton) findViewById(R.id.Op1);
        Op2 = (RadioButton) findViewById(R.id.Op2);
        Op3 = (RadioButton) findViewById(R.id.Op3);
        Op4 = (RadioButton) findViewById(R.id.Op4);
        Op5 = (RadioButton) findViewById(R.id.Op5);

        submitButton= (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            if(Op1.isChecked())
            {
                selectedOption=Op1.getText().toString();
            }
            else if(Op2.isChecked())
            {
                selectedOption=Op2.getText().toString();
            }
            else if(Op3.isChecked())
            {
                selectedOption=Op3.getText().toString();
            }
            else if(Op4.isChecked())
            {
                selectedOption=Op4.getText().toString();
            }
            else if(Op5.isChecked())
            {
                selectedOption=Op5.getText().toString();
            }
            Toast.makeText(getApplicationContext(),selectedOption,Toast.LENGTH_LONG).show();
        }

        });

    }
}