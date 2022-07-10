package GUI.services;


import GUI.Wilcomen;
import GUI.alert.Alert;
import GUI.kunde.JFRegistieren;
import GUI.kunde.JFrameArtikel;
import exception.BestandNichtAusreichendException;
import exception.LoginFailedException;
import exception.NotFoundException;
import model.Artikel;
import model.Kunde;
import model.Person;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JList<String> gefugteArtikel;
    DefaultListModel<String> model ;
    private JTable table;
    int anzahl = 0;
    private static Person person;

    public KundenService(JFrame wilcomen, JTextField emailText, JPasswordField passText, JRadioButton mitarbeiterRadio, JRadioButton kundeRadio) {
        this.mitarbeiterRadio = mitarbeiterRadio;
        this.kundeRadio = kundeRadio;
        this.parent = wilcomen;
        this.emailText = emailText;
        this.passText = passText;

        eshopCui = new EshopCui();
    }

    public KundenService(JFrame jFrameArtikel,JTextField mengeText, JList<String> gefugteArtikel, DefaultTableModel defaultTableModel, JTable jtable) {
        this.verfügbarenArtikelntextPane_1 = verfügbarenArtikelntextPane_1;
        this.mengeText = mengeText;
        this.gefugteArtikel = gefugteArtikel;
        eshopCui = new EshopCui();
        this.parent=jFrameArtikel;
        this.defaultTableModel = defaultTableModel;
        this.table = jtable;
        this.model = new DefaultListModel<>();
        model.addElement("name"+"  "+"bestand"+"  "+"preis");
        putArtikel();
        anzahl = 0;
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

        }
    }

    private void artikelEinfugen() {

        String name = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
        String bestand = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
        String preis = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
        if(Integer.parseInt(mengeText.getText())>0){
            try {
                eshopCui.warenEinlegen(name,Integer.parseInt(mengeText.getText()),(Kunde) person);
            } catch (BestandNichtAusreichendException e) {
                Alert alert=new Alert(parent,e.getMessage(),"Menge");
                alert.showInfoMassage();
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            double gesamtpreis=Double.parseDouble(preis)*Integer.parseInt(mengeText.getText());
            model.addElement(name+"   "+mengeText.getText()+"   "+gesamtpreis);
            gefugteArtikel.setModel(model);
            putArtikel();
        }else {
            Alert alert=new Alert(parent,"check die Menge","Menge");
            alert.showInfoMassage();
        }

        double gesamtPreis=Integer.valueOf(mengeText.getText())*Double.valueOf(preis);

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
            alert = new Alert(parent, "Hallo Herr :" + person.getVorName() + " ^_^", "Hallo");
            alert.showInfoMassage();
            parent.dispose();
            new JFrameArtikel();

            return;
        } catch (LoginFailedException e) {
            alert = new Alert(parent, e.getMessage(), "Error");
        }
        alert.showInfoMassage();
    }

    private void putArtikel() {
        for (int i=0;i<defaultTableModel.getRowCount();i++){
            System.out.println("removed"+defaultTableModel.getRowCount());
            defaultTableModel.removeRow(i);
        }
        List<Artikel> artikels = eshopCui.zeigeArtikel();
        for (Artikel ar : artikels) {
            String[] artikleArray = {ar.getArtikelBezeichnung(), String.valueOf(ar.getArtikelBestand()), String.valueOf(ar.getPreis())};
            defaultTableModel.addRow(artikleArray);
        }

    }

}


