package Persistent.repo;

import exception.NotFoundException;
import model.*;

import java.io.IOException;
import java.util.List;

public interface SaveRepo {
    void closeWrite() throws IOException;

    void openForRead(String file) ;

    void openForWrite(String file) throws IOException;

    Ereignis loadEreignis();

    void saveEreignis(Ereignis ereignis) throws IOException;

    List<ErignisToSave> loadListEreignis();

    void saveListEreignises(List<Ereignis> ereignisList);

    void creatFile(String fileName);

    void saveArtikel(List<Artikel> artikel) throws IOException;

    void saveListArtikels(List<Artikel> artikelList) throws IOException;

    List<Artikel> loadListArtikels();

    Artikel loadArtikel(String name) throws NotFoundException;

    void openForSerializer();



    void saveEreignisSerializer(Ereignis ereignis);

    Artikel readErignisSerialzer ();

    void closRead();

    void closSerial();

    void saveKunde(List<Kunde> kundeList);

    List<Kunde> loadKund();


}
