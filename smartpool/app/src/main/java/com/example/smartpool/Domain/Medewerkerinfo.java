package com.example.smartpool.Domain;

import java.io.Serializable;

public class Medewerkerinfo implements Serializable {
    private static String Naam;
    String gebruikersnaam;
    int creditaantal;
    String telefoonnumer;
    Carpoolcategorie carpoolcategorie;
    String Bedrijfnaam;
    String Foto;
    String Woonplaats;
    String Wachtwoord;
    String Naam;

    public Medewerkerinfo() {
    }

    public Medewerkerinfo(String gebruikersnaam, int creditaantal, String telefoonnumer, Carpoolcategorie carpoolcategorie, String bedrijfnaam, String foto, String woonplaats, String wachtwoord, String naam) {
        this.gebruikersnaam = gebruikersnaam;
        this.creditaantal = creditaantal;
        this.telefoonnumer = telefoonnumer;
        this.carpoolcategorie = carpoolcategorie;
        Bedrijfnaam = bedrijfnaam;
        Foto = foto;
        Woonplaats = woonplaats;
        Wachtwoord = wachtwoord;
        this.Naam = naam;

    }

    public static String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public int getCreditaantal() {
        return creditaantal;
    }

    public void setCreditaantal(int creditaantal) {
        this.creditaantal = creditaantal;
    }

    public String getTelefoonnumer() {
        return telefoonnumer;
    }

    public void setTelefoonnumer(String telefoonnumer) {
        this.telefoonnumer = telefoonnumer;
    }

    public com.example.smartpool.Domain.Carpoolcategorie getCarpoolcategorie() {
        return carpoolcategorie;
    }

    public void setCarpoolcategorie(com.example.smartpool.Domain.Carpoolcategorie carpoolcategorie) {
        this.carpoolcategorie = carpoolcategorie;
    }

    public String getBedrijfnaam() {
        return Bedrijfnaam;
    }

    public void setBedrijfnaam(String bedrijfnaam) {
        Bedrijfnaam = bedrijfnaam;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getWoonplaats() {
        return Woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        Woonplaats = woonplaats;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        Wachtwoord = wachtwoord;
    }

    public static String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }
}





