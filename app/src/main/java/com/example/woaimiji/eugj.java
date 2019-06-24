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
public class eugj extends ListActivity implements Runnable {
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
        for(int i=1;i<790;i++){
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
                    ListAdapter adapter =new ArrayAdapter<String>(eugj.this,android.R.layout.simple_list_item_1,list2);
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
        try {
            Thread.sleep(3000);
            doc = (Document) Jsoup.connect("https://www.eu4cn.com/wiki/%E5%9B%BD%E5%AE%B6#.E6.8C.89.E7.85.A7.E5.9B.BD.E5.AE.B6.E4.BB.A3.E7.A0.81.E8.8B.B1.E6.96.87.E9.A6.96.E5.AD.97.E6.AF.8D.E6.8E.92.E5.88.97").get();
            Elements ul =  doc.getElementsByTag("td");
            //int i=0;
            Element div[]=new Element[789];
            Element div2[]=new Element[789];
            /*for( Element a :ul){
                Log.i(TAG,"run+"+i+a.text());
                i++;}*/
           for(int i=37;i<4771;i=i+6){
                div[(i-37)/6]=ul.get(i+1);
                div2[(i-37)/6]=ul.get(i+3);
                cs= div[(i-37)/6].text();
                cf=div2[(i-37)/6].text();
                Log.i(TAG,"run+"+cs+cf);
                retList.add(cs+"         "+cf);}








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