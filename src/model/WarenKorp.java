package model;

import exception.NotFoundEx;

import java.time.Instant;
import java.util.ArrayList;

public class WarenKorp {
    private ArrayList<Artikel> waren;

    public WarenKorp() {
        this.waren = new ArrayList<>();
    }

    public void addArtikle(Artikel artikel) {
        this.waren.add(artikel);
    }

    public void loschArtikle(Artikel artikel) throws NotFoundEx {
        for (Artikel artikel1 : waren) {
            if (artikel.equals(artikel)) {
                this.waren.remove(artikel);
            } else {
                throw new NotFoundEx("dieser Artikel ist nicht vorhanden");
            }

        }

    }

    public ArrayList<Artikel> get() {

        return this.waren;
    }

    public Rechnung kaufen(Kunden kunden) {
        Rechnung rechnung = new Rechnung(Instant.now(), kunden, waren);
        //  removeAll();
        return rechnung;
    }

    public void removeAll() {
        this.waren.clear();
    }

    public String toString() {
        String gelekteWaren = "";
        for (Artikel artikel : waren) {
            gelekteWaren += artikel.getArtikelBezeichnung() + "\n";
        }
        return gelekteWaren;
    }
}
