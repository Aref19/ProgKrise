package Domain;

import model.Kunden;

import java.util.ArrayList;

public class KundenVerwaltung {

    private ArrayList <Kunden> kundenArrayList = new ArrayList<>();

    public void kundenRegistrierenAnlegen(int kundenNr, String kundenName, int kundenHausNr, int kundenPlz, String kundenStadt, String kundenHerkunft){
        Kunden kunden = new Kunden(kundenNr, kundenName, kundenHausNr, kundenPlz, kundenStadt, kundenHerkunft);
        kundenArrayList.add(kunden);
    }
}
