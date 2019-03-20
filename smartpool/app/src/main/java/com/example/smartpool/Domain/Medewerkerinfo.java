package com.example.smartpool.Domain;

public class Medewerkerinfo {
String gebruikersnaam;
int creditaantal;
Carpoolcategorie carpoolcategorie;

    public Medewerkerinfo(String gebruikersnaam, int creditaantal, Carpoolcategorie carpoolcategorie) {
        this.gebruikersnaam = gebruikersnaam;
        this.creditaantal = creditaantal;
        this.carpoolcategorie = carpoolcategorie;
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

    public Carpoolcategorie getCarpoolcategorie() {
        return carpoolcategorie;
    }

    public void setCarpoolcategorie(Carpoolcategorie carpoolcategorie) {
        this.carpoolcategorie = carpoolcategorie;
    }
}
