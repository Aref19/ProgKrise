package ui;

import Domain.EshopVerwaltung;
import Persistent.PersistentMitarbeiter;
import Utilities.IO;
import exception.*;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EshopCui {
    EshopVerwaltung eshopVerwaltung = new EshopVerwaltung();
    PersistentMitarbeiter persistentMitarbeiter = new PersistentMitarbeiter();

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
    public void kundeRegistrieren() {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr email ein: ");
        String email = IO.inputString();
        System.out.println("Geben Sie Ihr Nachname ein: ");
        String nachname = IO.inputString();
        System.out.println("Geben Sie der Strassenname ein: ");
        String strasse = IO.inputString();
        System.out.println("Geben Sie die Hausnummer ein: ");
        int hausnummer = IO.inputInt();
        System.out.println("Geben Sie die Postleitzahl ein: ");
        int plz = IO.inputInt();
        System.out.println("Geben Sie Ihre Stadt ein: ");
        String stadt = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String passwort = IO.inputString();
        try {
            eshopVerwaltung.kundenRegistrieren(new Kunde(name, nachname, new Adresse(hausnummer, plz, stadt, strasse), passwort,email));
        } catch (RegisitierungException e) {
            System.out.println(e.getMessage());
        }catch (INcorrectEmailException e){
            System.out.println(  e.getMessage());
        }


    }

    /**
     * Wenn Name und Passwort der Kunde richtig sind, liefert die boolean true
     *
     * @return
     */
    public KundeEinlogen kundenEinloggen(String email,String pass) {
        try {

            return eshopVerwaltung.kundenEinloggen(email, pass);
        } catch (LoginFailedException ex) {
            System.out.println(ex.getMessage());
        }
        return new KundeEinlogen(null, false);
    }


    /**
     * Wenn Name und Passwort der Mitarbeiter richtig sind, liefert die boolean true
     *
     * @return
     * @throws CustomIoException
     */
    public boolean mitarbeiterEinloggen(String email,String pass) throws IOException {
        MItarbeiterEilogen mItarbeiterEilogen=new MItarbeiterEilogen(null,false);
        try {
            mItarbeiterEilogen=eshopVerwaltung.mitarbeiterEinloggen(email,pass);
            person=mItarbeiterEilogen.mitarbeiter;
            return mItarbeiterEilogen.gefunden;
        } catch (LoginFailedException e) {
            System.out.println( e.getMessage());
        }
        return mItarbeiterEilogen.gefunden;
    }

    public void warenEinlegen() {
        List<Artikel> artikels = new ArrayList<>();
        do {
            zeigeArtikel();
            System.out.println("Geben Sie Artikel Bezeichnung ein:");
            String name = IO.inputString();
            System.out.println("Geben Sie Anzahl der Artikel:");
            int anzahlArtikel = IO.inputInt();
            try {
                artikels.add(eshopVerwaltung.warenlegen(name, anzahlArtikel, (Kunde) person));
            } catch (BestandNichtAusreichendException e) {
                System.out.println(e.getMessage());
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("wollen sie weiter einlegen n/j");
        } while (!IO.inputString().equals("n"));

    }

    public void kundEreignis() {

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
                eshopVerwaltung.artikelAnlegen((Mitarbeiter) person, new Artikel( name, bestand, preis));
            }catch (IOException e){
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
            eshopVerwaltung.mitarbeiterAnthorRegiseren(name, namchname, passwort,email);
            System.out.println("Registrierung ist Erfolgreich Abgeschlossen");
        } catch (RegisitierungException e) {
            System.out.println(e.getMessage());
        }catch (INcorrectEmailException e){
            System.out.println(e.getMessage());
        }


    }

    public void zeigeArtikel() {
        System.out.println("Hier sind die Verfügbaren Artikeln: ");
        List<Artikel> artikels = eshopVerwaltung.artielzeigen();
        for (Artikel a : artikels) {
            System.out.println(a);
        }
    }

    public void rechnung() {
        try {
            System.out.println(eshopVerwaltung.getRec((Kunde) person, ((Kunde) person).getWarenKorp().get()));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void artikelSortieren(boolean artSort) {
        List<Artikel> artikels = eshopVerwaltung.artikelSortieren(artSort);
        for (Artikel a : artikels) {
            System.out.println(a);
        }
    }

    public void run() throws IOException {
        do {
           // persistentMitarbeiter.ladeMitarbeiter();
            System.out.println("1- Als neue Kunde Registrieren \n2- Als Kunde Einlogen\n3- Als Mitarbeiter Einlogen ");
            int s = IO.inputInt();
            switch (s) {
                case 1 -> {
                    kundeRegistrieren();
                }
                case 2 -> {
                   KundeEinlogen kundeEinlogen = kundenEinloggen("","");
                    if (kundeEinlogen.gefunden) {
                        person = kundeEinlogen.kunde;
                        System.out.println("Liegen Sie jetzt einen Artikel in dem WarenKorb: 1 oder Abmelden: 2");
                        if (IO.inputInt() == 2) {
                            run();
                        }
                        warenEinlegen();

                        System.out.println("Weiter zu Kasse ==> j/n");
                        String ein = IO.inputString();
                        if (ein.equals("j")) {
                            System.out.println("Hier können Sie Ihre Rechnung sehen : \n");
                            rechnung();

                            System.out.println("Der Ereignis ist jetzt: ");
                            kundEreignis();
                            System.out.println("Vielen Dank für Ihren Einkauf");

                        } else
                            System.out.println("Vielen Dank Ihre Warenkorb ist leer");
                    }
                }
                case 3 -> {
                    if (mitarbeiterEinloggen("","")) {

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

                                    einlagerung();

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

                }
            }
            System.out.println("Wollen Sie System beenden n/j");
        } while (IO.inputString().equals("n"));
    }
}

