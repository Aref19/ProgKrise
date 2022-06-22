package Persistent;
import model.Mitarbeiter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * .csv damit es direkt in dem Projekt die Liste kommt
 * Scanner weil, IO klasse kann nicht datei Scannen
 */
public class PersistentMitarbeiter {
    private String filename = "mitarbeiter.csv";
    private File  file = null;
    private BufferedReader reader = null;

    public List<Mitarbeiter> ladeMitarbeiter() throws IOException {
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] data = line.split(";");
            try {
                Mitarbeiter m = new Mitarbeiter(
                        Integer.parseInt(data[0].trim()),
                        String.valueOf(data[1]),
                        String.valueOf(data[2]),
                        String.valueOf(data[3]));
                mitarbeiterList.add(m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        reader.close();
        return mitarbeiterList;
    }
    public void openForWriting(String datei) {
        file = new File(filename);
    }

    public List<Mitarbeiter> mitarbeiterList() throws FileNotFoundException {
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        BufferedReader lesen = new BufferedReader(new FileReader(filename));
        try {
            String line =lesen.readLine();
            while (line !=null){
                String [] content= line.split(";");
                mitarbeiterList.add(new Mitarbeiter(1,content[0],content[1],content[2]));
                line =lesen.readLine();
            }

        }catch (IOException e){
            // TODO Fehlermeldung ausgeben
        }

        return mitarbeiterList;
    }
//    private void mitarbeiterSpeichern(Mitarbeiter... mitarbeiters) {
//        openForWriting("");
//        if(file.exists()) {
//            String data = "";
//            try {
//                FileWriter writer = new FileWriter(file, false);
//                for (Mitarbeiter mitarbeiter : mitarbeiters) {
//                    data = data + mitarbeiter.toString() + "\n";
//                }
//
//                writer.append(data);
//                writer.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }else {
//            try {
//                FileWriter writer = new FileWriter(filename);
//                String data = "";
//                for (Mitarbeiter mitarbeiter : mitarbeiters) {
//                    data = data + mitarbeiter.toString() + "\n";
//                    writer.write(data);
//                    writer.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
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

//    public void mitarbeiterSpeichern(List<Mitarbeiter> mitarbeiterList) {
//        for (Mitarbeiter mitarbeiter: mitarbeiterList) {
//            mitarbeiterSpeichern(mitarbeiter);
//        }
//    }
}