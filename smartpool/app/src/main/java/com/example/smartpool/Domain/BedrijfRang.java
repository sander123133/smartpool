package com.example.smartpool.Domain;

import java.io.Serializable;

public class BedrijfRang implements Serializable {

    private String bedrijfsnaam;
    private int creditaantal;
    private int plaats;

    public BedrijfRang(String bedrijfsnaam, int creditaantal, int plaats) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.creditaantal = creditaantal;
        this.plaats = plaats;
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

    public int getPlaats() {
        return plaats;
    }

    public void setPlaats(int plaats) {
        this.plaats = plaats;
    }
}
