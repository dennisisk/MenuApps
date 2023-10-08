package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenuView extends AppCompatActivity implements View.OnClickListener {

    ImageView tb,nb, mb, jb,kr, db, sb, fb, hb, deb, drb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_view);

        ImageView tb = (ImageView) findViewById(R.id.turnback);
        tb.setOnClickListener(this);

        ImageView nb = (ImageView) findViewById(R.id.newbutton);
        nb.setOnClickListener(this);

        ImageView mb = (ImageView) findViewById(R.id.homebutton);
        mb.setOnClickListener(this);

        ImageView kb = (ImageView) findViewById(R.id.koreabutton);
        kb.setOnClickListener(this);

        ImageView jb = (ImageView) findViewById(R.id.japanbutton);
        jb.setOnClickListener(this);

        ImageView db = (ImageView) findViewById(R.id.drybutton);
        db.setOnClickListener(this);

        ImageView sb = (ImageView) findViewById(R.id.spicybutton);
        sb.setOnClickListener(this);

        ImageView fb = (ImageView) findViewById(R.id.fitbutton);
        fb.setOnClickListener(this);

        ImageView hb = (ImageView) findViewById(R.id.healthbutton);
        hb.setOnClickListener(this);

        ImageView deb = (ImageView) findViewById(R.id.dessertbutton);
        deb.setOnClickListener(this);

        ImageView drb = (ImageView) findViewById(R.id.drinkbutton);
        drb.setOnClickListener(this);

        Button shakebutton = (Button) findViewById(R.id.shakebutton);
        shakebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.turnback:
                Intent intent = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent);
                break;

            case R.id.newbutton:
                Intent intent1 = new Intent(this, NewFood_toc.class);
                startActivity(intent1);
                break;

            case R.id.homebutton:
                Intent intent2 = new Intent(this, HouseFood_toc.class);
                startActivity(intent2);
                break;

            case R.id.koreabutton:
                Intent intent3 = new Intent(this, KoreaFood_toc.class);
                startActivity(intent3);
                break;

            case R.id.japanbutton:
                Intent intent4 = new Intent(this, JapaneseFood_toc.class);
                startActivity(intent4);
                break;

            case R.id.drybutton:
                Intent intent5 = new Intent(this, JunkFood_toc.class);
                startActivity(intent5);
                break;

            case R.id.spicybutton:
                Intent intent6 = new Intent(this, SpicyFood_toc.class);
                startActivity(intent6);
                break;

            case R.id.fitbutton:
                Intent intent7 = new Intent(this, FitFood_toc.class);
                startActivity(intent7);
                break;

            case R.id.healthbutton:
                Intent intent8 = new Intent(this, HealthFood_toc.class);
                startActivity(intent8);
                break;

            case R.id.dessertbutton:
                Intent intent9 = new Intent(this, Dessert_toc.class);
                startActivity(intent9);
                break;

            case R.id.drinkbutton:
                Intent intent10 = new Intent(this, Drink_toc.class);
                startActivity(intent10);
                break;

            case R.id.shakebutton:
                Intent intent11 = new Intent(this, RandomShake.class);
                startActivity(intent11);
                break;

            default:
                break;
        }
    }

}

