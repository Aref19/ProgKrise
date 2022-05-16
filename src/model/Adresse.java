package model;

public class Adresse {


    private int hausNr;
    private int plz;
    private String stadt;
    private String herkunft;


    public Adresse(int kundenHausNr, int kundenPlz, String kundenStadt, String kundenHerkunft) {
        this.hausNr = kundenHausNr;
        this.plz = kundenPlz;
        this.stadt = kundenStadt;
        this.herkunft = kundenHerkunft;
    }

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
