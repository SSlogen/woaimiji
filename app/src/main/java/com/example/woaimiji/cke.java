package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class cke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cke);
    }
    public void btn1 (View btn) {
        if (btn.getId() == R.id.jb) {
            Intent hello = new Intent(this, ckegx.class);
            startActivity(hello);
        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.tg) {
            Intent hello = new Intent(this, ckejb.class);
            startActivity(hello);
        }
    }
    public void btn3 (View btn) {
        if (btn.getId() == R.id.sz) {
            Intent hello = new Intent(this, ckeyb.class);
            startActivity(hello);
        }
    }
    }













