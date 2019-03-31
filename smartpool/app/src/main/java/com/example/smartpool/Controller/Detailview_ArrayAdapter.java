package com.example.smartpool.Controller;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class Detailview_ArrayAdapter extends ArrayAdapter<Medewerkerinfo> {
    Context context;
    int recource;
    ArrayList<Medewerkerinfo> medewerkerinfos;
    Database database;
    public Detailview_ArrayAdapter(Context context, int recource, ArrayList<Medewerkerinfo> medewerkerinfos, Database database)
    {
        super(context, recource, medewerkerinfos);
        this.context = context;
        this.recource = recource;
        this.medewerkerinfos = medewerkerinfos;
        this.database = database;

    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_adpater_ritinformatie_detaivliew, parent, false);
        }
        Medewerkerinfo medewerkerinfo = medewerkerinfos.get(position);
        TextView naamTxt = view.findViewById(R.id.listview_adapter_naam_txt);
        TextView telefoonnummerTxt = view.findViewById(R.id.listview_adapter_telefoonnummer_Txt);
        TextView carpoolcategorieTxt = view.findViewById(R.id.listview_adapter_carpoolcategorie_txt);

        naamTxt.setText(medewerkerinfo.getGebruikersnaam());
        telefoonnummerTxt.setText(medewerkerinfo.getTelefoonnumer());
        medewerkerinfo.setCarpoolcategorie(database.getCarpoolCategorieFromGebruikersnaam(medewerkerinfo.getGebruikersnaam()));
        switch(medewerkerinfo.getCarpoolcategorie()){
            case BESTUUDER:
                carpoolcategorieTxt.setText("bestuuder");
                break;
            case MEERIJDER:
                carpoolcategorieTxt.setText("meerijder");
                break;
            case BACKUP_BESTUUDER:
                carpoolcategorieTxt.setText("back up");
                break;
        }
        return  view;
    }
}
