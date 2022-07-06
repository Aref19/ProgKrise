package Persistent;

import model.Kunde;
import model.Mitarbeiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PersistentKunde {
    private String kundefile = "kunde.csv";
    private File file = null;

    public void openForWriting(String datei) {

        file = new File(kundefile);
    }

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

}
