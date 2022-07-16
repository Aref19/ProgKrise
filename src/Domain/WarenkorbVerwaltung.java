package Domain;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import exception.NotFoundException;
import model.Artikel;
import model.Kunde;
import model.Person;
import model.WarenKorp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarenkorbVerwaltung {
    //ToDo
    private final String filename = "warenkorb.txt";
    private SaveRepo saveRepo;

    private List<WarenKorp> allkundWaren;

    public WarenkorbVerwaltung() {
        saveRepo = new SaveFile();
        saveRepo.creatFile(filename);
        allkundWaren = new ArrayList<>();

    }

    public void addArikel(Person person, Artikel artikel, int anzahl) throws NotFoundException {
        ((Kunde) person).getWarenKorp().addArtikle(artikel, anzahl);
    }

    public void returnArtikel(Person person, Artikel artikel) throws NotFoundException {
        ((Kunde) person).getWarenKorp().loschArtikle(artikel);
    }

    public WarenKorp getWarenKorb(Person kunde) {

        return ((Kunde) kunde).getWarenKorp();
    }

    public void saveWarenKorb(List<WarenKorp> warenKorp) {
        try {
            saveRepo.openForWrite(filename);
            saveRepo.saveWarenKorb(warenKorp);
            saveRepo.closeWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadWaren(Person  person) {
        try {
            saveRepo.openForRead(filename);
            allkundWaren = saveRepo.loadWaren(person);

            saveRepo.closRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<WarenKorp> getSavedWaren() {
        return allkundWaren;

    }
}
