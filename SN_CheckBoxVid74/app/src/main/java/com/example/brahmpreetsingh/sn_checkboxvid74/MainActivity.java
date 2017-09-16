package com.example.brahmpreetsingh.sn_checkboxvid74;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox jcb1;

    @Override
    public void onClick(View v) {                //This object 'v' contains the object of CheckBox
        CheckBox vcb1=(CheckBox) v;              //Here we have created a temporary reference to that checkbox only (View typecasted to checkbox)
        if (vcb1.isChecked())
        {
            Toast.makeText(this,"You need sugar! Good",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"You dont need sugar! WOW",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jcb1=(CheckBox)findViewById(R.id.xcb1);
        jcb1.setOnClickListener(this);                        //Listener assigned to checkbox's java reference ie jcb1


    }
}
