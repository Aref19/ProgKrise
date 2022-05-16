package Domain;

import model.Artikel;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundenVerwaltung kundenVerwaltung;

    public EshopVerwaltung(){
        artikelVerwaltung=new ArtikelVerwaltung();
        kundenVerwaltung=new KundenVerwaltung();
    }

    public void artikelanLegen(Artikel artikel){
        artikelVerwaltung.artikelAnlegen(artikel);
    }



}
