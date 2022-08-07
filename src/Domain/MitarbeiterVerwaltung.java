package Domain;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import exception.CustomIoException;
import exception.EmailExisted;
import exception.LoginFailedException;
import exception.RegisitierungException;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MitarbeiterVerwaltung {
    /**
     * Eine Arraylist für Mitarbeiter.
     */
    private List<Mitarbeiter> mitarbeiterList;
    private SaveRepo saveRepo;
    private String filename = "mitarbeiter.txt";


    public MitarbeiterVerwaltung() {
        mitarbeiterList = new ArrayList<>();
        saveRepo = new SaveFile();
        saveRepo.creatFile(filename);
        try {
            saveRepo.openForRead(filename);
            mitarbeiterList = saveRepo.loadMitarbeiter();
            saveRepo.closRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Beim Methode Mitarbeiter Anlegen wird Mitarbeiter angelegt und durch
     * For Schleife wird in der Liste gesucht ob der Mitarbeiter Vorname und Nummer bereits vergeben ist dann wird
     * Exception geworfen sonst wird der Mitarbeiter in der Liste hinzugefügt.
     *
     * @param name, nachname, passwort
     * @throws CustomIoException
     */

    public void mitarbeiterAnlegen(String name, String nachname, String passwort, String email) throws RegisitierungException, IOException,EmailExisted {
        for (Mitarbeiter listAusgeben : mitarbeiterList) {
            if (email.equals(listAusgeben.getEmail())) {
                throw new EmailExisted();
            }
        }

        Mitarbeiter mitarbeiter = new Mitarbeiter(name, nachname, passwort, email);
        System.out.println("id Mit :"+mitarbeiter.getId());
        mitarbeiterList.add(mitarbeiter);

        saveMitarbeiter();

    }

    /**
     * Beim Mitarbeiter Überprüfen Methode wird mit arbeiter überprüft Ob der Mitarbeiter Name und Sein Passwort
     * mit der Liste zustimmt dann wird er ein gelogt
     *
     * @param email
     * @param mitarbeiterPasswort
     * @return
     * @throws CustomIoException
     */
    public Einlogen mitarbeiterUeberprufen(String email, String mitarbeiterPasswort) throws LoginFailedException {
        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            if (email.equals(mitarbeiter.getEmail()) && mitarbeiterPasswort.equals(mitarbeiter.getPasswort())) {
                return new Einlogen(mitarbeiter, true);
            }
        }
        throw new LoginFailedException();
    }

    private void saveMitarbeiter() throws IOException {
        saveRepo.openForWrite(filename);
        saveRepo.mitarbeiterSpeichern(mitarbeiterList);
        saveRepo.closeWrite();
    }

    public List<Mitarbeiter> getMitarbeiterList(){
        try {
            loadMitarbeiter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mitarbeiterList;
    }

    private void loadMitarbeiter() throws IOException {
        saveRepo.openForRead(filename);
        mitarbeiterList = saveRepo.loadMitarbeiter();
        saveRepo.closRead();
    }


}

