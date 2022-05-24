package Domain;

import exception.ExistenceName;
import exception.NotFoundEx;
import model.Artikel;
import model.Kunden;

import java.util.ArrayList;
import java.util.Scanner;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundenVerwaltung kundenVerwaltung;
    private WarenKorbVerwaltung warenKorbVerwaltung;
    private Kunden kunden;

    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundenVerwaltung = new KundenVerwaltung();
        warenKorbVerwaltung=new WarenKorbVerwaltung();

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

    public void warenlegen(){
        warenKorbVerwaltung.addArtikel(new Artikel(1,"bana",5,2.5));
        warenKorbVerwaltung.addArtikel(new Artikel(2,"apfel",5,2.5));
    }


}
