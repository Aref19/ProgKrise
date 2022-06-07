package Domain;

import Persistent.Persistent;
import exception.CustomIoException;
import exception.ExceptionsName;
import exception.NotFoundEx;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundeVerwaltung kundeVerwaltung;
    private WarenKorpVerw warenKorbVerwaltung;
    private MitarbeiterVerwaltung mitarbeiterVerwaltung;
    private RechnungWerVar rechnungWerVar;
    private Persistent persistent;
    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundeVerwaltung = new KundeVerwaltung();
        warenKorbVerwaltung = new WarenKorpVerw();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWerVar = new RechnungWerVar();
        persistent = new Persistent();
    }

    public ArrayList<Artikel> artikelSortieren(boolean artsort) {
        return artikelVerwaltung.artikelSortieren(artsort);

    }

    /**
     * Die übertragene Daten von Methode KundeRegistrieren werden hier im KundenRegistrieren über Parameter kunde weiter gegeben.
     * Die daten werden im Methode registrieren verarbeitet.
     * @param kunde
     */
    public void kundenRegistrieren(Kunde kunde) {
        try {
            kundeVerwaltung.registrieren(kunde);
        } catch (ExceptionsName e) {
            e.prinEror();
        }
    }

    public KundeEinlogen kundenEinloggen(String na, String pas) throws NotFoundEx {
        if (kundeVerwaltung.einlogen(na, pas).gefunden) {
            return kundeVerwaltung.einlogen(na, pas);
        } else
            throw new NotFoundEx("Kunden nicht gefunden");
    }

    public void kaufen() {
        //  warenKorbVerwaltung.kaufen(kunden);
    }

    public void warenlegen(String name, int anzahl, Kunde kunde) throws NotFoundEx {
        Artikel artikel = artikelVerwaltung.findArtikel(name, anzahl);
        kunde.getWarenKorp().addArtikle(artikel, anzahl);
    }

    public void mitarbeiterRegistieren(Mitarbeiter mitarbeiter) throws CustomIoException {
        mitarbeiterVerwaltung.mitarbeiterAnlegen(mitarbeiter);
    }

    public boolean mitarbeiterEinloggen(String na, String pa) throws CustomIoException {
        return mitarbeiterVerwaltung.mitarbeiterUeberprufen(na, pa);
    }

    public Ereigniss eilage(Artikel artikel) {
        atikelLegen(artikel.getArtikelNr(), artikel.getArtikelBestand(), artikel.getArtikelBezeichnung());
        return mitarbeiterVerwaltung.mitarbeiterEinlagerung(artikel);
    }

    public void mitarbeiteranthorReg(Mitarbeiter mitarbeiter) throws CustomIoException {
        mitarbeiterVerwaltung.mitarbeiterAnlegen(mitarbeiter);
        persistent.mitarbeiterSpeichern(mitarbeiter); //varargs
    }

    public Ereigniss ergnissKund(Artikel artikel) {
        return kundeVerwaltung.artikelAuslagern(artikel);
    }


    public ArrayList<Artikel> artielzeigen() {
        return artikelVerwaltung.getArtikelList();
    }

    public Rechnung getRec(Kunde kunde, HashMap<Artikel, Integer> artikels) {
        return rechnungWerVar.creatRec(kunde, artikels);
    }

    public void atikelLegen(int artikelNr, int artikelBestand, String artikelBezeichnung) {
        artikelVerwaltung.artikelAnlegen(artikelNr, artikelBestand, artikelBezeichnung);
    }
}
