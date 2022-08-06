package model;

public class Massengutartikel extends Artikel {

    private int masse;

    public Massengutartikel(int artikelNr, String artikelBezeichnung, int artikelBestand, double preis, int masse) {
        super(artikelNr, artikelBezeichnung, artikelBestand, preis);
        this.masse = masse;
    }

    public Massengutartikel(String artikelBezeichnung, int artikelBestand, double preis, int masse) {
        super(artikelBezeichnung, artikelBestand, preis);
        this.masse = masse;
    }

    public int getMasse() {
        return masse;
    }

    public void setMasse(int masse) {
        this.masse = masse;
    }

    @Override
    public String toSaveInFile() {
        return super.toSaveInFile() + ";" + masse;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + masse;
    }
}
