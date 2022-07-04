package GUI;

import GUI.services.KundenService;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Wilkommen extends  JFrame{
    private JPanel kundeEinloggen;
    private JPanel willkommenPanel;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPanel mitarbeiterPanel;
    private JTextField textField1;
    private JPasswordField passwordField2;
    private JButton überprüfenButton;
    private JButton einloggenButton;
    private JPanel rootPanel;
    private KundenService kundenService;

    public Wilkommen(String title) {
        super(title);
        this.setContentPane(rootPanel);
        this.setLocation(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();// damit die geöffnet wird
        this.setVisible(true);
        kundenService=new KundenService(this,emailField,passwordField1);
        überprüfenButton.addActionListener(kundenService);
    }



    public static void main(String[] args) {
        Wilkommen Wilkommen=new Wilkommen("Wilkommen");

    }

}
