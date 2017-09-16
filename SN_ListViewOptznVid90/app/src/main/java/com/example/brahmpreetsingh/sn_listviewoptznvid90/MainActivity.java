package com.example.brahmpreetsingh.sn_listviewoptznvid90;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView jlistview;

    //Data defined
    String[] titles={"Meme1","Meme2","Meme3","Meme4","Meme5"};
    String[] discriptions={"Discription 1","Discription 2","Discription 3","Discription 4","Discription 5"};
    int[] images={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jlistview=(ListView)findViewById(R.id.xlistView);

        CustomAdapter adap123 = new CustomAdapter(this,titles,discriptions,images);
        jlistview.setAdapter(adap123);
    }
}














class CustomAdapter extends ArrayAdapter<String>
{
    Context custAdapContxt;
    String[] titlesarray;
    String[] descarray;
    int[] imgs;


    CustomAdapter(Context c,String[] titles,String[] discriptions,int[] images)
    {

        super(c,R.layout.single_row,R.id.xtv1,titles);


        this.custAdapContxt=c;
        this.descarray=discriptions;
        this.imgs=images;
        this.titlesarray=titles;
    }









     @Override
    public View getView(int position, View convertView, ViewGroup parent)
                                         {
                                         View CounterConvertView=convertView;

                                         if(CounterConvertView==null) {                      //if null then it will fill the 'CounterConvertView'
                                         LayoutInflater inflater123 = (LayoutInflater) custAdapContxt.getSystemService(custAdapContxt.LAYOUT_INFLATER_SERVICE);
                                         CounterConvertView = inflater123.inflate(R.layout.single_row, parent, false);
                                         }

                                         ImageView jimageview=(ImageView) CounterConvertView.findViewById(R.id.ximageView);
                                         TextView jtv1=(TextView) CounterConvertView.findViewById(R.id.xtv1);
                                         TextView jtv2=(TextView) CounterConvertView.findViewById(R.id.xtv2);

        jimageview.setImageResource(imgs[position]);
        jtv1.setText(titlesarray[position]);
        jtv2.setText(descarray[position]);



        return CounterConvertView;
    }
}
