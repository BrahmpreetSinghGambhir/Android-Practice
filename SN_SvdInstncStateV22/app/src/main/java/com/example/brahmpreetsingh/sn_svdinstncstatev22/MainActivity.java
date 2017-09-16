package com.example.brahmpreetsingh.sn_svdinstncstatev22;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        count++;
        Log.d("Brahm","Resume count is "+count);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("Brahm123",count);                             //Putting integer value into object "outState"
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {     //Bundle object here is same as  that passed to onCreate() method
        count = savedInstanceState.getInt("Brahm123");                 //Retriving integer value from object "savedIntanceState" and key passed
        super.onRestoreInstanceState(savedInstanceState);
    }
}
