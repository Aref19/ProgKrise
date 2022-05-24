package model;

public class Artikel {
    /**
     * @author AJ
     * Klasse zu einzelne Artikel
     */
    private int artikelNr;
    private String artikelBezeichnung;
    private int artikelBestand;
    private double preis;

    /**
     * Konstruktur
     * Um Artikel zu überzeugen
     *
     * @param artikelNr
     * @param artikelBezeichnung
     * @param artikelBestand
     */
    public Artikel(int artikelNr, String artikelBezeichnung, int artikelBestand,double preis) {
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
    public int getArtikelNr() {return artikelNr;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setArtikelNr(int artikelNr) {
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
    @Override
    public String toString() {
        return String.format("\nArtikel Nr.: %d\nArtikel Bezeichnung: %s\nArtikel Bestand: %d\nPreis :",
                artikelNr,
                artikelBezeichnung,
                artikelBestand,
                preis);
    }
}
