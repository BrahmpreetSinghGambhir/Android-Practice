package com.example.brahmpreetsingh.sn_listactivityvid80;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    ListView jlist;
    String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jlist=getListView();
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        jlist.setAdapter(arr);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,((TextView)v).getText().toString()+""+position,Toast.LENGTH_LONG).show();
    }
}
