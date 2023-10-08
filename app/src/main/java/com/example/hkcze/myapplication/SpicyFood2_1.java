package com.example.hkcze.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SpicyFood2_1 extends Fragment implements View.OnClickListener {

    ImageView sb;
    ImageView tb;
    ImageView fb;
    TextView npt;
    int count = 0;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_spicy_food2_1, container, false);

        ImageView tb = (ImageView) rootView.findViewById(R.id.turnback);
        tb.setOnClickListener(this);
        tb.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), CookingMenuHomePage.class);
                startActivity(intent);
                return true;
            }
        });
        ImageView sb = (ImageView) rootView.findViewById(R.id.sharebutton);
        sb.setOnClickListener(this);
        ImageView fb = (ImageView) rootView.findViewById(R.id.fontbutton);
        fb.setOnClickListener(this);

        return rootView;
    }

    public void changetextsize (View v) {
        npt= getActivity().findViewById(R.id.nextpage1);
        if (count == 0) {
            npt.setTextSize(35);
            count++;
        }
        else if (count == 1) {
            npt.setTextSize(45);
            count++;
        }
        else {
            npt.setTextSize(25);
            count = 0;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.turnback:
                Intent intent = new Intent(this.getActivity(), MainMenuView.class);
                startActivity(intent);
                break;

            case R.id.sharebutton:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareone = "Your body here";
                String sharetwo = "Your subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sharetwo);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareone);
                startActivity(Intent.createChooser(myIntent, "Share"));
                break;

            case R.id.fontbutton:
                changetextsize(v);
                break;

            default:
                break;
        }
    }
}
