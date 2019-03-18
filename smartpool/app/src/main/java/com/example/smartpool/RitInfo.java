package com.example.smartpool;

public class RitInfo {

    private String opstapplaats;
    private String eindbestmming;
    private String datum;
    private String tijdHeen;
    private String tijdTerug;
    private int vrijePlaatsen;

    public RitInfo(String opstapplaats, String eindbestmming, String datum, String tijdHeen, String tijdTerug, int vrijePlaatsen) {
        this.opstapplaats = opstapplaats;
        this.eindbestmming = eindbestmming;
        this.datum = datum;
        this.tijdHeen = tijdHeen;
        this.tijdTerug = tijdTerug;
        this.vrijePlaatsen = vrijePlaatsen;
    }

    public String getOpstapplaats() {
        return opstapplaats;
    }

    public void setOpstapplaats(String opstapplaats) {
        this.opstapplaats = opstapplaats;
    }

    public String getEindbestmming() {
        return eindbestmming;
    }

    public void setEindbestmming(String eindbestmming) {
        this.eindbestmming = eindbestmming;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijdHeen() {
        return tijdHeen;
    }

    public void setTijdHeen(String tijdHeen) {
        this.tijdHeen = tijdHeen;
    }

    public String getTijdTerug() {
        return tijdTerug;
    }

    public void setTijdTerug(String tijdTerug) {
        this.tijdTerug = tijdTerug;
    }

    public int getVrijePlaatsen() {
        return vrijePlaatsen;
    }

    public void setVrijePlaatsen(int vrijePlaatsen) {
        this.vrijePlaatsen = vrijePlaatsen;
    }
}