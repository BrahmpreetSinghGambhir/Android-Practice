package com.example.brahmpreetsingh.sn_handlerbasicegv180;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    ProgressBar jprogressbar;
    Handler handler123;
    Thread MyThread;

    //Method meant to update ProgressBar
    @Override                                                   //This code will run under Main thread
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jprogressbar=(ProgressBar)findViewById(R.id.xprogressBar);


        MyThread = new Thread(new SeperateThread());
        MyThread.start();                                       //Here we've started thr working of SeperateThread

        handler123=new Handler()                                //Handler instantiated in MainThread so now its stuck with MainThread message queue.
        {
            @Override
            public void handleMessage(Message msg)              //Method responsible for handling of incoming messages
            {
                jprogressbar.setProgress(msg.arg1);             //Updating ProgressBar

            }
        };

    }


    //Seperate thread
    public class SeperateThread implements Runnable
    {

        //Method meant to send message to MainThread
        @Override                                               //This code will run under Seperate thread
        public void run()
        {
            for(int i=0;i<100;i++)
            {
                Message message123 = Message.obtain();              //Getting Message object.
                message123.arg1=i;                                  //Setting value to messgae123 i.e. Message object.
                handler123.sendMessage(message123);                 //We're using the handler's object here that we instantiated in MainThread because we can.
                                                                    //and also sending message object to sendMessgae() everytime one loop completes.
                try
                {
                    MyThread.sleep(100);                            //Just for pause of 100ms
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
