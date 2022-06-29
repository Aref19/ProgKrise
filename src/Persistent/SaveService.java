package Persistent;

import Persistent.repo.SaveRepo;
import model.Artikel;

import java.io.*;

public class SaveService implements SaveRepo {
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    public final static String nameFIleArtikel="Artikel.text";



    @Override
    public void openForReading(String name)throws FileNotFoundException {
        reader=new BufferedReader(new FileReader(name));
    }

    @Override
    public void openForWrit(String name) throws IOException {
        writer=new BufferedWriter(new FileWriter(name));
    }

    @Override
    public void saveArtikel(Artikel artikel) throws IOException {
           if (writer!=null){
               writer.write(artikel.getArtikelBezeichnung());
           }
    }

    @Override
    public Artikel loadArtikel(Artikel artikel) {

        return null;
    }


}
