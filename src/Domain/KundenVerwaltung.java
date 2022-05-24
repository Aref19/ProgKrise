package Domain;

import exception.ExistenceName;
import exception.NotFoundEx;
import model.Adresse;
import model.KundEilogen;
import model.Kunden;
import model.Person;

import java.util.ArrayList;

public class KundenVerwaltung {

    private ArrayList<Kunden> kundenArrayList = new ArrayList<>();


    public KundEilogen einlogen(String na, String pass)throws  NotFoundEx{
        for (Kunden kunden : kundenArrayList) {
            if (kunden.getVorName().equals(na) && kunden.getPassword().equals(pass)) {
                return new KundEilogen(kunden,true);
            }
        }
        throw new NotFoundEx("dies ist nicht vorhanden");
    }

    public void registieren(Kunden kunden) throws ExistenceName {
        if (kundenArrayList.size() > 0) {
            for (Kunden kunden1 : kundenArrayList) {
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

}
