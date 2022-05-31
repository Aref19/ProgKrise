package model;
import model.Adresse;

public class Kunden extends Person {

    /**
     * Klasse Kunden erweitert Person.
     */
    private Adresse adresse;

    /**
     * Constructor
     * @param kundenNr
     * @param kundenVorname
     * @param nachName
     * @param adresse
     * @param passwort
     */
    public Kunden(int kundenNr, String kundenVorname, String nachName, Adresse adresse, String passwort){
        super(kundenNr, kundenVorname, nachName, passwort);
        this.adresse=adresse;
    }

    /**
     * Getter und Setter
     * @return
     */
    public int getKundenHausNr() {
        return adresse.getHausNr() ;
    }

    public void setKundenHausNr(int kundenHausNr) {
        this.adresse.setHausNr(kundenHausNr);
    }

    public int getKundenPlz() {
        return this.adresse.getPlz();
    }
    public void setKundenPlz(int kundenPlz){
        this.adresse.setPlz(kundenPlz);
    }
}
