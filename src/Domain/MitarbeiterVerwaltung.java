package Domain;

import model.Mitarbeiter;

import java.util.ArrayList;

public class MitarbeiterVerwaltung {

    ArrayList <Mitarbeiter> mitarbeiterList = new ArrayList<>();

    public void mitarbeiterAnlegen(Mitarbeiter mitarbeiter ){
    mitarbeiterList.add(mitarbeiter);
    }

    public void mitarbeiterUeberprufen( String Name, int mitarbeiterNr){
        for (Mitarbeiter mitarbeiter: mitarbeiterList) {

        }
    }

    public ArrayList<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }
}
