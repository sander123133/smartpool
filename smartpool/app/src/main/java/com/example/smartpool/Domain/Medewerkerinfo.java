package com.example.smartpool.Domain;

import java.io.Serializable;

public class Medewerkerinfo implements Serializable {
String gebruikersnaam;
int creditaantal;
String telefoonnumer;
String wachtwoord;
String woonplaats;
String naam;
String foto;
String bedrijf;
Carpoolcategorie carpoolcategorie;
String Datum;


    public Medewerkerinfo() {
    }

    public Medewerkerinfo(String gebruikersnaam, int creditaantal, String telefoonnumer, String wachtwoord, String woonplaats, String naam, String foto, String bedrijf) {
        this.gebruikersnaam = gebruikersnaam;
        this.creditaantal = creditaantal;
        this.telefoonnumer = telefoonnumer;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.naam = naam;
        this.foto = foto;
        this.bedrijf = bedrijf;
    }

    public Medewerkerinfo(String gebruikersnaam, int creditaantal, String telefoonnumer, String wachtwoord, String woonplaats, String naam, String foto, String bedrijf, Carpoolcategorie carpoolcategorie, String datum) {
        this.gebruikersnaam = gebruikersnaam;
        this.creditaantal = creditaantal;
        this.telefoonnumer = telefoonnumer;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.naam = naam;
        this.foto = foto;
        this.bedrijf = bedrijf;
        this.carpoolcategorie = carpoolcategorie;
        Datum = datum;
    }

    public String getGebruikersnaam() {
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

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public Carpoolcategorie getCarpoolcategorie() {
        return carpoolcategorie;
    }

    public void setCarpoolcategorie(Carpoolcategorie carpoolcategorie) {
        this.carpoolcategorie = carpoolcategorie;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }
}
