package Domain;

import model.Artikel;

import java.util.ArrayList;

public class ArtikelVerwaltung {

    private ArrayList <Artikel> artikelList = new ArrayList<>();

    public void artikelAnlegen(int artikelNr, int artikelBestand, String artikelBezeichnung ){ //Artikelerschaffen
        Artikel artikel = new Artikel( artikelNr, artikelBezeichnung, artikelBestand);
        artikelList.add(artikel);
    }
    public void artikelLoeschen(){

    }

    public ArrayList<Artikel> getArtikelList() {
        return artikelList;
    }
}
