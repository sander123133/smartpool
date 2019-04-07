package com.example.smartpool.Domain;

import java.io.Serializable;

/**
 * Object waarin informatie van een beloning uit de giftshop in opgeslagen wordt.
 * @author Inge
 */
public class BeloningWaardeCredit implements Serializable {

    private String beloningsnaam;
    private String waarde;
    private int creditaantal;
    private String beschrijving;
    private String foto;
    private String WebsiteURL;

    /**
     * Default constructor
     */
    public BeloningWaardeCredit() {
    }

    /**
     * Constructor
     * @param beloningsnaam Naam van de beloning
     * @param waarde Waarde van de beloning
     * @param creditaantal Het aantal credits dat de beloning kost
     * @param beschrijving Een beschrijving van wat de beloning inhoudt
     * @param foto Een foto van de beloning
     * @param websiteURL De website url van de beloning
     */
    public BeloningWaardeCredit(String beloningsnaam, String waarde, int creditaantal, String beschrijving, String foto, String websiteURL) {
        this.beloningsnaam = beloningsnaam;
        this.waarde = waarde;
        this.creditaantal = creditaantal;
        this.beschrijving = beschrijving;
        this.foto = foto;
        WebsiteURL = websiteURL;
    }

    /**
     * Geeft de waarde van de variabele beloningsnaam
     * @return String beloningsnaam
     */
    public String getBeloningsnaam() {
        return beloningsnaam;
    }

    /**
     * Stelt de waarde van variabele schoolnaam gelijk aan de parameter variabele.
     * @param beloningsnaam Naam van de beloning
     */
    public void setBeloningsnaam(String beloningsnaam) {
        this.beloningsnaam = beloningsnaam;
    }

    /**
     * Geeft de waarde van de variabele waarde
     * @return String waarde
     */
    public String getWaarde() {
        return waarde;
    }

    /**
     * Stelt de waarde van variabele waarde gelijk aan de parameter variabele.
     * @param waarde String waarde van een beloning
     */
    public void setWaarde(String waarde) {
        this.waarde = waarde;
    }

    /**
     * Geeft de waarde van de variabele creditaantal
     * @return int creditaantal
     */
    public int getCreditaantal() {
        return creditaantal;
    }

    /**
     * Stelt de waarde van variabele creditaantal gelijk aan de parameter variabele.
     * @param creditaantal int aantal credits die de beloning kost
     */
    public void setCreditaantal(int creditaantal) {
        this.creditaantal = creditaantal;
    }

    /**
     * Geeft de waarde van de variabele beschrijving
     * @return String beschrijving
     */
    public String getBeschrijving() {
        return beschrijving;
    }

    /**
     * Stelt de waarde van variabele beschrijving gelijk aan de parameter variabele.
     * @param beschrijving String beschrijving van de beloning
     */
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    /**
     * Geeft de waarde van de variabele foto
     * @return String fotourl
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Stelt de waarde van variabele foto gelijk aan de parameter variabele.
     * @param foto String fotourl van de beloning
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Geeft de waarde van de variabele websiteurl
     * @return String websiteurl van de beloning
     */
    public String getWebsiteURL() {
        return WebsiteURL;
    }

    /**
     * Stelt de waarde van variabele websiteurl gelijk aan de parameter variabele.
     * @param websiteURL String websiteurl van de beloning
     */
    public void setWebsiteURL(String websiteURL) {
        WebsiteURL = websiteURL;
    }

}
