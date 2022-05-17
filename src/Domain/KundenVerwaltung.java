package Domain;

import model.Adresse;
import model.Kunden;
import model.Person;

import java.util.ArrayList;

public class KundenVerwaltung {

    private ArrayList <Kunden> kundenArrayList = new ArrayList<>();

    public void kundenRegistrierenAnlegen(int kundenNr, String kundenName, String kundenNachname,  Adresse adresse){
        Kunden kunden = new Kunden(kundenNr, kundenName, kundenNachname,  adresse);
        kundenArrayList.add(kunden);
    }


}
