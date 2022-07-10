package Domain;




import exception.*;
import model.*;

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

    private EreignisVerwaltung ereignisVerwaltung;

    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundeVerwaltung = new KundeVerwaltung();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWarenkorb = new RechnungWarenkorb();

        ereignisVerwaltung = new EreignisVerwaltung();

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
    public void kundenRegistrieren(Kunde kunde) throws INcorrectEmailException,RegisitierungException {
        Person.checkEmail(kunde.getEmail());
        kundeVerwaltung.registrieren(kunde);
    }

    public Einlogen kundenEinloggen(String na, String pas) throws LoginFailedException {
        return kundeVerwaltung.einlogen(na, pas);
    }

    public void warenlegen(String name, int anzahl, Kunde kunde) throws BestandNichtAusreichendException, NotFoundException {
            Artikel artikel = artikelVerwaltung.findArtikel(name);
            artikelVerwaltung.artikelBestandReduzieren(artikel, anzahl);
            kunde.getWarenKorp().addArtikle(artikel, anzahl);

    }

    public Einlogen mitarbeiterEinloggen(String email, String password) throws LoginFailedException {

            return mitarbeiterVerwaltung.mitarbeiterUeberprufen(email, password);

    }

    public void artikelAnlegen(Mitarbeiter mitarbeiter, Artikel artikel) throws IOException {
        try {
            artikelVerwaltung.artikelAnlegen(artikel.getArtikelBestand(), artikel.getArtikelBezeichnung(), artikel.getPreis());
        } catch (IOException e) {
            throw e;
        }
        ereignisVerwaltung.fuegeEreignisHinzu(new Ereignis(mitarbeiter, Instant.now(), Ereignis.STATUS.Neu, artikel));

    }

    public void mitarbeiterAnthorRegiseren(String name, String nachname, String passwort, String email)
            throws RegisitierungException, INcorrectEmailException, IOException {

        Person.checkEmail(email);
        mitarbeiterVerwaltung.mitarbeiterAnlegen(name, nachname, passwort, email);

    }

    public List<Artikel> artielzeigen() {
        return artikelVerwaltung.getArtikelList();
    }

    public Rechnung getRec(Kunde kunde, HashMap<Artikel, Integer> artikels) throws IOException {
        for (Map.Entry<Artikel, Integer> artikelIntegerEntry : artikels.entrySet()) {
            ereignisVerwaltung.fuegeEreignisHinzu(new Ereignis(kunde, Instant.now(), Ereignis.STATUS.Kauf, artikelIntegerEntry.getKey()));
        }
        return rechnungWarenkorb.creatRec(kunde, artikels);
    }

}
