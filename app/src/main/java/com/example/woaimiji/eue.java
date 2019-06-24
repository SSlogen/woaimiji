package com.example.woaimiji;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
public class eue extends ListActivity implements Runnable {
    private final String TAG = "Rate";
    Handler handler;
    String data[]={"one","two","three"};
    private String logDate = "";
    private final String DATE_SP_KEY = "lastRateDateStr";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_hoiqt);
        SharedPreferences sp = getSharedPreferences("myrate", Context.MODE_PRIVATE);
        logDate = sp.getString(DATE_SP_KEY, "");
        Log.i("List","lastRateDateStr=" + logDate);
        final List<String> list1 =new ArrayList<String>();
        for(int i=1;i<91;i++){
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
                    ListAdapter adapter =new ArrayAdapter<String>(eue.this,android.R.layout.simple_list_item_1,list2);
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
        String cf="";
        String cd="";
        try {
            Thread.sleep(3000);
            doc = (Document) Jsoup.connect("https://www.eu4cn.com/wiki/%E6%8E%A7%E5%88%B6%E5%8F%B0%E6%8C%87%E4%BB%A4").get();
            Elements ul =  doc.getElementsByTag("td");
            //int i=0;
            Element div[]=new Element[90];
            Element div2[]=new Element[90];
            Element div3[]=new Element[90];
            /*for( Element a :ul){
                Log.i(TAG,"run+"+i+a.text());
                i++;}*/
            for(int i=856;i<946;i=i+3){
                div[(i-856)/3]=ul.get(i);
                div2[(i-856)/3]=ul.get(i+1);
                div3[(i-856)/3]=ul.get(i+2);
                cs= div[(i-856)/3].text();
                cf=div2[(i-856)/3].text();
                cd=div3[(i-856)/3].text();
                Log.i(TAG,"run+"+cs+cf+cd);
                retList.add(cs+"         "+cf+"        "+cd);}








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