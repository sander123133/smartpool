package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

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

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterRitoverzicht;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Database db = new Database(this);
    private AdapterRitoverzicht adapter;
    private ArrayList<RitInfo> mDataset;


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



        db.createTestData();

        //TESTDATA
        //BedrijfRang bedrijfRang = new BedrijfRang("DHL", 40, 3);
        //db.insertBedrijf(bedrijfRang);

        //Medewerkerinfo medewerkerinfo = new Medewerkerinfo("IngevZetten", 100, "0657003878", "IvZ", "Breda", "Inge van Zetten", "test", "DHL");
        //db.insertMedewerker(medewerkerinfo);

        //Log.d("Check medewerker", "medewerker toegevoegd: " + ingelogdeGebruiker.getGebruikersnaam());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RitoverzichtFragment()).commit();
        getSupportActionBar().setTitle("Ritten");

    }

}