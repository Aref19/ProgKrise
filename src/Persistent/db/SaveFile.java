package Persistent.db;

import Persistent.repo.SaveRepo;
import exception.NotFoundException;
import model.*;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SaveFile implements SaveRepo {
    BufferedReader bufferedReader=null;
    BufferedWriter bufferedWriter=null;
    ObjectOutputStream objectOutputStream=null;
    String kundefile = "kunde.csv";
    File file=null;

    public void openForWriting(String datei) {
        file = new File(kundefile);
    }
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
        if(file.equals("Ereignis.txt")){
            bufferedWriter=new BufferedWriter(new FileWriter(file,true));
        }else
           bufferedWriter=new BufferedWriter(new FileWriter(file,false));
    }

    @Override
    public void saveArtikel(List<Artikel> artikel) throws IOException {
        try {
            for (Artikel artikel1:artikel){
                bufferedWriter.append((artikel1.toSaveInFile()+System.lineSeparator()));
            }
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
            System.out.println(data);
            while (data!=null){
                String content[]=data.split(";");
                artikels.add(new Artikel(Integer.valueOf(content[0]),
                        content[1],Integer.valueOf( content[2]),
                        Double.valueOf( content[3])));
                data=bufferedReader.readLine();
                System.out.println(data);
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
        try {
            objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveEreignisSerializer(Ereignis ereignis) {
        try {
            System.out.println(ereignis.getPerson());
            objectOutputStream.writeObject(new ErignisToSave(ereignis.getPerson().getId(),ereignis.getArtikel().getArtikelNr()
            ,Instant.now(),ereignis.getStatus(),ereignis.getArtikel().getArtikelBestand()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Artikel readErignisSerialzer() {
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
    public void closSerial() {
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }


    @Override
    public Ereignis loadEreignis() {
        return null;
    }

    @Override
    public void saveEreignis(Ereignis ereignis) throws IOException {
        try {

            bufferedWriter.append(new ErignisToSave(ereignis.getPerson().getId(),ereignis.getArtikel().getArtikelNr()
            ,Instant.now(), ereignis.getStatus(),ereignis.getArtikel().getArtikelBestand()).toString()+System.lineSeparator());
        }catch (IOException e){
            throw e;
        }

    }

    @Override
    public List<ErignisToSave> loadListEreignis() {
        List<ErignisToSave> ereignses=new ArrayList<>();
        try {
            String data= bufferedReader.readLine();
            while (data!=null){
                String content[]=data.split(";");

                ereignses.add(new ErignisToSave(
                        UUID.fromString(content[1]),
                          Integer.valueOf(content[2]),
                       ErignisToSave.convertStringToInstat(content[0]),
                        ErignisToSave.statusFromString(content[4]),
                       Integer.valueOf( content[3])));
                data=bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ereignses;
    }

    @Override
    public void saveListEreignises(List<Ereignis> ereignisList) {

    }
    @Override
    public void kundeSpeichern(Kunde... kunde) {
        openForWriting("");
        if (file.exists()) {
            try {
                FileWriter writer = new FileWriter(file, true);
                String data = "";
                for (Kunde kund : kunde) {
                    data = data + kund.toString();
                    writer.write(data);
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<Kunde> ladeKunden() throws FileNotFoundException {
        File file = new File(kundefile);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] data = line.split(";");
            /*
                        try {

                Kunde k = new Kunde(
                        Integer.parseInt(data[0].trim()),
                        String.valueOf(data[1]),
                        String.valueOf(data[2]),
                        String.valueOf(data[3]));
                        String.valueOf(data[4]);
                        String.valueOf(data[5]);
                System.out.println(k.getVorName());
            } catch (Exception e) {
                e.printStackTrace();
            }
                        */
        }


        reader.close();
        return null;
    }
    public void mitarbeiterSpeichern(List<Mitarbeiter> mitarbeiterList) {
        openForWriting("");
        if(file.exists()) {
            String data = "";
            try {
                FileWriter writer = new FileWriter(file, false);
                for (Mitarbeiter mitarbeiter : mitarbeiterList) {
                    data = data + mitarbeiter.toString() + System.lineSeparator();
                }

                writer.append(data);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


