package com.example.woaimiji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class hoicy extends ListActivity implements Runnable  {
    private final String TAG = "Rate";
    Handler handler;
    String data[]={"one","two","three"};
    private String logDate = "";
    private final String DATE_SP_KEY = "lastRateDateStr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_hoicy);
        SharedPreferences sp = getSharedPreferences("myrate", Context.MODE_PRIVATE);
        logDate = sp.getString(DATE_SP_KEY, "");
        Log.i("List","lastRateDateStr=" + logDate);
        final List<String> list1 =new ArrayList<String>();
        for(int i=1;i<29;i++){
            list1.add("item"+i);
        }
        ListAdapter adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1);
        setListAdapter(adapter);

        Thread thread =new Thread(this);
        thread.start();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                if(msg.what==7){
                   List<String> list2 =(List<String>)msg.obj;
                    ListAdapter adapter =new ArrayAdapter<String>(hoicy.this,android.R.layout.simple_list_item_1,list2);
                    setListAdapter(adapter);
                }
                super.handleMessage(msg);
            }
        };
    }
    public void run () {
        List<String> retList =new ArrayList<String>();
        Document doc = null;
        String cs="";
        try {
            Thread.sleep(3000);
            doc = (Document) Jsoup.connect("https://mip.ali213.net/gl/wenda/141.html").get();
            Elements ul =  doc.getElementsByTag("p");
            //int i=0;
            Element div[]=new Element[28];
            /*for( Element a :ul){
                Log.i(TAG,"run+"+i+a);
                i++;}*/
            for(int i=5;i<33;i=i+1){
                div[(i-5)]=ul.get(i);
                cs= div[(i-5)].text();
                Log.i(TAG,"run+"+cs);
                retList.add(cs);}








        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg = handler.obtainMessage(7);
        msg.obj=retList;
        handler.sendMessage(msg);
    }












}
