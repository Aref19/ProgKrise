package model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class Rechnung {
    private Instant instant;
    private Kunde kunde;
    private HashMap<Artikel, Integer> artikels;

    public Rechnung(Kunde kunde, HashMap<Artikel, Integer> artikels) {
        this.artikels = artikels;
        this.kunde = kunde;
        this.instant = Instant.now();
    }

    public Instant getInstant() {
        return instant;
    }

    public Kunde getKunden() {
        return kunde;
    }

    public HashMap<Artikel, Integer> getArtikels() {
        return this.artikels;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setKunden(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setArtikels(HashMap<Artikel, Integer> artikels) {
        this.artikels = artikels;
    }

    public String toString() {
        String gelekteWaren = "\n" + "Kunde:\t" + kunde.getVorName() + "\n" + "Datum :\t" + simpleFormat(Date.from(this.instant));
        Double preis = 0.0;
        for (Map.Entry<Artikel, Integer> artikelIntegerEntry : artikels.entrySet()) {
            gelekteWaren += "\n" + artikelIntegerEntry.getKey().getArtikelBezeichnung() + "\t Anzahl: \t  " + artikelIntegerEntry.getValue();
            preis += artikelIntegerEntry.getValue() * artikelIntegerEntry.getKey().getPreis();
        }
        gelekteWaren += "\n\n" +
                "--------------------------------";
        gelekteWaren += "\npreis \t :" + preis;
        return gelekteWaren;
    }

    private String simpleFormat(Date date){
        SimpleDateFormat simpleFormatter=new SimpleDateFormat("HH:mm dd.MM yyyy");
       return simpleFormatter.format(date);

    }
}
