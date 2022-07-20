package GUI.services;


import GUI.alert.Dialog;
import GUI.kunde.JFrameArtikel;
import GUI.until.PdfGenerator;
import exception.BestandNichtAusreichendException;
import exception.LoginFailedException;
import exception.NotFoundException;
import model.Artikel;
import model.Person;
import model.WarenKorp;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;

public class KundenService  {

    private static EshopCui eshopCui = new EshopCui();
    private static Person person;
    private DefaultTableModel defaultTableModel;
    DefaultListModel<String> model;

    public KundenService() {
        defaultTableModel = new DefaultTableModel();
        model = new DefaultListModel<>();
    }



    public void sacheKaufen() {
        saveWarenWarenKorb(true);

    }

    public void saveWarenWarenKorb(boolean buyStatus) {
        eshopCui.saveWaren(buyStatus);
    }

    public DefaultListModel kasse() {
        List<Artikel> artikelList = null;
        HashMap<Artikel, Integer> artikels = null;
        WarenKorp warenKorp;
        try {
            warenKorp = eshopCui.kundeWaren();
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

    public void entfernenFromKorp(int index) throws NotFoundException {

        String artikel[] = model.get(index).split("    ");
        model.remove(index);
        eshopCui.returnWare(artikel[0], artikel[1]);
        putArtikel();
        return;


    }

    public DefaultListModel artikelEinfugen(String name, String bestand, String preis, int anzahl) throws BestandNichtAusreichendException, NotFoundException {

        if (anzahl > 0) {
            eshopCui.warenEinlegen(name, anzahl);
            double gesamtpreis = Double.parseDouble(preis) * anzahl;
            model.addElement(name + "    " + anzahl + "    " + gesamtpreis);
        }
        return model;
    }


    public void login(String email, String pass) throws LoginFailedException {
        person = null;
        person = eshopCui.kundenEinloggen(email, pass).person;
        JFrameArtikel jFrameArtikel = new JFrameArtikel();
        Runnable readable = new Dialog(jFrameArtikel, "Hallo Herr/Frau :" + person.getVorName(), "Wolcame");
        Thread thread = new Thread(readable);
        thread.start();
        eshopCui.setPerson(person);
        return;

    }

    public DefaultTableModel putArtikel() {
        List<Artikel> artikels = eshopCui.zeigeArtikel();
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
       PdfGenerator pdfGenerator = new PdfGenerator(eshopCui.rechnung());
        pdfGenerator.creatPdf();
    }

    public void kill(JFrame jFrame){
        jFrame.dispose();
    }

    public void setPerson(){
        eshopCui.setPerson(person);
    }


}


