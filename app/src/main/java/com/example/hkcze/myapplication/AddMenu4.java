package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddMenu4 extends AppCompatActivity implements View.OnClickListener {

    ImageView lb;
    ImageView tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu4);

        ImageView lb = (ImageView) findViewById(R.id.lastbutton);
        lb.setOnClickListener(this);
        ImageView tb = (ImageView) findViewById(R.id.turnback);
        tb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.lastbutton:
                Intent intent = new Intent(this, AddMenu3.class);
                startActivity(intent);
                break;

            case R.id.turnback:
                Intent intent2 = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent2);
                break;
        }
    }
}
