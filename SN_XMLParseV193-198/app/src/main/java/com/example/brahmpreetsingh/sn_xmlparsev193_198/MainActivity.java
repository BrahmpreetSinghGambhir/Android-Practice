package com.example.brahmpreetsingh.sn_xmlparsev193_198;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;






//MAIN CLASS (Destroyable)
public class MainActivity extends AppCompatActivity implements ResultsCallBack
{

    PlaceHolderFragment fragment123;
    ListView jlistview;

    @Override
    public void onPreExecute()
    {

    }

    @Override
    public void onPostExecute(ArrayList<HashMap<String, String>> results)
    {
       jlistview.setAdapter(new MyAdapter(this,results));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Here we're adding fragment to activity after checking condition
        if (savedInstanceState == null)                                                                //Checking if fragment is already attached to activity
        {
            fragment123 = new PlaceHolderFragment();
            getSupportFragmentManager().beginTransaction().add(fragment123, "FragmentTag");
        } else {
            fragment123 = (PlaceHolderFragment) getSupportFragmentManager().findFragmentByTag("FragmentTag");
        }
        fragment123.startTask();                            //Method 'startTask()' present in Fragment meant for starting TechCrunchTask called

        jlistview=(ListView)findViewById(R.id.xlistView);
    }








    //FRAGMENT CLASS (Immortal)
    public static class PlaceHolderFragment extends Fragment {
        TechCrunchTask myTask;
        ResultsCallBack callBack;

        //Constructor
        public PlaceHolderFragment() {

        }

        /*
        Using onAttach() & onDetach() we will be telling AsyncTask class about the new activie Activity in place now.
        */

        @Override
        public void onAttach(Activity activity)           //This method is called everytime existing Activity gets destroyed & new Activity gets created
        {
            super.onAttach(activity);
            callBack=(ResultsCallBack) activity;
            if(myTask!=null)
            {
                myTask.onAttach(callBack);                      //Here we're passing typecasted activity to onAttach() method of TechCrunchTask class
            }

        }

        @Override
        public void onDetach()                          //This gets called evertime an Activity is about to be destroyed to detach fragmet from Activty
        {
            super.onDetach();
            callBack=null;
            if(myTask!=null) {
                myTask.onDetach();
            }
        }


        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);                        //This made Fragment immortal
        }




        //Method responsible for starting TechCrunchTask
        public void startTask() {
            if (myTask != null) {
                myTask.cancel(true);
            } else {
                myTask = new TechCrunchTask(callBack);
                myTask.execute();
            }
        }
    }








    //ASYNCTASK CLASS
    // (Being a static class, this has no way relation to MainActivity but we need data from this class to be updated in the ListView component of MainActivity)
    public static class TechCrunchTask extends AsyncTask<Void, Void, ArrayList<HashMap<String,String>>>
    {
        URL url;
        ResultsCallBack callBack=null;

        //CONSTRUCTOR
        public TechCrunchTask(ResultsCallBack callBack)
        {
            this.callBack=callBack;
        }

        @Override
        protected ArrayList<HashMap<String,String>> doInBackground(Void... params)
        {
            ArrayList<HashMap<String, String>> results = new ArrayList<>();     //ArrayList initalized to receive ArrayList from processXML()
            try {
                url = new URL("https://feeds.feedburner.com/techcrunch/android?format=xml");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                InputStream inputStream_Object = con.getInputStream();
                results = processXML(inputStream_Object);                    //processXML() method responsible for DOM parsing called & InputStream object passed
                                                                             //and returned ArrayList object received in corresponding ArratyList object

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return results;
        }


        //This method will be responsible for DOM parsing. (processXML() method responsible for receiving Inputstream object and precessing it)
        public ArrayList<HashMap<String,String>> processXML(InputStream inputStream) throws Exception
        {


            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document xmldocument = documentBuilder.parse(inputStream);                   //With the help of parse() method, here we're parsing
            // received InputStream object in 'inputStream'parameter of method
            Element rootElement = xmldocument.getDocumentElement();
            // Log.d("Brahm","The root element is: "+rootElement.getTagName());


            NodeList itemList123;
            Node currentItem;
            NodeList itemChildren;                                                  //NodeList saves Elements under 'Item'
            Node currentChild;
            // NamedNodeMap mediaThumbnailAttributes;
            // Node currentAttribute;
            int counter = 0;
            ArrayList<HashMap<String, String>> results = new ArrayList<>();         //ArrayList initialized to save HashMap object for each item
            HashMap<String, String> hashMap = null;                   //We have used HashMap so that we could save data in the form of Key & value format
                                                                      //(One Hash-map initialized for every one item)


            itemList123 = rootElement.getElementsByTagName("item");                   //Got the elements list with tag 'item' in 'itemList123' variable

            for (int i = 0; i < itemList123.getLength(); i++)                         //Loop handling all the 'item' tags
            {
                currentItem = itemList123.item(i);
                // Log.d("Brahm", "" + currentItem.getNodeName());
                itemChildren = currentItem.getChildNodes();                   //Got the node list present in the current Item into 'itemChildren' variable
                hashMap = new HashMap<>();                                    //HashMap initialized at the item level


                for (int j = 0; j < itemChildren.getLength(); j++)                      //Loop handling all the children tags contained in 'item'
                {
                    currentChild = itemChildren.item(j);
                    //Log.d("Brahm",currentChild.getNodeName());            //This gave us list of all nodes present under item element

                    //Shortcut (For this case) --->
                    if (currentChild.getNodeName().equalsIgnoreCase("media:thumbnail")) {
                        counter++;
                        if (counter == 2) {
                            // Log.d("Brahm", "url: " + currentChild.getAttributes().item(0).getTextContent());
                            hashMap.put("Hash_url", currentChild.getTextContent());                     //Putting data into HashMap in the format of key-value pair
                        }

                        //Long ideal way --->
                                        /*
                                        mediaThumbnailAttributes= currentChild.getAttributes();
                                        for (int k=0; k<mediaThumbnailAttributes.getLength();k++) {
                                            currentAttribute=mediaThumbnailAttributes.item(k);
                                            // Log.d("Brahm",currentAttribute.getNodeName());        //This wil give us attribute names under media:thumbnail
                                            if(currentAttribute.getNodeName().equalsIgnoreCase("url"))
                                            {
                                            counter++;
                                                if(counter==2)
                                                {
                                                    Log.d("Brahm",currentAttribute.getTextContent());
                                                }
                                            }
                                        }
                                        */

                    }

                    if (currentChild.getNodeName().equalsIgnoreCase("description")) {
                        // Log.d("Brahm", "Description : " + currentChild.getTextContent());
                        hashMap.put("Hash_description", currentChild.getTextContent());      //Putting data into HashMap in the format of key-value pair
                    }


                    if (currentChild.getNodeName().equalsIgnoreCase("title")) {
                        // Log.d("Brahm", "Title: " + currentChild.getTextContent());
                        hashMap.put("Hash_title", currentChild.getTextContent());             //Putting data into HashMap in the format of key-value pair
                    }


                    if (currentChild.getNodeName().equalsIgnoreCase("pubDate")) {
                        // Log.d("Brahm", "pubDate: " + currentChild.getTextContent());
                        hashMap.put("Hash_pubDate", currentChild.getTextContent());            //Putting data into HashMap in the format of key-value pair
                    }
                }

                if(hashMap!=null & !hashMap.isEmpty())
                {
                    results.add(hashMap);                                           //Adding 'hashMap' object for each item to ArrayList of Hashmaps
                }
                // Log.d("Brahm",""+hashMap);
                counter = 0;

            }
            return results;
        }

        //Receiving information (Typecasted activity) from Fragment class
        public void onAttach(ResultsCallBack callBack)
        {
            this.callBack=callBack;
        }

        public void onDetach()
        {
            callBack=null;
        }

        /*
        Using these two methods onPreExecute() & onPostExecute() we will be telling MainActivity about the active activity in AsyncTask class as
        informed to it by Fragment class
        */


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (callBack != null) {
                callBack.onPreExecute();            //calling on preExecute() method of MainActivity via type-casted object of Activity ie callBack
            }
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> hashMaps) {
            // Log.d("Brahm",hashMaps+"");                                                     //Displaying received 'results' object from doInBackground() in Log.d
            if (callBack != null) {
                callBack.onPostExecute(hashMaps);   //calling on preExecute() method of MainActivity via type-casted object of Activity ie callBack
            }
        }


    }
}





/*The sole target of creating this interface is to make MainActivity implement this interface by overriding and defining these methods in a way that it recevies
data & results fromn AsyncTask class (We've created this interface also so that MainActivity knows the active activity current in AsyncTask as informend by
Fragment to it*/

//INTERFACE
interface ResultsCallBack
{
    public void onPreExecute();
    public void onPostExecute(ArrayList<HashMap<String,String>> results);
}




class MyAdapter extends BaseAdapter
{
    ArrayList<HashMap<String,String>> dataSource = new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    View row;
    MyHolder holder;
    public MyAdapter(Context context , ArrayList<HashMap<String,String>> results)
    {

        this.context=context;
        this.dataSource=results;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.row=convertView;
        if(row==null) {
            row = inflater.inflate(R.layout.custom_row, parent, false);
            holder = new MyHolder(row);
            row.setTag(holder);
        }
        else
        {
            holder=(MyHolder) row.getTag();
        }

        HashMap<String,String> currentItem = dataSource.get(position);
        holder.jTitle.setText(currentItem.get("Hash_title"));
        holder.jImageView.setImageURI(Uri.parse(currentItem.get("Hash_url")));
        holder.jpubDate.setText(currentItem.get("Hash_pubDate"));
        holder.jDescription.setText(currentItem.get("Hash_description"));
        return row;
    }
}

class MyHolder
{
    TextView jTitle;
    TextView jpubDate;
    ImageView jImageView;
    TextView jDescription;
    public MyHolder(View row)
    {
        jTitle=(TextView)row.findViewById(R.id.xtextViewTitle);
        jpubDate=(TextView)row.findViewById(R.id.xtextViewPub);
        jImageView=(ImageView)row.findViewById(R.id.ximageView);
        jDescription=(TextView)row.findViewById(R.id.xtextViewDesc);

    }
}

