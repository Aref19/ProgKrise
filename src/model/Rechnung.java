package model;

import java.time.Instant;
import java.util.ArrayList;

public class Rechnung {
    private Instant instant;
    private Kunden kunden;
    private ArrayList<Artikel> artikels;
    public Rechnung(Instant instant,Kunden kunden,ArrayList<Artikel> artikels){
        this.artikels=artikels;
        this.kunden=kunden;
        this.instant=instant;
    }
    public Instant getInstant() {
        return instant;
    }

    public Kunden getKunden() {
        return kunden;
    }

    public ArrayList<Artikel> getArtikels() {
        return this.artikels;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setKunden(Kunden kunden) {
        this.kunden = kunden;
    }

    public void setArtikels(ArrayList<Artikel> artikels) {
        this.artikels = artikels;
    }
    public String toString() {
        String gelekteWaren = "Kund :"+kunden.toString()+"instanz :"+this.instant;

        for (Artikel artikel : getArtikels()) {
            System.out.println("hallo");
            gelekteWaren += artikel.toString() + "\n";
        }

        return  gelekteWaren;
    }
}
