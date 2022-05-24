package model;

import java.util.ArrayList;

public class Warenkorb {
    private ArrayList<Artikel> waren;

    public Warenkorb() {
        waren = new ArrayList<>();
    }

    public void setWaren(ArrayList<Artikel> waren) {
        this.waren = waren;
    }

    public ArrayList<Artikel> getWaren() {
        return waren;
    }




}
