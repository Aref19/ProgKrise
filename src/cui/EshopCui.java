package cui;

import Domain.ArtikelVerwaltung;
import Domain.EshopVerwaltung;
import Domain.KundenVerwaltung;
import Utilities.IO;
import model.Artikel;

import java.io.IOException;

public class EshopCui {
   EshopVerwaltung eshopVerwaltung=new EshopVerwaltung();

    public void erstelleArtikel() {
        System.out.println("Bitte geben Sie den Artikel Nr ein :) ");
        int artikelNr = IO.inputInt();
        System.out.println("Bitte geben Sie den Artikel Bestand ein :) ");
        int artikelbestand = IO.inputInt();
        System.out.println("Bitte geben Sie den Bezeichnung ein :) ");
        String artikelBezeichnung = IO.inputString();
        this.eshopVerwaltung.artikelanLegen(new Artikel());
    }

    public void kundenRegistrien(){
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

    public int eingabeAusKonsoleLesen(){
        return IO.inputInt();
    }

    public void folgtEingabeVomFrontPage(int consolZahl) throws IOException {





        /*
            TODO
             */
        switch (consolZahl) {
            case 1 -> {
                System.out.println("Name eingeben");
                System.out.println("Passwort eingeben");
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
        } catch (IOException e) {
            System.out.println(e.getMessage());;

        }

        // cui.erstelleArtikel();
    }

}
