package com.example.brahmpreetsingh.sn_listviewimagevid84;
                                                                    //Video 84 to 89 covered
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        //   Resources res123 = getResources();
        //   titles = res123.getStringArray(R.array.titlearray);                    //This is also a way to assign data to array titles
        //   discriptions = res123.getStringArray(R.array.discarray);
        //   images = res123.getDrawable(R.array.imagearray,null);


        CustomAdapter adap123 = new CustomAdapter(this,titles,discriptions,images);
        jlistview.setAdapter(adap123);
    }
}













// Making class of custom adapter, later of which we will make object.
class CustomAdapter extends ArrayAdapter<String>
{
    Context custAdapContxt;                                           //These are the variables that are fetching data from Main Class.
    String[] titlesarray;                                             //eg. to use 'this' context we have made object of Context i.e
    String[] descarray;                                               //'custAdapContxt'.
    int[] imgs;

    //Constructor created
    CustomAdapter(Context c,String[] titles,String[] discriptions,int[] images)
    {
        //Super constructor called (Mandatory to get previliges of ArrayAdapter class)
        super(c,R.layout.single_row,R.id.xtv1,titles);

        //We're fetching data values here to the vvariable we've created in the 'CustomAdapter' class.
        this.custAdapContxt=c;
        this.descarray=discriptions;
        this.imgs=images;
        this.titlesarray=titles;
    }









    //At Runtime, 'getView()' method will be called and thereby appearnce of row will get set ie data will be poured to 'single_row' view.
    //In this method only 'ListView' will call the adapter i.e. 'CustomAdapter'  and thus 'getView()' will get called.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //Here we will make java object for 'single_row.xml"
        // To make java object of LayoutInflater outside MainClass, we need the context of MAinClass.
        LayoutInflater inflater123 = (LayoutInflater) custAdapContxt.getSystemService(custAdapContxt.LAYOUT_INFLATER_SERVICE);

        // RowView inflated with content of 'single_row' layout
        View RowView = inflater123.inflate(R.layout.single_row,parent,false);       //'RowView' contains reference to 'parent'


        //Proper java reference created to respective views present in Main View i.e. RowView
        ImageView jimageview=(ImageView) RowView.findViewById(R.id.ximageView);
        TextView jtv1=(TextView) RowView.findViewById(R.id.xtv1);
        TextView jtv2=(TextView) RowView.findViewById(R.id.xtv2);

        //Data is being poured into the respective Views of MainView i.e. 'RowView'
        jimageview.setImageResource(imgs[position]);
        jtv1.setText(titlesarray[position]);
        jtv2.setText(descarray[position]);



        return RowView;         //The final view created for a row is being returned here.
    }
}
