package Persistent.db;

import Persistent.repo.SaveRepo;
import exception.NotFoundException;
import model.Artikel;
import model.Ereignis;

import java.io.*;
import java.util.ArrayList;
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
    public void closeWrite() throws IOException {
        bufferedWriter.close();
    }

    @Override
    public void openForRead(String file){
        try {
            bufferedReader=new BufferedReader(new FileReader(file));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void openForWrite(String file) throws IOException {
        bufferedWriter=new BufferedWriter(new FileWriter(file,true));
    }

    @Override
    public void saveArtikel(Artikel artikel) throws IOException {
        try {
            bufferedWriter.write((artikel.toSaveInFile()+System.lineSeparator()));
        }catch (IOException e){
            throw e;
        }
    }

    @Override
    public void saveListArtikels(List<Artikel> artikelList) throws IOException {
        try {
            for (Artikel artikel:artikelList) {
                bufferedWriter.write(artikel.toString());
            }

        }catch (IOException e){
            throw e;
        }
    }

    @Override
    public List<Artikel> loadListloadArtikels() {
        List<Artikel> artikels=new ArrayList<>();
        try {
            String data= bufferedReader.readLine();
            while (data!=null){
                String content[]=data.split(";");

                artikels.add(new Artikel(Integer.valueOf(content[0]),content[1],Integer.valueOf( content[2]),Double.valueOf( content[3])));
                data=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return artikels;
    }

    @Override
    public Artikel loadArtikel(String name) throws NotFoundException {
        List<Artikel> artikels=loadListloadArtikels();

        for (Artikel artikel1:artikels) {
            if(artikel1.getArtikelBezeichnung().equals(name)){
             return  artikel1;
            }
        }
        throw new NotFoundException("leider Artikel mit name :\t"+name+"nicht gefunden");
    }

    @Override
    public void openForSerializer() {

    }

    @Override
    public void openForReadSerializer() {

    }

    @Override
    public void saveArtikelSerializer(Artikel artikel) {

    }

    @Override
    public Artikel readArilkelSerialzer() {
        return null;
    }

    @Override
    public void closRead() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

