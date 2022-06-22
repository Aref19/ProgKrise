package Domain;

import Persistent.PersistentKunde;
import Persistent.PersistentMitarbeiter;
import exception.*;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundeVerwaltung kundeVerwaltung;
    private WarenKorpVerw warenKorbVerwaltung;
    private MitarbeiterVerwaltung mitarbeiterVerwaltung;
    private RechnungWarenkorb rechnungWarenkorb;
    private PersistentMitarbeiter persistentMitarbeiter;
    private PersistentKunde persistentKunde;
    private EreignisVerwaltung ereignisVerwaltung;
    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundeVerwaltung = new KundeVerwaltung();
        warenKorbVerwaltung = new WarenKorpVerw();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWarenkorb = new RechnungWarenkorb();
        persistentMitarbeiter = new PersistentMitarbeiter();
        ereignisVerwaltung=new EreignisVerwaltung();
        persistentKunde = new PersistentKunde();
    }

    public ArrayList<Artikel> artikelSortieren(boolean artsort) {
        return artikelVerwaltung.artikelSortieren(artsort);

    }

    /**
     * Die übertragene Daten von Methode KundeRegistrieren werden hier im KundenRegistrieren über Parameter kunde weiter gegeben.
     * Die daten werden im Methode registrieren verarbeitet.
     * @param kunde
     */
    public void kundenRegistrieren(Kunde kunde) throws RegisitierungException {
        try {
            kundeVerwaltung.registrieren(kunde);
        } catch (RegisitierungException e) {
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
         return    artikelVerwaltung.findArtikel(name);
        }catch (NotFoundException e){
            throw e;

        }catch (BestandNichtAusreichendException e){
            throw e;
        }
    }

    public boolean mitarbeiterEinloggen(String name, String password) throws LoginFailedException {
        try {
            return mitarbeiterVerwaltung.mitarbeiterUeberprufen(name, password);
        } catch (LoginFailedException e) {
            throw e;
        }
    }

    public void artikelAnlegen(Artikel artikel) {
        artikelVerwaltung.artikelAnlegen(artikel.getArtikelNr(), artikel.getArtikelBestand(), artikel.getArtikelBezeichnung());
//        ereignisVerwaltung.ereignisAnlegen(artikel,mitarbeiter, Ereignis.STATUS.Neu);

    }

    public void mitarbeiteranthorReg(String name, String nachname, String passwort) throws RegisitierungException {
        try {
            mitarbeiterVerwaltung.mitarbeiterAnlegen(name, nachname, passwort);
        }catch (RegisitierungException e){
         throw e;
        }
    }
    public ArrayList<Artikel> artielzeigen() {
        return artikelVerwaltung.getArtikelList();
    }

    public Rechnung getRec(Kunde kunde, HashMap<Artikel, Integer> artikels) {
        return rechnungWarenkorb.creatRec(kunde, artikels);
    }

    public void speicherEreignisVonKund(Ereignis ereignis){
        ereignisVerwaltung.KundenAuslagereungEreignissSpeicher(ereignis);
    }

    public void speicherEreignisVonMitarbeiter(Ereignis ereignis){
        ereignisVerwaltung.mitarbeiterAuslagereungEreignissSpeicher(ereignis);
    }

    public List<Ereignis> kundenEreignisAusgeben(){
       return  ereignisVerwaltung.kundenEreigniss();
    }

    public List<Ereignis> mitarbeiterEreignisAusgeben(){
        return  ereignisVerwaltung.mitarbeiterEreignis();
    }

}
