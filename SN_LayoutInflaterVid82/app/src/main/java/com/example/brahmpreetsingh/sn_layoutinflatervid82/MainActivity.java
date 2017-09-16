package com.example.brahmpreetsingh.sn_layoutinflatervid82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout jlinearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlinearlayout=(LinearLayout)findViewById(R.id.xlinearlayout);

        LayoutInflater layoutinflater123 = getLayoutInflater();
        View v = layoutinflater123.inflate(R.layout.sub_layout,jlinearlayout,false);
        jlinearlayout.addView(v);
    }
}
