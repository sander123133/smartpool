package com.example.smartpool.Domain;

import java.io.Serializable;

public class RitInfo implements Serializable {

    private String opstapplaats;
    private String eindbestmming;
    private String datum;
    private String tijdHeen;
    private String tijdTerug;
    private int vrijePlaatsen;
    private String gebruikersnaam;
    private String status;
    private String kenteken;
    private String qrCode;
    private int ritnummer;

    public RitInfo(String opstapplaats, String eindbestmming, String datum, String tijdHeen, String tijdTerug, int vrijePlaatsen, String gebruikersnaam, String status, String kenteken, String qrCode){
        this.opstapplaats = opstapplaats;
        this.eindbestmming = eindbestmming;
        this.datum = datum;
        this.tijdHeen = tijdHeen;
        this.tijdTerug = tijdTerug;
        this.vrijePlaatsen = vrijePlaatsen;
        this.gebruikersnaam = gebruikersnaam;
        this. status = status;
        this.kenteken = kenteken;
        this.qrCode = qrCode;
    }

    public RitInfo(String opstapplaats, String eindbestmming, String datum, String tijdHeen, String tijdTerug, int vrijePlaatsen, String gebruikersnaam, String status, String kenteken, String qrCode, int ritnummer) {
        this.opstapplaats = opstapplaats;
        this.eindbestmming = eindbestmming;
        this.datum = datum;
        this.tijdHeen = tijdHeen;
        this.tijdTerug = tijdTerug;
        this.vrijePlaatsen = vrijePlaatsen;
        this.gebruikersnaam = gebruikersnaam;
        this.status = status;
        this.kenteken = kenteken;
        this.qrCode = qrCode;
        this.ritnummer = ritnummer;
    }

    public int getRitnummer() {
        return ritnummer;
    }

    public void setRitnummer(int ritnummer) {
        this.ritnummer = ritnummer;
    }

    public RitInfo(String opstapplaats, String eindbestmming, String datum, String tijdHeen) {
        this.opstapplaats = opstapplaats;
        this.eindbestmming = eindbestmming;
        this.datum = datum;
        this.tijdHeen = tijdHeen;
    }

    public RitInfo() {
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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