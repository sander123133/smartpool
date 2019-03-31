package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.AutoInfo;
import com.example.smartpool.Domain.Carpoolcategorie;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.Utility;

import java.util.ArrayList;

public class RitinformatieActivity_detailview  extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview_ritinformatie);
        Database database = new Database(this);
        TextView beginTijdTxt = findViewById(R.id.detail_ritinformatieActivity_tijdinput_txt);
        TextView datumTxt = findViewById(R.id.detail_ritinformatieActivity2_datumInput_txt);
        TextView opstapplaatsTxt = findViewById(R.id.detail_ritinformatieActivity_opstapplaats_txt);
        TextView eindbestemmingTxt = findViewById(R.id.detail_ritinformatieActivity_eindbestemming_txt);
        TextView openplaatsenTxt = findViewById(R.id.detail_ritinformatieActivity_openplaatsenInput_txt);
        TextView eindTijdTxt =findViewById(R.id.detail_ritinformatieActivity_terugrijdtijdinput_txt);
        TextView kentekenTxt = findViewById(R.id.detail_ritinformatieActivity_kentekenInput_txt);
        TextView kleurTxt = findViewById(R.id.detail_ritinformatieActivity_kleurInput_txt);
        TextView naamTxt = findViewById(R.id.detail_ritinformatieActivity_autoInput_txt);

       Bundle extras = getIntent().getExtras();
       RitInfo ritInfo = (RitInfo) extras.getSerializable("Ritoverzicht");
       String gebruikersnaam = "rogier";
       beginTijdTxt.setText(ritInfo.getTijdHeen());
       datumTxt.setText(ritInfo.getDatum());
       opstapplaatsTxt.setText(ritInfo.getOpstapplaats());
       eindbestemmingTxt.setText(ritInfo.getEindbestmming());
       openplaatsenTxt.setText(String.valueOf(ritInfo.getVrijePlaatsen()));
       eindTijdTxt.setText(ritInfo.getTijdTerug());

        ListView gebruikersListview = findViewById(R.id.activity_detailview_ritinformatie_gebruikers_list);
        ArrayList<RitAanmelding> aangemelde_medewerkers = database.getRitAanmeldingen(ritInfo.getRitnummer());
        ArrayList<Medewerkerinfo> medewerkerinfos = new ArrayList<>();
        for(RitAanmelding medewerker : aangemelde_medewerkers)
        {
            medewerkerinfos.add(database.getFullAangemeldeMedewerkerInfo(medewerker));
        }
        gebruikersListview.setAdapter(new Detailview_ArrayAdapter(this, R.layout.listview_adpater_ritinformatie_detaivliew, medewerkerinfos, database));
        Utility.setListViewHeightBasedOnChildren(gebruikersListview);

        Button meldaanAlsBackupBtn = findViewById(R.id.detail_ritinformatieActivity_meldaanAlsmeerijder_btn);
        Button meldaanAlsMeerijder = findViewById(R.id.detail_ritinformatieActivity_meldaanAlsmeerijder_btn);
        Button ritVoltooidBtn = findViewById(R.id.detail_rtinformatieActivity_ritvoltooid_btn);

        AutoInfo autoInfo = database.getAuto(ritInfo.getKenteken());
        kentekenTxt.setText(autoInfo.getKenteken());
        kleurTxt.setText(autoInfo.getKleur());
        naamTxt.setText(autoInfo.getMerk());



        meldaanAlsBackupBtn.setOnClickListener(v -> {
            database.insertAanmelding(new RitAanmelding((String) datumTxt.getText(), gebruikersnaam, Carpoolcategorie.BACKUP_BESTUUDER,ritInfo.getRitnummer()));
        });
        meldaanAlsMeerijder.setOnClickListener(v -> {
            database.insertAanmelding(new RitAanmelding((String) datumTxt.getText(), gebruikersnaam, Carpoolcategorie.MEERIJDER,ritInfo.getRitnummer()));
        });

        ritVoltooidBtn.setOnClickListener(v -> {
            StringBuilder dataString = new StringBuilder();
            dataString.append("{[");
            for(int index = 0; index < medewerkerinfos.size(); index++){
                dataString.append("{");
                dataString.append("gebruikersnaam: " + medewerkerinfos.get(index).getGebruikersnaam() + ", ");
                dataString.append("carpoolcategorie: " + medewerkerinfos.get(index).getCarpoolcategorie());
                if(!(index == medewerkerinfos.size() - 1)) {
                    dataString.append("}, ");
                }
                else {
                    dataString.append("}");
                }
            }
            dataString.append("]}");
            Intent intent = new Intent(getApplicationContext(), QRGeneratorActivity.class);
            intent.putExtra("data", dataString.toString());
            startActivity(intent);
        });


    }


}
