package ui;

import Domain.EshopVerwaltung;

import Utilities.IO;
import exception.*;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EshopCui {
    EshopVerwaltung eshopVerwaltung = new EshopVerwaltung();


    static Person person;

    public static void main(String[] args) throws CustomIoException {
        EshopCui eshopCui = new EshopCui();
        try {
            eshopCui.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kunde gibt seine Daten ein und diese Daten werden im weiteren Methode KundenRegistrierung übertragen.
     * Die klasse Kunde Constructor und Klasse Adresse Constructor werden die Daten benutzt, um Kunde zu erzeugen.
     */
    public void kundeRegistrieren(Kunde kunde) throws INcorrectEmailException, RegisitierungException {
        eshopVerwaltung.kundenRegistrieren(kunde);
    }

    /**
     * Wenn Name und Passwort der Kunde richtig sind, liefert die boolean true
     *
     * @return
     */
    public Einlogen kundenEinloggen(String email, String pass) throws LoginFailedException {


        return eshopVerwaltung.kundenEinloggen(email, pass);

    }


    /**
     * Wenn Name und Passwort der Mitarbeiter richtig sind, liefert die boolean true
     *
     * @return
     * @throws CustomIoException
     */
    public boolean mitarbeiterEinloggen(String email, String pass) throws LoginFailedException {
        Einlogen mItarbeiterEilogen = new Einlogen(null, false);

        mItarbeiterEilogen = eshopVerwaltung.mitarbeiterEinloggen(email, pass);
        person = mItarbeiterEilogen.person;
        return mItarbeiterEilogen.gefunden;

    }

    public void warenEinlegen(String name, int anzahl) throws BestandNichtAusreichendException, NotFoundException {
        eshopVerwaltung.warenlegen(name, anzahl, person);
    }

    public void kundEreignis() {

    }

    public void returnWare(String name, String annzahl) throws NotFoundException {
        eshopVerwaltung.returnArikel(name, annzahl, person);
    }

    public void einlagerung() {// Mitarbeiter einlagarung
//        List<Artikel> artikels = new ArrayList<>();
        do {
            System.out.println("Name des Artikels :");
            String name = IO.inputString();
            System.out.println("Bestand des Artikels :");
            int bestand = IO.inputInt();
            System.out.println("Der Preis ist: ");
            double preis = IO.inputdoubel();
//            artikels.add(new Artikel(2, na, be, pr));
            try {
                eshopVerwaltung.artikelAnlegen((Mitarbeiter) person, new Artikel(name, bestand, preis));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("wollen sie weiter einlegen n/j");
        } while (!IO.inputString().equals("n"));
        System.out.println("sie haben jetzt");
        zeigeArtikel();


    }

    public void mitarbeiterRegestieren() {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr Nachname ein: ");
        String namchname = IO.inputString();
        System.out.println("Geben Sie Ihr Email ein: ");
        String email = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String passwort = IO.inputString();

        try {
            eshopVerwaltung.mitarbeiterAnthorRegiseren(name, namchname, passwort, email);
            System.out.println("Registrierung ist Erfolgreich Abgeschlossen");
        } catch (RegisitierungException e) {
            System.out.println(e.getMessage());
        } catch (INcorrectEmailException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setPerson(Person person) {
        EshopCui.person = person;
    }

    public WarenKorp kundeWaren() throws NotFoundException {

            return eshopVerwaltung.kundeWaren((Kunde) person);


    }

    public List<Artikel> zeigeArtikel() {
        return eshopVerwaltung.artielzeigen();
    }

    public void rechnung() {
        try {
            System.out.println(eshopVerwaltung.getRec((Kunde) person, ((Kunde) person).getWarenKorp().get()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void artikelSortieren(boolean artSort) {
        List<Artikel> artikels = eshopVerwaltung.artikelSortieren(artSort);
        for (Artikel a : artikels) {
            System.out.println(a);
        }
    }

    public void saveWaren(){
        eshopVerwaltung.saveWaren(person);
    }

    public void run() throws IOException {
        do {
            // persistentMitarbeiter.ladeMitarbeiter();
            System.out.println("1- Als neue Kunde Registrieren \n2- Als Kunde Einlogen\n3- Als Mitarbeiter Einlogen ");
            int s = IO.inputInt();
            switch (s) {
                case 1 -> {
                    //kundeRegistrieren();
                }
                case 2 -> {
                    Einlogen einlogen = null;
                    try {
                        einlogen = kundenEinloggen("", "");
                    } catch (LoginFailedException e) {
                        e.printStackTrace();
                    }
                    if (einlogen.gefunden) {
                        person = einlogen.person;
                        System.out.println("Liegen Sie jetzt einen Artikel in dem WarenKorb: 1 oder Abmelden: 2");
                        if (IO.inputInt() == 2) {
                            run();
                        }


                        System.out.println("Weiter zu Kasse ==> j/n");
                        String ein = IO.inputString();
                        if (ein.equals("j")) {
                            System.out.println("Hier können Sie Ihre Rechnung sehen : \n");
                            rechnung();

                            System.out.println("Der Ereignis ist jetzt: ");
                            kundEreignis();
                            System.out.println("Vielen Dank für Ihren Einkauf");

                        } else System.out.println("Vielen Dank Ihre Warenkorb ist leer");
                    }
                }
                case 3 -> {
                    try {
                        if (mitarbeiterEinloggen("", "")) {

                            do {
                                System.out.println("Wollen Sie 1- Mitarbeiter Regestieren\n 2- Einlagerung\n3-Sortierten \n 4 - abmelden" + "\t" + "\n5-Einlagerung");
                                int input = IO.inputInt();
                                if (input == 4) {
                                    run();
                                }
                                switch (input) {
                                    case 1 -> {
                                        mitarbeiterRegestieren();
                                    }
                                    case 2 -> {


                                    }
                                    case 3 -> {
                                        zeigeArtikel();
                                        System.out.println("wie wollen sie es sortieren");
                                        int sort = IO.inputInt();
                                        boolean artsort;
                                        artsort = sort == 1 ? true : false;
                                        artikelSortieren(artsort);
                                    }

                                }
                                System.out.println("Wollen Sie als Mitarbeiter benden n/j");
                            } while (IO.inputString().equals("n"));
                        }
                    } catch (LoginFailedException e) {
                        e.printStackTrace();
                    }

                }
            }
            System.out.println("Wollen Sie System beenden n/j");
        } while (IO.inputString().equals("n"));
    }
}

