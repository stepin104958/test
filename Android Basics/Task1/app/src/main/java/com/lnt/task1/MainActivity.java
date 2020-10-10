package com.lnt.task1;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String HOME_ACTIVITY_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Called when the user press the send button
     */
    public void sendMyMessage(View view) {
        Intent intent = new Intent(this, Display.class);
        EditText editText = (EditText) findViewById(R.id.message);
        String msg = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
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