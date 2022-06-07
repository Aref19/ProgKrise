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
        do {
            System.out.println("1- Als neue Kunde Registrieren \n2- Als Kunde Einlogen\n3- Als Mitarbeiter Eilogen ");
            int s = IO.inputInt();
            switch (s) {
                case 1 -> {
                    eshopCui.kundeRegistrieren();
                }
                case 2 -> {
                    KundeEinlogen kundeEinlogen = eshopCui.kundenEinloggen();
                    if (kundeEinlogen.gefunden) {
                        person = kundeEinlogen.kunde;
                        System.out.println("Liegen Sie jetzt einen Artikel in dem WarenKorb");
                        do {
                            eshopCui.warenEinlegen();
                            System.out.println("Mochten Sie weitere Artikeln hinzufugen? n/j ");
                        } while (IO.inputString().equals("j"));
                        System.out.println("Weiter zu Kasse ==> j/n");
                        String ein = IO.inputString();
                        if (ein.equals("j")) {
                            eshopCui.warenkaufen();
                            System.out.println("Hier können Sie Ihre Rechnung sehen : \n");
                            eshopCui.rechnung();
                            System.out.println("Der Ereignis ist jetzt: ");
                            System.out.println("Vielen Dank für Ihren Einkauf");

                        } else
                            System.out.println("Vielen Dank Ihre Warenkorb ist leer");
                    }
                }
                case 3 -> {
                    if (eshopCui.mitarbeiterEinloggen()) {
                        do {
                            System.out.println("Wollen Sie 1- Mitarbeiter Regestieren\n 2- Einlagerung\n3-Sortierten");
                            switch (IO.inputInt()) {
                                case 1 -> {
                                    eshopCui.mitarbeiterRegestieren();
                                }
                                case 2 -> {
                                    eshopCui.einlagerung();
                                }
                                case 3 -> {
                                    eshopCui.zeigeArtikel();
                                    System.out.println("wie wollen sie es sortieren");
                                    int sort = IO.inputInt();
                                    boolean artsort;
                                    artsort = sort == 1 ? true : false;
                                    eshopCui.artikelSortieren(artsort);
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
        return null;
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
        System.out.println("Geben Sie  Name ein:");
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
        eshopVerwaltung.kaufen();
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

    public void kundenEreignis(String na, int be) {
        //  Ereigniss ereigniss=   eshopVerwaltung.kundenEreignis(new Artikel(1,na,be,2.5));
        //   System.out.println(ereigniss);
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


}
