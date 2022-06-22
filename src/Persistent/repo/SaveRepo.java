package Persistent.repo;

import model.Artikel;
import model.Ereignis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SaveRepo {
    void openForRead(String file) throws FileNotFoundException;

    void openForWrite(String file) throws IOException;

    Ereignis loadEreignis();

    void saveEreignis(Ereignis ereignis);

    List<Ereignis> loadListEreignis();

    void saveListEreignises(List<Ereignis> ereignisList);

    void creatFile(String fileName);

    void saveArtikel(Artikel artikel);

    void saveListArtikels(List<Artikel> artikelList);

    List<Artikel> loadListloadArtikels();

    Artikel Artikel();
}
