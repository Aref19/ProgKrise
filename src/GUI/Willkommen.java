package GUI;

import Domain.EshopVerwaltung;
import GUI.alert.Alert;
import GUI.mitarbeiter.JFrameMitarbeiterRegistrieren;
import GUI.kunde.JFRegistieren;
import GUI.services.KundenService;
import GUI.services.MitarbeiterService;
import exception.LoginFailedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Willkommen extends JFrame {
    private Container container;
    private JTextField emailText;
    private JPasswordField passText;
    private JLabel emaiJLabel;
    private JLabel pasJLabel;
    private JButton anmeldJButton;
    private JButton registereJButton;
    private Panel rootPannel;
    private ButtonGroup buttonGroup;
    private KundenService kundenService;
    JRadioButton mitarbeiterRadio;
    JRadioButton kundRadio;
    MitarbeiterService mitarbeiterService = new MitarbeiterService();
    JFrameMitarbeiterRegistrieren jFrameMitarbeiterRegistrieren = new JFrameMitarbeiterRegistrieren();

    private EshopVerwaltung eshop;

    public Willkommen(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(SystemColor.inactiveCaption);
        setBounds(100, 100, 423, 272);
        getContentPane().setLayout(null);
        initialize();
        this.setVisible(true);
        eshop = new EshopVerwaltung();
        kundenService = new KundenService(eshop);
        registereJButton.addActionListener(registrieren());
        anmeldJButton.addActionListener(einloggen());
    }

    public void initialize() {

        emaiJLabel = new JLabel("Email");
        emaiJLabel.setFont(new Font("Andalus", Font.ITALIC, 12));
        emaiJLabel.setBounds(15, 60, 46, 14);
        getContentPane().add(emaiJLabel);
        buttonGroup = new ButtonGroup();
        emailText = new JTextField();
        emailText.setBounds(80, 59, 131, 20);
        getContentPane().add(emailText);
        emailText.setColumns(10);

        pasJLabel = new JLabel("Passwort");
        pasJLabel.setFont(new Font("Andalus", Font.ITALIC, 12));
        pasJLabel.setBounds(13, 108, 60, 14);
        getContentPane().add(pasJLabel);
        passText = new JPasswordField();
        passText.setBounds(80, 105, 131, 20);
        getContentPane().add(passText);

        mitarbeiterRadio = new JRadioButton("Mitarbeiter");
        buttonGroup.add(mitarbeiterRadio);

        mitarbeiterRadio.setBounds(292, 66, 109, 23);
        getContentPane().add(mitarbeiterRadio);

        kundRadio = new JRadioButton("Kunde");
        buttonGroup.add(kundRadio);
        kundRadio.setSelected(true);
        kundRadio.setBounds(292, 104, 109, 23);
        getContentPane().add(kundRadio);

        registereJButton = new JButton("Registrieren");
        registereJButton.setFont(new Font("Andalus", Font.ITALIC, 12));
        registereJButton.setFocusable(false);
        registereJButton.setFocusPainted(false);
        registereJButton.setBounds(275, 199, 120, 23);
        getContentPane().add(registereJButton);

        anmeldJButton = new JButton("Anmelden");
        anmeldJButton.setFont(new Font("Andalus", Font.ITALIC, 12));
        anmeldJButton.setFocusable(false);
        anmeldJButton.setFocusPainted(false);
        anmeldJButton.setBounds(15, 199, 100, 23);
        getContentPane().add(anmeldJButton);


    }

    private ActionListener einloggen() {
        return e -> {
            if (mitarbeiterRadio.isSelected()) {
                boolean antwort = mitarbeiterService.anmelden(emailText.getText(), passText.getText());
                if (antwort == true) {
                    jFrameMitarbeiterRegistrieren.setVisible(true);
                } else
                    new Alert(this, "Ups! Überprüfe deine Daten", "Anmelde Fehler").showInfoMassage();
            } else if (kundRadio.isSelected()) {
                anmelden();
            }

        };
    }

    private ActionListener registrieren() {

        return e -> {
            if (kundRadio.isSelected()) {
                kundenService.kill(this);
                new JFRegistieren("Registieren");
            } else if (mitarbeiterRadio.isSelected()) {
                //ToDo Ajab
            }
        };
    }

    private void anmelden() {
        try {
            kundenService.login(emailText.getText(), passText.getText());
            kundenService.kill(this);
//            kundenService.setPerson();
        } catch (LoginFailedException ex) {
            Alert alert = new Alert(this, ex.getMessage(), "Error");
            alert.showInfoMassage();
        }
    }



    public static void main(String[] args) {
        Willkommen willkommen = new Willkommen("");
    }


}
