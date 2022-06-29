package Domain;

import Persistent.SaveService;
import Persistent.repo.SaveRepo;
import exception.BestandNichtAusreichendException;
import exception.NotFoundException;
import model.Artikel;

import java.util.*;

public class ArtikelVerwaltung  {

    /**
     * Arraylist für Artikel
     */
    private ArrayList<Artikel> artikelList ;
    HashMap<String,Integer> buchstaben;
    private SaveRepo saveRepo;
    public ArtikelVerwaltung(){
        buchstaben=new HashMap<>();
        setBoc(buchstaben);
        artikelList=new ArrayList<>();
        artikelList.add(new Artikel(2,"Apfhel",7,2.5));
        artikelList.add(new Artikel(3,"Zizrone",6,2.5));
        artikelList.add(new Artikel(1,"Banana",4,2.5));
        artikelList.add(new Artikel(4,"Orang",5,2.5));
        saveRepo= new SaveService();

    }

    /**
     * Methode um eine Artikel an zu legen und in der Arraylist zu speichern.
     * @param artikelNr
     * @param artikelBestand
     * @param artikelBezeichnung
     */

    public void artikelAnlegen(int artikelNr, int artikelBestand, String artikelBezeichnung) throws Exception { //Artikelerschaffen
        Artikel artikel = new Artikel(artikelNr, artikelBezeichnung, artikelBestand,2.4);
        artikelList.add(artikel);
        saveRepo.openForReading(SaveService.nameFIleArtikel);
        saveRepo.saveArtikel(new Artikel(1,"dsa",2,2.5));
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
    private void setBoc(HashMap<String,Integer> boc){
        boc.put("A",1);
        boc.put("B",2);
        boc.put("C",3);
        boc.put("D",4);
        boc.put("E",5);
        boc.put("F",6);
        boc.put("G",7);
        boc.put("H",8);
        boc.put("I",9);
        boc.put("J",10);
        boc.put("K",11);
        boc.put("L",12);
        boc.put("M",13);
        boc.put("N",14);
        boc.put("O",15);
        boc.put("P",16);
        boc.put("Q",17);
        boc.put("R",18);
        boc.put("S",19);
        boc.put("T",20);
        boc.put("Y",21);
        boc.put("Z",22);
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
}
