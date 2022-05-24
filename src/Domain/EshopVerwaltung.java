package Domain;

import exception.CustomIoException;
import exception.ExistenceName;
import exception.NotFoundEx;
import model.Artikel;
import model.Ereigniss;
import model.Kunden;
import model.Mitarbeiter;

import java.util.ArrayList;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundenVerwaltung kundenVerwaltung;
    private WarenKorpVerw warenKorbVerwaltung;
    private Kunden kunden;
    MitarbeiterVerwaltung mitarbeiterVerwaltung;
    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundenVerwaltung = new KundenVerwaltung();
        warenKorbVerwaltung=new WarenKorpVerw();
         mitarbeiterVerwaltung=new MitarbeiterVerwaltung();

    }

    public void artikelSortieren() {
        ArrayList<Artikel> artikels = artikelVerwaltung.artikelSortieren(false);
        for (Artikel artikel : artikels) {
            System.out.println(artikel.toString());
        }

    }

    public void kundRegistieren(Kunden kunden)  {
        try {
            kundenVerwaltung.registieren(kunden);
        } catch (ExistenceName e) {
            e.prinEror();

        }
    }

    public boolean kundAnlogen(String na,String pas) {
        try {
            if(kundenVerwaltung.einlogen(na,pas).gefunden){
                kunden=kundenVerwaltung.einlogen(na,pas).kunden;
                return true;
            }else
                return false;
        }catch (NotFoundEx notFoundEx){
            //ToDo Eror anmelden
        }
       return false;
    }

    public void kaufen(){
        warenKorbVerwaltung.kaufen(kunden);
    }

    public void warenlegen(Artikel artikel){
        warenKorbVerwaltung.addArtikel(artikel);

    }

    public void mitarbeiterRe(Mitarbeiter mitarbeiter) throws CustomIoException {
        mitarbeiterVerwaltung.mitarbeiterAnlegen(mitarbeiter);
    }

    public boolean mitarbeiterEilogen(String na, String pa) throws CustomIoException {
      return  mitarbeiterVerwaltung.mitarbeiterUeberprufen(na,pa);
    }

    public Ereigniss eilage(Artikel artikel){
       return mitarbeiterVerwaltung.mitarbeiterEinlagerung(artikel );
    }
    public void mitarbeiteranthorReg(Mitarbeiter mitarbeiter) throws CustomIoException {
        mitarbeiterVerwaltung.mitarbeiterAnlegen(mitarbeiter);
    }
    public Ereigniss ergnissKund(Artikel artikel ){
     return    kundenVerwaltung.artikelAuslagern(artikel);
    }



}
