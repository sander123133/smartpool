package com.example.smartpool.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.R;
import com.squareup.picasso.Picasso;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class GifsthopDetailActivity extends AppCompatActivity {

    private Database db = new Database(this);
    private Medewerkerinfo ingelogdeGebruiker;
    private int nieuwCreditaantal;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giftshop_detail_activity);

        Bundle extras = getIntent().getExtras();
        final BeloningWaardeCredit bwc = (BeloningWaardeCredit) extras.getSerializable("Beloning");

        //declareer layout panes uit giftshopDetail scherm
        ImageView mBeloningFoto = (ImageView) findViewById(R.id.detail_FotoBeloning);
        TextView mBeloningsnaam = (TextView) findViewById(R.id.detail_tvBeloningsnaam);
        TextView mWaarde = (TextView) findViewById(R.id.detail_tvWaarde);
        TextView mOmschrijving = (TextView) findViewById(R.id.detail_tvOmschrijving);
        TextView mCreditAantal = (TextView) findViewById(R.id.detail_tvAantalCredits);
        TextView mLinkWebsite = (TextView) findViewById(R.id.detail_tvLink);
        Button btnCreditsInwisselen = (Button) findViewById(R.id.detail_btnInwisselen);

        //waarde uit object koppelen aan layout panes
        this.setTitle(bwc.getBeloningsnaam());
        mBeloningsnaam.setText(bwc.getBeloningsnaam());
        mWaarde.setText("Waarde: " + Double.toString(bwc.getWaarde()) + " euro");
        mOmschrijving.setText(bwc.getBeschrijving());
        mCreditAantal.setText(Integer.toString(bwc.getCreditaantal()));
        mLinkWebsite.setText(bwc.getWebsiteURL());
        Picasso.with(this).load(bwc.getFoto()).into(mBeloningFoto);

        ingelogdeGebruiker = db.geefMedewerker("DaveyvZetten");

        //controleer of creditaantal voldoende is om beloning te kopen,
        //voeg beloning toe als dit zo is, geef een melding als dit niet zo is.
        btnCreditsInwisselen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ingelogdeGebruiker.getCreditaantal() >= bwc.getCreditaantal()){

                    Log.d("GiftShopDetail", "credits ingelogde gebruiker" + ingelogdeGebruiker.getCreditaantal());
                    Log.d("GiftShopDetail", "credits beloning" + bwc.getCreditaantal());

                    //maak kortingscode
                    String kortingscode = maakKortingsCode(12);
                    Log.d("GiftshopDetailActivity", "kortingscode: " + kortingscode);

                    //datum van kopen
                    String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                    Log.i("GiftshopDetailActivity", "datum: " + date);

                    //beloning invoegen in database
                    MedewerkerBeloning medewerkerBeloning = new MedewerkerBeloning(bwc.getWaarde(), bwc.getBeloningsnaam(), ingelogdeGebruiker.getGebruikersnaam(), kortingscode, date);
                    if(db.insertMedewerkerBeloning(medewerkerBeloning)){
                        Log.d("GiftshopDetailActivity", "MedewerkerBeloning toegevoegd");
                    }else{
                        Log.d("GiftshopDetailActivity", "MedewerkerBeloning niet toegevoegd");
                    }

                    //creditaantal ingelogde gebruiker verlagen
                    nieuwCreditaantal = ingelogdeGebruiker.getCreditaantal() - bwc.getCreditaantal();
                    db.updateCreditTeBesteden(nieuwCreditaantal, ingelogdeGebruiker.getGebruikersnaam());

                    Log.d("GiftshopDetailAcitivity", "nieuw creditaantal: " + nieuwCreditaantal);

                    Toast.makeText(getApplicationContext(), "Aankoop geslaagd!", Toast.LENGTH_SHORT).show();

                }else{

                    //Snackbar snackbar = Snackbar.make(view, "Onvoldoende credits", Snackbar.LENGTH_LONG);
                    Toast.makeText(getApplicationContext(), "Onvoldoende credits", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    //methode om kortingscode te genereren, controle duplicates??
    public String maakKortingsCode(int length) {

        String candidateChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }



}
