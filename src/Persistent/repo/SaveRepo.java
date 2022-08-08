package Persistent.repo;


import Persistent.db.SaveFile;
import exception.NotFoundException;
import model.Artikel;
import model.Ereignis;
import model.ErignisToSave;
import model.Kunde;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SaveRepo {
    void closeWrite() throws IOException;

    void openForRead(String file);

    void openForWrite(String file) throws IOException;

    Ereignis loadEreignis();

    void saveEreignis(Ereignis ereignis) throws IOException;

    List<ErignisToSave> loadListEreignis();

    void saveListEreignises(List<Ereignis> ereignisList);

    void creatFile(String fileName);

    void saveArtikel(List<Artikel> artikel) throws IOException;

    void saveListArtikels(List<Artikel> artikelList) throws IOException;

    List<Artikel> loadListloadArtikels();

    Artikel loadArtikel(String name) throws NotFoundException;

    void openForSerializer();

    void kundSave(List<Kunde> kundeList);

    void saveEreignisSerializer(Ereignis ereignis);

    Artikel readErignisSerialzer();

    void closRead();

    void closSerial();


}
