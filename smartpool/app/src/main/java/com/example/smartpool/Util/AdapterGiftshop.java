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

AdapterGiftshop extends RecyclerView.Adapter<AdapterGiftshop.ViewHolder> {

    private ArrayList<BeloningWaardeCredit> mDataset;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //view (list_row_item) die de items bevat die in de listview moeten komen
        public View view;

        //view items die de list_row_item bevat
        public ImageView fotoBeloning;
        public TextView tvNaamBeloning;
        public TextView tvWaardeBeloning;
        public TextView tvCreditAantal;

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

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            BeloningWaardeCredit mBeloning = mDataset.get(position);

            Intent giftshopDetailIntent = new Intent(
                    view.getContext().getApplicationContext(),
                    GifsthopDetailActivity.class);

            giftshopDetailIntent.putExtra("Beloning", mBeloning);

            view.getContext().startActivity(giftshopDetailIntent);
        }
    }

    //constructor voor adapter
    public AdapterGiftshop(ArrayList<BeloningWaardeCredit> mDataset, Context mContext){
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    //Nieuwe views maken (invoked by the layout manager)
    @NonNull
    @Override
    public AdapterGiftshop.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.gifsthop_list_item, viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //inhoud van de view vervangen door waarden uit de dataset
    @Override
    public void onBindViewHolder(@NonNull AdapterGiftshop.ViewHolder viewHolder, int position) {

        BeloningWaardeCredit bwc = mDataset.get(position);

        viewHolder.tvCreditAantal.setText(Integer.toString(bwc.getCreditaantal()));
        viewHolder.tvWaardeBeloning.setText(Double.toString(bwc.getWaarde()));
        viewHolder.tvNaamBeloning.setText(bwc.getBeloningsnaam());
        Picasso.with(mContext).load(bwc.getFoto()).into(viewHolder.fotoBeloning);

    }

    //geeft grootte van de dataset terug
    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }


}
