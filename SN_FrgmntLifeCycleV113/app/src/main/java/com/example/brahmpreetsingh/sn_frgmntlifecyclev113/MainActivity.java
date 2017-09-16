package com.example.brahmpreetsingh.sn_frgmntlifecyclev113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/*
 ************************************Video 113 to 115*****************************************
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Brahm","onCreate called (Activity)");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Brahm","onStart called(Activity)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Brahm","onStop called(Activity)");
    }

    @Override
    protected void onDestroy() {
        Log.i("Brahm","onDestroy called (Activity)");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i("Brahm","onBackPressed called (Activity)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Brahm","onPause called (Activity)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Brahm","onResume called (Activity)");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Brahm","onRestart called (Activity)");
    }
}
