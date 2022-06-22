package Persistent.db;

import Persistent.repo.SaveRepo;
import model.Artikel;
import model.Ereignis;

import java.io.*;
import java.util.List;

public class SaveFile implements SaveRepo {
    BufferedReader bufferedReader=null;
    BufferedWriter bufferedWriter=null;
    File file=null;

    @Override
    public void creatFile(String fileName) {
        file = new File(fileName);
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (IOException e){
            }

        }
    }

    @Override
    public void openForRead(String file) throws FileNotFoundException {
        bufferedReader=new BufferedReader(new FileReader(file));
    }

    @Override
    public void openForWrite(String file) throws IOException {
        bufferedWriter=new BufferedWriter(new FileWriter(file));
    }

    @Override
    public void saveArtikel(Artikel artikel) {

    }

    @Override
    public void saveListArtikels(List<Artikel> artikelList) {

    }

    @Override
    public List<Artikel> loadListloadArtikels() {
        return null;
    }

    @Override
    public Artikel Artikel() {
        return null;
    }



    @Override
    public Ereignis loadEreignis() {
        return null;
    }

    @Override
    public void saveEreignis(Ereignis ereignis) {

    }

    @Override
    public List<Ereignis> loadListEreignis() {
        return null;
    }

    @Override
    public void saveListEreignises(List<Ereignis> ereignisList) {

    }

    }

