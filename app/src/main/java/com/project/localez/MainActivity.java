package com.project.localez;

import static com.project.localez.Login.mGoogleSignInClient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem ppopular, bbusiness, hhealth, ssports, ttechnology;
    PagerAdapter pagerAdapter;
    Toolbar ttoolbar;
    Spinner spinner;
    public static String COUNTRY_CODE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_logout).setOnClickListener(view -> signOut());

        ttoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(ttoolbar);
//
        ppopular = findViewById(R.id.Popular);
        bbusiness = findViewById(R.id.Business);
        hhealth = findViewById(R.id.Health);
        ssports = findViewById(R.id.Sports);
        ttechnology = findViewById(R.id.Technology);

        spinner= findViewById(R.id.country_spinner);
        spinner.setSelection(18);
        int spinner_pos = spinner.getSelectedItemPosition();
        String[] country_values = getResources().getStringArray(R.array.country_values);
        COUNTRY_CODE = country_values[spinner_pos];

        ViewPager viewPager = findViewById(R.id.contain);
        tabLayout = findViewById(R.id.category);

        pagerAdapter = new Adapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pagerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                COUNTRY_CODE = country_values[position];
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, task -> {
                    Toast.makeText(MainActivity.this, "You've been logged out.", Toast.LENGTH_SHORT).show();
                    Intent goLogin = new Intent(MainActivity.this, Login.class);
                    startActivity(goLogin);
                    finish();
                });
    }
}