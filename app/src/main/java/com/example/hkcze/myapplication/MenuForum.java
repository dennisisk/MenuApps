package com.example.hkcze.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MenuForum extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout lo;
    private EditText et;
    private Button bt;
    int n = (int) Math.random();
    int l = (int) Math.random();
    int j = (int) Math.random();
    int k;
    ImageView tb;
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuforum);

        lo = (LinearLayout) findViewById(R.id.linearLayout);
        lo.addView(createNewTextView("有咩餸易整又好食?"));
        lo.addView(createNewTextView("咸蛋蒸肉餅，好易整又好味！"));
        lo.addView(createNewTextView("係呀我都鍾意食。"));
        lo.addView(createNewTextView("蝦仁炒蛋都易整又好食"));
        lo.addView(createNewTextView("冰沙啦，就咁磨冰同加D果汁都好好食"));
        lo.addView(createNewTextView("鮮奶撻都唔錯!"));
        lo.addView(createNewTextView("可以試下整漢堡扒!"));
        lo.addView(createNewTextView("上次我開party都整過鮮奶撻，好味!"));
        lo.addView(createNewTextView("多謝咁多位提議，想問下鮮奶撻嘅食譜係邊可以搵?"));
        lo.addView(createNewTextView("呢個app都有得睇點整!"));
        et = (EditText) findViewById(R.id.argue);
        bt = (Button) findViewById(R.id.submitbutton);
        bt.setOnClickListener(this);
        TextView textView = new TextView(this);
        textView.setText("");
        ImageView lb = (ImageView) findViewById(R.id.lastbutton);
        lb.setOnClickListener(this);

        addTextByAI();
    }

    public void addTextByAI() {
        Random rand = new Random();
        l = rand.nextInt(5);
        for (int i = 0; i < l; i++){
            n = rand.nextInt(5);
            if(n == 1){
                lo.addView(createNewTextView("hi"));
            }
            if(n == 2){
                lo.addView(createNewTextView("WoW"));
            }
            if(n == 3){
                lo.addView(createNewTextView("Huh"));
            }
            if(n == 4){
                lo.addView(createNewTextView("Wait"));
            }
            if(n == 5){
                lo.addView(createNewTextView("Um"));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.submitbutton:
                lo.addView(createNewTextViewMe(et.getText().toString()));
                et.setText("");
                Random rand = new Random();
                j = rand.nextInt(2);
                if (j == 1){
                    break;
                }
                else {
                    addTextByAI();
                }
                break;

            case R.id.lastbutton:
                Intent intent = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    private TextView createNewTextViewMe(String text) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setBackgroundResource(R.drawable.border);
        textView.setLayoutParams(lparams);
        textView.setText("本人:　"+text);
        return textView;
    }

    private TextView createNewTextView(String text) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setBackgroundResource(R.drawable.border);
        textView.setLayoutParams(lparams);
        textView.setText("匿名:　"+text);
        return textView;
    }

}