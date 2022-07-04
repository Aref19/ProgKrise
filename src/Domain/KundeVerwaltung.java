package Domain;


import Persistent.PersistentKunde;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import exception.LoginFailedException;

import exception.RegisitierungException;
import model.KundeEinlogen;
import model.Kunde;


import java.util.ArrayList;
import java.util.List;

public class KundeVerwaltung {

    private List<Kunde> kundeArrayList;
    private PersistentKunde persistentKunde = new PersistentKunde();
    Kunde kunde;
    private SaveRepo saveRepo;
    final String fileName ="kundsave.txt";
    public KundeVerwaltung() {
        saveRepo=new SaveFile();
        saveRepo.creatFile(fileName);
        saveRepo.openForRead(fileName);
        kundeArrayList = saveRepo.loadKunde();
        saveRepo.closRead();
    }

    public KundeEinlogen einlogen(String na, String pass) throws LoginFailedException {
        for (Kunde kunde : kundeArrayList) {
            if (kunde.getEmail().equals(na) && kunde.getPassword().equals(pass)) {
                this.kunde = kunde;
                return new KundeEinlogen(kunde, true);
            }
        }
        throw new LoginFailedException();
    }

    /**
     * Die übertragene daten von methode KundenRegistrieren von EshopVerwaltung werden im methode registrieren verarbeitet.
     * Wird ein Kunde Registriert
     *
     * @param kunde
     * @throws RegisitierungException
     */
    public void registrieren(Kunde kunde) throws RegisitierungException {
        if (kundeArrayList.size() > 0) {
            for (Kunde kund1 : kundeArrayList) {
                if (kund1.getVorName().equals(kunde.getVorName()) && kund1.getNachName().equals(kunde.getNachName())) {
                    throw new RegisitierungException(kund1.getVorName() + "\t ist bereits vorhanden\t");

                } else {
                    kundeArrayList.add(kunde);
                    persistentKunde.kundeSpeichern(kunde);
                }
            }
        } else {
            kundeArrayList.add(kunde);
            persistentKunde.kundeSpeichern(kunde);
        }
    }


}
