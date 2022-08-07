package Domain;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import model.Artikel;
import model.Ereignis;
import model.ErignisToSave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EreignisVerwaltung {

    private List<Ereignis> ereignis;
    private SaveRepo saveRepo;
    private String fileName = "Ereignis.txt";
    private List<ErignisToSave> erignisToSave;


    public EreignisVerwaltung() {
        this.ereignis = new ArrayList<>();
        saveRepo = new SaveFile();
        saveRepo.creatFile(fileName);
        saveRepo.openForRead(fileName);
        erignisToSave = saveRepo.loadListEreignis();
        saveRepo.closRead();
        //  saveRepo.openForSerializer();

    }

    public void fuegeEreignisHinzu(Ereignis ereignis) throws IOException {
        saveRepo.openForWrite(fileName);
        saveRepo.saveEreignis(ereignis);
        saveRepo.closeWrite();
        this.ereignis.add(ereignis);
    }

    public List<ErignisToSave> getEreignisse(){
        loadEreignisse();
        return erignisToSave;
    }

    private void loadEreignisse(){
        saveRepo.openForRead(fileName);
        erignisToSave = saveRepo.loadListEreignis();
        saveRepo.closRead();
    }

    public List<Ereignis> sortEreignisse(int sortart, List<Ereignis> ereignisList){
        List<Ereignis> ereignisArrayList=new ArrayList<>(ereignisList);;
        if (sortart==0) {
            Collections.sort(ereignisArrayList, Comparator.comparing(Ereignis::getDatum));
        } else if(sortart==1){
            Collections.sort(ereignisArrayList, Comparator.comparing(o ->o.getArtikel().getArtikelBezeichnung()));
        }else if(sortart==2){
            Collections.sort(ereignisArrayList, Comparator.comparing(o -> o.getPerson().getVorName()));
        }else {
            Collections.sort(ereignisArrayList, Comparator.comparing(Ereignis::getStatus));
        }
        return ereignisArrayList;
    }
}
