package model;

public class Artikel {



    /**
     * @author AJ
     *
     * Klasse zu einzelne Artikel
     */

    private int artikelNr;
    private String artikelBezeichnung;
    private int artikelBestand;

    /**
     * Konstruktur
     * Um Artikel zu überzeugen
     * @param artikelNr
     * @param artikelBezeichnung
     * @param artikelBestand
     */
    public Artikel(int artikelNr, String artikelBezeichnung, int artikelBestand ){
        this.artikelNr = artikelNr;
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelBestand = artikelBestand;
    }

    /**
     * Getter und Setter um den Artikel zurück zu geben und es zu überschreiben wenn es neue Artikel kommt oder raus geht.
     * @return
     */

    public int getArtikelNr(){
        return artikelNr;
    }

    public void setArtikelNr(int artikelNr){this.artikelNr = artikelNr;}

    public String getArtikelBezeichnung(){
        return artikelBezeichnung;
    }

    public void setArtikelBezeichnung(String artikelBezeichnung){
        this.artikelBezeichnung = artikelBezeichnung;
    }

    public int getArtikelBestand(){
        return artikelBestand;
    }
    public void setArtikelBestand(int artikelBestand){this.artikelBestand = artikelBestand;}

 }
