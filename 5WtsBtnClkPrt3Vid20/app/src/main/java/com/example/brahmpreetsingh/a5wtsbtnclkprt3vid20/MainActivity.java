package com.example.brahmpreetsingh.a5wtsbtnclkprt3vid20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//Anonymous InnerClass way

public class MainActivity extends AppCompatActivity {

    Button jbutton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbutton1=(Button)findViewById(R.id.xbutton1);
        jbutton1.setOnClickListener(o);                            //Object 'o' passed here as we made object of 'OnClickListener'
    }                                                              //by implementing unimplemented method onClick() at the same place.

    View.OnClickListener o=new View.OnClickListener() {            //Interface 'OnClickListener' instantiated by implementing unimplemented method in braces.
        @Override                                                   //Code from "new.......};" can be directly passed to setOnClickListener() as anonymous inner class.
        public void onClick(View v) {
            Log.d("Brahm","Button clicked !!!!!!");
        }
    };
}
