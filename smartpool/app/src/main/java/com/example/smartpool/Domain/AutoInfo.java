package com.example.smartpool.Domain;

public class AutoInfo {

    private String kenteken;
    private String merk;
    private String kleur;

    public AutoInfo(String kenteken, String merk, String kleur) {
        this.kenteken = kenteken;
        this.merk = merk;
        this.kleur = kleur;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
