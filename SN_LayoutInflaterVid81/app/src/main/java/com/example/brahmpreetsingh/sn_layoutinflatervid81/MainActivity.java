package com.example.brahmpreetsingh.sn_layoutinflatervid81;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView jtv1;
    LinearLayout jlinearlayout;
    FrameLayout jframelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlinearlayout=(LinearLayout)findViewById(R.id.xlinearlayout);
        jframelayout=(FrameLayout)findViewById(R.id.xframelayout);

        LayoutInflater layoutinflater123 = getLayoutInflater();
        View v = layoutinflater123.inflate(R.layout.sub_layout,null);
    //Case 1
             jlinearlayout.addView(v);

    //Case 2
      //     jframelayout.addView(v);

    }
}
