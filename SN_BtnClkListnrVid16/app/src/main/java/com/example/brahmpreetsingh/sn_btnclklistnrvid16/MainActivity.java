package com.example.brahmpreetsingh.sn_btnclklistnrvid16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button jbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbutton1=(Button)findViewById(R.id.xbutton1);
        jbutton1.setOnClickListener(this);                       //Button and listener linked here
    }

    @Override
    public void onClick(View v) {
        Log.d("Brahm","Button click ho gya");
    }
}
