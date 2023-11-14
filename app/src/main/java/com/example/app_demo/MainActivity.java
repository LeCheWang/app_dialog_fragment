package com.example.app_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 vp2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        refView();

        vp2.setAdapter(new PageFragment(MainActivity.this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Add");
                        break;
                    case 1:
                        tab.setText("Home");
                        break;
                    case 2:
                        tab.setText("Search");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });

    }

    private void refView() {
        tabLayout = findViewById(R.id.tlMenu);
        vp2 = findViewById(R.id.vp2);
    }

}