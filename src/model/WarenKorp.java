package model;

import exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarenKorp {


    private HashMap<Artikel, Integer> warenList;
    private String email;
    private String nameArtikel;
    private double gesamtPreis;
    private int anzahl;
    public WarenKorp() {
        this.warenList = new HashMap<>();
    }

    public WarenKorp(String email, String nameArtikel, double gesamtPreis, int anzahl) {
        this.email = email;
        this.nameArtikel = nameArtikel;
        this.gesamtPreis = gesamtPreis;
        this.anzahl = anzahl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameArtikel() {
        return nameArtikel;
    }

    public void setNameArtikel(String nameArtikel) {
        this.nameArtikel = nameArtikel;
    }

    public double getGesamtPreis() {
        return gesamtPreis;
    }

    public void setGesamtPreis(double gesamtPreis) {
        this.gesamtPreis = gesamtPreis;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void addArtikle(Artikel artikel, int anzahl) {
        // TODO: Wenn Artikel schon im WK, dann Anzahl erhöhen
        if (this.warenList.containsKey(artikel)) {
            int erhohteWert = this.warenList.get(artikel) + anzahl;
            this.warenList.put(artikel, erhohteWert);
        } else {
            this.warenList.put(artikel, anzahl);
        }

    }

    public void loschArtikle(Artikel artikel) throws NotFoundException {
        warenList.remove(artikel);
    }

    public HashMap<Artikel, Integer> get() {
        return this.warenList;
    }


    public void removeAll() {
        this.warenList.clear();
    }

    public String toString() {
        return email+";"+nameArtikel+";"+gesamtPreis+";"+anzahl;
        //   return gelekteWaren;
    }

    public List<Artikel> hashtoList() {
        List<Artikel> ereignisList = new ArrayList<>();
        for (Map.Entry<Artikel, Integer> artikelIntegerEntry : warenList.entrySet()) {
            ereignisList.add(artikelIntegerEntry.getKey());
        }
        return ereignisList;
    }
}
