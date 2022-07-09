package GUI.services;


import GUI.Wilcomen;
import GUI.alert.Alert;
import GUI.kunde.JFRegistieren;
import exception.LoginFailedException;
import model.Person;
import ui.EshopCui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KundenService implements ActionListener {
    private JTextField emailText;
    private JPasswordField passText;
    private EshopCui eshopCui;
    private JFrame parent;
    private JRadioButton mitarbeiterRadio;
    private JRadioButton kundeRadio;

    public KundenService(Wilcomen wilcomen, JTextField emailText, JPasswordField passText, JRadioButton mitarbeiterRadio, JRadioButton kundeRadio) {
        this.mitarbeiterRadio = mitarbeiterRadio;
        this.kundeRadio = kundeRadio;
        this.parent = wilcomen;
        this.emailText = emailText;
        this.passText = passText;
        eshopCui = new EshopCui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("anmelden")) {
            login();
        } else {
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
            //ToDo new JFarme Artikel oder so was
            return;
        } catch (LoginFailedException e) {
            alert = new Alert(parent, e.getMessage(),"Error");
        }
        alert.showInfoMassage();
    }

}
