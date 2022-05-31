package cui;

import Domain.ArtikelVerwaltung;
import Domain.KundenVerwaltung;
import Domain.MitarbeiterVerwaltung;
import Utilities.IO;
import exception.CustomIoException;
import model.Artikel;
import model.Mitarbeiter;
import Domain.WarenkorbVerwaltung;

import java.io.*;
import java.util.ArrayList;

public class EshopCui {
    private ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
    private KundenVerwaltung kundenVerwaltung = new KundenVerwaltung();
    private MitarbeiterVerwaltung mitarbeiterList = new MitarbeiterVerwaltung();
    private WarenkorbVerwaltung artikelKaufen = new WarenkorbVerwaltung();


    public void erstelleArtikel() {
        System.out.println("Bitte geben Sie den neu Artikel Nr ein :) ");
        int artikelNr = IO.inputInt();
        System.out.println("Bitte geben Sie den Artikel Bestand ein :) ");
        int artikelbestand = IO.inputInt();
        System.out.println("Bitte geben Sie den Artikel Bezeichnung ein :) ");
        String artikelBezeichnung = IO.inputString();
        this.artikelVerwaltung.artikelAnlegen(artikelNr, artikelbestand, artikelBezeichnung);
        this.artikelVerwaltung.artikelAnlegen(1, 50, "Schwarztee");
        this.artikelVerwaltung.artikelAnlegen(20, 60, "Grüntee");
        this.artikelVerwaltung.artikelAnlegen(30,10 , "Kaffee");
        this.artikelVerwaltung.artikelAnlegen(10, 10, "Pappe");
        System.out.println(artikelVerwaltung.getArtikelList());

    }

    public void frontPageMenu() {
        System.out.println("Befehle:\nMitarbeiter Einlogen: 1");

        System.out.println("Kunden Einlogen:      2");

        System.out.println("Als Neue Kunden Registrieren:        3");

        System.out.println("Beenden: 0");

        System.out.println("Bitte von Oben genannten Zahlen eine Zahl eingeben >");
        //  int eingabeAusKonsolelesen = IO.inputInt();
        /**
         * Wie kann ich diese int eingabe Manipulieren in weiterem Methode
         * ohne den variabeln Global zu initializieren.
         */
    }
    public void loeschenArtikel(){
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
        System.out.println(artikelVerwaltung.getArtikelList().toString());
    }

    public void artikelerhohenPage(){
        System.out.println(artikelVerwaltung.getArtikelList());
        System.out.println("Bitte geben sie den Artikel Nr ein um bestand zu erhöhen");
        int artikelNr = IO.inputInt();
        System.out.println("Bitte geben Sie den neuen Bestand ein");
        int neueErhohteBestand = IO.inputInt();
        artikelVerwaltung.artikelBestandErhohen(artikelNr, neueErhohteBestand);
        System.out.println(artikelVerwaltung.getArtikelList());
    }
    public void mitarbeiterinDieListe() throws CustomIoException {
        this.mitarbeiterList.mitarbeiterAnlegen(new Mitarbeiter(1,"AJ", "Khan", "123"));
    }
    public void mitarbeiterEinlogen() throws CustomIoException {
        System.out.println("Bitte geben Sie Name ein");
        String mitarbeiterName = IO.inputString();
        System.out.println("Bitte geben Sie Passwort ein");
        String passwort = IO.inputString();

       if(mitarbeiterList.mitarbeiterUeberprufen(mitarbeiterName, passwort)){
           System.out.println("Du bist angemeldet");
           System.out.println("Neue Mitarbeiter Registrieren\t 1 \nArtikel \t 2" );
           System.out.println("Bitte geben sie von den oben genannten Zahl ein");
           int zahl = IO.inputInt();
           zweitenSwitch(zahl);
        }else{
           System.out.println("Etwas ist Schief gelaufen");
           mitarbeiterEinlogen();
       }
    }
    public void mitarbeiterRegistrieren() throws CustomIoException {
            System.out.println("Bitte geben Sie Neu ID ein");
            int mitarbeiterId = IO.inputInt();
            System.out.println("Bitte geben Sie vorname ein");
            String mitarbeiterVorname = IO.inputString();
            System.out.println("Bitte geben Sie nachname ein");
            String nachname = IO.inputString();
            System.out.println("Bitte geben Sie Passwort ein");
            String mitarbeiterPasswort = IO.inputString();
            mitarbeiterList.mitarbeiterAnlegen(new Mitarbeiter(mitarbeiterId, mitarbeiterVorname, nachname, mitarbeiterPasswort));
            System.out.println( mitarbeiterList.getMitarbeiterList().toString());
    }
    public void serialisierung() throws IOException {

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("Mitarbeiter.ser"));
            oos.writeObject(new Mitarbeiter(1, "A", "k", "1"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            oos.close();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Mitarbeiter.ser"));
           Mitarbeiter mitarbeiter = ( Mitarbeiter) ois.readObject();
            System.out.println(mitarbeiter.getVorName());
            System.out.println("komm ");
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void mitarbeiterLoeaschen(){
        System.out.println("Bitte geben Sie Mitarbeiter Vorname");
        String mitarbeiterVorname = IO.inputString();
        System.out.println("bitte geben Sie Mitarbeiter Nachname");
        String mitarbeiterNachname = IO.inputString();
        mitarbeiterList.mitarbeiterLoeaschen(mitarbeiterVorname, mitarbeiterNachname);
    }

    public void kundenKaufartikel(){
        System.out.println("Bitte geben Sie den Artikel Bezeichnung");
        String artikel = IO.inputString();
        artikelVerwaltung.artikelSuchen(artikel);
    }
    public void gesuchteArtikelkaufen(){
        System.out.println("Welche Artikel Wollen Sie kaufen bitte geben Sie Artikel NR ein");
        String artikelNr = IO.inputString();


    }
    public void zweitenSwitch(int zahl) throws CustomIoException {
        switch (zahl){
            case 1 ->{
                mitarbeiterRegistrieren();
            }
            case 2 ->{
                System.out.println("Artikel Anlegen\t 1 \nArtikel Bestand Erhöhen \t 2\nArtikel Löschen\t3");
                int artikelZahl = IO.inputInt();
                drittenSwitch(artikelZahl);
            }
        }
    }
    public void drittenSwitch(int artikelZahl){
        switch (artikelZahl){
            case 1 ->{
                erstelleArtikel();
            }
            case 2 ->{
                artikelerhohenPage();
            }
            case 3 ->{
                loeschenArtikel();
            }
        }
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
            case 3 -> {
                System.out.println("Muss noch gemacht werden");
                kundenKaufartikel();
            }
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
            cui.mitarbeiterinDieListe();
            cui.serialisierung();
            cui.run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
