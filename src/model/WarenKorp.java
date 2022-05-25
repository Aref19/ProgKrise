package model;

import exception.NotFoundEx;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;

public  class WarenKorp {
    private HashMap<Artikel,Integer> warenList;
    static WarenKorp waren;
    public WarenKorp() {
        this.warenList = new HashMap<>();
    }


    public void addArtikle(Artikel artikel,int anzahl) {
        this.warenList.put(artikel,anzahl);
    }

    public void loschArtikle(Artikel artikel) throws NotFoundEx {
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
}
