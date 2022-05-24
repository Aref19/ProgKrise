package Domain;

import exception.CustomIoException;
import model.Artikel;
import model.Ereigniss;
import model.Mitarbeiter;

import java.time.Instant;
import java.util.ArrayList;

public class MitarbeiterVerwaltung{
    /**
     * Eine Arraylist für Mitarbeiter.
     */
    ArrayList<Mitarbeiter> mitarbeiterList = new ArrayList<>();
    Mitarbeiter mitarbeiterIstEingelogt;
    /**
     * Beim Methode Mitarbeiter Anlegen wird Mitarbeiter angelegt und durch
     * For Schleife wird in der Liste gesucht ob der Mitarbeiter Vorname und Nummer bereits vergeben ist dann wird
     * Exception geworfen sonst wird der Mitarbeiter in der Liste hinzugefügt.
     * @param mitarbeiter
     * @throws CustomIoException
     */
    public void mitarbeiterAnlegen(Mitarbeiter mitarbeiter) throws CustomIoException {
        CustomIoException a = new CustomIoException();
        for (Mitarbeiter listAusgeben : mitarbeiterList) {
            if (mitarbeiter.getVorName().equals(listAusgeben.getVorName()) && mitarbeiter.getNummer() == (listAusgeben.getNummer())) {
                a.getMessage3();
            }
            System.out.println("Die Liste ist " + listAusgeben.getVorName());
        }
        mitarbeiterList.add(mitarbeiter);
    }

    /**
     * Beim Mitarbeiter Überprüfen Methode wird mit arbeiter überprüft Ob der Mitarbeiter Name und Sein Passwort
     * mit der Liste zustimmt dann wird er ein gelogt
     * @param name
     * @param mitarbeiterPasswort
     * @return
     * @throws CustomIoException
     */
    public boolean mitarbeiterUeberprufen(String name, String mitarbeiterPasswort) throws CustomIoException {
        CustomIoException a = new CustomIoException();
        try {
            for (Mitarbeiter mitarbeiter : mitarbeiterList) {
                if (name.equals(mitarbeiter.getVorName()) && mitarbeiterPasswort.equals(mitarbeiter.getPasswort())) {
                    mitarbeiterIstEingelogt = mitarbeiter;
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(a.getMessage2());
        }
        return false;
    }

    public void mitarbeiterLoeaschen(String vorname, String nachname) {
        for (Mitarbeiter mitarbeiterLoeschen : mitarbeiterList) {
            if (vorname.equals(mitarbeiterLoeschen.getVorName()) && nachname.equals(mitarbeiterLoeschen.getNachName())) {
                mitarbeiterList.remove(mitarbeiterLoeschen);
            }
        }
    }

    public Ereigniss mitarbeiterEinlagerung(Artikel artikel ){

        return new Ereigniss(mitarbeiterIstEingelogt, artikel, Instant.now());
    }
    public ArrayList<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;

    }

}

