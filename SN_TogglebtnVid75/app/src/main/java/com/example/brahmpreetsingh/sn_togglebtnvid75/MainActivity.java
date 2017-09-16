package com.example.brahmpreetsingh.sn_togglebtnvid75;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{
    ToggleButton jtogglebutton1;
    RelativeLayout jrl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jtogglebutton1=(ToggleButton)findViewById(R.id.xtoggleButton1);
        jrl1=(RelativeLayout)findViewById(R.id.xrl1);
        jtogglebutton1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {                       //Here 'buttonView' contains object 'jtogglebutton1' & the second parameter indicates
                                                                                               //if the ToggleButton was checked or not.
        if(isChecked)                                                                //"true" state i.e. checked
        {
            jrl1.setBackgroundColor(Color.BLACK);
        }
        else
        {
            jrl1.setBackgroundColor(Color.WHITE);
        }
    }
}
