package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.Carpoolcategorie;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;

import java.util.ArrayList;

public class RitinformatieActivity_detailview  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview_ritinformatie);
        Database database = new Database(this);

        TextView beginTijdTxt = findViewById(R.id.detail_ritinformatieActivity_tijdinput_txt);
        TextView datumTxt = findViewById(R.id.detail_ritinformatieActivity2_datum_txt);
        TextView opstapplaatsTxt = findViewById(R.id.detail_ritinformatieActivity_opstapplaats_txt);
        TextView eindbestemmingTxt = findViewById(R.id.detail_ritinformatieActivity_eindbestemming_txt);
        TextView openplaatsenTxt = findViewById(R.id.detail_ritinformatieActivity_openplaatsenInput_txt);
        TextView eindTijdTxt =findViewById(R.id.detail_ritinformatieActivity_terugrijdtijdinput_txt);
        TextView kentekenTxt = findViewById(R.id.detail_ritinformatieActivity_kentekenInput_txt);
        String gebruikersnaam = "sander123133";
        database.createTestData();
        /*
        ArrayList<RitInfo>  ritten = database.getRitten();

        beginTijd.setText(ritten.get(0).getTijdHeen());
        datum.setText(ritten.get(0).getDatum());
        opstapplaats.setText(ritten.get(0).getOpstapplaats());
        eindbestemming.setText(ritten.get(0).getEindbestmming());
        openplaatsen.setText(String.valueOf(ritten.get(0).getVrijePlaatsen()));
        eindTijd.setText(ritten.get(0).getTijdTerug());
        
        ListView gebruikersListview = findViewById(R.id.activity_detailview_ritinformatie_gebruikers_list);
        ArrayList<Medewerkerinfo> medewerkerinfos = new ArrayList<>();

        gebruikersListview.setAdapter(new Detailview_ArrayAdapter(this, R.layout.listview_adpater_ritinformatie_detaivliew, medewerkerinfos));
        */

        Button meldaanAlsBackupBtn = findViewById(R.id.detail_ritinformatieActivity_meldaanAlsmeerijder_btn);
        Button meldaanAlsMeerijder = findViewById(R.id.detail_ritinformatieActivity_meldaanAlsmeerijder_btn);

        meldaanAlsBackupBtn.setOnClickListener(v -> {
            database.insertAanmelding(new RitAanmelding((String) datumTxt.getText(), gebruikersnaam, Carpoolcategorie.BACKUP_BESTUUDER));
        });
        meldaanAlsBackupBtn.setOnClickListener(v -> {
            database.insertAanmelding(new RitAanmelding((String) datumTxt.getText(), gebruikersnaam, Carpoolcategorie.MEERIJDER));
        });
    }
}
