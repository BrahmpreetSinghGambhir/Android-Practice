package com.example.brahmpreetsingh.sn_framelayoutv70;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView jimageview1;
    ImageView jimageview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jimageview1=(ImageView)findViewById(R.id.ximageView1);
        jimageview2=(ImageView) findViewById(R.id.ximageView2);

        jimageview1.setOnClickListener(this);
        jimageview2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if(v.getId()==R.id.ximageView1)
    {
        jimageview1.setVisibility(View.GONE);
        jimageview2.setVisibility(View.VISIBLE);
    }
        else
    {
        jimageview2.setVisibility(View.GONE);
        jimageview1.setVisibility(View.VISIBLE);
    }
    }
}
