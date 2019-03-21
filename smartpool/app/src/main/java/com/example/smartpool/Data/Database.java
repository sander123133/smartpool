package com.example.smartpool.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.smartpool.Domain.BeloningWaardeCredit;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();

    private static final String DB_NAME = "smartpoolDB";
    private static final int DB_V = 1;

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
    private static final String RITINFO_KOLOM_OPEN_PLAATSEN = "Open plaatsen";
    private static final String RITINFO_KOLOM_TIJD_TERUGRIJDEN = "Tijd terugrijden";
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
        sqLiteDatabase.execSQL("CREATE TABLE '" + MEDEWERKER_TABEL_NAAM + "' ( `" +
                MEDEWERKER_KOLOM_GEBRUIKERSNAAM + "` TEXT, `" +
                MEDEWERKER_KOLOM_WACHTWOORD + "` TEXT NOT NULL, `" +
                MEDEWERKER_KOLOM_NAAM + "` TEXT NOT NULL, " +
                MEDEWERKER_KOLOM_WOONPLAATS + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_BEDRIJF + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_TELEFOONNUMMER + " INTEGER NOT NULL," +
                MEDEWERKER_KOLOM_FOTO + " TEXT NOT NULL," +
                MEDEWERKER_KOLOM_CREDITS_BESTEDEN + " INTEGER," +
                "PRIMARY KEY(`" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + "`)," +
                "FOREIGN KEY(" + MEDEWERKER_KOLOM_BEDRIJF + ")" +
                "REFERENCES " + BEDRIJFRANG_TABEL_NAAM + "(" + BEDRIJFRANG_KOLOM_BEDRIJFSNAAM + ") )");

        //tabel MedewerkerBeloning
        sqLiteDatabase.execSQL("CREATE TABLE " + MEDEWERKERBELONING_TABEL_NAAM + " ( " +
                MEDEWERKERBELONING_KOLOM_TRANSACTIENMR + " TEXT, " +
                MEDEWERKERBELONING_KOLOM_BELONINGSNAAM + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_WAARDE + " NUMERIC NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_KORTINGSCODE + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM + " TEXT NOT NULL, " +
                MEDEWERKERBELONING_KOLOM_DATUM + " TEXT NOT NULL, " +
                "FOREIGN KEY(" + MEDEWERKERBELONING_KOLOM_GEBRUIKERSNAAM + ") REFERENCES " +
                MEDEWERKER_TABEL_NAAM + "(" + MEDEWERKER_KOLOM_GEBRUIKERSNAAM + "), " +
                "PRIMARY KEY(" + MEDEWERKERBELONING_KOLOM_TRANSACTIENMR + "), " +
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

}