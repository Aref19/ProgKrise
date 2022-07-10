package GUI.services;


import GUI.Wilcomen;
import GUI.alert.Alert;
import GUI.kunde.JFRegistieren;
import GUI.kunde.JFrameArtikel;
import exception.LoginFailedException;
import model.Artikel;
import model.Person;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class KundenService implements ActionListener {
    private JTextField emailText;
    private JPasswordField passText;
    private EshopCui eshopCui;
    private JFrame parent;
    private JRadioButton mitarbeiterRadio;
    private JRadioButton kundeRadio;
    private JTable verfügbarenArtikelntextPane_1;
    private DefaultTableModel defaultTableModel;
    private  JList<Artikel> menge;
    private  DefaultListModel<Artikel> demoList;

    public KundenService(Wilcomen wilcomen, JTextField emailText, JPasswordField passText, JRadioButton mitarbeiterRadio, JRadioButton kundeRadio) {
        this.mitarbeiterRadio = mitarbeiterRadio;
        this.kundeRadio = kundeRadio;
        this.parent = wilcomen;
        this.emailText = emailText;
        this.passText = passText;

        eshopCui = new EshopCui();
    }

    public KundenService(JTable verfügbarenArtikelntextPane_1, JList<Artikel> menge, DefaultTableModel defaultTableModel) {
        this.verfügbarenArtikelntextPane_1=verfügbarenArtikelntextPane_1;
        this.menge=menge;
        eshopCui = new EshopCui();
        this.defaultTableModel=defaultTableModel;
        putArtikel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("anmelden")) {
            login();

        } else if(e.getActionCommand().equals("Registeren")){
            registieren();
        }
    }

    private void registieren() {
        parent.dispose();
        new JFRegistieren("Registieren");
    }


    private void login() {
        Alert alert;
        Person person = null;
        try {
            if (mitarbeiterRadio.isSelected()) {
                eshopCui.mitarbeiterEinloggen(emailText.getText(), passText.getText());
            } else
            person = eshopCui.kundenEinloggen(emailText.getText(), passText.getText()).person;
            alert = new Alert(parent, "Hallo Herr :" + person.getVorName() + " ^_^","Hallo");
            alert.showInfoMassage();
            parent.dispose();
            new JFrameArtikel();

            return;
        } catch (LoginFailedException e) {
            alert = new Alert(parent, e.getMessage(),"Error");
        }
        alert.showInfoMassage();
    }
    private void putArtikel(){
       List<Artikel>artikels=eshopCui.zeigeArtikel();
        demoList=new DefaultListModel();
        verfügbarenArtikelntextPane_1.add(new JLabel("bestand"));
        for (Artikel ar:artikels) {
            String [] artikleArray={ar.getArtikelBezeichnung(),String.valueOf(ar.getArtikelBestand()),String.valueOf(ar.getPreis())};
            defaultTableModel.addRow(artikleArray);
            }

        }

    }


