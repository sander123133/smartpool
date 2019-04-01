package com.example.smartpool.Util;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartpool.Controller.AangemeldeRittenAcitivity;
import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.R;

import java.util.ArrayList;

public class ApdapterAangemeldeRitten extends ArrayAdapter<RitAanmelding>{
    private ArrayList<RitAanmelding> aanmeldingen;
    private Database database;
    private final Context context;
    private int recouce;
    public ApdapterAangemeldeRitten(Context context, int resource, ArrayList<RitAanmelding> aanmeldingen, Database database) {
        super(context, resource, aanmeldingen);
        this.aanmeldingen = aanmeldingen;
        this.recouce = resource;
        this.database = database;
        this.context = context;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_adpater_activity_aangemelderitten, parent, false);
        }
        RitAanmelding ritAanmelding =  aanmeldingen.get(position);
        TextView carpoolcategorieTxt = view.findViewById(R.id.listview_adpater_aangemelderitten_carpoolcategorieInput_txt);
        TextView datumTijdTxt = view.findViewById(R.id.listview_adpater_aangemelderitten_datumEntijdInput_txttextView6);
        TextView ophaalPlaats = view.findViewById(R.id.listview_adpater_aangemelderitten_opstapplaats_txt);
        TextView eindbestemming = view.findViewById(R.id.listview_adpater_aangemelderitten_eindBestemming);
        Button   afmeldButton = view.findViewById(R.id.listview_adpater_aangemelderitten_afmeld_btn);

        switch (ritAanmelding.getCarpoolcategorie()){
            case BESTUUDER:
                carpoolcategorieTxt.setText(" Bestuuder");
                break;
            case BACKUP_BESTUUDER:
                carpoolcategorieTxt.setText(" back-up bestuuder");
                break;
            case MEERIJDER:
                 carpoolcategorieTxt.setText(" meer ijder");
                 break;
        }

        datumTijdTxt.setText(ritAanmelding.getDatum() + "  " + ritAanmelding.getBegintijd());
        ophaalPlaats.setText(ritAanmelding.getOpstapplaats());
        eindbestemming.setText(ritAanmelding.getEindBestemming());
        afmeldButton.setOnClickListener(v ->{
            database.deleteAanmelding(ritAanmelding.getGebruikersnaam(), ritAanmelding.getDatum());
            Intent intent = new Intent(context.getApplicationContext(), AangemeldeRittenAcitivity.class);
            context.startActivity(intent);
        });

        return view;
    }
}
