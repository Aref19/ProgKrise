package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Kunde extends Person {

    /**
     * Klasse Kunden erweitert Person.
     */
    private Adresse adresse;
    private WarenKorp warenKorp;



    public Kunde(String kundenVorname, String nachName, Adresse adresse, String pass, String email){
        super(kundenVorname, nachName,pass,email);
        this.adresse=adresse;
        this.warenKorp=new WarenKorp();
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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

    public void setWarenKorp(WarenKorp warenKorp){
        this.warenKorp=warenKorp;
    }

    public WarenKorp getWarenKorp(){
        return this.warenKorp;
    }

    @Override
    public String toString() {
        return this.getVorName() +";"+this.getNachName()+";"+this.adresse.toString()+";"+this.getPassword()+";"+this.getEmail();
    }
}

