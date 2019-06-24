package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class stl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stl);
    }
    public void btn1 (View btn) {
        if (btn.getId() == R.id.stcye) {
            Intent hello = new Intent(this, stlc.class);
            startActivity(hello);

        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.stqte) {
            Intent hello = new Intent(this, stle.class);
            startActivity(hello);

        }
    }







}
