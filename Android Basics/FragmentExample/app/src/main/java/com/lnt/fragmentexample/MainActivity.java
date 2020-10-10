package com.lnt.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button firstButton,secondButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = (Button) findViewById(R.id.first);
        secondButton = (Button) findViewById(R.id.second);

        final Bundle bundle = new Bundle();
        bundle.putString("message","From Activity to Fragment");

        firstButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
            loadFragment(new firstFragment());
        }
        });

        secondButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                loadFragment(new SecondFragment());
            }
        });
    }


    private void loadFragment(Fragment fragment)
    {
        //set Fragmentclass Arguments
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
        // save the changes
    }


}