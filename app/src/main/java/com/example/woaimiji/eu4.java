package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class eu4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eu4);
    }
    public void btn1 (View btn) {
        if (btn.getId() == R.id.eucy) {
            Intent hello = new Intent(this, eucj.class);
            startActivity(hello);
        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.euqt) {
            Intent hello = new Intent(this, euqt.class);
            startActivity(hello);
        }
    }
    public void btn3 (View btn) {
        if (btn.getId() == R.id.eugj) {
            Intent hello = new Intent(this, eugj.class);
            startActivity(hello);
        }
    }
    public void btn4 (View btn) {
        if (btn.getId() == R.id.euee) {
            Intent hello = new Intent(this, eue.class);
            startActivity(hello);
        }
    }







}
