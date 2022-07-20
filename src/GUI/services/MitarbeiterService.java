package GUI.services;

import Domain.MitarbeiterVerwaltung;
import exception.LoginFailedException;
import exception.RegisitierungException;

import java.io.IOException;

public class MitarbeiterService {
    MitarbeiterVerwaltung mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
    public boolean anmelden (String email, String password){
        try {
            mitarbeiterVerwaltung.mitarbeiterUeberprufen(email,password);
            return true;
        } catch (LoginFailedException e) {
            return false;
        }
    }
    public boolean registrieren(String name, String nachname, String passwort, String email){
        try {
            mitarbeiterVerwaltung.mitarbeiterAnlegen(name,nachname, passwort, email );
            return true;
        } catch (RegisitierungException | IOException e) {
            return false;
        }
    }
}
