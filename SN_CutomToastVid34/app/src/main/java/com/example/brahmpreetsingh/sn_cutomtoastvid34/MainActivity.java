package com.example.brahmpreetsingh.sn_cutomtoastvid34;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void process(View v)
    {

        Toast t = new Toast(this);
        t.setDuration(Toast.LENGTH_LONG);
        t.setGravity(Gravity.BOTTOM,0,0);

        LayoutInflater lin = getLayoutInflater();
        View v1 = lin.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.xlinearlayout));
        t.setView(v1);
        t.show();

    }
}
