package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity implements View.OnClickListener{

    ImageView tb;
    ImageView sb;
    int count = 0;
    TextView cu_tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        ImageView tb = (ImageView) findViewById(R.id.turnback);
        tb.setOnClickListener(this);
        ImageView sb = (ImageView) findViewById(R.id.sharebutton);
        sb.setOnClickListener(this);

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

            case R.id.turnback:
                Intent intent = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    public void changetextsize (View v) {
        TextView cu_tv2 = (TextView) findViewById(R.id.contactus_textView2);
        if (count == 0) {
            cu_tv2.setTextSize(35);
            cu_tv2.setText(R.string.contactus_textview2);
            count++;
        }
        else if (count == 1) {
            cu_tv2.setTextSize(45);
            cu_tv2.setText(R.string.contactus_textview2);
            count++;
        }
        else {
            cu_tv2.setTextSize(25);
            cu_tv2.setText(R.string.contactus_textview2);
            count = 0;
        }
    }
}
