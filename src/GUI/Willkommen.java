package GUI;

import GUI.alert.Alert;
import GUI.alert.Dialog;
import GUI.kunde.JFrameArtikel;
import GUI.kunde.JFRegistieren;
import GUI.mitarbeiter.JFrameMitarbeiter;
import GUI.mitarbeiter.JFrameNewMitarbeiter;
import GUI.services.KundenService;
import GUI.services.MitarbeiterService;
import exception.LoginFailedException;
import model.Person;

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
    JFrameNewMitarbeiter jFrameMitarbeiterRegistrieren ;
    public Willkommen() throws HeadlessException {
        this.setTitle("Willkommen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(SystemColor.inactiveCaption);
        setBounds(100, 100, 423, 272);
        getContentPane().setLayout(null);
        initialize();
        this.setVisible(true);
        kundenService = new KundenService();
        registereJButton.addActionListener(registrieren());
        anmeldJButton.addActionListener(einloggen());
    }

    /**

     * Hier sind die GUI Attribute erstellt und Positioniert
     */
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


            JLabel lblWillkommen = new JLabel("Willkommen");
            lblWillkommen.setVerticalTextPosition(SwingConstants.TOP);
            lblWillkommen.setFont(new Font("Andalus", Font.BOLD, 14));
            lblWillkommen.setBounds(165, 10, 89, 13);
            getContentPane().add(lblWillkommen);


    }

    /**
     * Einloggen Methode
     * Wenn aus der Groupbutton "Mitarbeiter" ausgewählt ist, dann
     * geht auf die mitarbeiterservice und loggt sich als Mitarbeiter ein
     * Ansonsten als Kunde anmelden
     * @return
     */
    private ActionListener einloggen() {
        return e -> {
            if (mitarbeiterRadio.isSelected()) {
                try {
                    mitarbeiterService.anmelden(emailText.getText(), passText.getText());
                    new JFrameMitarbeiter(mitarbeiterService);
                            dispose();
                } catch (LoginFailedException ex) {
                    new Alert(this, ex.getMessage(), "Anmelde Fehler").showInfoMassage();
                }

            } else if (kundRadio.isSelected()) {
                anmelden();
            }

        };
    }

    /**
     * Wenn aus der Groupbutton "Kunde" ausgewählt ist, dann
     *geht auf die Kundenservice und registriert sich als Kunde
     * Ansonsten als Mitarbeiter anmelden, um neuer Mitarbeiter registrieren zu können
     * @return
     */
    private ActionListener registrieren() {

        return e -> {
            if (kundRadio.isSelected()) {
                dispose();
                new JFRegistieren(kundenService);
            } else if (mitarbeiterRadio.isSelected()) {
                Alert alert=new Alert(this,"Melden Sie sich zu erst als Mitarbeiter","Vorsicht");
                alert.showInfoMassage();
            }
        };
    }


    /**
     * Hier wird der Kunde sich anmelden
     * Wenn er sich erfolgreich angemeldet hat, dann wird ein Begrüßungsfenster Angezeigt
     * Wenn die Daten nicht vorhanden sind, dann wird ein Exception geworfen "Sie haben noch kein Account"
     */
    private void anmelden() {
        try {
           Person person= kundenService.login(emailText.getText(), passText.getText());
            dispose();

            JFrameArtikel jFrameArtikel = new JFrameArtikel(kundenService);
            Runnable readable = new Dialog(jFrameArtikel, "Hallo   " + person.getVorName(), "Willkommen");
            Thread thread = new Thread(readable);
            thread.start();
        } catch (LoginFailedException ex) {
            Alert alert = new Alert(this, ex.getMessage(), "Error");
            alert.showInfoMassage();
        }
    }



    public static void main(String[] args) {
        Willkommen willkommen = new Willkommen();
    }


}
