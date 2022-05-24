package Domain;

import model.Artikel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ArtikelVerwaltung  {

    /**
     * Arraylist für Artikel
     */
    private ArrayList<Artikel> artikelList = new ArrayList<>();

    /**
     * Methode um eine Artikel an zu legen und in der Arraylist zu speichern.
     * @param artikelNr
     * @param artikelBestand
     * @param artikelBezeichnung
     */

    public void artikelAnlegen(int artikelNr, int artikelBestand, String artikelBezeichnung) { //Artikelerschaffen
        Artikel artikel = new Artikel(artikelNr, artikelBezeichnung, artikelBestand,2.4);
        artikelList.add(artikel);


    }

    /**
     * Methode ArtikelLöschen entfernt artikel von der Artikel Liste
     * @param artikel
     * @return
     */
    public boolean artikelLoeschen(Artikel artikel) {
        return artikelList.remove(artikel);
    }

    /**
     * Es wird Artikel gesucht nach ihrer Bezeichnung und wird Arraylist zurückgegeben.
     * @param artikelBezeichnung
     * @return
     */
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

    /**
     * Beim ArtikelBestandErhöhen Methode wird nur den Bestand erhöht durch ausgleich vom Artikel Nr.
     * Diese Methode gibt es keine Werte zurück, erkennt man auch durch Void.
     * @param artikelNr
     * @param artikelBestand
     */
    public void artikelBestandErhohen(int artikelNr, int artikelBestand) {
        for (Artikel artikel : artikelList) {
            if (artikel.getArtikelNr() == artikelNr)
                artikel.setArtikelBestand(artikelBestand);
        }
    }

    /**
     * Die ArrayList wird wieder zurückgegeben.
     * @return
     */
    public ArrayList<Artikel> getArtikelList() {
        return artikelList;
    }

    public ArrayList<Artikel> artikelSortieren(Boolean sort){
        ArrayList<Artikel> sortertlist = new ArrayList<>(artikelList);
        if(sort){
            Collections.sort(sortertlist, new Comparator<Artikel>() {
                @Override
                public int compare(Artikel o1, Artikel o2) {
                    return Integer.valueOf(o1.getArtikelNr()).compareTo(o2.getArtikelNr());
                }
            });
        }else {
            Collections.sort(sortertlist, new Comparator<Artikel>() {
                @Override
                public int compare(Artikel o1, Artikel o2) {
                    return Integer.valueOf(o1.getArtikelBezeichnung().length()).compareTo(o2.getArtikelBezeichnung().length());
                }
            });
        }
         return sortertlist;
    }


}
