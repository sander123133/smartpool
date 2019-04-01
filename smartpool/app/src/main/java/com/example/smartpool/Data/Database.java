package com.example.smartpool.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.smartpool.Domain.BedrijfRang;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.Domain.Medewerkerinfo;

import com.example.smartpool.Domain.AutoInfo;

import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.Domain.RitInfo;


import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();

    private static final String DB_NAME = "smartpoolDB";

    private static final int DB_V = 4;


    //tabel en kolomnamen
    //tabel MedewerkerInfo
    private static final String MEDEWERKER_TABEL_NAAM = "MedewerkerInfo";
    private static final String MEDEWERKER_KOLOM_GEBRUIKERSNAAM = "Gebruikersnaam";
    private static final String MEDEWERKER_KOLOM_WACHTWOORD = "Wachtwoord";
    private static final String MEDEWERKER_KOLOM_NAAM = "Naam";
    private static final String MEDEWERKER_KOLOM_WOONPLAATS = "Woonplaats";
    private static final String MEDEWERKER_KOLOM_BEDRIJF = "Bedrijf";
    private static final String MEDEWERKER_KOLOM_TELEFOONNUMMER = "Telefoonnummer";
    private static final String MEDEWERKER_KOLOM_FOTO = "Foto";
    private static final String MEDEWERKER_KOLOM_CREDITS_BESTEDEN = "CreditsBesteedbaar";

    //tabel MedewerkerBeloning
    private static final String MEDEWERKERBELONING_TABEL_NAAM = "MedewerkerBeloning";
    private static final String MEDEWERKERBELONING_KOLOM_TRANSACTIENMR = "Transactienummer";
    private static final String MEDEWERKERBELONING_KOLOM_WAARDE = "Waarde";
    private static final String MEDEWERKERBELONING_KOLOM_BELONINGSNAAM = "Beloningsnaam";
    private static final String MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM = "Gebruikersnaam";
    private static final String MEDEWERKERBELONING_KOLOM_KORTINGSCODE = "Kortingscode";
    private static final String MEDEWERKERBELONING_KOLOM_DATUM  = "Datum";

    //tabel BeloningWaardeCredit
    private static final String BWC_TABEL_NAAM = "BeloningWaardeCredit";
    private static final String BWC_KOLOM_BELONINGSNAAM = "Beloningsnaam";
    private static final String BWC_KOLOM_WAARDE = "Waarde";
    private static final String BWC_KOLOM_CREDITAANTAL = "Creditaantal";
    private static final String BWC_KOLOM_BESCHRIJVING = "Beschrijving";
    private static final String BWC_KOLOM_FOTO = "Foto";
    private static final String BWC_KOLOM_WEBSITEURL = "WebsiteUrl";

    //tabel BedrijfRang
    private static final String BEDRIJFRANG_TABEL_NAAM = "BedrijfRang";
    private static final String BEDRIJFRANG_KOLOM_BEDRIJFSNAAM = "Bedrijfsnaam";
    private static final String BEDRIJFRANG_KOLOM_CREDITAANTAL = "Creditaantal";
    private static final String BEDRIJFRANG_KOLOM_PLAATS = "Plaats";

    //tabel MedewerkerRang
    private static final String MEDEWERKERRANG_TABEL_NAAM = "MedewerkerRang";
    private static final String MEDEWERKERRANG_KOLOM_GEBRUIKERSNAAM = "Gebruikersnaam";
    private static final String MEDEWERKERRANG_KOLOM_TOTAALCREDITS = "TotaalCredits";
    private static final String MEDEWERKERRANG_KOLOM_PLAATS = "Plaats";

    //tabel RitInformatie
    private static final String RITINFO_TABEL_NAAM = "RitInformatie";
    private static final String RITINFO_KOLOM_GEBRUIKERSNAAM = "Gebruikersnaam";
    private static final String RITINFO_KOLOM_OPSTAPPLAATS = "Opstapplaats";
    private static final String RITINFO_KOLOM_EINDBESTEMMING = "Eindbestemming";
    private static final String RITINFO_KOLOM_DATUM = "Datum";
    private static final String RITINFO_KOLOM_STARTTIJD = "Starttijd";
    private static final String RITINFO_KOLOM_OPEN_PLAATSEN = "Openplaatsen";
    private static final String RITINFO_KOLOM_TIJD_TERUGRIJDEN = "Tijdterugrijden";
    private static final String RITINFO_KOLOM_STATUS = "Status";
    private static final String RITINFO_KOLOM_KENTEKEN = "Kenteken";
    private static final String RITINFO_KOLOM_QRCODE = "qrcode";

    //tabel AanmeldingRit
    private static final String AANMELDING_TABEL_NAAM = "AanmeldingRit";
    private static final String AANMELDING_KOLOM_GEBRUIKERSNAAM = "Gebruikersnaam";
    private static final String AANMELDING_KOLOM_DATUM = "Datum";
    private static final String AANMELDING_KOLOM_CARPOOLCATEGORIE = "Carpoolcategorie";

    //tabel CarpoolCategorieCredits
    private static final String CARPOOOLCATCREDITS_TABEL_NAAM = "CarpoolCategorieCredits";
    private static final String CARPOOLCATCREDITS_KOLOM_CARPOOLCAT = "Carpoolcategorie";
    private static final String CARPOOLCATCREDITS_KOLOM_CREDITAANTAL = "Creditaantal";

    //tabel Statusnaam
    private static final String STATUSNAAM_TABEL_NAAM = "Statusnaam";
    private static final String STATUSNAAM_KOLOM_STATUSNAAM = "Statusnaam";

    //tabel qr-code
    private static final String QRCODE_TABEL_NAAM = "QRcode";
    private static final String QRCODE_KOLOM_QRCODE = "qrcode";

    //tabel MedewerkerAutoInfo
    private static final String AUTOINFO_TABEL_NAAM = "MedewerkerAutoInfo";
    private static final String AUTOINFO_KOLOM_KENTEKEN = "Kenteken";
    private static final String AUTOINFO_KOLOM_MERK = "Merk";
    private static final String AUTOINFO_KOLOM_KLEUR = "Kleur";


    public Database(Context context) {
        super(context, DB_NAME, null, DB_V);
        Log.d(TAG, "Database: constructor called");
    }

    //tabellen aanmaken
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //tabel BeloningWaardeCredit
        sqLiteDatabase.execSQL("CREATE TABLE '" + BWC_TABEL_NAAM + "' ( `" +
                BWC_KOLOM_BELONINGSNAAM + "` TEXT, `" +
                BWC_KOLOM_WAARDE + "` NUMERIC, `" +
                BWC_KOLOM_CREDITAANTAL + "` INTEGER NOT NULL, " +
                BWC_KOLOM_BESCHRIJVING + " TEXT NOT NULL," +
                BWC_KOLOM_FOTO + " TEXT NOT NULL," +
                BWC_KOLOM_WEBSITEURL + " TEXT NOT NULL," +
                "PRIMARY KEY(" + BWC_KOLOM_BELONINGSNAAM + "," + BWC_KOLOM_WAARDE + "))");

        //tabel BedrijfRang
        sqLiteDatabase.execSQL("CREATE TABLE " + BEDRIJFRANG_TABEL_NAAM + "(" +
                BEDRIJFRANG_KOLOM_BEDRIJFSNAAM + " TEXT, " +
                BEDRIJFRANG_KOLOM_CREDITAANTAL + " INTEGER, " +
                BEDRIJFRANG_KOLOM_PLAATS + " INTEGER, " +
                "PRIMARY KEY(" + BEDRIJFRANG_KOLOM_BEDRIJFSNAAM + "))");

        //tabel medewerkerinfo
        sqLiteDatabase.execSQL("CREATE TABLE " + MEDEWERKER_TABEL_NAAM + "(" +
                MEDEWERKER_KOLOM_GEBRUIKERSNAAM + " TEXT, " +
                MEDEWERKER_KOLOM_WACHTWOORD + " TEXT NOT NULL, " +
                MEDEWERKER_KOLOM_NAAM + " TEXT NOT NULL, " +
                MEDEWERKER_KOLOM_WOONPLAATS + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_BEDRIJF + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_TELEFOONNUMMER + " INTEGER NOT NULL," +
                MEDEWERKER_KOLOM_FOTO + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_CREDITS_BESTEDEN + " INTEGER," +
                "PRIMARY KEY(" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + ")," +
                "FOREIGN KEY(" + MEDEWERKER_KOLOM_BEDRIJF + ")" +
                "REFERENCES " + BEDRIJFRANG_TABEL_NAAM + "(" + BEDRIJFRANG_KOLOM_BEDRIJFSNAAM + ") )");

        //tabel MedewerkerBeloning
        sqLiteDatabase.execSQL("CREATE TABLE " + MEDEWERKERBELONING_TABEL_NAAM  +  " ( " +
                MEDEWERKERBELONING_KOLOM_TRANSACTIENMR + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MEDEWERKERBELONING_KOLOM_BELONINGSNAAM + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_WAARDE + " NUMERIC NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_KORTINGSCODE + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_DATUM + " TEXT NOT NULL, " +
                "FOREIGN KEY(" + MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM + ") REFERENCES " +
                MEDEWERKER_TABEL_NAAM + "(" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + "), " +
                //"PRIMARY KEY(" + MEDEWERKERBELONING_KOLOM_TRANSACTIENMR + "), " +
                "FOREIGN KEY(" + MEDEWERKERBELONING_KOLOM_BELONINGSNAAM + ", " + MEDEWERKERBELONING_KOLOM_WAARDE + ") " +
                "REFERENCES " + BWC_TABEL_NAAM + "(" + BWC_KOLOM_BELONINGSNAAM + ", " + BWC_KOLOM_WAARDE +") )");

        //tabel MedewerkerRang
        sqLiteDatabase.execSQL("CREATE TABLE " + MEDEWERKERRANG_TABEL_NAAM + "(" +
                MEDEWERKERRANG_KOLOM_GEBRUIKERSNAAM + " TEXT, " +
                MEDEWERKERRANG_KOLOM_TOTAALCREDITS + " INTEGER, " +
                MEDEWERKERRANG_KOLOM_PLAATS + " INTEGER, " +
                "PRIMARY KEY(`" + MEDEWERKERRANG_KOLOM_GEBRUIKERSNAAM + "`)," +
                "FOREIGN KEY(" + MEDEWERKERRANG_KOLOM_GEBRUIKERSNAAM + ")" +
                "REFERENCES " + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + "(" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + ") )");

        //tabel CarpoolCategorie
        sqLiteDatabase.execSQL("CREATE TABLE " + CARPOOOLCATCREDITS_TABEL_NAAM + "(" +
                CARPOOLCATCREDITS_KOLOM_CARPOOLCAT + " TEXT, " +
                CARPOOLCATCREDITS_KOLOM_CREDITAANTAL + " INTEGER NOT NULL, " +
                "PRIMARY KEY(" + CARPOOLCATCREDITS_KOLOM_CARPOOLCAT + "))");

        //tabel Statusnaam
        sqLiteDatabase.execSQL("CREATE TABLE " + STATUSNAAM_TABEL_NAAM + "(" +
                STATUSNAAM_KOLOM_STATUSNAAM + " TEXT, " +
                "PRIMARY KEY(" + STATUSNAAM_KOLOM_STATUSNAAM + "))");

        //tabel QRcode
        sqLiteDatabase.execSQL("CREATE TABLE " + QRCODE_TABEL_NAAM + "(" +
                QRCODE_KOLOM_QRCODE + " TEXT, " +
                "PRIMARY KEY(" + QRCODE_KOLOM_QRCODE + "))");

        //tabel MedewerkerAutoInfo
        sqLiteDatabase.execSQL("CREATE TABLE " + AUTOINFO_TABEL_NAAM + "(" +
                AUTOINFO_KOLOM_KENTEKEN + " TEXT, " +
                AUTOINFO_KOLOM_KLEUR + " TEXT NOT NULL, " +
                AUTOINFO_KOLOM_MERK + " TEXT NOT NULL, " +
                "PRIMARY KEY(" + AUTOINFO_KOLOM_KENTEKEN + "))");

        //tabel RitInfo
        sqLiteDatabase.execSQL("CREATE TABLE " + RITINFO_TABEL_NAAM + "( " +
                RITINFO_KOLOM_GEBRUIKERSNAAM + " TEXT, " +
                RITINFO_KOLOM_OPSTAPPLAATS + " TEXT NOT NULL, " +
                RITINFO_KOLOM_EINDBESTEMMING + " TEXT NOT NULL, " +
                RITINFO_KOLOM_DATUM + " TEXT, " +
                RITINFO_KOLOM_STARTTIJD + " TEXT NOT NULL, " +
                RITINFO_KOLOM_OPEN_PLAATSEN + " INTEGER NOT NULL, " +
                RITINFO_KOLOM_TIJD_TERUGRIJDEN + " TEXT NOT NULL, " +
                RITINFO_KOLOM_STATUS + " TEXT NOT NULL, " +
                RITINFO_KOLOM_KENTEKEN + " TEXT NOT NULL, " +
                RITINFO_KOLOM_QRCODE + " TEXT NOT NULL, " +
                "PRIMARY KEY(" + RITINFO_KOLOM_GEBRUIKERSNAAM + ", " + RITINFO_KOLOM_DATUM + ")," +
                "FOREIGN KEY(" + RITINFO_KOLOM_GEBRUIKERSNAAM + ")" +
                "REFERENCES " + MEDEWERKER_TABEL_NAAM + "(" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + ")," +
                "FOREIGN KEY(" + RITINFO_KOLOM_STATUS + ")" +
                "REFERENCES " + STATUSNAAM_TABEL_NAAM + "(" + STATUSNAAM_KOLOM_STATUSNAAM + ")," +
                "FOREIGN KEY(" + RITINFO_KOLOM_KENTEKEN + ")" +
                "REFERENCES " + AUTOINFO_TABEL_NAAM + "(" + AUTOINFO_KOLOM_KENTEKEN + ")," +
                "FOREIGN KEY(" + RITINFO_KOLOM_QRCODE + ")" +
                "REFERENCES " + QRCODE_TABEL_NAAM + "(" + QRCODE_KOLOM_QRCODE + ") )");

        //tabel AanmeldingRit
        sqLiteDatabase.execSQL("CREATE TABLE " + AANMELDING_TABEL_NAAM + "(" +
                AANMELDING_KOLOM_CARPOOLCATEGORIE + " TEXT, " +
                AANMELDING_KOLOM_DATUM + " TEXT, " +
                AANMELDING_KOLOM_GEBRUIKERSNAAM + " TEXT, " +
                "PRIMARY KEY(" + AANMELDING_KOLOM_DATUM + ", " + AANMELDING_KOLOM_GEBRUIKERSNAAM + ", " + AANMELDING_KOLOM_CARPOOLCATEGORIE + ")," +
                "FOREIGN KEY(" + AANMELDING_KOLOM_CARPOOLCATEGORIE + ")" +
                "REFERENCES " + CARPOOOLCATCREDITS_TABEL_NAAM + "(" + CARPOOLCATCREDITS_KOLOM_CARPOOLCAT + ")," +
                "FOREIGN KEY(" + AANMELDING_KOLOM_GEBRUIKERSNAAM + ", " + AANMELDING_KOLOM_DATUM + ") " +
                "REFERENCES " + RITINFO_TABEL_NAAM + "(" + RITINFO_KOLOM_GEBRUIKERSNAAM + ", " + RITINFO_KOLOM_DATUM +") )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + MEDEWERKER_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + MEDEWERKERBELONING_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + RITINFO_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + AANMELDING_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + MEDEWERKERRANG_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + CARPOOOLCATCREDITS_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + STATUSNAAM_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + QRCODE_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + AUTOINFO_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + BEDRIJFRANG_TABEL_NAAM);
        sqLiteDatabase.execSQL("DROP TABLE " + BWC_TABEL_NAAM);

        onCreate(sqLiteDatabase);

    }

    public ArrayList<BeloningWaardeCredit> geefAlleBeloningen(){

        ArrayList<BeloningWaardeCredit> beloningen = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + BWC_TABEL_NAAM + ";", null);
        res.moveToFirst();

        while (!res.isAfterLast()){

            BeloningWaardeCredit bwc = new BeloningWaardeCredit();

            //waarden in bwc object stoppen
            bwc.setBeloningsnaam(res.getString(res.getColumnIndex(BWC_KOLOM_BELONINGSNAAM)));
            bwc.setBeschrijving(res.getString(res.getColumnIndex(BWC_KOLOM_BESCHRIJVING)));
            bwc.setCreditaantal(res.getInt(res.getColumnIndex(BWC_KOLOM_CREDITAANTAL)));
            bwc.setWaarde(res.getDouble(res.getColumnIndex(BWC_KOLOM_WAARDE)));
            bwc.setWebsiteURL(res.getString(res.getColumnIndex(BWC_KOLOM_WEBSITEURL)));
            bwc.setFoto(res.getString(res.getColumnIndex(BWC_KOLOM_FOTO)));

            beloningen.add(bwc);
            res.moveToNext();
        }

        close();
        return beloningen;

    }

    public ArrayList<RitInfo> geefRitInfo() {

        ArrayList<RitInfo> ritInfoArrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + RITINFO_TABEL_NAAM + ";", null);
        res.moveToFirst();

        while (!res.isAfterLast()){

            RitInfo ri = new RitInfo();

            ri.setOpstapplaats(res.getString(res.getColumnIndex(RITINFO_KOLOM_OPSTAPPLAATS)));
            ri.setEindbestmming(res.getString(res.getColumnIndex(RITINFO_KOLOM_EINDBESTEMMING)));
            ri.setDatum(res.getString(res.getColumnIndex(RITINFO_KOLOM_DATUM)));
            ri.setTijdHeen(res.getString(res.getColumnIndex(RITINFO_KOLOM_STARTTIJD)));
            ri.setTijdTerug(res.getString(res.getColumnIndex(RITINFO_KOLOM_TIJD_TERUGRIJDEN)));
            ri.setVrijePlaatsen(res.getInt(res.getColumnIndex(RITINFO_KOLOM_OPEN_PLAATSEN)));
            ri.setGebruikersnaam(res.getString(res.getColumnIndex(RITINFO_KOLOM_GEBRUIKERSNAAM)));
            ri.setStatus(res.getString(res.getColumnIndex(RITINFO_KOLOM_STATUS)));
            ri.setKenteken(res.getString(res.getColumnIndex(RITINFO_KOLOM_KENTEKEN)));
            ri.setQrCode(res.getString(res.getColumnIndex(RITINFO_KOLOM_QRCODE)));

            ritInfoArrayList.add(ri);
            res.moveToNext();
        }
        close();
        return ritInfoArrayList;
    }

    public boolean insertBeloning(BeloningWaardeCredit beloningWaardeCredit){

        Log.d(TAG, "insertBeloning: aangeroepen");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BWC_KOLOM_BELONINGSNAAM, beloningWaardeCredit.getBeloningsnaam());
        contentValues.put(BWC_KOLOM_WAARDE, beloningWaardeCredit.getWaarde());
        contentValues.put(BWC_KOLOM_CREDITAANTAL, beloningWaardeCredit.getCreditaantal());
        contentValues.put(BWC_KOLOM_BESCHRIJVING, beloningWaardeCredit.getBeschrijving());
        contentValues.put(BWC_KOLOM_FOTO, beloningWaardeCredit.getFoto());
        contentValues.put(BWC_KOLOM_WEBSITEURL, beloningWaardeCredit.getWebsiteURL());

        Log.d(TAG, "insert beloning: " + beloningWaardeCredit.getBeloningsnaam());

        db.insert(BWC_TABEL_NAAM, null, contentValues);
        close();


        return  true;

    }

    public boolean insertAutoInfo(AutoInfo autoInfo) {

        Log.d(TAG, "insertAutoInfo: aangeroepen");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(AUTOINFO_KOLOM_KENTEKEN, autoInfo.getKenteken());
        contentValues.put(AUTOINFO_KOLOM_KLEUR, autoInfo.getKleur());
        contentValues.put(AUTOINFO_KOLOM_MERK, autoInfo.getMerk());

        Log.d(TAG, "insert autoinfo: " + autoInfo.getKenteken());

        db.insert(AUTOINFO_TABEL_NAAM, null, contentValues);
        close();


        return  true;

    }

    public boolean insertRitInfo(RitInfo ritInfo) {

        Log.d(TAG, "insertRitInfo: aangeroepen");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RITINFO_KOLOM_DATUM, ritInfo.getDatum());
        contentValues.put(RITINFO_KOLOM_EINDBESTEMMING, ritInfo.getEindbestmming());
        contentValues.put(RITINFO_KOLOM_GEBRUIKERSNAAM, ritInfo.getGebruikersnaam());
        contentValues.put(RITINFO_KOLOM_KENTEKEN, ritInfo.getKenteken());
        contentValues.put(RITINFO_KOLOM_OPEN_PLAATSEN, ritInfo.getVrijePlaatsen());
        contentValues.put(RITINFO_KOLOM_OPSTAPPLAATS, ritInfo.getOpstapplaats());
        contentValues.put(RITINFO_KOLOM_QRCODE, ritInfo.getQrCode());
        contentValues.put(RITINFO_KOLOM_STARTTIJD, ritInfo.getTijdHeen());
        contentValues.put(RITINFO_KOLOM_STATUS, ritInfo.getStatus());
        contentValues.put(RITINFO_KOLOM_TIJD_TERUGRIJDEN, ritInfo.getTijdTerug());

        Log.d(TAG, "insert ritinfo: " + ritInfo.getKenteken());

        db.insert(RITINFO_TABEL_NAAM, null, contentValues);
        close();


        return  true;
    }



    public void createTestData(){

        Log.d(TAG, "createTestData: Called");

        Cursor res = getReadableDatabase().rawQuery("SELECT * FROM "+ BWC_TABEL_NAAM + ";", null);
        res.moveToFirst();

        try{
            if (res.isNull(0));
        }catch (CursorIndexOutOfBoundsException c){
            Log.d(TAG, "createTestData: NO TEST DATA AVAILABLE CONFIRMED");

            ArrayList<BeloningWaardeCredit> beloningen = genereerBeloningen();


            //geen data -> maak aan
            Log.d(TAG, "createTestData: Creating BeloningWaardeCredit TEST DATA");
            SQLiteDatabase db = getWritableDatabase();

            for(BeloningWaardeCredit bwc: beloningen){
                insertBeloning(bwc);
            }


        }

        Log.d(TAG, "createTestData: Testdata is already available.");
        close();


    }

    public ArrayList<BeloningWaardeCredit> genereerBeloningen(){

        ArrayList<BeloningWaardeCredit> beloningen = new ArrayList<>();

        BeloningWaardeCredit beloning1 = new BeloningWaardeCredit(
                "vvv cadeaubon", 10, 15, "De VVV Cadeaubon (voorheen VVV Irischeque, daarvoor VVV Geschenkbon) is een cadeaubon in Nederland waarvoor de ontvanger naar eigen keuze iets bij een van de 23.000 aangesloten acceptatiepunten kan kopen.",
                "https://www.primera.nl/media/catalog/product/cache/1/thumbnail/900x/163b81649b7ef7bc8a00b0066e59ae0a/v/v/vvv_cadeaukaart_front_2.jpg", "https://www.vvvcadeaukaarten.nl/"
        );

        BeloningWaardeCredit beloning2 = new BeloningWaardeCredit(
                "vvv cadeaubon", 20, 30, "De VVV Cadeaubon (voorheen VVV Irischeque, daarvoor VVV Geschenkbon) is een cadeaubon in Nederland waarvoor de ontvanger naar eigen keuze iets bij een van de 23.000 aangesloten acceptatiepunten kan kopen.",
                "https://www.primera.nl/media/catalog/product/cache/1/thumbnail/900x/163b81649b7ef7bc8a00b0066e59ae0a/v/v/vvv_cadeaukaart_front_2.jpg", "https://www.vvvcadeaukaarten.nl/"
        );

        BeloningWaardeCredit beloning3 = new BeloningWaardeCredit(
                "vvv cadeaubon", 50, 75, "De VVV Cadeaubon (voorheen VVV Irischeque, daarvoor VVV Geschenkbon) is een cadeaubon in Nederland waarvoor de ontvanger naar eigen keuze iets bij een van de 23.000 aangesloten acceptatiepunten kan kopen.",
                "https://www.primera.nl/media/catalog/product/cache/1/thumbnail/900x/163b81649b7ef7bc8a00b0066e59ae0a/v/v/vvv_cadeaukaart_front_2.jpg", "https://www.vvvcadeaukaarten.nl/"
        );

        beloningen.add(beloning1);
        beloningen.add(beloning2);
        beloningen.add(beloning3);

        return beloningen;

    }


    public boolean insertMedewerkerBeloning(MedewerkerBeloning medewerkerBeloning){

        Log.d(TAG, "insertMedewerkerBeloning: aangeroepen");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MEDEWERKERBELONING_KOLOM_BELONINGSNAAM, medewerkerBeloning.getBeloningsnaam());
        contentValues.put(MEDEWERKERBELONING_KOLOM_DATUM, medewerkerBeloning.getDatum());
        contentValues.put(MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM, medewerkerBeloning.getGebruikersnaam());
        contentValues.put(MEDEWERKERBELONING_KOLOM_KORTINGSCODE, medewerkerBeloning.getKortingscode());
        contentValues.put(MEDEWERKERBELONING_KOLOM_WAARDE, medewerkerBeloning.getWaarde());

        Log.d(TAG, "insert medewerkerbeloning: " + medewerkerBeloning.getBeloningsnaam());

        db.insert(MEDEWERKERBELONING_TABEL_NAAM, null, contentValues);
        close();

        return true;
    }

    public ArrayList<MedewerkerBeloning> geefAlleBeloningenMedewerker(String gebruikersnaam){

        Log.d(TAG, "geefAlleBeloningenMedewerker: aangeroepen");
        ArrayList<MedewerkerBeloning> beloningenMedewerker = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM " + MEDEWERKERBELONING_TABEL_NAAM + " WHERE " + MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM + " = '" + gebruikersnaam + "';", null);
        res.moveToFirst();

        while (!res.isAfterLast()){

            MedewerkerBeloning mdb = new MedewerkerBeloning();

            mdb.setBeloningsnaam(res.getString(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_BELONINGSNAAM)));
            mdb.setDatum(res.getString(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_DATUM)));
            mdb.setGebruikersnaam(res.getString(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM)));
            mdb.setKortingscode(res.getString(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_KORTINGSCODE)));
            mdb.setTransactienummer(res.getInt(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_TRANSACTIENMR)));
            mdb.setWaarde(res.getDouble(res.getColumnIndex(MEDEWERKERBELONING_KOLOM_WAARDE)));

            beloningenMedewerker.add(mdb);
            res.moveToNext();

        }

        close();
        return beloningenMedewerker;


    }

    public void verwijderBeloning(String transactienummer){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "DELETE FROM " + MEDEWERKERBELONING_TABEL_NAAM + " WHERE " + MEDEWERKERBELONING_KOLOM_TRANSACTIENMR + " = '" + transactienummer + "';";

        sqLiteDatabase.execSQL(query);
        close();
    }






    public void insertMedewerker(Medewerkerinfo medewerkerinfo){

        Log.d(TAG, "insertBeloning: aangeroepen");


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MEDEWERKER_KOLOM_GEBRUIKERSNAAM, medewerkerinfo.getGebruikersnaam());
        contentValues.put(MEDEWERKER_KOLOM_WACHTWOORD, medewerkerinfo.getWachtwoord());
        contentValues.put(MEDEWERKER_KOLOM_NAAM, medewerkerinfo.getNaam());
        contentValues.put(MEDEWERKER_KOLOM_BEDRIJF, medewerkerinfo.getBedrijf());
        contentValues.put(MEDEWERKER_KOLOM_WOONPLAATS, medewerkerinfo.getWoonplaats());
        contentValues.put(MEDEWERKER_KOLOM_TELEFOONNUMMER, medewerkerinfo.getTelefoonnumer());
        contentValues.put(MEDEWERKER_KOLOM_FOTO, medewerkerinfo.getFoto());
        contentValues.put(MEDEWERKER_KOLOM_CREDITS_BESTEDEN, medewerkerinfo.getCreditaantal());

        Log.d(TAG, "insert medewerker: " + medewerkerinfo.getGebruikersnaam());

        db.insert(MEDEWERKER_TABEL_NAAM, null, contentValues);
        close();


    }

    public Medewerkerinfo geefMedewerker(String gebruikersnaam){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + MEDEWERKER_TABEL_NAAM + " WHERE " + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + " = '" + gebruikersnaam + "';" , null);
        res.moveToFirst();

        Medewerkerinfo medewerkerinfo = new Medewerkerinfo();

        medewerkerinfo.setGebruikersnaam(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_GEBRUIKERSNAAM)));
        medewerkerinfo.setWachtwoord(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_WACHTWOORD)));
        medewerkerinfo.setBedrijf(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_BEDRIJF)));
        medewerkerinfo.setCreditaantal(res.getInt(res.getColumnIndex(MEDEWERKER_KOLOM_CREDITS_BESTEDEN)));
        medewerkerinfo.setFoto(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_FOTO)));
        medewerkerinfo.setNaam(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_NAAM)));
        medewerkerinfo.setTelefoonnumer(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_TELEFOONNUMMER)));
        medewerkerinfo.setWoonplaats(res.getString(res.getColumnIndex(MEDEWERKER_KOLOM_WOONPLAATS)));

        close();
        return medewerkerinfo;

    }

    public void insertBedrijf(BedrijfRang bedrijfRang){

        Log.d(TAG, "insertBedrijf: aangeroepen");

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BEDRIJFRANG_KOLOM_BEDRIJFSNAAM, bedrijfRang.getBedrijfsnaam());
        contentValues.put(BEDRIJFRANG_KOLOM_CREDITAANTAL, bedrijfRang.getCreditaantal());
        contentValues.put(BEDRIJFRANG_KOLOM_PLAATS, bedrijfRang.getPlaats());


        Log.d(TAG, "insert bedrijf: " + bedrijfRang.getBedrijfsnaam());

        db.insert(BEDRIJFRANG_TABEL_NAAM, null, contentValues);
        close();


    }

    public void updateCreditTeBesteden(int creditaantal, String gebruikersnaam){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + MEDEWERKER_TABEL_NAAM + " SET " + MEDEWERKER_KOLOM_CREDITS_BESTEDEN + " = " + creditaantal + " WHERE " + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + " = '" + gebruikersnaam + "';";

        db.execSQL(query);
        close();

    }

    public void insertRit(RitInfo ritInfo){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RITINFO_KOLOM_DATUM, ritInfo.getDatum());
        contentValues.put(RITINFO_KOLOM_EINDBESTEMMING, ritInfo.getEindbestmming());
        contentValues.put(RITINFO_KOLOM_OPSTAPPLAATS, ritInfo.getOpstapplaats());
        contentValues.put(RITINFO_KOLOM_STARTTIJD, ritInfo.getTijdHeen());
        contentValues.put(RITINFO_KOLOM_TIJD_TERUGRIJDEN, ritInfo.getTijdTerug());
        contentValues.put(RITINFO_KOLOM_DATUM, ritInfo.getDatum());
        contentValues.put(RITINFO_KOLOM_OPEN_PLAATSEN, ritInfo.getVrijePlaatsen());
        contentValues.put(RITINFO_KOLOM_QRCODE, "nee");
        contentValues.put(RITINFO_KOLOM_GEBRUIKERSNAAM, "bleh1234");
        contentValues.put(RITINFO_KOLOM_STATUS, "verhinderd");
        contentValues.put(RITINFO_KOLOM_KENTEKEN, "12-345-67");


        try {
            db.insert(RITINFO_TABEL_NAAM, null, contentValues);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        close();
    }

    public void insertAanmelding(RitAanmelding aanmelding){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(AANMELDING_KOLOM_DATUM, aanmelding.getDatum() );
        contentValues.put(AANMELDING_KOLOM_GEBRUIKERSNAAM, aanmelding.getGebruikersnaam());
        switch (aanmelding.getCarpoolcategorie()){
            case BACKUP_BESTUUDER:
                contentValues.put(AANMELDING_KOLOM_CARPOOLCATEGORIE, "Back up");
                break;
            case MEERIJDER:
                contentValues.put(AANMELDING_KOLOM_CARPOOLCATEGORIE, "meerijder");
                break;
            case BESTUUDER:
                contentValues.put(AANMELDING_KOLOM_CARPOOLCATEGORIE, "bestuuder");
                break;
        }
        db.insert(AANMELDING_TABEL_NAAM, null, contentValues);
    }




}
