package model;

import java.time.Instant;
import java.util.List;

public class Ereignis {
    Person person;      // Person


  //  private List<Artikel> artikelList;  // TODO Rausnehmen, nur ein Artikel pro Ereignis
    private Artikel artikel;

    Instant Datum;

    STATUS status;
   public enum STATUS {
        Neu, Auslagerung, Einlagerung, Kauf
    }
//    public Ereignis(Person person, Instant datum, STATUS lagerung, List<Artikel> artikelList) {
//        this.person = person;
//        this.artikelList = artikelList;
//        Datum = datum;
//        this.status = lagerung;
//    }
    public Ereignis(Person person, Instant datum, STATUS status, Artikel artikel) {
        this.person = person;
        this.artikel = artikel;
        Datum = datum;
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public STATUS getStatus() {
        return status;
    }

    public Instant getDatum() {
        return Datum;
    }

//    public List<Artikel> getArtikelList() {
//        return artikelList;
//    }
//
//    public void setArtikelList(List<Artikel> artikelList) {
//        this.artikelList = artikelList;
//    }

    @Override
    public String toString(){
       return "\tDatum\t" + getDatum()
               + (person instanceof Kunde ? "\t Der Kunde:\t" : "\t Der Mitarbeiter:\t") + getPerson().getVorName()
               + "\tStatus" + status;
    }

}
