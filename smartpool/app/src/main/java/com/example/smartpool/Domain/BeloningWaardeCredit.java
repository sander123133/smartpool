package com.example.smartpool.Domain;

import java.io.Serializable;

public class BeloningWaardeCredit implements Serializable {

    private String beloningsnaam;
    private double waarde;
    private int creditaantal;
    private String beschrijving;
    private String foto;
    private String WebsiteURL;

    public BeloningWaardeCredit(String beloningsnaam, double waarde, int creditaantal, String beschrijving, String foto, String websiteURL) {
        this.beloningsnaam = beloningsnaam;
        this.waarde = waarde;
        this.creditaantal = creditaantal;
        this.beschrijving = beschrijving;
        this.foto = foto;
        WebsiteURL = websiteURL;
    }

    public String getBeloningsnaam() {
        return beloningsnaam;
    }

    public void setBeloningsnaam(String beloningsnaam) {
        this.beloningsnaam = beloningsnaam;
    }

    public double getWaarde() {
        return waarde;
    }

    public void setWaarde(double waarde) {
        this.waarde = waarde;
    }

    public int getCreditaantal() {
        return creditaantal;
    }

    public void setCreditaantal(int creditaantal) {
        this.creditaantal = creditaantal;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getWebsiteURL() {
        return WebsiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        WebsiteURL = websiteURL;
    }

}
