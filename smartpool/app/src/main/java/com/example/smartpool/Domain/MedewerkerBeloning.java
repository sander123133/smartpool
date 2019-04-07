package com.example.smartpool.Domain;

import java.io.Serializable;

/**
 * Object waarin informatie van een aankoop van een beloning uit de giftshop door de gebruiker in opgeslagen wordt.
 * @author Inge
 */
public class MedewerkerBeloning implements Serializable {

    private int transactienummer;
    private String waarde;
    private String beloningsnaam;
    private String gebruikersnaam;
    private String kortingscode;
    private String datum;

    /**
     * Default constructor
     */
    public MedewerkerBeloning() {
    }

    /**
     * Constructor
     * @param transactienummer Het transactienummer van een beloning
     * @param waarde De waarde van een beloning
     * @param beloningsnaam De naam van een beloning
     * @param gebruikersnaam De gebruikersnaam van de ingelogde gebruiker
     * @param kortingscode De kortingscode waarmee de gebruiker de beloning online kan inwisselen
     * @param datum De datum waarop de beloning gekocht is
     */
    public MedewerkerBeloning(int transactienummer, String waarde, String beloningsnaam, String gebruikersnaam, String kortingscode, String datum) {
        this.transactienummer = transactienummer;
        this.waarde = waarde;
        this.beloningsnaam = beloningsnaam;
        this.gebruikersnaam = gebruikersnaam;
        this.kortingscode = kortingscode;
        this.datum = datum;
    }

    /**
     * Constructor zonder transactienummer omdat transactienummer autoincrement is in de database.
     * @param waarde De waarde van een beloning
     * @param beloningsnaam De naam van een beloning
     * @param gebruikersnaam De gebruikersnaam van de ingelogde gebruiker
     * @param kortingscode De kortingscode waarmee de gebruiker de beloning online kan inwisselen
     * @param datum De datum waarop de beloning gekocht is
     */
    public MedewerkerBeloning(String waarde, String beloningsnaam, String gebruikersnaam, String kortingscode, String datum) {
        this.waarde = waarde;
        this.beloningsnaam = beloningsnaam;
        this.gebruikersnaam = gebruikersnaam;
        this.kortingscode = kortingscode;
        this.datum = datum;
    }

    /**
     * Geeft de waarde van de variabele transactienummer
     * @return String transactienummer van de beloning
     */
    public int getTransactienummer() {
        return transactienummer;
    }

    /**
     * Stelt de waarde van variabele transactienummer gelijk aan de parameter variabele.
     * @param transactienummer int transactienummer van de beloning
     */
    public void setTransactienummer(int transactienummer) {
        this.transactienummer = transactienummer;
    }

    /**
     * Geeft de waarde van de variabele waarde
     * @return String waarde van de beloning
     */
    public String getWaarde() {
        return waarde;
    }

    /**
     * Stelt de waarde van variabele waarde gelijk aan de parameter variabele.
     * @param waarde String waarde van de beloning
     */
    public void setWaarde(String waarde) {
        this.waarde = waarde;
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
     * Geeft de waarde van de variabele gebruikersnaam
     * @return String gebruikersnaam van de ingelogde gebruiker
     */
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    /**
     * Stelt de waarde van variabele gebruikersnaam gelijk aan de parameter variabele.
     * @param gebruikersnaam Gebruikersnaam van de ingelogde gebruiker
     */
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    /**
     * Geeft de waarde van de variabele kortingscode
     * @return String kortingscode
     */
    public String getKortingscode() {
        return kortingscode;
    }

    /**
     * Stelt de waarde van variabele kortingscode gelijk aan de parameter variabele.
     * @param kortingscode String kortingscode van de beloning
     */
    public void setKortingscode(String kortingscode) {
        this.kortingscode = kortingscode;
    }

    /**
     * Geeft de waarde van de variabele datum
     * @return String datum
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Stelt de waarde van variabele datum gelijk aan de parameter variabele.
     * @param datum Datum waarop de beloning gekocht is
     */
    public void setDatum(String datum) {
        this.datum = datum;
    }
}
