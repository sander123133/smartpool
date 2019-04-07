package com.example.smartpool.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartpool.Controller.GifsthopDetailActivity;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class

        /**
         * * Custom adapter die ervoor zorgt dat de lijstitems in de recyclerview gevuld worden met de beloning objecten uit de database
         * die weergegeven moeten worden in de giftshop.
         * @author Inge
         * @see GiftshopFragment
         */
AdapterGiftshop extends RecyclerView.Adapter<AdapterGiftshop.ViewHolder> {

    private ArrayList<BeloningWaardeCredit> mDataset;
    private Context mContext;
    private String gebruikersnaam;

    /**
     * Klasse die de layout beschrijft van de viewholder die gemaakt moet worden. Haalt referenties van de layout nodes van de
     * list item waarin de data uit de dataset weergegeven moet worden.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //view (list_row_item) die de items bevat die in de listview moeten komen
        public View view;

        //view items die de list_row_item bevat
        public ImageView fotoBeloning;
        public TextView tvNaamBeloning;
        public TextView tvWaardeBeloning;
        public TextView tvCreditAantal;


        /**
         * Constructor voor klasse viewholder
         * @param itemView view die de items bevat die in de listview moeten komen.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.view.setOnClickListener(this);

            //elementen ophalen die in list_row_item view zitten
            fotoBeloning = (ImageView) view.findViewById(R.id.image_Beloning);
            tvNaamBeloning = (TextView) view.findViewById(R.id.tv_NaamBeloning);
            tvWaardeBeloning = (TextView) view.findViewById(R.id.tvWaardeBeloning);
            tvCreditAantal = (TextView) view.findViewById(R.id.tvAantalCreditsBeloning);

        }

        /**
         * Methode die ervoor zorg dat het object waar op geklikt is in de lijst doorgegeven wordt aan
         * GiftshopDetailActivity.
         * @param view View waar op geklikt wordt.
         */
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            BeloningWaardeCredit mBeloning = mDataset.get(position);

            Intent giftshopDetailIntent = new Intent(
                    view.getContext().getApplicationContext(),
                    GifsthopDetailActivity.class);

            giftshopDetailIntent.putExtra("Beloning", mBeloning);
            giftshopDetailIntent.putExtra("Gebruikersnaam", gebruikersnaam);

            view.getContext().startActivity(giftshopDetailIntent);
        }
    }

    /**
     * Constructor
     * @param mDataset Lijst met beloningen uit de database die weergegeven moet worden in de recyclerview
     * @param mContext Context waarin de lijst weergegeven moet worden
     */
    public AdapterGiftshop(ArrayList<BeloningWaardeCredit> mDataset, Context mContext, String gebruikersnaam) {
        this.mDataset = mDataset;
        this.mContext = mContext;
        this.gebruikersnaam = gebruikersnaam;

    }

    /**
     * Maakt een nieuwe viewholder als er geen viewholders zijn die de recyclerview opnieuw kan gebruiken.
     * @param viewGroup De viewholder die geupdate moet worden om de waarden uit het object op de positie van de dataset weer te geven
     * @param i De positie van het item in de dataset
     * @return Geeft gemaakte viewholder terug
     */
    @NonNull
    @Override
    public AdapterGiftshop.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.gifsthop_list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    /**
     * Methode die de data uit de dataset in de bijbehorende layout uit het lijstitem zet voor de opgegeven positie in de recyclerview.
     * @param viewHolder referentie van het lijstitem en de layout nodes die daarbij horen.
     * @param position positie van het object in de lijst
     */
    @Override
    public void onBindViewHolder(@NonNull AdapterGiftshop.ViewHolder viewHolder, int position) {

        BeloningWaardeCredit bwc = mDataset.get(position);

        viewHolder.tvCreditAantal.setText(Integer.toString(bwc.getCreditaantal()));
        viewHolder.tvWaardeBeloning.setText(bwc.getWaarde());
        viewHolder.tvNaamBeloning.setText(bwc.getBeloningsnaam());
        Picasso.with(mContext).load(bwc.getFoto()).into(viewHolder.fotoBeloning);

    }

    /**
     * Geeft de grootte van de dataset
     * @return int aantal objecten in de lijst.
     */
    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }


}
