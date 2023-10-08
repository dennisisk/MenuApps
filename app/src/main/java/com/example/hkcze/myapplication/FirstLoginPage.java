package com.example.hkcze.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class FirstLoginPage extends AppCompatActivity {

    private GifImageView giv;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_login_page);

        GifImageView giv = (GifImageView) findViewById(R.id.giv);
        ProgressBar pb = (ProgressBar) findViewById(R.id.pb);
        pb.setVisibility(ProgressBar.VISIBLE);

        try {
            InputStream inputStream = getAssets().open("cooking_icon.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            giv.setBytes(bytes);
            giv.startAnimation();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirstLoginPage.this.startActivity(new Intent(FirstLoginPage.this, CookingMenuHomePage.class));
                FirstLoginPage.this.finish();
            }
        },4500);
    }
}
