package com.example.brahmpreetsingh.listviewoptznvid92;

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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] Titles = {"Meme1", "Meme2", "Meme3", "Meme4", "Meme5", "Meme6", "Meme7", "Meme8"};
    String[] Discriptions = {"Discription1", "Discription2", "Discription3", "Discription4", "Discription5", "Discription6", "Discription7", "Discription8"};
    int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4};

    ListView jlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview = (ListView)findViewById(R.id.xlistView);

        CustmAdapter adapter123=new CustmAdapter(this,Titles,Discriptions,images);
        jlistview.setAdapter(adapter123);
    }
}

class CustmAdapter extends ArrayAdapter<String> {
    Context ContxtCustmAdapter;
    String[] CustTitles;
    String[] CustDisc;
    int[] CustImages;

    CustmAdapter(Context c, String[] titles, String[] disc, int[] imgs) {
        super(c, R.layout.single_row, R.id.xtv1, titles);
        this.ContxtCustmAdapter = c;
        this.CustTitles = titles;
        this.CustDisc = disc;
        this.CustImages = imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {       //'getView()' method is returning object of View for ng single_Row.xmlsi
        View RowView = convertView;
        MyViewHolder holder123=null;
        if (RowView == null) {
            LayoutInflater inflater123 = (LayoutInflater) ContxtCustmAdapter.getSystemService(ContxtCustmAdapter.LAYOUT_INFLATER_SERVICE);
            RowView = inflater123.inflate(R.layout.single_row, parent, false);
            holder123 = new MyViewHolder(RowView);                  //Here we've sent 'RowView' to constructor of 'MyViewHolder' class ie 'MyViewHolder(View v)'

            RowView.setTag(holder123);
            }
        
        else {
            holder123=(MyViewHolder)RowView.getTag();
            }

        holder123.jimageview.setImageResource(CustImages[position]);
        holder123.jtv1.setText(CustTitles[position]);
        holder123.jtv2.setText(CustDisc[position]);

        return RowView;
    }
}

class MyViewHolder {              //Specialized class to assign 'findviewbyid's
    TextView jtv1;
    TextView jtv2;
    ImageView jimageview;

    MyViewHolder(View v) {
        jtv1 = (TextView) v.findViewById(R.id.xtv1);
        jtv2 = (TextView) v.findViewById(R.id.xtv2);
        jimageview = (ImageView) v.findViewById(R.id.ximageView);
    }
}