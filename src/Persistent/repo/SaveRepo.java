package Persistent.repo;

import exception.NotFoundException;
import model.Artikel;
import model.Ereignis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SaveRepo {
    void closeWrite() throws IOException;

    void openForRead(String file) ;

    void openForWrite(String file) throws IOException;

    Ereignis loadEreignis();

    void saveEreignis(Ereignis ereignis);

    List<Ereignis> loadListEreignis();

    void saveListEreignises(List<Ereignis> ereignisList);

    void creatFile(String fileName);

    void saveArtikel(Artikel artikel) throws IOException;

    void saveListArtikels(List<Artikel> artikelList) throws IOException;

    List<Artikel> loadListloadArtikels();

    Artikel loadArtikel(String name) throws NotFoundException;

    void openForSerializer();

    void openForReadSerializer();

    void saveArtikelSerializer(Artikel artikel);

    Artikel readArilkelSerialzer ();

    void closRead();

}
