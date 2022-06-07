package model;

import java.time.Instant;

public class Ereigniss {
    Object object;
    Artikel artikel;
    Instant Datum;
   public enum staus{
        Auslagerung, Einlagerung
    }
    public Ereigniss(Object object, Artikel artikel, Instant datum, staus lagerung) {
        this.object = object;
        this.artikel = artikel;
        Datum = datum;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Instant getDatum() {
        return Datum;
    }

    public void setDatum(Instant datum) {
        Datum = datum;
    }

    @Override
    public String toString(){
        if(object instanceof Mitarbeiter){
            System.out.println("Erginness :");
            return " Danke Herr :"+((Mitarbeiter) object).getNachName()+"\nfur Eilagerung :\n"+artikel+"\n datum :"+Datum;
        }else {
            return artikel.toString()+" Danke Herr für Einkauf : "+((Kunde) object).getNachName();
        }
    }
}
