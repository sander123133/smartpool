package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.R;

public class GifsthopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giftshop_detail_activity);

        Bundle extras = getIntent().getExtras();
        BeloningWaardeCredit bwc = (BeloningWaardeCredit) extras.getSerializable("Beloning");


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
        //Picasso.with(this).load(bwc.getFoto()).into(mBeloningFoto);

        btnCreditsInwisselen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeloningOverzichtActivity.class);
                startActivity(intent);
            }
        });


    }


}
