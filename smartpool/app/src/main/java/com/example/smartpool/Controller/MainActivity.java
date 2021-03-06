package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpool.Data.Database;

import com.example.smartpool.Domain.AutoInfo;
import com.example.smartpool.Domain.BedrijfRang;
import com.example.smartpool.Domain.Carpoolcategorie;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.Domain.RitInfo;

import com.example.smartpool.R;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private String gebruikersnaam;

    private Database db = new Database(this);


    //functie om menu item klik actie
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_giftshop:
                    Bundle gebruikerIngelogd = new Bundle();
                    gebruikerIngelogd.putString("Gebruikersnaam", gebruikersnaam);
                    GiftshopFragment giftshopFragment = new GiftshopFragment();
                    giftshopFragment.setArguments(gebruikerIngelogd);
                    manager.beginTransaction().replace(R.id.fragment_container, giftshopFragment).commit();
                    getSupportActionBar().setTitle("Giftshop");
                    break;
                case R.id.nav_ranglijst:
                    manager.beginTransaction().replace(R.id.fragment_container, new ListItem()).commit();
                    getSupportActionBar().setTitle("Ranglijst");
                    break;
                case R.id.nav_ritten:
                    Bundle gebruikerIngelogdAddactivity = new Bundle();
                    gebruikerIngelogdAddactivity.putString("Gebruikersnaam", gebruikersnaam);
                    RitoverzichtFragment ritoverzichtFragment= new RitoverzichtFragment();
                    ritoverzichtFragment.setArguments(gebruikerIngelogdAddactivity);
                    manager.beginTransaction().replace(R.id.fragment_container, ritoverzichtFragment).commit();
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

        Bundle extras = getIntent().getExtras();

        gebruikersnaam = extras.getString("Gebruikersnaam");
        Medewerkerinfo gebrIngelogd = db.geefMedewerker(gebruikersnaam);


        db.createTestData();
        db.checkRitAanmeldingen();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View nav_header = navigationView.getHeaderView(0);
        TextView headernaam = (TextView) nav_header.findViewById(R.id.nav_naamGebruiker);
        headernaam.setText(gebrIngelogd.getNaam());

        db.createTestData();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Bundle gebruikerIngelogdAddactivity = new Bundle();
        gebruikerIngelogdAddactivity.putString("Gebruikersnaam", gebruikersnaam);
        RitoverzichtFragment ritoverzichtFragment= new RitoverzichtFragment();
        ritoverzichtFragment.setArguments(gebruikerIngelogdAddactivity);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ritoverzichtFragment).commit();
        getSupportActionBar().setTitle("Ritten");

    }


    @Override
    public void onBackPressed() {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent intent = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_profiel:
                Toast.makeText(this,"oof", Toast.LENGTH_SHORT);
                break;
            case R.id.nav_mijnritten:
                intent = new Intent(this, AangemeldeRittenAcitivity.class);
                intent.putExtra("Gebruikersnaam", gebruikersnaam);
                startActivity(intent);
                break;
            case R.id.nav_uitloggen:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_mijnbeloningen:
                intent = new Intent(this, BeloningOverzichtActivity.class);
                intent.putExtra("Gebruikersnaam", gebruikersnaam);
                startActivity(intent);
                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}