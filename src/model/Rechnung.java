package model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Rechnung {
    private Instant instant;
    private Kunde kunde;
    private HashMap<Artikel,Integer> artikels;
    public Rechnung(Kunde kunde, HashMap<Artikel,Integer> artikels){
        this.artikels=artikels;
        this.kunde = kunde;
        this.instant=Instant.now();
    }
    public Instant getInstant() {
        return instant;
    }

    public Kunde getKunden() {
        return kunde;
    }

    public HashMap<Artikel,Integer> getArtikels() {
        return this.artikels;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setKunden(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setArtikels(HashMap<Artikel,Integer> artikels) {
        this.artikels = artikels;
    }
    public String toString() {
        String gelekteWaren = "Kund :"+ kunde.toString()+"\tDatum :"+this.instant;
        for (Map.Entry<Artikel,Integer>artikelIntegerEntry :artikels.entrySet()) {
            gelekteWaren+=artikelIntegerEntry.getKey().getArtikelBezeichnung() +" Anzahl : "+artikelIntegerEntry.getValue();
        }
        return  gelekteWaren;
    }
}
