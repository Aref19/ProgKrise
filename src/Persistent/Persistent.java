package Persistent;

import model.Mitarbeiter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * .csv damit es direkt in dem Projekt die Liste kommt
 * Scanner weil, IO klasse kann nicht datei Scannen
 */
public class Persistent {
    private String filename = "mitarbeiter.csv";

    public void ladeMitarbeiter() throws IOException {
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] data = line.split(";");
            try {
                Mitarbeiter m = new Mitarbeiter(
                        Integer.parseInt(data[0].trim()),
                        String.valueOf(data[1]),
                        String.valueOf(data[2]),
                        String.valueOf(data[3]));
                System.out.println(m.getVorName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        reader.close();
    }

    public void mitarbeiterSpeichern(Mitarbeiter... mitarbeiters) {
        try {
            FileWriter writer = new FileWriter(filename);
            String data = "";
            for (Mitarbeiter mitarbeiter : mitarbeiters) {
                data = data + mitarbeiter.toString() + "\n";
                writer.write(data);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Persistent p = new Persistent();

        try {
            p.ladeMitarbeiter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
