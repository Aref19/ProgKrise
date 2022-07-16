package GUI.mitarbeiter;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JFrameMitarbeiterRegistrieren extends JFrame {
    private JTextField mitarbeiterVornameTextField;
    private JTextField mitarbeiterNachnameTextField;
    private JTextField emailMitarbeiterTextField;
    private JTextField mitarbeiterPasswortTextField;

    /**
     * Launch the application.
     */
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
        mitarbeiterEmailLabel.setBounds(63, 200, 316, 19);
        getContentPane().add(mitarbeiterEmailLabel);

        emailMitarbeiterTextField = new JTextField();
        emailMitarbeiterTextField.setBounds(63, 233, 316, 31);
        getContentPane().add(emailMitarbeiterTextField);
        emailMitarbeiterTextField.setColumns(10);

        JLabel passwortMitarbeiterLabel = new JLabel("Bitte geben Sie neuen Passwort des Mitarbeiter");
        passwortMitarbeiterLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwortMitarbeiterLabel.setBounds(63, 288, 316, 19);
        getContentPane().add(passwortMitarbeiterLabel);

        mitarbeiterPasswortTextField = new JTextField();
        mitarbeiterPasswortTextField.setBounds(63, 327, 316, 31);
        getContentPane().add(mitarbeiterPasswortTextField);
        mitarbeiterPasswortTextField.setColumns(10);

        JButton mitarbeiterRegistringBtnNewButton = new JButton("Registriern");
        mitarbeiterRegistringBtnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        mitarbeiterRegistringBtnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        mitarbeiterRegistringBtnNewButton.setBounds(430, 326, 115, 31);
        getContentPane().add(mitarbeiterRegistringBtnNewButton);
    }
}

