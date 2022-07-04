package model;

public class Adresse {
    /**
     * Variable für Klasse Adresse
     */

    private int hausNr;
    private int plz;
    private String stadt;
    private String herkunft;
    private String strasse;
    /**
     * Construktor
      * @param kundenHausNr
     * @param kundenPlz
     * @param kundenStadt
     */
    public Adresse(int kundenHausNr, int kundenPlz, String kundenStadt,String strasse) {
        this.hausNr = kundenHausNr;
        this.plz = kundenPlz;
        this.stadt = kundenStadt;
         this.strasse = strasse;
    }

    /**
     * Getter und Setter für Klass Adresse
     * @return
     */
    public int getHausNr() {
        return hausNr;
    }

    public void setHausNr(int hausNr) {
        this.hausNr = hausNr;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getHerkunft() {
        return herkunft;
    }

    public void setHerkunft(String herkunft) {
        this.herkunft = herkunft;
    }
}
