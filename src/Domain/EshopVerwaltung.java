package Domain;

import exception.CustomIoException;
import exception.ExistenceName;
import exception.NotFoundEx;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EshopVerwaltung {
    private ArtikelVerwaltung artikelVerwaltung;
    private KundenVerwaltung kundenVerwaltung;
    private WarenKorpVerw warenKorbVerwaltung;
    private MitarbeiterVerwaltung mitarbeiterVerwaltung;
    private RechnungWerVar rechnungWerVar;

    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundenVerwaltung = new KundenVerwaltung();
        warenKorbVerwaltung = new WarenKorpVerw();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWerVar = new RechnungWerVar();

    }

    public ArrayList<Artikel> artikelSortieren(boolean artsort) {
        return artikelVerwaltung.artikelSortieren(artsort);

    }

    public void kundenRegistieren(Kunden kunden) {
        try {
            kundenVerwaltung.registieren(kunden);
        } catch (ExistenceName e) {
            e.prinEror();

        }
    }

    public KundEilogen kundenEinloggen(String na, String pas) throws NotFoundEx {

        if (kundenVerwaltung.einlogen(na, pas).gefunden) {
            return kundenVerwaltung.einlogen(na, pas);
        } else
            throw new NotFoundEx("Kunden nicht gefunden");
    }

    public void kaufen() {
        warenKorbVerwaltung.kaufen(kunden);
    }

    public void warenlegen(String name, int anzahl, Kunden kunden) throws NotFoundEx {
        Artikel artikel = artikelVerwaltung.findArtikel(name, anzahl);
        kunden.getWarenKorp().addArtikle(artikel, anzahl);
        // warenKorbVerwaltung.addArtikel(artikel,anzahl);

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
    }

    public Ereigniss ergnissKund(Artikel artikel) {
        return kundenVerwaltung.artikelAuslagern(artikel);
    }


    public ArrayList<Artikel> artielzeigen() {
        return artikelVerwaltung.getArtikelList();
    }

    public Rechnung getRec(Kunden kunden, HashMap<Artikel, Integer> artikels) {
        return rechnungWerVar.creatRec(kunden, artikels);
    }

    public void atikelLegen(int artikelNr, int artikelBestand, String artikelBezeichnung) {
        artikelVerwaltung.artikelAnlegen(artikelNr, artikelBestand, artikelBezeichnung);
    }
}
