package GUI.mitarbeiter;


import GUI.alert.Alert;
import GUI.services.MitarbeiterService;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

public class JFrameMitarbeiterRegistrieren extends JFrame {
    private JTextField mitarbeiterVornameTextField;
    private JTextField mitarbeiterNachnameTextField;
    private JTextField emailMitarbeiterTextField;
    private JTextField mitarbeiterPasswortTextField;

    /**
     * Launch the application.
     */
    MitarbeiterService mitarbeiterService = new MitarbeiterService();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameMitarbeiterRegistrieren frame = new JFrameMitarbeiterRegistrieren();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JFrameMitarbeiterRegistrieren() {
        setFont(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 600, 569, 405);
        getContentPane().setLayout(null);

        JLabel mitarbeiterVorname = new JLabel("Bitte geben Sie Vorname des neuen Mitarbeiter. ");
        mitarbeiterVorname.setFont(new Font("Arial", Font.PLAIN, 14));
        mitarbeiterVorname.setHorizontalAlignment(SwingConstants.CENTER);
        mitarbeiterVorname.setBounds(63, 25, 316, 19);
        getContentPane().add(mitarbeiterVorname);

        mitarbeiterVornameTextField = new JTextField();
        mitarbeiterVornameTextField.setBounds(63, 54, 316, 31);
        getContentPane().add(mitarbeiterVornameTextField);
        mitarbeiterVornameTextField.setColumns(10);

        JLabel mitarbeiterNachnameLabel = new JLabel("Bitte geben Sie nach name des neuen Mitarbeiter");
        mitarbeiterNachnameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mitarbeiterNachnameLabel.setBounds(63, 107, 316, 42);
        getContentPane().add(mitarbeiterNachnameLabel);

        mitarbeiterNachnameTextField = new JTextField();
        mitarbeiterNachnameTextField.setBounds(63, 159, 316, 31);
        getContentPane().add(mitarbeiterNachnameTextField);
        mitarbeiterNachnameTextField.setColumns(10);

        JLabel mitarbeiterEmailLabel = new JLabel("Bitte geben Sie E-Mail des neuen Mitarbeiter");
        mitarbeiterEmailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mitarbeiterEmailLabel.setBounds(63, 288, 316, 19);
        getContentPane().add(mitarbeiterEmailLabel);

        emailMitarbeiterTextField = new JTextField();
        emailMitarbeiterTextField.setBounds(63, 327, 316, 31);
        getContentPane().add(emailMitarbeiterTextField);
        emailMitarbeiterTextField.setColumns(10);

        JLabel passwortMitarbeiterLabel = new JLabel("Bitte geben Sie neuen Passwort des Mitarbeiter");
        passwortMitarbeiterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwortMitarbeiterLabel.setBounds(63, 200, 316, 19);
        getContentPane().add(passwortMitarbeiterLabel);

        mitarbeiterPasswortTextField = new JPasswordField();
        mitarbeiterPasswortTextField.setBounds(63, 233, 316, 31);
        getContentPane().add(mitarbeiterPasswortTextField);
        mitarbeiterPasswortTextField.setColumns(10);

        JButton mitarbeiterRegistringBtnNewButton = new JButton("Registriern");
        mitarbeiterRegistringBtnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        mitarbeiterRegistringBtnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        mitarbeiterRegistringBtnNewButton.setBounds(430, 326, 115, 31);
        getContentPane().add(mitarbeiterRegistringBtnNewButton);

        mitarbeiterRegistringBtnNewButton.addActionListener(mitarbeiterRegistrieren());
    }

    public ActionListener mitarbeiterRegistrieren() {
        return event -> {

            boolean antwort = mitarbeiterService.registrieren(
                    mitarbeiterVornameTextField.getText(),
                    mitarbeiterNachnameTextField.getText(),
                    mitarbeiterPasswortTextField.getText(),
                    emailMitarbeiterTextField.getText()
            );
            if (antwort) {
                new Alert(this, "Du würdest Registriert", "Registrierung Erfolgreich").showInfoMassage();
                leereFelder();
            } else
                new Alert(this, "Bereits Registriert", "Registrierung Fehlgeschlagen").showInfoMassage();
        };
    }
    public void leereFelder(){
        mitarbeiterVornameTextField.setText("");
        mitarbeiterNachnameTextField.setText("");
        mitarbeiterPasswortTextField.setText("");
        emailMitarbeiterTextField.setText("");
    }


}