package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BedrijfRang;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterRitoverzicht;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private Database db = new Database(this);


    //functie om menu item klik actie
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.nav_giftshop:
                    //haal medewerker die net in de database gestopt is op, test
                    /////////////////test///////////////
                    Medewerkerinfo ingelogdeGebruiker = db.geefMedewerker("IngevZetten");
                    Bundle gebruikerIngelogd = new Bundle();
                    gebruikerIngelogd.putSerializable("GebruikerIngelogd", ingelogdeGebruiker);
                    GiftshopFragment giftshopFragment = new GiftshopFragment();
                    giftshopFragment.setArguments(gebruikerIngelogd);
                    manager.beginTransaction().replace(R.id.fragment_container, giftshopFragment).commit();
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        db.createTestData();


        //TESTDATA
        //BedrijfRang bedrijfRang = new BedrijfRang("DHL", 40, 3);
        //db.insertBedrijf(bedrijfRang);

        //Medewerkerinfo medewerkerinfo = new Medewerkerinfo("IngevZetten", 100, "0657003878", "IvZ", "Breda", "Inge van Zetten", "test", "DHL");
        //db.insertMedewerker(medewerkerinfo);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RitoverzichtFragment()).commit();
        getSupportActionBar().setTitle("Ritten");

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Intent intent = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_profiel:

                break;
            case R.id.nav_mijnritten:

                break;
            case R.id.nav_mijnbeloningen:
                intent = new Intent(this, BeloningOverzichtActivity.class);
                break;
        }

        startActivity(intent);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}