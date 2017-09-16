package com.example.brahmpreetsingh.sn_basicexpintentvid24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button jbutton1;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       jbutton1=(Button)findViewById(R.id.xbutton1);
    }

    public void doSomething(View v)                           //In a way we passed View for button here
    {   //WAY 1
        //Intent i = new Intent(this,ActivityB.class);
        //startActivity(i);

        //Way 2
        Intent i = new Intent();
        i.setClassName("com.example.brahmpreetsingh.sn_basicexpintentvid24","com.example.brahmpreetsingh.sn_basicexpintentvid24.ActivityB");
        startActivity(i);
    }

}