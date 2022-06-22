package model;

import java.time.Instant;
import java.util.List;

public class Ereignis {
    Person person;      // Person


    private List<Artikel> artikelList;

    Instant Datum;
   public enum STATUS {
        Neu, Auslagerung, Einlagerung, Kauf
    }
    public Ereignis(Person person, Instant datum, STATUS lagerung, List<Artikel> artikelList) {
        this.person = person;
        this.artikelList = artikelList;
        Datum = datum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



    public Instant getDatum() {
        return Datum;
    }

    public void setDatum(Instant datum) {
        Datum = datum;
    }

    public List<Artikel> getArtikelList() {
        return artikelList;
    }

    public void setArtikelList(List<Artikel> artikelList) {
        this.artikelList = artikelList;
    }

    @Override
    public String toString(){
        if(person instanceof Mitarbeiter){
            System.out.println("Erginness :");
            return "\tDatum\t" + getDatum()+ "\t Der Mitarbeiter:\t" + getPerson().getVorName() + "\tStatus" + STATUS.Einlagerung;
        }else {
            return "\tDatum\t" + getDatum()+ "\t Der Kunde:\t" + getPerson().getVorName() + "\tStatus" + STATUS.Auslagerung;

        }
    }

}
