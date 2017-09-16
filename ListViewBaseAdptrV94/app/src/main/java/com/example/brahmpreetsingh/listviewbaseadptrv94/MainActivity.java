package com.example.brahmpreetsingh.listviewbaseadptrv94;

import android.content.Context;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView jlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview=(ListView)findViewById(R.id.xlistView);
        CustmAdapter adapter123 = new CustmAdapter(this);
        jlistview.setAdapter(adapter123);


    }






    class SingleRowData                  //We will be making composite object out of this.
    {
        String title;
        String discription;
        int image;
        SingleRowData(String Ctitle,String Cdiscription,int Cimages)
        {
            this.title=Ctitle;
            this.discription=Cdiscription;
            this.image=Cimages;
        }
    }






    /*
    1. Create a class that extends Base adapter and implements all the methods.
    2.Maintain some array inside your base adapter class that will contain all the date {Images+Titles+discriptions)
    3.Use the 'getView()' to fill the data from your array e the custom structure of that single row for each row
     */
    class CustmAdapter extends BaseAdapter
    {
        ArrayList<SingleRowData> list123;                          //ArrayList  of 'SingleRowData' type reference created.
        Context CustAdapcontext;
        CustmAdapter(Context c)                         //Constructor defined to which context shall be received. We need Context's object here so that we can retrieve resources
        {

            this.CustAdapcontext=c;
            list123=new ArrayList<>();                    //This is an empty list here

            /*
            1. Get the tiles, discriptions, images from xml
            2. Group each title its relateed discription and image into single row object.
            3. Put the single row object inside Arraylist
             */

            Resources res123=c.getResources();
            String[] Titles = res123.getStringArray(R.array.Titles);
            String[] Discription = res123.getStringArray(R.array.Discriptions);
            int[] images = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a1,R.drawable.a2,R.drawable.a3};

            for(int i=0;i<=7;i++)
            {
            SingleRowData s =new SingleRowData(Titles[i],Discription[i],images[i]);           //Making object of class 'SingleRowData' by passing values to constructor of same.
            list123.add(s);
        }
        }
        @Override
        public int getCount() {                                                             //This will tell number of elements ie no. of composite objects.
            return list123.size();
        }

        @Override
        public Object getItem(int position) {                                               //This will return Composite object of specified position
            return list123.get(position);
        }

        @Override
        public long getItemId(int position) {                                                //This will return ItemId of the Composite object
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //2nd parameter 'convertView' tells that if we are creating it
                                                                                // for the first time or subssequent time
            /*
            1. Get the root view
            2. Use the root view to find other views
            3. Set the values to inner views
             */
            LayoutInflater inflater123 = (LayoutInflater)CustAdapcontext.getSystemService(LAYOUT_INFLATER_SERVICE);
            View RowView = inflater123.inflate(R.layout.single_row,parent,false);

            TextView WTitles =(TextView)RowView.findViewById(R.id.xtv1);
            TextView WDiscription = (TextView)RowView.findViewById(R.id.xtv2);
            ImageView Wimages = (ImageView) RowView.findViewById(R.id.ximageView);

            SingleRowData temp = list123.get(position);           //here 'get()' method is returning the composite object at a certain position.

            WTitles.setText(temp.title);
            WDiscription.setText(temp.discription);
            Wimages.setImageResource(temp.image);

            return RowView;
        }
    }
}
