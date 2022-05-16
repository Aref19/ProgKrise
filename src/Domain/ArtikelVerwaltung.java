package Domain;

import model.Artikel;

import java.util.ArrayList;

public class ArtikelVerwaltung {

    private ArrayList<Artikel> artikelList = new ArrayList<>();


    public void artikelAnlegen(int artikelNr, int artikelBestand, String artikelBezeichnung) { //Artikelerschaffen
        Artikel artikel = new Artikel(artikelNr, artikelBezeichnung, artikelBestand);
        artikelList.add(artikel);

    }

    public boolean artikelLoeschen(Artikel artikel) {
        return artikelList.remove(artikel);
    }

    public ArrayList<Artikel> artikelSuchen(String artikelBezeichnung) {
        ArrayList<Artikel> gefundenArtikelList = new ArrayList<>();
        for (Artikel artikel : artikelList) {
            if (
                    artikel.getArtikelBezeichnung().toLowerCase()
                            .contains(artikelBezeichnung.toLowerCase())
            ) {
                gefundenArtikelList.add(artikel);
            }
        }
        return gefundenArtikelList;
    }

    public void artikelBestandErhohen(int artikelNr, int artikelBestand) {
        for (Artikel artikel : artikelList) {
            if (artikel.getArtikelNr() == artikelNr)
                artikel.setArtikelBestand(artikelBestand);
        }
    }

    public ArrayList<Artikel> getArtikelList() {
        return artikelList;
    }



}
