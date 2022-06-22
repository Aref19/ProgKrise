package model;

import java.time.Instant;
import java.util.List;

public class Ereignis {
    Person person;      // Person


    Artikel artikel;

    private int  anzahl;

    Instant Datum;
   public enum STATUS {
        Neu, Auslagerung, Einlagerung, Kauf
    }
    public Ereignis(Person person, Instant datum, STATUS lagerung, Artikel artikel, int anzahl) {
        this.person = person;
        this.anzahl = anzahl;
        this.artikel = artikel;
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

    public Artikel getArtikelList() {
        return artikel;
    }

    public void setArtikelList(Artikel artikel) {
        this.artikel = artikel;
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
