package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

import com.example.smartpool.Data.Database;
import com.example.smartpool.R;

public class MainActivity extends AppCompatActivity {

    //functie om menu item klik actie
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_giftshop:
                    manager.beginTransaction().replace(R.id.fragment_container, new GiftshopFragment()).commit();
                    getSupportActionBar().setTitle("Giftshop");
                    break;
                case R.id.nav_ranglijst:
                    manager.beginTransaction().replace(R.id.fragment_container, new RitoverzichtFragment()).commit();
                    getSupportActionBar().setTitle("Ranglijst");
                    break;
                case R.id.nav_ritten:
                    manager.beginTransaction().replace(R.id.fragment_container, new RitoverzichtFragment()).commit();
                    getSupportActionBar().setTitle("Ritten");
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_container);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RitoverzichtFragment()).commit();
        getSupportActionBar().setTitle("Ritten");

        Database db = new Database(this);
        db.createTestData();

   }
}
