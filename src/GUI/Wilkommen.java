package GUI;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class Wilkommen {
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wilkommen");
        frame.setContentPane(new Wilkommen().rootPanel);
        frame.setLocation(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();// damit die geöffnet wird
        frame.setVisible(true);
    }



}
