package model;
import model.Adresse;

public class Kunden extends Person {
    private Adresse adresse;

    public Kunden(int kundenNr, String kundenVorname, String nachName, Adresse adresse){
        super(kundenNr, kundenVorname, nachName);
        this.adresse=adresse;
    }

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
