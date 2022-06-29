package Persistent.repo;

import model.Artikel;

import java.io.IOException;

public interface SaveRepo {
    public void openForReading(String name)throws Exception;
    public void saveArtikel(Artikel artikel) throws IOException;
    public Artikel loadArtikel(Artikel artikel);
    public void openForWrit(String name) throws IOException;

}
