package Persistent.Domain;

import exception.ExistenceName;
import exception.NotFoundEx;
import model.Artikel;
import model.Kunden;

import java.util.ArrayList;

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
            e.printStackTrace();
        }
    }

    public void kundAnlogen(String na,String pas)  {
        try {
          kunden=kundenVerwaltung.einlogen(na,pas);
        } catch (NotFoundEx e) {
            e.printStackTrace();
        }
    }

    public void kaufen(){
        warenKorbVerwaltung.kaufen(kunden);
    }

    public void warenlegen(){
        warenKorbVerwaltung.addArtikel(new Artikel(1,"bana",5,2.5));
        warenKorbVerwaltung.addArtikel(new Artikel(2,"apfel",5,2.5));
    }


}
