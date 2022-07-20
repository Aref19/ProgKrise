package GUI.mitarbeiter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFrameNewMitarbeiter extends JFrame {

    private JPanel contentPane;
    private JLabel lblNeuerMitarbeiterRegistrieren;
    private JLabel lblVorname;
    private JTextField textFieldVorname;
    private JLabel lblNachname;
    private JTextField textFieldNachname;
    private JLabel lblEmail;
    private JTextField textFieldEmail;
    private JLabel lblPasswort;
    private JPasswordField passwordField;
    private JButton btnRegistrieren;


    public JFrameNewMitarbeiter(){
        initGUI();
        this.setVisible(true);
        this.setLocation(400,40);
    }

    public static void main(String[] args) {
       new JFrameNewMitarbeiter();
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 365);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        setContentPane(contentPane);
        contentPane.setLayout(null);


        {

            lblNeuerMitarbeiterRegistrieren = new JLabel("Neuer Mitarbeiter Registrieren");
            lblNeuerMitarbeiterRegistrieren.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
            lblNeuerMitarbeiterRegistrieren.setBounds(79, 10, 216, 23);
            contentPane.add(lblNeuerMitarbeiterRegistrieren);
        }

        {
            lblVorname = new JLabel("Geben Sie die Vorname ein");
            lblVorname.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblVorname.setBounds(10, 83, 147, 13);
            contentPane.add(lblVorname);


        }

        {
            textFieldVorname = new JTextField();
            textFieldVorname.setBounds(167, 80, 209, 19);
            contentPane.add(textFieldVorname);
            textFieldVorname.setColumns(10);
        }


        {
            lblNachname = new JLabel("Geben Sie die Nachname ein");
            lblNachname.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblNachname.setBounds(10, 133, 147, 13);
            contentPane.add(lblNachname);
        }


        {
            textFieldNachname = new JTextField();
            textFieldNachname.setColumns(10);
            textFieldNachname.setBounds(167, 130, 209, 19);
            contentPane.add(textFieldNachname);
        }


        {
            lblEmail = new JLabel("Email-Adresse");
            lblEmail.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblEmail.setBounds(10, 188, 147, 13);
            contentPane.add(lblEmail);
        }


        {
            textFieldEmail = new JTextField();
            textFieldEmail.setColumns(10);
            textFieldEmail.setBounds(167, 185, 209, 19);
            contentPane.add(textFieldEmail);
        }


        {
            lblPasswort = new JLabel("Passwort");
            lblPasswort.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblPasswort.setBounds(10, 236, 147, 13);
            contentPane.add(lblPasswort);
        }


        {
            passwordField = new JPasswordField();
            passwordField.setBounds(167, 233, 209, 19);
            contentPane.add(passwordField);
        }


        {
            btnRegistrieren = new JButton("Registrieren");
            btnRegistrieren.setFocusPainted(false);
            btnRegistrieren.setFocusable(false);
            btnRegistrieren.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnRegistrieren.setBounds(10, 303, 366, 21);
            contentPane.add(btnRegistrieren);
        }

    }
}
