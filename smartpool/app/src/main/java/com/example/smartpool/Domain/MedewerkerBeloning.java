package com.example.smartpool.Domain;

import java.io.Serializable;

public class MedewerkerBeloning implements Serializable {

    private String transactienummer;
    private double waarde;
    private String beloningsnaam;
    private String gebruikersnaam;
    private String kortingscode;
    private String datum;

    public MedewerkerBeloning() {
    }

    public MedewerkerBeloning(String transactienummer, double waarde, String beloningsnaam, String gebruikersnaam, String kortingscode, String datum) {
        this.transactienummer = transactienummer;
        this.waarde = waarde;
        this.beloningsnaam = beloningsnaam;
        this.gebruikersnaam = gebruikersnaam;
        this.kortingscode = kortingscode;
        this.datum = datum;
    }

    public String getTransactienummer() {
        return transactienummer;
    }

    public void setTransactienummer(String transactienummer) {
        this.transactienummer = transactienummer;
    }

    public double getWaarde() {
        return waarde;
    }

    public void setWaarde(double waarde) {
        this.waarde = waarde;
    }

    public String getBeloningsnaam() {
        return beloningsnaam;
    }

    public void setBeloningsnaam(String beloningsnaam) {
        this.beloningsnaam = beloningsnaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getKortingscode() {
        return kortingscode;
    }

    public void setKortingscode(String kortingscode) {
        this.kortingscode = kortingscode;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
