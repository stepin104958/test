package com.lnt.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Display extends AppCompatActivity {
    private static final String HOME_ACTIVITY_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView tv=findViewById(R.id.textView);
        tv.setText(message);
    }



    private void showLog(String text)
    {
        Log.d(HOME_ACTIVITY_TAG, text);
    }


    @Override
    protected void onRestart()
    {
        super.onRestart();
        showLog("Activity Restarted");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        showLog("Activity Started");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        showLog("Activity Resumed");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        showLog("Activity Paused");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        showLog("Activity Stopped");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        showLog("Activity Destroyed");
    }
}