package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.smartpool.Domain.Carpoolcategorie;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.R;

import java.util.ArrayList;

public class RitinformatieActivity_detailview  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview_ritinformatie);

        ListView gebruikersListview = findViewById(R.id.activity_detailview_ritinformatie_gebruikers_list);
        ArrayList<Medewerkerinfo> medewerkerinfos = new ArrayList<>();
        medewerkerinfos.add(new Medewerkerinfo("sander",0, Carpoolcategorie.BESTUUDER,"123456789"));
        medewerkerinfos.add(new Medewerkerinfo("sander2",0, Carpoolcategorie.BACKUP_BESTUUDER,"12322446789"));
        medewerkerinfos.add(new Medewerkerinfo("sander3",0, Carpoolcategorie.MEERIJDER,"12345634"));
        gebruikersListview.setAdapter(new Detailview_ArrayAdapter(this, R.layout.listview_adpater_ritinformatie_detaivliew, medewerkerinfos));

    }
}
