package cui;

import Domain.ArtikelVerwaltung;
import Domain.EshopVerwaltung;
import Domain.KundenVerwaltung;
import Domain.MitarbeiterVerwaltung;
import Utilities.IO;
import model.Artikel;
<<<<<<< HEAD
=======
import model.Mitarbeiter;
>>>>>>> 4b3a976b672706517b406a351607da3795f7aa20

import java.awt.event.TextEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EshopCui {
<<<<<<< HEAD
   EshopVerwaltung eshopVerwaltung=new EshopVerwaltung();
=======
    private ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
    private KundenVerwaltung kundenVerwaltung = new KundenVerwaltung();
    private MitarbeiterVerwaltung mitarbeiterList = new MitarbeiterVerwaltung();
>>>>>>> 4b3a976b672706517b406a351607da3795f7aa20

    public void erstelleArtikel() {
        System.out.println("Bitte geben Sie den Artikel Nr ein :) ");
        int artikelNr = IO.inputInt();
        System.out.println("Bitte geben Sie den Artikel Bestand ein :) ");
        int artikelbestand = IO.inputInt();
        System.out.println("Bitte geben Sie den Bezeichnung ein :) ");
        String artikelBezeichnung = IO.inputString();
<<<<<<< HEAD
        this.eshopVerwaltung.artikelanLegen(new Artikel());
=======
        this.artikelVerwaltung.artikelAnlegen(artikelNr, artikelbestand, artikelBezeichnung);
        this.artikelVerwaltung.artikelAnlegen(1, 50, "Schwarztee");
        this.artikelVerwaltung.artikelAnlegen(20, 60, "Grüntee");
        this.artikelVerwaltung.artikelAnlegen(30,10 , "Kaffee");
        this.artikelVerwaltung.artikelAnlegen(10, 10, "Pappe");
        System.out.println(artikelVerwaltung.getArtikelList());

>>>>>>> 4b3a976b672706517b406a351607da3795f7aa20
    }

    public void kundenRegistrien() {
        System.out.println("Bitte geben Sie name Ein");
        String kundenName = IO.inputString();
        //this.kundenVerwaltung.kundenRegistrierenAnlegen(kundenNr, kundenName, kundenHausNr, kundenPlz, kundenStadt, kundenHerkunft);
    }

    public void frontPageMenu() {
        System.out.println("Befehle: \n Mitarbeiter Einlogen: 1");

        System.out.println(" Kunden Einlogen:      2");

        System.out.println(" Als Neue Kunden Registrieren:        3");

        System.out.println(" Beenden: 0");

        System.out.println(" Bitte von Oben genannten Zahlen eine Zahl eingeben >");
        //  int eingabeAusKonsolelesen = IO.inputInt();
        /**
         * Wie kann ich diese int eingabe Manipulieren in weiterem Methode
         * ohne den variabeln Global zu initializieren.
         */
    }
    public void loeschenPage(){
        System.out.println("Was wollen Sie Löschen? Bitte bezeichnung eingeben");
        String eingegebeneBezeichnung = IO.inputString();
        ArrayList<Artikel> gespeicherteGefundenArtikelList = artikelVerwaltung.artikelSuchen(eingegebeneBezeichnung);
        if(gespeicherteGefundenArtikelList.size() <= 0){
            System.out.println("Gibt nichts zum Löschen");
        } else if (gespeicherteGefundenArtikelList.size() == 1) {
            artikelVerwaltung.artikelLoeschen(gespeicherteGefundenArtikelList.get(0));
        } else {
            System.out.println("Welcher Artikel genauer? Bitte Artikel Nr eingeben");
            System.out.println(gespeicherteGefundenArtikelList);
            int artikelNr = IO.inputInt();
            for (Artikel artikel: gespeicherteGefundenArtikelList) {
                if(artikel.getArtikelNr() == artikelNr){
                    artikelVerwaltung.artikelLoeschen(artikel);
                }
            }
        }
        System.out.println(artikelVerwaltung.getArtikelList());
    }

    public void artikelerhohenPage(){
        System.out.println("Bitte geben sie den Artikel Nr ein um bestand zu erhöhen");
        int artikelNr = IO.inputInt();
        System.out.println("Bitte geben Sie den neuen Bestand ein");
        int neueErhohteBestand = IO.inputInt();
        artikelVerwaltung.artikelBestandErhohen(artikelNr, neueErhohteBestand);
        System.out.println(artikelVerwaltung.getArtikelList());
    }

    public void mitarbeiterEinlogen(){
        System.out.println("Bitte geben Sie Name ein");
        String mitarbeiterName = IO.inputString();
        System.out.println("Bitte geben Sie Passwort ein");
        String passwort = IO.inputString();
       this.mitarbeiterList.mitarbeiterAnlegen(new Mitarbeiter(1,"Ajab", "Khan"));
       mitarbeiterList.mitarbeiterUeberprufen(mitarbeiterName, 0);

    }

    public int eingabeAusKonsoleLesen() {
        return IO.inputInt();
    }

    public void folgtEingabeVomFrontPage(int consolZahl) throws IOException {
        /*
            TODO
             */
        switch (consolZahl) {
            case 1 -> {
                mitarbeiterEinlogen();
            }
            case 2 -> {
                System.out.println("Name eingeben");

                System.out.println("Passwort Eingeben");
            }
            case 3 -> System.out.println("Muss noch gemacht werden");

            default -> throw new IOException("Die Zahl ist außer Menu " + consolZahl);
        }

    }

    public void run() throws IOException {
        int eingabeAusKonsoleLesen;
        frontPageMenu();

        eingabeAusKonsoleLesen = eingabeAusKonsoleLesen();
        folgtEingabeVomFrontPage(eingabeAusKonsoleLesen);

    }

    public static void main(String[] args) {

        EshopCui cui = new EshopCui();

        try {
            cui.run();
            cui.erstelleArtikel();
            cui.loeschenPage();
            cui.artikelerhohenPage();
            cui.mitarbeiterEinlogen();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;

        }

        // cui.erstelleArtikel();
    }



}
