package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rechnung {
    private Instant instant;
    private Kunden kunden;
    private HashMap<Artikel,Integer> artikels;
    public Rechnung(Kunden kunden,HashMap<Artikel,Integer> artikels){
        this.artikels=artikels;
        this.kunden=kunden;
        this.instant=Instant.now();
    }
    public Instant getInstant() {
        return instant;
    }

    public Kunden getKunden() {
        return kunden;
    }

    public HashMap<Artikel,Integer> getArtikels() {
        return this.artikels;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setKunden(Kunden kunden) {
        this.kunden = kunden;
    }

    public void setArtikels(HashMap<Artikel,Integer> artikels) {
        this.artikels = artikels;
    }
    public String toString() {
        String gelekteWaren = "Kund :"+kunden.toString()+"\tDatum :"+this.instant;
        for (Map.Entry<Artikel,Integer>artikelIntegerEntry :artikels.entrySet()) {
            gelekteWaren+=artikelIntegerEntry.getKey().getArtikelBezeichnung() +" Anzahl : "+artikelIntegerEntry.getValue();
        }
        return  gelekteWaren;
    }
}
