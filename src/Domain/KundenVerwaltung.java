package Domain;

import exception.ExistenceName;
import exception.NotFoundEx;
import model.Adresse;
import model.Kunden;
import model.Person;

import java.util.ArrayList;

public class KundenVerwaltung {

    private ArrayList<Kunden> kundenArrayList = new ArrayList<>();

<<<<<<< HEAD
    public void kundenRegistrierenAnlegen(int kundenNr, String kundenName, String kundenNachname,  Adresse adresse , String passwort){
        Kunden kunden = new Kunden(kundenNr, kundenName, kundenNachname,  adresse , passwort);
        kundenArrayList.add(kunden);
=======

    public Kunden einlogen(String na, String pass)throws NotFoundEx {
        for (Kunden kunden : kundenArrayList) {
            if (kunden.getVorName().equals(na) && kunden.getPassword().equals(pass)) {
                return kunden;
            }else
                throw new NotFoundEx("diese kund nicht");
        }
        return null;
>>>>>>> 9d7b6d36315e18e3ea8291b81bae3b2be107e396
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
