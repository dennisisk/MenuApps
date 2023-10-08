package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NextPage extends AppCompatActivity implements View.OnClickListener {

    ImageView sb;
    ImageView fb;
    TextView npt;
    int count = 0;
    ImageView lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);

        ImageView sb = (ImageView) findViewById(R.id.sharebutton);
        sb.setOnClickListener(this);
        ImageView fb = (ImageView) findViewById(R.id.fontbutton);
        ImageView lb= (ImageView) findViewById(R.id.lastbutton);
        lb.setOnClickListener(this);
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

            case R.id.lastbutton:
                Intent intent = new Intent(this, CookingMenuExample.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    public void changetextsize (View v) {
        TextView npt= (TextView) findViewById(R.id.nextpage);
        if (count == 0) {
            npt.setTextSize(35);
            npt.setText(R.string.nextpagetext);
            count++;
        }
        else if (count == 1) {
            npt.setTextSize(45);
            npt.setText(R.string.nextpagetext);
            count++;
        }
        else {
            npt.setTextSize(25);
            npt.setText(R.string.nextpagetext);
            count = 0;
        }
    }
}
