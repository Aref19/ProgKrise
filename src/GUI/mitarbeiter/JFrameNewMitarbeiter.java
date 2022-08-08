package GUI.mitarbeiter;

import GUI.Willkommen;
import GUI.alert.Alert;
import GUI.services.MitarbeiterService;
import exception.EmailExisted;
import exception.INcorrectEmailException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton btnZurck;

    MitarbeiterService mitarbeiterService = new MitarbeiterService();
    public JFrameNewMitarbeiter(){
        initGUI();
        this.setVisible(true);
        this.setLocation(400,40);
        btnRegistrieren.addActionListener(mitarbeiterRegistrieren());
        btnZurck.addActionListener(back());
    }



    public static void main(String[] args) {
        new JFrameNewMitarbeiter();
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 410, 365);
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
            btnRegistrieren.setBounds(250, 303, 140, 21);
            contentPane.add(btnRegistrieren);
        }
        {
            btnZurck = new JButton("Zur\u00FCck");
            btnZurck.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                }
            });
            btnZurck.setFocusPainted(false);
            btnZurck.setFocusable(false);
            btnZurck.setFont(new Font("Andalus", Font.ITALIC, 13));
            btnZurck.setBounds(10, 303, 140, 21);
            contentPane.add(btnZurck);
        }

    }
    public ActionListener mitarbeiterRegistrieren() {
        return event -> {

            boolean antwort = false;
            if(checkData(textFieldVorname ,textFieldNachname,passwordField,textFieldEmail)){
                try {
                    antwort = mitarbeiterService.registrieren(
                            textFieldVorname.getText(),
                            textFieldNachname.getText(),
                            passwordField.getText(),
                            textFieldEmail.getText()
                    );
                } catch(EmailExisted e){
                    new Alert(this, "check Email Existed", "Registrierung ").showInfoMassage();
                } catch(INcorrectEmailException e){
                    new Alert(this, "check Email", "Registrierung ").showInfoMassage();
                }
                if (antwort) {
                    new Alert(this, "Du würdest Registriert", "Registrierung Erfolgreich").showInfoMassage();
                    leereFelder();
                    new JFrameMitarbeiter(mitarbeiterService);
                    this.dispose();
                }
            }else
                new Alert(this, "one Field Text is empty", "Registrierung Erfolgreich").showInfoMassage();

        };
    }
    public void leereFelder(){
        textFieldVorname.setText("");
        textFieldNachname.setText("");
        passwordField.setText("");
        textFieldEmail.setText("");

    }

    public boolean checkData(JTextField...textFields){
        for (JTextField jTextField : textFields){
            if(jTextField.getText().equals("")){
                return false;
            }
        }
        return true;
    }

    public ActionListener back(){
        return e->{
            new JFrameMitarbeiter(mitarbeiterService);
            this.dispose();
        };
    }


}
