package com.example.brahmpreetsingh.sn_toastdemovid32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    public void doSomething(View v)
    {
        Toast t=Toast.makeText(this,"You clicked me!",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER,50,100);
        t.show();
        // Toast.makeText(this,"You clicked me!",Toast.LENGTH_SHORT).show();
    }
}
