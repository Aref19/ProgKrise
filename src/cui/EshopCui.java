package cui;

import Domain.*;
import Utilities.IO;
import exception.CustomIoException;
import exception.NotFoundEx;
import model.*;

import java.util.List;

public class EshopCui {
    EshopVerwaltung eshopVerwaltung = new EshopVerwaltung();
    static Person person;

    public static void main(String[] args) throws CustomIoException {
        EshopCui eshopCui = new EshopCui();
        eshopCui.run();
    }

    /**
     * Kunde gibt seine Daten ein und diese Daten werden im weiteren Methode KundenRegistrierung übertragen.
     * Die klasse Kunde Constructor und Klasse Adresse Constructor werden die Daten benutzt, um Kunde zu erzeugen.
     */
    public void kundeRegistrieren() {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
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
        eshopVerwaltung.kundenRegistrieren(new Kunde(1, name, nachname, new Adresse(hausnummer, plz, stadt, strasse), passwort));
    }

    /**
     * Wenn Name und Passwort der Kunde richtig sind, liefert die boolean true
     *
     * @return
     */
    public KundeEinlogen kundenEinloggen() {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort: ");
        String passwort = IO.inputString();
        try {
            return eshopVerwaltung.kundenEinloggen(name, passwort);
        } catch (NotFoundEx notFoundEx) {
            notFoundEx.prinEror();
        }
        return new KundeEinlogen(null, false);
    }

    public void mitarbeiterRegistieren() throws CustomIoException {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr Nachname ein: ");
        String namchname = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String pass = IO.inputString();
        eshopVerwaltung.mitarbeiterRegistieren(new Mitarbeiter(2, name, namchname, pass));
    }

    /**
     * Wenn Name und Passwort der Mitarbeiter richtig sind, liefert die boolean true
     *
     * @return
     * @throws CustomIoException
     */
    public boolean mitarbeiterEinloggen() throws CustomIoException {
        System.out.println("Geben Sie Ihr Name ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String pass = IO.inputString();
        return eshopVerwaltung.mitarbeiterEinloggen(name, pass);
    }

    public void warenEinlegen() {
        zeigeArtikel();
        System.out.println("Geben Sie Artikel Bezeichnung ein:");
        String name = IO.inputString();
        System.out.println("Geben Sie Anzahl der Artikel:");
        int anzahlArtikel = IO.inputInt();
        try {
            eshopVerwaltung.warenlegen(name, anzahlArtikel, (Kunde) person);
        } catch (NotFoundEx e) {
            e.prinEror();
        }
    }

    public void warenkaufen() {
        List<Ereigniss> ereignisses = eshopVerwaltung.kaufen((Kunde) person, ((Kunde) person).getWarenKorp().get());
        for (Ereigniss gefundeneEreignisse : ereignisses) {
            System.out.println(gefundeneEreignisse);
        }
    }

    public void einlagerung() {
        System.out.println("Name des Artikels :");
        String na = IO.inputString();
        System.out.println("Bestand des Artikels :");
        int be = IO.inputInt();
        System.out.println("Der Preis ist: ");
        double pr = IO.inputdoubel();
        Ereigniss ereigniss = eshopVerwaltung.eilage(new Artikel(2, na, be, pr));
        System.out.println("sie haben jetzt");
        zeigeArtikel();
        System.out.println(ereigniss);

    }

    public void mitarbeiterRegestieren() throws CustomIoException {
        System.out.println("Geben Sie Ihr Vorname ein: ");
        String name = IO.inputString();
        System.out.println("Geben Sie Ihr Nachname ein: ");
        String namchname = IO.inputString();
        System.out.println("Geben Sie Ihr Passwort ein: ");
        String pass = IO.inputString();
        eshopVerwaltung.mitarbeiteranthorReg(new Mitarbeiter(1, name, namchname, pass));

    }

    public void zeigeArtikel() {
        System.out.println("Hier sind die Verfügbaren Artikeln: ");
        List<Artikel> artikels = eshopVerwaltung.artielzeigen();
        for (Artikel a : artikels) {
            System.out.println(a);
        }
    }

    public void rechnung() {
        System.out.println(eshopVerwaltung.getRec((Kunde) person, ((Kunde) person).getWarenKorp().get()));
    }

    public void artikelSortieren(boolean artSort) {
        List<Artikel> artikels = eshopVerwaltung.artikelSortieren(artSort);
        for (Artikel a : artikels) {
            System.out.println(a);
        }
    }

        public void run() throws CustomIoException {
            do {
                System.out.println("1- Als neue Kunde Registrieren \n2- Als Kunde Einlogen\n3- Als Mitarbeiter Einlogen ");
                int s = IO.inputInt();
                switch (s) {
                    case 1 -> {
                        kundeRegistrieren();
                    }
                    case 2 -> {
                        KundeEinlogen kundeEinlogen = kundenEinloggen();
                        if (kundeEinlogen.gefunden) {
                            person = kundeEinlogen.kunde;
                            System.out.println("Liegen Sie jetzt einen Artikel in dem WarenKorb: 1 oder Abmelden: 2");
                            if(IO.inputInt() == 2){
                                run();
                            }
                            do {
                                warenEinlegen();
                                System.out.println("Mochten Sie weitere Artikeln hinzufugen? n/j ");
                            } while (IO.inputString().equals("j"));
                            System.out.println("Weiter zu Kasse ==> j/n");
                            String ein = IO.inputString();
                            if (ein.equals("j")) {
                                System.out.println("Hier können Sie Ihre Rechnung sehen : \n");
                                rechnung();

                                System.out.println("Der Ereignis ist jetzt: ");
                                warenkaufen();
                                System.out.println("Vielen Dank für Ihren Einkauf");

                            } else
                                System.out.println("Vielen Dank Ihre Warenkorb ist leer");
                        }
                    }
                    case 3 -> {
                        if (mitarbeiterEinloggen()) {
                            do {
                                System.out.println("Wollen Sie 1- Mitarbeiter Regestieren\n 2- Einlagerung\n3-Sortierten \n 4 - abmelden");
                                    if(IO.inputInt() == 4){
                                        run();
                                    }
                                switch (IO.inputInt()) {
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
                        } else
                            System.out.println("Sie haben noch kein Account");
                    }
                }
                System.out.println("Wollen Sie System beenden n/j");
            } while (IO.inputString().equals("n"));
        }
    }

