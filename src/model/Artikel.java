package model;

import java.util.Random;
import java.util.UUID;;
import  java.util.concurrent.atomic.*;
public class Artikel {
    /**
     * @author AJ
     * Klasse zu einzelne Artikel
     */
    private UUID artikelNr;
    private String artikelBezeichnung;
    private int artikelBestand;
    private double preis;

    /**
     * Konstruktur
     * Um Artikel zu überzeugen
     *

     * @param artikelBezeichnung
     * @param artikelBestand
     */
    public Artikel( String artikelBezeichnung, int artikelBestand,double preis) {
        this.artikelNr = UUID.randomUUID();
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelBestand = artikelBestand;
        this.preis=preis;
    }
    public Artikel( UUID artikelNr,String artikelBezeichnung, int artikelBestand,double preis) {
        this.artikelNr = artikelNr;
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelBestand = artikelBestand;
        this.preis=preis;
    }

    /**
     * Getter und Setter um den Artikel zurückzugeben und es zu überschreiben, wenn es neue Artikel kommt oder rausgeht.
     *
     * @return
     */
    public UUID getArtikelNr() {return artikelNr;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setArtikelNr(UUID artikelNr) {
        this.artikelNr = artikelNr;
    }

    public String getArtikelBezeichnung() {
        return artikelBezeichnung;
    }

    public void setArtikelBezeichnung(String artikelBezeichnung) {
        this.artikelBezeichnung = artikelBezeichnung;
    }

    public int getArtikelBestand() {
        return artikelBestand;
    }

    public void setArtikelBestand(int artikelBestand) {
        this.artikelBestand = artikelBestand;
    }



    /**
     * Default String zu überschreiben. danit es keine hash Code vom id gibt.
     * @return
     */


    public String toSaveInFile() {
        return artikelNr+";"+artikelBezeichnung+";"+artikelBestand+";"+preis;

    }

    @Override
    public String toString() {
        return artikelBezeichnung+"  "+artikelBestand+"   "+preis;
    }
}
