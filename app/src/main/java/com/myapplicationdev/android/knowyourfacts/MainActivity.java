package com.myapplicationdev.android.knowyourfacts;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    Button btnReadLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.viewpager1);

        btnReadLater = (Button) findViewById(R.id.btnReadLater);
        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new FragmentFacts());
        al.add(new FragmentFacts2());
        al.add(new FragmentFacts3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnReadLater.getText().toString().equals("Read Later")) {
                    btnReadLater.setText("Read Now");
                    vPager.setVisibility(View.GONE);
                } else {
                    btnReadLater.setText("Read Later");
                    vPager.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_previous) {
            if (vPager.getCurrentItem() > 0) {
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);
            }
        }
        if (id == R.id.action_random) {
            int max = vPager.getChildCount();
            Random r = new Random();
            vPager.setCurrentItem(r.nextInt(max), true);
        }
        if (id == R.id.action_next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max - 1) {
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
