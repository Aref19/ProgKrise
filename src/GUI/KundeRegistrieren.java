package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class KundeRegistrieren extends  JFrame {
    private JPanel rootPanel;
    private JTextField vornameTxtField;
    private JTextField nachnametextField2;
    private JTextField straßetextField3;
    private JLabel hauNr;
    private JTextField hausNrtextField1;
    private JLabel stadtPanel;
    private JTextField stadttextField1;
    private JLabel plzPanel;
    private JTextField plztextField1;
    private JLabel vorname;
    private JLabel nachname;
    private JLabel straße;
    private JLabel emailPanel;
    private JLabel Passwort;
    private JButton bestätigen;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public KundeRegistrieren(String title)  {
        super(title);
        this.setContentPane(rootPanel);
        this.setLocation(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();// damit die geöffnet wird
        this.setVisible(true);
    }
}




