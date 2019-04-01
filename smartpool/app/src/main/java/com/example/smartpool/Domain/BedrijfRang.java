package com.example.smartpool.Domain;

import java.io.Serializable;

public class BedrijfRang implements Serializable {

    private String bedrijfsnaam;
    private int creditaantal;

    public BedrijfRang(String bedrijfsnaam, int creditaantal) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.creditaantal = creditaantal;
    }

    public BedrijfRang() {
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public int getCreditaantal() {
        return creditaantal;
    }

    public void setCreditaantal(int creditaantal) {
        this.creditaantal = creditaantal;
    }

}
