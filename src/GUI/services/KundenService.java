package GUI.services;

import GUI.ArtikelLegen;
import GUI.KundeRegistrieren;
import GUI.Wilkommen;
import GUI.alert.RegisterungAlert;
import model.Einlogen;
import ui.EshopCui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KundenService implements ActionListener {
    private JTextField emailText;
    private JPasswordField passwordField;
    private EshopCui eshopCui;
    Wilkommen willkommenPanel;
    public KundenService(Wilkommen willkommenPanel, JTextField emailText, JPasswordField passwordField) {
        this.willkommenPanel=willkommenPanel;
        eshopCui = new EshopCui();
        this.emailText = emailText;
        this.passwordField = passwordField;
    }

    public Einlogen kundeUeberpruefen(){
        System.out.println(passwordField.getText());
      return  eshopCui.kundenEinloggen(emailText.getText(),passwordField.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(kundeUeberpruefen().gefunden){
            willkommenPanel.setVisible(false);
           willkommenPanel.dispose();
            ArtikelLegen artikelLegen=new ArtikelLegen("Artikel");

        }else {
            RegisterungAlert registerungAlert=new RegisterungAlert("OOH");
            registerungAlert.show();
            willkommenPanel.setVisible(false);
            willkommenPanel.dispose();
            KundeRegistrieren kundeRegistrieren=new KundeRegistrieren("KundenRegisteren");
        }
    }
}
