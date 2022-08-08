package Domain;


import Persistent.db.SaveFile;

import Persistent.repo.SaveRepo;
import exception.BestandNichtAusreichendException;
import exception.NotFoundException;
import model.Artikel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ArtikelVerwaltung  {

    /**
     * Arraylist für Artikel
     */

    private List<Artikel> artikelList ;
    SaveRepo saveRepo=new SaveFile();
    final String filename="Artikel.txt";
    public ArtikelVerwaltung()  {
        saveRepo.creatFile(filename);
        saveRepo.openForRead(filename);
        artikelList=saveRepo.loadListloadArtikels();
        saveRepo.closRead();

    }

    /**
     * Methode um eine Artikel an zu legen und in der Arraylist zu speichern.
     * @param artikelBestand
     * @param artikelBezeichnung
     */


    public void artikelAnlegen( int artikelBestand, String artikelBezeichnung,double preis) throws IOException { //Artikelerschaffen
        Artikel artikel = new Artikel(artikelBezeichnung, artikelBestand,preis);

           checkArikel(artikelBezeichnung,artikelBestand);

          saveAtrikel( artikelList);

    }

    private void saveAtrikel(List<Artikel> artikelList) {
        try {
            saveRepo.openForWrite(filename);
            saveRepo.saveArtikel(artikelList);
            saveRepo.closeWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public Artikel findArtikel(String name) throws NotFoundException {
        for (Artikel artikel:artikelList) {
            if (artikel.getArtikelBezeichnung().equals(name)) {
                return artikel;
            }
        }
        throw new NotFoundException("Eingegeben Artikel Existiert leider nicht");
    }
    public void artikelBestand(Artikel artikel, int anzahl){
        for (Artikel artikelSuchen: artikelList) {
            if(artikelSuchen.equals(artikel)){
                artikelSuchen.setArtikelBestand(artikelSuchen.getArtikelBestand() - anzahl);
            }
        }
    }

    private boolean mengeReicht(Artikel artikel, int a) {
        return artikel.getArtikelBestand() >= a ;
    }

    /**
     * Beim ArtikelBestandErhöhen Methode wird nur den Bestand erhöht durch ausgleich vom Artikel Nr.
     * Diese Methode gibt es keine Werte zurück, erkennt man auch durch Void.
     * @param artikelNr
     * @param artikelBestand
     */
 /*   public void artikelBestandErhohen(int artikelNr, int artikelBestand) {
        for (Artikel artikel : artikelList) {
            if (artikel.getArtikelNr() == artikelNr)
                artikel.setArtikelBestand(artikelBestand);
        }
    }*/

    /**
     * Die ArrayList wird wieder zurückgegeben.
     * @return
     */
    public List<Artikel> getArtikelList() {
        return artikelList;
    }

    public ArrayList<Artikel> artikelSortieren(boolean sort){
        ArrayList<Artikel> sortertlist = new ArrayList<>(artikelList);
        if(sort){
            Collections.sort(sortertlist, new Comparator<Artikel>() {
                @Override
                public int compare(Artikel artikel1, Artikel artikel2) {
                    return Integer.valueOf(artikel1.getArtikelNr()).compareTo(artikel2.getArtikelNr());
                }
            });
        }else {
            Collections.sort(sortertlist, new Comparator<Artikel>() {
                @Override
                public int compare(Artikel o1, Artikel o2){
                    return o1.getArtikelBezeichnung().compareTo(o2.getArtikelBezeichnung());
                }

            });
        }
         return sortertlist;
    }


    public void artikelBestandReduzieren(Artikel artikel, int anzahl) throws BestandNichtAusreichendException {
        // TODO Bestand prüfen und - wenn genug - reduzieren (sonst Exception werfen)
        for (Artikel artikelSuchen: artikelList) {
            if(artikelSuchen.equals(artikel)){
                artikelSuchen.setArtikelBestand(artikelSuchen.getArtikelBestand() - anzahl);
                return;
            }
        }
        throw new BestandNichtAusreichendException(artikel);
    }
    private void checkArikel(String name,int anzahl){
        Artikel artikel = null;
        for (Artikel a:artikelList) {
            if (a.getArtikelBezeichnung().equals(name)){
                 artikel=a;

            }
        }
        if(artikel!=null){
            artikelList.remove(artikel);
            artikel.setArtikelBestand(artikel.getArtikelBestand()+anzahl);
            artikelList.add(artikel);
            System.out.println("add");
        }


    }
}
