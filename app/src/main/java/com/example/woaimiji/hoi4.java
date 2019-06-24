package com.example.woaimiji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hoi4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoi4);
    }
    public void btn1 (View btn) {
        if (btn.getId() == R.id.cym) {
            Intent hello = new Intent(this, hoicy.class);
            startActivity(hello);
        }
    }
    public void btn2 (View btn) {
        if (btn.getId() == R.id.qtz) {
            Intent hello = new Intent(this, hoiqt.class);
            startActivity(hello);
        }
    }
    public void btn3 (View btn) {
        if (btn.getId() == R.id.sjd) {
            Intent hello = new Intent(this, hoisj.class);
            startActivity(hello);
        }
    }

}















