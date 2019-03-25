package com.example.smartpool.Domain;

public class RitAanmelding {

    private String datum;
    private String gebruikersnaam;
    private Carpoolcategorie carpoolcategorie;

    public RitAanmelding(String datum, String gebruikersnaam, Carpoolcategorie carpoolcategorie) {
        this.datum = datum;
        this.gebruikersnaam = gebruikersnaam;
        this.carpoolcategorie = carpoolcategorie;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public Carpoolcategorie getCarpoolcategorie() {
        return carpoolcategorie;
    }

    public void setCarpoolcategorie(Carpoolcategorie carpoolcategorie) {
        this.carpoolcategorie = carpoolcategorie;
    }
}
