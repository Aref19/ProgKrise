package model;

import exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarenKorp {


    private HashMap<Artikel, Integer> warenList;

    public WarenKorp() {
        this.warenList = new HashMap<>();
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
        return "";
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
