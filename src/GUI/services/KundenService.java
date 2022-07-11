package GUI.services;


import GUI.alert.Alert;
import GUI.alert.Dialog;
import GUI.kunde.JFRegistieren;
import GUI.kunde.JFrameArtikel;
import GUI.kunde.JFrameKasse;
import exception.BestandNichtAusreichendException;
import exception.LoginFailedException;
import exception.NotFoundException;
import model.Artikel;
import model.Person;
import model.WarenKorp;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class KundenService implements ActionListener {
    private JTextField emailText;
    private JTextField mengeText;
    private JPasswordField passText;
    private EshopCui eshopCui;
    private JFrame parent;
    private JRadioButton mitarbeiterRadio;
    private JRadioButton kundeRadio;
    private JTable verfügbarenArtikelntextPane_1;
    private DefaultTableModel defaultTableModel;
    private JList<String> gelegteArtikel;
    DefaultListModel<String> model;
    private JTable table;
    int anzahl = 0;
    private Person person;


    public KundenService(JFrame wilcomen, JTextField emailText, JPasswordField passText, JRadioButton mitarbeiterRadio, JRadioButton kundeRadio) {
        this.mitarbeiterRadio = mitarbeiterRadio;
        this.kundeRadio = kundeRadio;
        this.parent = wilcomen;
        this.emailText = emailText;
        this.passText = passText;
        eshopCui = new EshopCui();
    }

    public KundenService(JFrame jFrameArtikel, JTextField mengeText, JList<String> gelegteArtikel, DefaultTableModel defaultTableModel, JTable jtable) {
        this.verfügbarenArtikelntextPane_1 = verfügbarenArtikelntextPane_1;
        this.mengeText = mengeText;
        this.gelegteArtikel = gelegteArtikel;
        eshopCui = new EshopCui();
        this.parent = jFrameArtikel;
        this.defaultTableModel = defaultTableModel;
        this.table = jtable;
        this.model = new DefaultListModel<>();
        model.addElement("name"+"    " +"bestand" +"    "+ "preis");
        putArtikel();
        anzahl = 0;
    }

    public KundenService(JFrameKasse jFrameKasse, JList<String> contentList) {
        this.gelegteArtikel = contentList;
        this.parent = jFrameKasse;
        this.model = new DefaultListModel<>();
        model.addElement("name"+"    " +"bestand" +"    "+ "preis");
        eshopCui=new EshopCui();
        zahlen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("anmelden")) {
            login();
        } else if (e.getActionCommand().equals("Registeren")) {
            registieren();
        } else if (e.getActionCommand().equals("+")) {
            anzahl++;
            mengeText.setText("" + anzahl);
        } else if (e.getActionCommand().equals("-")) {
            if (anzahl > 0) {
                anzahl--;
                mengeText.setText("" + anzahl);
            }
        } else if (e.getActionCommand().equals("Einfeugen")) {
            artikelEinfugen();
        } else if (e.getActionCommand().equals("kasse")) {
            parent.dispose();
            new JFrameKasse();

        } else if (e.getActionCommand().equals("entfernen")) {
            entfernenFromKorp();
        }
    }

    private void zahlen() {
       HashMap<Artikel,Integer> artikels= eshopCui.kundeWaren().get();
       List<Artikel> artikelList=eshopCui.kundeWaren().hashtoList();
       double gesamtpreis=0;
        for(int i=0;i<artikelList.size();i++){
            Artikel artikel=artikelList.get(i);
            model.addElement(artikel.getArtikelBezeichnung()+"     "+artikels.get(artikel)+"    "+(artikel.getPreis()*artikels.get(artikel)));
            gesamtpreis+=(artikel.getPreis()*artikels.get(artikel));
        }
        model.addElement("----------------------------------");
        model.addElement("gesamt Preis :  "+gesamtpreis);
        gelegteArtikel.setModel(model);
    }

    private void entfernenFromKorp() {
        Alert alert;
        try {
            if (gelegteArtikel.getSelectedIndex() >= 1) {
                String artikel[] = model.get(gelegteArtikel.getSelectedIndex()).split("    ");
                model.remove(gelegteArtikel.getSelectedIndex());
                eshopCui.returnWare(artikel[0], artikel[1]);
                putArtikel();
                return;
            } else {
                alert = new Alert(parent, "select artikel", "Artikel");
                alert.showInfoMassage();
            }
        } catch (NotFoundException e) {
            alert = new Alert(parent, e.getMessage(), "Not found");
            alert.showInfoMassage();
        } catch (Exception e) {
            alert = new Alert(parent, "Biite suchen sie Richtige Arikel aus", "Artikel");
            alert.showInfoMassage();
        }
    }

    private void artikelEinfugen() {
        String name = "";
        String bestand = "";
        String preis = "";
        try {
            name = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
            bestand = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
            preis = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
            if (Integer.parseInt(mengeText.getText()) > 0) {
                eshopCui.warenEinlegen(name, Integer.parseInt(mengeText.getText()));
                double gesamtpreis = Double.parseDouble(preis) * Integer.parseInt(mengeText.getText());
                model.addElement(name + "    " + mengeText.getText() + "    " + gesamtpreis);
                gelegteArtikel.setModel(model);
                putArtikel();
            } else {
                Alert alert = new Alert(parent, "check die Menge", "Menge");
                alert.showInfoMassage();
            }
        } catch (BestandNichtAusreichendException e) {
            Alert alert = new Alert(parent, e.getMessage(), "Menge");
            alert.showInfoMassage();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Alert alert = new Alert(parent, "bitte select Produckt", "Menge");
            alert.showInfoMassage();
        }
    }

    private void registieren() {
        parent.dispose();
        new JFRegistieren("Registieren");
    }

    private void login() {
        Alert alert;
        person = null;
        try {
            if (mitarbeiterRadio.isSelected()) {
                eshopCui.mitarbeiterEinloggen(emailText.getText(), passText.getText());
            } else
                person = eshopCui.kundenEinloggen(emailText.getText(), passText.getText()).person;
          /*  alert = new Alert(parent, "Hallo Herr :" + person.getVorName() + " ^_^", "Hallo");
            alert.showInfoMassage();*/
            Runnable readable=new Dialog();
            Thread thread=new Thread(readable);
            thread.start();
            parent.dispose();
            new JFrameArtikel();
            eshopCui.setPerson(person);
            return;
        } catch (LoginFailedException e) {
            alert = new Alert(parent, e.getMessage(), "Error");
        }
        alert.showInfoMassage();
    }

    private void putArtikel() {
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
        table.setModel(defaultTableModel);
    }


}


