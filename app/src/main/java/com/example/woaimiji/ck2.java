package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ck2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck2);
    }
    public void btn1 (View btn) {
        if (btn.getId() == R.id.js) {
            Intent hello = new Intent(this, ckjs.class);
            startActivity(hello);
        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.qj) {
            Intent hello = new Intent(this, ckqj.class);
            startActivity(hello);
        }
    }
    public void btn3 (View btn) {
        if (btn.getId() == R.id.qt) {
            Intent hello = new Intent(this, ckqt.class);
            startActivity(hello);
        }
    }
    public void btn4 (View btn) {
        if (btn.getId() == R.id.xg) {
            Intent hello = new Intent(this, cke.class);
            startActivity(hello);
        }
    }
















}
