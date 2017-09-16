package com.example.brahmpreetsingh.sn_actvtylifecyclev12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Brahm","onCreate() method called");
    }

    @Override
    protected void onStart() {
        Log.d("Brahm","onStart() method called");
        super.onStart();                           //While using lifecycle methods make sure that you use its parent class implementation(Done)
    }

    @Override
    protected void onStop() {
        Log.d("Brahm","onStop() method called");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d("Brahm","onPause() method called");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Brahm","onResume() method called");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d("Brahm","onRestart() method called");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d("Brahm","onDestroy() method called");
        super.onDestroy();
    }
}

//We can apply filter for tags in Logcat by clicking " Edit Filters" and adding one by giving "Filter name" & "tag name"
//Example: I am able to see Messages with "Brahm" Tag only as I have defined the filter. (LOGCAT)