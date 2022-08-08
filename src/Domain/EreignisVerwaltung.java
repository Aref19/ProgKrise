package Domain;

import Persistent.db.SaveFile;
import Persistent.repo.SaveRepo;
import model.Ereignis;
import model.ErignisToSave;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<ErignisToSave> getEreignisse() {
        loadEreignisse();
        return erignisToSave;
    }

    private void loadEreignisse() {
        saveRepo.openForRead(fileName);
        erignisToSave = saveRepo.loadListEreignis();
        saveRepo.closRead();
    }

    public List<Ereignis> sortEreignisse(int sortart, List<Ereignis> ereignisList) {
        List<Ereignis> ereignisArrayList = new ArrayList<>(ereignisList);
        ;
        if (sortart == 0) {
            Collections.sort(ereignisArrayList, Comparator.comparing(Ereignis::getDatum));
        } else if (sortart == 1) {
            Collections.sort(ereignisArrayList, Comparator.comparing(o -> o.getArtikel().getArtikelBezeichnung()));
        } else if (sortart == 2) {
            Collections.sort(ereignisArrayList, Comparator.comparing(o -> o.getPerson().getVorName()));
        } else {
            Collections.sort(ereignisArrayList, Comparator.comparing(Ereignis::getStatus));
        }
        return ereignisArrayList;
    }

    public List<Ereignis> ereignisFilttern(List<Ereignis> ereignisList, int artfilttern, String data) {
        List<Ereignis> beerDrinkers = null;
        if (artfilttern == 0) {
            beerDrinkers = ereignisList.stream()
                    .filter(e -> compereToDate(Date.from(e.getDatum()), simpleFormat(data))).collect(Collectors.toList());
        } else if (artfilttern == 1) {
            beerDrinkers = ereignisList.stream()
                    .filter(e -> e.getArtikel().getArtikelBezeichnung().equals(data)).collect(Collectors.toList());
        } else if (artfilttern == 2) {
            beerDrinkers = ereignisList.stream()
                    .filter(e -> e.getPerson().getVorName().equals(data)).collect(Collectors.toList());
        } else {
            beerDrinkers = ereignisList.stream()
                    .filter(e -> e.getStatus().toString().equals(data)).collect(Collectors.toList());
        }
        return beerDrinkers;
    }

    private Date simpleFormat(String date) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd.MM.yyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;

    }

    private boolean compereToDate(Date date, Date date1) {
        if (date.getYear() == date1.getYear() && date.getDay() == date1.getDay() && date.getMonth() == date1.getMonth()) {
            return true;
        }
        return false;
    }


}
