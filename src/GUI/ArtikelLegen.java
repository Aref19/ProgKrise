package GUI;

import GUI.services.KundenService;

import javax.swing.*;
import java.awt.*;

public class ArtikelLegen extends JFrame {
    private JLabel artikelLegenLabel;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JPanel ButtonUndTxtFieldPanel;
    private JButton weiterZuWarenkorbButton;
    private JButton einfügenButton;
    private JButton abbrechenButton;
    private JPanel rootPanel;

    public ArtikelLegen(String title){
        super(title);
        this.setContentPane(rootPanel);
        this.setLocation(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();// damit die geöffnet wird
        this.setVisible(true);

    }
}
