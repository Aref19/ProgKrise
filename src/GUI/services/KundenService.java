package GUI.services;


import Domain.EshopVerwaltung;
import GUI.alert.Dialog;
import GUI.kunde.JFrameArtikel;
import GUI.until.PdfGenerator;
import exception.BestandNichtAusreichendException;
import exception.LoginFailedException;
import exception.NotFoundException;
import model.*;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class KundenService  {

//    private static EshopCui eshopCui = new EshopCui();
    private static Person person;
    private DefaultTableModel defaultTableModel;
    DefaultListModel<String> model;

    private EshopVerwaltung eshop;

    public KundenService(EshopVerwaltung eshop) {
        this.eshop = eshop;
        defaultTableModel = new DefaultTableModel();
        model = new DefaultListModel<>();
    }

    public void sacheKaufen() {
        saveWarenWarenKorb(true);

    }

    public void saveWarenWarenKorb(boolean buyStatus) {
//        eshopCui.saveWaren(buyStatus);
        eshop.saveWaren(person, buyStatus);
    }

    public DefaultListModel kasse() {
        List<Artikel> artikelList = null;
        HashMap<Artikel, Integer> artikelHash = null;
        WarenKorp warenKorp;
        try {
            model=new DefaultListModel<>();
//            warenKorp = eshopCui.kundeWaren();
            warenKorp = eshop.kundeWaren(person);
            artikelHash = warenKorp.get();
            artikelList = warenKorp.hashtoList();
        } catch (NotFoundException e) {
            e.getMessage();
        }
        double gesamtpreis = 0;
        for (Artikel artikel:artikelList) {
            Artikel artikel1 = artikel;
            model.addElement(artikel1.getArtikelBezeichnung() + "     " + artikelHash.get(artikel1) + "    " + (artikel1.getPreis() * artikelHash.get(artikel1)));
            gesamtpreis += (artikel1.getPreis() * artikelHash.get(artikel1));
        }
        model.addElement("--------------------------------------------");
        model.addElement("gesamt Preis :  " + gesamtpreis);
        return model;
    }

    public void entfernenFromKorp(int index) throws NotFoundException {

        String artikeldaten[] = model.get(index).split("    ");
        model.remove(index);
//        eshopCui.returnWare(artikel[0], artikel[1]);
        eshop.returnArikel(artikeldaten[0], artikeldaten[1], person);
        putArtikel();
        return;


    }

    public DefaultListModel artikelEinfugen(String name, String bestand, String preis, int anzahl) throws BestandNichtAusreichendException, NotFoundException {

        if (anzahl > 0) {
//            eshopCui.warenEinlegen(name, anzahl);
            eshop.warenlegen(name, anzahl, person);
            double gesamtpreis = Double.parseDouble(preis) * anzahl;
            model.addElement(name + "    " + anzahl + "    " + gesamtpreis);
        }
        return model;
    }


    public void login(String email, String pass) throws LoginFailedException {
//        person = eshopCui.kundenEinloggen(email, pass).person;
        person = eshop.kundenEinloggen(email, pass).person;
//        eshopCui.setPerson(person);
        JFrameArtikel jFrameArtikel = new JFrameArtikel(this);
        Runnable readable = new Dialog(jFrameArtikel, "Hallo Herr/Frau :" + person.getVorName(), "Wolcame");
        Thread thread = new Thread(readable);
        thread.start();
        return;

    }

    public DefaultTableModel putArtikel() {
//        List<Artikel> artikels = eshopCui.zeigeArtikel();
        List<Artikel> artikels = eshop.artielzeigen();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("betsand");
        defaultTableModel.addColumn("preis");
        for (Artikel ar : artikels) {
            if (ar.getArtikelBestand() != 0) {
                String[] artikleArray = {ar.getArtikelBezeichnung(), String.valueOf(ar.getArtikelBestand()), String.valueOf(ar.getPreis())};
                defaultTableModel.addRow(artikleArray);
            }
        }
        return defaultTableModel;
    }

    public void creatPdf(){
//       PdfGenerator pdfGenerator = new PdfGenerator(eshopCui.rechnung());
        try {
            Rechnung re = eshop.getRec((Kunde) person, ((Kunde) person).getWarenKorp().get());
            PdfGenerator pdfGenerator = new PdfGenerator(re);
            pdfGenerator.creatPdf();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void kill(JFrame jFrame){
        jFrame.dispose();
    }

//    public void setPerson(){
//        eshopCui.setPerson(person);
//    }


}


