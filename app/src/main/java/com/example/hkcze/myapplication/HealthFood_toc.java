package com.example.hkcze.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class HealthFood_toc extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_food_toc);

        ImageView tb = (ImageView) findViewById(R.id.turnback);
        tb.setOnClickListener(this);

        ListView lv = (ListView)findViewById(R.id.listviewnf7);
        ArrayList<String> newfood1toc = new ArrayList<>();
        newfood1toc.addAll(Arrays.asList(getResources().getStringArray(R.array.HealthFood_toc)));

        adapter = new ArrayAdapter<>(
                HealthFood_toc.this,
                android.R.layout.simple_list_item_1,
                newfood1toc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent1 = new Intent(view.getContext(), HealthFood1.class);
                    startActivityForResult(intent1,0);
                }
                if (i == 1){
                    Intent intent1 = new Intent(view.getContext(), HealthFood2.class);
                    startActivityForResult(intent1,1);
                }
                if (i == 2){
                    Intent intent1 = new Intent(view.getContext(), HealthFood3.class);
                    startActivityForResult(intent1,2);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.turnback:
                Intent intent = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searching, menu);
        MenuItem item = menu.findItem(R.id.searching);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
