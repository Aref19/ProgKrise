package Domain;

import exception.ExistenceName;
import exception.NotFoundEx;

import model.Artikel;
import model.Ereigniss;
import model.KundEilogen;
import model.Kunden;


import java.time.Instant;
import java.util.ArrayList;

public class KundenVerwaltung {

    private ArrayList<Kunden> kundenArrayList = new ArrayList<>();
    Kunden kunde;
    public KundEilogen einlogen(String na, String pass)throws  NotFoundEx{
        for (Kunden kunden : kundenArrayList) {
            if (kunden.getVorName().equals(na) && kunden.getPassword().equals(pass)) {
                kunde=kunden;
                return new KundEilogen(kunden,true);
            }
        }

        throw new NotFoundEx("dies ist nicht vorhanden");

    }

    public void registieren(Kunden kunden) throws ExistenceName{
        kundenArrayList=new ArrayList<>();
        if (kundenArrayList.size() > 0) {
            for (Kunden kunden1 : kundenArrayList) {
                System.out.println(kunden1.getVorName());
                if (kunden1.getVorName().equals(kunden.getVorName())) {
                    throw new ExistenceName("dieser Nmae is benutzt bitt ändern");
                } else {
                    kundenArrayList.add(kunden);
                    System.out.println("add");

                }
            }
        } else {
            kundenArrayList.add(kunden);
        }
    }

    public Ereigniss artikelAuslagern(Artikel artikel){
        return new Ereigniss(kunde,artikel, Instant.now());
    }

}
