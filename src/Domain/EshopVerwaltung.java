package Domain;

import Persistent.PersistentKunde;
import Persistent.PersistentMitarbeiter;
import exception.*;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundeVerwaltung kundeVerwaltung;
    private MitarbeiterVerwaltung mitarbeiterVerwaltung;
    private RechnungWarenkorb rechnungWarenkorb;
    private PersistentMitarbeiter persistentMitarbeiter;
    private PersistentKunde persistentKunde;
    private EreignisVerwaltung ereignisVerwaltung;

    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundeVerwaltung = new KundeVerwaltung();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWarenkorb = new RechnungWarenkorb();
        persistentMitarbeiter = new PersistentMitarbeiter();
        ereignisVerwaltung = new EreignisVerwaltung();
        persistentKunde = new PersistentKunde();
    }

    public ArrayList<Artikel> artikelSortieren(boolean artsort) {
        return artikelVerwaltung.artikelSortieren(artsort);

    }

    /**
     * Die übertragene Daten von Methode KundeRegistrieren werden hier im KundenRegistrieren über Parameter kunde weiter gegeben.
     * Die daten werden im Methode registrieren verarbeitet.
     *
     * @param kunde
     */
    public void kundenRegistrieren(Kunde kunde) throws RegisitierungException, INcorrectEmailException {
        try {
            Person.checkEmail(kunde.getEmail());
            kundeVerwaltung.registrieren(kunde);
        } catch (RegisitierungException e) {
            throw e;
        } catch (INcorrectEmailException e) {
            throw e;
        }
    }

    public KundeEinlogen kundenEinloggen(String na, String pas) throws LoginFailedException {
        return kundeVerwaltung.einlogen(na, pas);
    }

    public Artikel warenlegen(String name, int anzahl, Kunde kunde) throws BestandNichtAusreichendException, NotFoundException {
        try {
            Artikel artikel = artikelVerwaltung.findArtikel(name);
            artikelVerwaltung.artikelBestandReduzieren(artikel, anzahl);
            kunde.getWarenKorp().addArtikle(artikel, anzahl);


            return artikelVerwaltung.findArtikel(name);
        } catch (NotFoundException e) {
            throw e;

        } catch (BestandNichtAusreichendException e) {
            throw e;
        }
    }

    public boolean mitarbeiterEinloggen(String email, String password) throws LoginFailedException {
        try {
            return mitarbeiterVerwaltung.mitarbeiterUeberprufen(email, password);
        } catch (LoginFailedException e) {
            throw e;
        }
    }

    public void artikelAnlegen(Mitarbeiter mitarbeiter, Artikel artikel) throws IOException {
        System.out.println(artikel);
        try {
            artikelVerwaltung.artikelAnlegen( artikel.getArtikelBestand(), artikel.getArtikelBezeichnung(),artikel.getPreis());
        }catch (IOException e){
            throw e;
        }
        ereignisVerwaltung.fuegeEreignisHinzu(new Ereignis(mitarbeiter, Instant.now(), Ereignis.STATUS.Neu, artikel));
    }

    public void mitarbeiterAnthorRegiseren(String name, String nachname, String passwort, String email) throws RegisitierungException, INcorrectEmailException {
        try {
            Person.checkEmail(email);
            mitarbeiterVerwaltung.mitarbeiterAnlegen(name, nachname, passwort, email);
        } catch (RegisitierungException e) {
            throw e;
        } catch (INcorrectEmailException e) {

            throw e;
        }
    }

    public List<Artikel> artielzeigen() {
        return artikelVerwaltung.getArtikelList();
    }

    public Rechnung getRec(Kunde kunde, HashMap<Artikel, Integer> artikels) {
        for (Map.Entry<Artikel, Integer> artikelIntegerEntry : artikels.entrySet()) {
            ereignisVerwaltung.fuegeEreignisHinzu(new Ereignis(kunde, Instant.now(), Ereignis.STATUS.Kauf, artikelIntegerEntry.getKey()));
        }

        return rechnungWarenkorb.creatRec(kunde, artikels);
    }

}
