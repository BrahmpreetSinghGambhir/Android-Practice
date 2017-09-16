package com.example.brahmpreetsingh.sn_javalinearlayoutv41;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll=new LinearLayout(this);
        t=new TextView(this);
        b=new Button(this);

        LinearLayout.LayoutParams dimension123 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimension123);

        LinearLayout.LayoutParams dimension456 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        t.setLayoutParams(dimension456);
        b.setLayoutParams(dimension456);

        ll.setOrientation(LinearLayout.VERTICAL);

        t.setText("Hello world!");
        b.setText("Click me!");

        ll.addView(t);
        ll.addView(b);



        setContentView(ll);

    }
}
