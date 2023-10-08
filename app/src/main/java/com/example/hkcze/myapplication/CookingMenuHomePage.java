package com.example.hkcze.myapplication;

import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CookingMenuHomePage extends AppCompatActivity implements View.OnClickListener {

    Button cu;
    Button mmb;
    Button forb;
    ImageView fb;
    Button addmb;
    private RelativeLayout ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking_menu_home_page);

        Button cu = (Button) findViewById(R.id.contactusbutton);
        cu.setOnClickListener(this);
        Button mmb = (Button) findViewById(R.id.mainmenubutton);
        mmb.setOnClickListener(this);
        Button forb = (Button) findViewById(R.id.forumbutton);
        forb.setOnClickListener(this);
        ImageView fb = (ImageView) findViewById(R.id.fontbutton);
        Button addmb= (Button) findViewById(R.id.addmenubutton);
        addmb.setOnClickListener(this);

        ai = (RelativeLayout) findViewById(R.id.autoimage);
        Timer timer = new Timer();
        MyTImer mt = new MyTImer();

        timer.schedule(mt,2000, 2000);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.contactusbutton:
                Intent intent = new Intent(this, ContactUs.class);
                startActivity(intent);
                break;

            case R.id.mainmenubutton:
                Intent intent2 = new Intent(this, MainMenuView.class);
                startActivity(intent2);
                break;

            case R.id.forumbutton:
                Intent intent3 = new Intent(this, MenuForum.class);
                startActivity(intent3);
                break;

            case R.id.addmenubutton:
                Intent intent4 = new Intent(this, AddMenu.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }

    class MyTImer extends TimerTask {
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    int Image[] = {R.drawable.japan, R.drawable.dry, R.drawable.desert, R.drawable.drink};
                    ai.setBackgroundResource(Image[getRandomNumber()]);
                }

                private int getRandomNumber() {
                    return new Random().nextInt(4);
                }
            });
        }
    }
}