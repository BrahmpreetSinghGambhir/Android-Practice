package com.example.brahmpreetsingh.gridviewvid97to103;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        Intent objintent2=getIntent();

        //Saving data into variables coming from 'MainActivity.java'
        int tempimage2=objintent2.getIntExtra("countryimagekey",R.drawable.canada);           //Second parameter is mandatory in case of getIntExtra()
        String tempname2=objintent2.getStringExtra("countrynamekey");

        //Lets create references to componenets in MyDialog.xml
        TextView jjtextview=(TextView)findViewById(R.id.xxtextView);
        ImageView jjimageview=(ImageView)findViewById(R.id.xximageView);

        //Setting data to components
        jjtextview.setText(tempname2);
        jjimageview.setImageResource(tempimage2);

    }
    public void doSomething(View v)
    {
        finish();                                       //This finish() method will simply close the dialog.
    }
}
