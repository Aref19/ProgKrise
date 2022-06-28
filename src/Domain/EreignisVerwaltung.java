package Domain;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import model.Ereignis;
import model.ErignisToSave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EreignisVerwaltung {

  private   List<Ereignis> ereignis;
  private SaveRepo saveRepo;
  private String fileName="Ereignis.txt";
    private   List<ErignisToSave> erignisToSave;


    public EreignisVerwaltung() {
        this.ereignis = new ArrayList<>();
        saveRepo=new SaveFile();
        saveRepo.creatFile(fileName);
        saveRepo.openForRead(fileName);
      erignisToSave= saveRepo.loadListEreignis();
      //  saveRepo.openForSerializer();

    }

    public void KundenAuslagereungEreignissSpeicher(Ereignis ereignis) {

        this.ereignis.add(ereignis);

    }

    public void fuegeEreignisHinzu(Ereignis ereignis) throws IOException {
        saveRepo.openForWrite(fileName);
        saveRepo.saveEreignis(ereignis);
        saveRepo.closeWrite();
       this.ereignis.add(ereignis);

    }

    public List<ErignisToSave> savedEreignises() {
        System.out.println(erignisToSave.size());
        return erignisToSave;
    }





}
