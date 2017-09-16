package com.example.brahmpreetsingh.sn_customfontvid71;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView jtv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jtv1=(TextView) findViewById(R.id.xtv1);                                                    //Step 1: Java Reference created
        Typeface MyTypefaceObject123 = Typeface.createFromAsset(getAssets(),"fonts/SAMAN___.TTF");  //Step 2: We have made object containing the custom font using 'createFromAsset()' method
                                                                                                    //present in 'Typeface' class. This 'createFromAsset()' takes two parameters :
                                                                                                    //1. AssetManager object  (Object retrived via 'getAssets()' method
                                                                                                    //2. CustomFont location
        jtv1.setTypeface(MyTypefaceObject123);                                                      //We've set Typeface object 'MyTypeFaceObject123' to 'jtv1' using 'setTypeface()' method
    }

}
