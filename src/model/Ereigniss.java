package model;

import java.time.Instant;

public class Ereigniss {
    Object object;
    Artikel artikel;
    Instant Datum ;

    public Ereigniss(Object object, Artikel artikel, Instant datum) {
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
}
