package Domain;

import model.Artikel;

import java.util.ArrayList;

public class WarenkorbVerwaltung {

    private ArtikelVerwaltung kaufartikel = new ArtikelVerwaltung();

    public void artikelKaufen(String artikel){

        this.kaufartikel.artikelSuchen(artikel);

    }
}
