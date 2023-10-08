package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookingMenuExample extends AppCompatActivity implements View.OnClickListener {

    ImageView sb;
    ImageView fb;
    TextView tt;
    int count = 0;
    ImageView nb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_cookingmenu);

        ImageView sb = (ImageView) findViewById(R.id.sharebutton);
        sb.setOnClickListener(this);
        ImageView fb = (ImageView) findViewById(R.id.fontbutton);
        ImageView nb= (ImageView) findViewById(R.id.nextbutton);
        nb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.sharebutton:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareone = "Your body here";
                String sharetwo = "Your subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sharetwo);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareone);
                startActivity(Intent.createChooser(myIntent, "Share"));
                break;

            case R.id.nextbutton:
                Intent intent = new Intent(this, NextPage.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    public void changetextsize (View v) {
        TextView tt= (TextView) findViewById(R.id.text);
        if (count == 0) {
            tt.setTextSize(35);
            tt.setText(R.string.textview);
            count++;
        }
        else if (count == 1) {
            tt.setTextSize(45);
            tt.setText(R.string.textview);
            count++;
        }
        else {
            tt.setTextSize(25);
            tt.setText(R.string.textview);
            count = 0;
        }
    };
}
