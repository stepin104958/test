package com.lnt.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //Array List for person names
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Virat","Rohit","Steve","Hardik","Krunal"));
    ArrayList<String> lastName=  new ArrayList<>(Arrays.asList("Kohli","Sharma","Smith","Pandya","Pandya"));
    ArrayList<Integer> file = new ArrayList<>(Arrays.asList(R.drawable.new,R.drawable.new,R.drawable.new,R.drawable.new,R.drawable.new))
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // call the constructor of CustomAdapter to send the reference and data to Adapter
        NewAdapter newAdapter = new NewAdapter(MainActivity.this, personNames,lastName);

        recyclerView.setAdapter(newAdapter);
    }
}