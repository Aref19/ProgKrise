package Domain;

import model.Artikel;

import java.util.ArrayList;

public class ArtikelVerwaltung {

    private ArrayList <Artikel> artikelList = new ArrayList<>();

    public void artikelAnlegen(Artikel newArtikel){ //Artikelerschaffen
        artikelList.add(newArtikel);
    }
    public void artikelLoeschen(){

    }

    public ArrayList<Artikel> getArtikelList() {
        return artikelList;
    }

    public void changePreis(int newPreis){

    }


}
