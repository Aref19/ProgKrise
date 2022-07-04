package Domain;

import Persistent.PersistentMitarbeiter;
import exception.CustomIoException;
import exception.INcorrectEmailException;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MitarbeiterVerwaltung{
    /**
     * Eine Arraylist für Mitarbeiter.
     */
    private List<Mitarbeiter> mitarbeiterList;
    private PersistentMitarbeiter persistentMitarbeiter = new PersistentMitarbeiter();


    public MitarbeiterVerwaltung() {
        mitarbeiterList=new ArrayList<>();
        try {
            mitarbeiterList = persistentMitarbeiter.mitarbeiterList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Beim Methode Mitarbeiter Anlegen wird Mitarbeiter angelegt und durch
     * For Schleife wird in der Liste gesucht ob der Mitarbeiter Vorname und Nummer bereits vergeben ist dann wird
     * Exception geworfen sonst wird der Mitarbeiter in der Liste hinzugefügt.
     * @param name, nachname, passwort
     * @throws CustomIoException
     */

    public void mitarbeiterAnlegen(String name, String nachname, String passwort,String email) throws RegisitierungException{
            for (Mitarbeiter listAusgeben : mitarbeiterList) {
                if (name.equals(listAusgeben.getVorName())
                        && nachname.equals(listAusgeben.getNachName())) {

                    throw new RegisitierungException("Diese Kombination von Namen und Nachnamen esistiert Bereits schon");
                }
            }

        Mitarbeiter mitarbeiter = new Mitarbeiter( name, nachname, passwort,email);
        mitarbeiterList.add(mitarbeiter);

        persistentMitarbeiter.mitarbeiterSpeichern(mitarbeiterList);

    }

    /**
     * Beim Mitarbeiter Überprüfen Methode wird mit arbeiter überprüft Ob der Mitarbeiter Name und Sein Passwort
     * mit der Liste zustimmt dann wird er ein gelogt
     * @param email
     * @param mitarbeiterPasswort
     * @return
     * @throws CustomIoException
     */
    public MItarbeiterEilogen mitarbeiterUeberprufen(String email, String mitarbeiterPasswort) throws LoginFailedException{
        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            if (email.equals(mitarbeiter.getEmail()) && mitarbeiterPasswort.equals(mitarbeiter.getPasswort())) {
                return new MItarbeiterEilogen(mitarbeiter,true);
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

        persistentMitarbeiter.mitarbeiterSpeichern(mitarbeiterList);
    }
    public List<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }


}

