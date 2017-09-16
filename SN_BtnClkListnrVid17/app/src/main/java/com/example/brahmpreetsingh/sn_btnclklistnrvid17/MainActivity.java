package com.example.brahmpreetsingh.sn_btnclklistnrvid17;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button jbutton1;
    Button jbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbutton1=(Button)findViewById(R.id.xbutton1);
        jbutton1.setOnClickListener(this);
        jbutton2=(Button)findViewById(R.id.xbutton2);
        jbutton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.xbutton1)
        {
        Log.d("Brahm","Button 1 click ho gya");
        }
        if(v.getId()==R.id.xbutton2)
        {
            Log.d("Brahm","Button 2 click ho gya");
        }
    }
}

