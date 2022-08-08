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


}

