package Domain;

import Persistent.PersistentMitarbeiter;
import exception.CustomIoException;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.Artikel;
import model.Ereignis;
import model.Mitarbeiter;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MitarbeiterVerwaltung{
    /**
     * Eine Arraylist für Mitarbeiter.
     */
    ArrayList<Mitarbeiter> mitarbeiterList;
    PersistentMitarbeiter persistentMitarbeiter = new PersistentMitarbeiter();
    public MitarbeiterVerwaltung(){
        mitarbeiterList=new ArrayList<>();
    }
    /**
     * Beim Methode Mitarbeiter Anlegen wird Mitarbeiter angelegt und durch
     * For Schleife wird in der Liste gesucht ob der Mitarbeiter Vorname und Nummer bereits vergeben ist dann wird
     * Exception geworfen sonst wird der Mitarbeiter in der Liste hinzugefügt.
     * @param name, nachname, passwort
     * @throws CustomIoException
     */
    public void mitarbeiterAnlegen(String name, String nachname, String passwort) throws RegisitierungException {
        try {

            for (Mitarbeiter listAusgeben : mitarbeiterList) {
                if (name.equals(listAusgeben.getVorName())
                        && nachname.equals(listAusgeben.getNachName())) {
                }
            }

        Mitarbeiter mitarbeiter = new Mitarbeiter(1, name, nachname, passwort);
        mitarbeiterList.add(mitarbeiter);
        persistentMitarbeiter.mitarbeiterSpeichern(mitarbeiter);
        } finally {
            throw new RegisitierungException("Diese Kombination von Namen und Nachnamen esistiert Bereits schon");
        }
    }


    /**
     * Beim Mitarbeiter Überprüfen Methode wird mit arbeiter überprüft Ob der Mitarbeiter Name und Sein Passwort
     * mit der Liste zustimmt dann wird er ein gelogt
     * @param name
     * @param mitarbeiterPasswort
     * @return
     * @throws CustomIoException
     */
    public boolean mitarbeiterUeberprufen(String name, String mitarbeiterPasswort) throws LoginFailedException {
        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            if (name.equals(mitarbeiter.getVorName()) && mitarbeiterPasswort.equals(mitarbeiter.getPasswort())) {
                return true;
            }
        }
       throw new LoginFailedException();
    }

    public void mitarbeiterLoeaschen(String vorname, String nachname) {
        for (Mitarbeiter mitarbeiterLoeschen : mitarbeiterList) {
            if (vorname.equals(mitarbeiterLoeschen.getVorName()) && nachname.equals(mitarbeiterLoeschen.getNachName())) {
                mitarbeiterList.remove(mitarbeiterLoeschen);
            }
        }
    }
    public ArrayList<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }

    public void liesDaten(){

    }
}

