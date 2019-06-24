package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1 (View btn) {
        if (btn.getId() == R.id.ck) {
            Intent hello = new Intent(this, ck2.class);
            startActivity(hello);
        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.hoi) {
            Intent hello = new Intent(this, hoi4.class);
            startActivity(hello);
        }
    }
    public void btn3 (View btn) {
        if (btn.getId() == R.id.eu) {
            Intent hello = new Intent(this, eu4.class);
            startActivity(hello);
        }
    }
    public void btn4 (View btn) {
        if (btn.getId() == R.id.qx) {
            Intent hello = new Intent(this, stl.class);
            startActivity(hello);
        }
    }
















}
