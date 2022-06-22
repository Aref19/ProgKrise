package Domain;

import exception.ExceptionsName;
import exception.NotFoundEx;

import model.Artikel;
import model.Ereigniss;
import model.KundeEinlogen;
import model.Kunde;


import java.time.Instant;
import java.util.ArrayList;

public class KundeVerwaltung {

    private ArrayList<Kunde> kundeArrayList;

    Kunde kunde;
    public KundeVerwaltung(){
        kundeArrayList = new ArrayList<>();
    }
    public KundeEinlogen einlogen(String na, String pass)throws  NotFoundEx{
        for (Kunde kunde : kundeArrayList) {
            if (kunde.getVorName().equals(na) && kunde.getPassword().equals(pass)) {
                this.kunde = kunde;
                return new KundeEinlogen(kunde,true);
            }
        }
        throw new NotFoundEx("dies ist nicht vorhanden");
    }

    /**
     * Die übertragene daten von methode KundenRegistrieren von EshopVerwaltung werden im methode registrieren verarbeitet.
     * Wird ein Kunde Registriert
     * @param kunde
     * @throws ExceptionsName
     */
    public void registrieren(Kunde kunde) throws ExceptionsName {
        if (kundeArrayList.size() > 0) {
            for (Kunde kund1 : kundeArrayList) {
                if (kund1.getVorName().equals(kunde.getVorName()) && kund1.getNachName().equals(kunde.getNachName())) {
                    throw new ExceptionsName(kund1.getVorName() + "\t ist bereits vorhanden\t" + kund1.getNachName() + "\tist bereits vorhanden" );

                } else {
                    kundeArrayList.add(kunde);
                }
            }
        } else {
            kundeArrayList.add(kunde);
        }
    }

    public Ereigniss artikelAuslagern(Artikel artikel){
        return new Ereigniss(kunde,artikel, Instant.now(), Ereigniss.staus.Auslagerung);
    }


}
