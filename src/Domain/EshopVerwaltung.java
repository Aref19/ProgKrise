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
    private WarenkorbVerwaltung warenkorbVerwaltung;

    private EreignisVerwaltung ereignisVerwaltung;
    /**
     ToDo if kaufen delete all artikel in waren korp from warenkorbVerwaltung.getSavedWaren() then save
     ToDo if the custmor delte one item from waren korp
     ToDo if make ereignis by bey and change Artikel Anzahl
     **/
    public EshopVerwaltung() {
        artikelVerwaltung = new ArtikelVerwaltung();
        kundeVerwaltung = new KundeVerwaltung();
        mitarbeiterVerwaltung = new MitarbeiterVerwaltung();
        rechnungWarenkorb = new RechnungWarenkorb();
        warenkorbVerwaltung = new WarenkorbVerwaltung();
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
    public void kundenRegistrieren(Kunde kunde) throws INcorrectEmailException, RegisitierungException {
        Person.checkEmail(kunde.getEmail());
        kundeVerwaltung.registrieren(kunde);
    }

    public Einlogen kundenEinloggen(String na, String pas) throws LoginFailedException {
        Einlogen einlogen= kundeVerwaltung.einlogen(na, pas);
        warenkorbVerwaltung.loadWaren(einlogen.person);
        return einlogen;
    }

    public void returnArikel(String artiekelName, String anzahl, Person person) throws NotFoundException {
        Artikel artikel = findArtikel(artiekelName);
        artikelVerwaltung.returnWare(artikel, anzahl);
        warenkorbVerwaltung.returnArtikel(person, artikel);
    }

    public void warenlegen(String name, int anzahl, Person person) throws BestandNichtAusreichendException, NotFoundException {
        Artikel artikel = findArtikel(name);
        artikelVerwaltung.artikelBestandReduzieren(artikel, anzahl);
        warenkorbVerwaltung.addArikel(person, artikel, anzahl);

    }

    public Artikel findArtikel(String name) throws NotFoundException {
        return artikelVerwaltung.findArtikel(name);
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

    public WarenKorp kundeWaren(Person person) throws NotFoundException {
        List<WarenKorp> warenKorpList=warenkorbVerwaltung.getSavedWaren();
        for(int i=0;i<warenKorpList.size();i++){
            if(warenKorpList.get(i).getEmail().equals(person.getEmail())){// nur waren von kund
                Artikel artikel=  findArtikel(warenKorpList.get(i).getNameArtikel());
                warenkorbVerwaltung.getWarenKorb(person).addArtikle(artikel,warenKorpList.get(i).getAnzahl());
            }
        }
        return warenkorbVerwaltung.getWarenKorb(person);
    }

    public void saveWaren(Person person){
        List<Artikel> artikels=((Kunde)person).getWarenKorp().hashtoList();
        List<WarenKorp> warenKorpList= warenkorbVerwaltung.getSavedWaren();
        boolean save=false;
        for (int i=0;i<artikels.size();i++){
            if(warenKorpList.size()>0){
                for (int j=0;j<warenKorpList.size();j++){
                    if(warenKorpList.get(j).getEmail().equals(person.getEmail())){
                        if(artikels.get(i).getArtikelBezeichnung().equals(warenKorpList.get(j).getNameArtikel())){
                            int anzahl=((Kunde)person).getWarenKorp().get().get(artikels.get(i));
                            warenKorpList.add(new WarenKorp(person.getEmail(),warenKorpList.get(j).getNameArtikel(),
                                    anzahl*artikels.get(i).getPreis(),anzahl));
                            warenKorpList.remove(j);
                            save=true;
                        }
                    }
                }
                if(!save){// if email nicht vorhanden
                    int anzahl=((Kunde)person).getWarenKorp().get().get(artikels.get(i));
                    warenKorpList.add(new WarenKorp(person.getEmail(),artikels.get(i).getArtikelBezeichnung(),
                            anzahl*artikels.get(i).getPreis(),anzahl));
                    save=false;
                }

            }else {// if data ist leer
                int anzahl=((Kunde)person).getWarenKorp().get().get(artikels.get(i));
                warenKorpList.add(new WarenKorp(person.getEmail(),artikels.get(i).getArtikelBezeichnung(),
                        anzahl*artikels.get(i).getPreis(),anzahl));
            }

        }
        warenkorbVerwaltung.saveWarenKorb(warenKorpList);
    }


}
