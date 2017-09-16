package com.example.brahmpreetsingh.a5wysbtnclkprt2vid19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button jbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbutton1=(Button)findViewById(R.id.xbutton1);
        jbutton1.setOnClickListener(new Inrclass());                //Object of 'Inrclass' class passed as it is implementing the 'OnClickListener' interface
    }

    //Inner Class
    class Inrclass implements View.OnClickListener                  //We made inner class 'Inrclass' in 'MainActivity' class, implemented 'OnClickListener' interface in it & passed
    {                                                               //object of class 'InrClass' while linking Button to Listener i.e.  jbutton1.setOnClickListener(new Inrclass());
        @Override
        public void onClick(View v) {
            Log.d("Brahm","Button clicked !!!");
        }
    }
}
