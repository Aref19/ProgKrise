package GUI.services;


import Domain.EshopVerwaltung;
import GUI.alert.Alert;
import GUI.until.PdfGenerator;
import exception.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class KundenService {

    private static EshopVerwaltung eshop;
    private static Person person;
    private DefaultTableModel defaultTableModel;
    DefaultListModel<String> model;

    public KundenService() {
        defaultTableModel = new DefaultTableModel();
        model = new DefaultListModel<>();
        eshop = new EshopVerwaltung();
    }


    public void sacheKaufen() {
        saveWarenWarenKorb(true);

    }

    public void saveWarenWarenKorb(boolean buyStatus) {
        eshop.saveWaren(person, buyStatus);
    }

    public DefaultListModel kasse() {
        List<Artikel> artikelList = null;
        HashMap<Artikel, Integer> artikels = null;
        WarenKorp warenKorp;
        try {
            model = new DefaultListModel<>();
            warenKorp = eshop.kundeWaren(person);
            artikels = warenKorp.get();
            artikelList = warenKorp.hashtoList();
        } catch (NotFoundException e) {
            e.getMessage();
        }
        double gesamtpreis = 0;
        for (int i = 0; i < artikelList.size(); i++) {
            Artikel artikel = artikelList.get(i);
            model.addElement(artikel.getArtikelBezeichnung() + "     " + artikels.get(artikel) + "    " + (artikel.getPreis() * artikels.get(artikel)));
            gesamtpreis += (artikel.getPreis() * artikels.get(artikel));
        }
        model.addElement("--------------------------------------------");
        model.addElement("gesamt Preis :  " + gesamtpreis);
        return model;
    }

    public DefaultTableModel entfernenFromKorp(int index) throws NotFoundException {
        String artikel[] = model.get(index).split("    ");
        model.remove(index);
        eshop.returnArikel(artikel[0], artikel[1], person);
        return putArtikel();


    }

    public DefaultListModel artikelEinfugen(String name, String bestand, String preis, int anzahl) throws BestandNichtAusreichendException, NotFoundException {
        if (anzahl > 0) {
            eshop.warenlegen(name, anzahl, person);
            saveModel(model, name, bestand, preis, anzahl);
        }
        return model;
    }


    public Person login(String email, String pass) throws LoginFailedException {
        person = eshop.kundenEinloggen(email, pass).person;
        return person;

    }

    public DefaultTableModel putArtikel() {
        List<Artikel> artikels = eshop.artielzeigen();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Betsand");
        defaultTableModel.addColumn("Preis");
        defaultTableModel.addColumn("Masse");
        for (Artikel ar : artikels) {
            int masse = ar instanceof Massengutartikel ? ((Massengutartikel) ar).getMasse() : 1;
            if (ar.getArtikelBestand() != 0) {
                String[] artikleArray = {ar.getArtikelBezeichnung(), String.valueOf(ar.getArtikelBestand()), String.valueOf(ar.getPreis()), String.valueOf(masse)};
                defaultTableModel.addRow(artikleArray);
            }
        }
        return defaultTableModel;
    }

    public Rechnung creatPdf() {
        PdfGenerator pdfGenerator = null;
        Rechnung rechnung = null;
        try {
            rechnung = eshop.getRec(((Kunde) person), ((Kunde) person).getWarenKorp().get());
            pdfGenerator = new PdfGenerator(rechnung);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pdfGenerator.creatPdf();
        return rechnung;
    }

    public void kill(JFrame jFrame) {
        jFrame.dispose();
    }

    public void kundRegisteren(Kunde kunde, JFrame parent) {
        Alert alert = null;
        try {
            eshop.kundenRegistrieren(kunde);
            return;
        } catch (INcorrectEmailException ex) {
            alert = new Alert(parent, ex.getMessage(), "Email!");
        } catch (NumberFormatException ne) {
            alert = new Alert(parent, "das ist keine Nr\n" + ne.getMessage(), "Nummer");
        } catch (RegisitierungException regex) {
            alert = new Alert(parent, regex.getMessage(), "Registeren");
        }
        alert.showInfoMassage();

    }

    private void saveModel(DefaultListModel defaultListModel,
                           String name, String bestand, String preis, int anzahl) {
        double gesamtpreis = Double.parseDouble(preis) * anzahl;

        for (int i = 0; i < defaultListModel.size(); i++) {
            String content[] = defaultListModel.getElementAt(i).toString().split("    ");
            if (content[0].equals(name)) {
                defaultListModel.remove(i);
                anzahl = Integer.parseInt(content[1]) + anzahl;
                gesamtpreis = Double.parseDouble(preis) * anzahl;
                defaultListModel.addElement(content[0] + "    " + anzahl + "    " + gesamtpreis);
                return;
            }
        }
        model.addElement(name + "    " + anzahl + "    " + gesamtpreis);

    }


}





