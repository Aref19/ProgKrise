package Domain;


import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import exception.LoginFailedException;

import exception.RegisitierungException;
import model.Einlogen;
import model.Kunde;
import model.WarenKorp;


import java.io.IOException;
import java.util.List;

public class KundeVerwaltung {

    private List<Kunde> kundeArrayList;
    private SaveRepo saveRepo;
    final String fileName = "kundsave.txt";

    public KundeVerwaltung() {
        saveRepo = new SaveFile();
        saveRepo.creatFile(fileName);
        saveRepo.openForRead(fileName);
        kundeArrayList = saveRepo.loadKunde();
        saveRepo.closRead();
    }

    public Einlogen einlogen(String na, String pass) throws LoginFailedException {
        for (Kunde kunde : kundeArrayList) {
            if (kunde.getEmail().equals(na) && kunde.getPassword().equals(pass)) {
                return new Einlogen(kunde, true);
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
            for (int i = 0; i < kundeArrayList.size(); i++) {
                if (kundeArrayList.get(i).getEmail().equals(kunde.getEmail())) {
                    throw new RegisitierungException(kundeArrayList.get(i).getEmail() + "\n ist bereits vorhanden\t");
                }
            }
        }
        kundeArrayList.add(kunde);


        saveKund();
    }

    private void saveKund() {
        try {
            saveRepo.openForWrite(fileName);
            saveRepo.saveKunde(kundeArrayList);
            saveRepo.closeWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WarenKorp getWarenKorb(Kunde kunde){
       return kunde.getWarenKorp();
    }


}
