package GUI.mitarbeiter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFrameMitarbeiterEinlagerung extends JFrame {

    private JPanel contentPane;
    private JLabel lblNeueArtikelnEinlagern;
    private JLabel lblNewLabel;
    private JLabel lblBestandDesArtikels;
    private JTextField textField;
    private JTextField textField_1;
    private JButton btnEinfgen;
    private JButton btnZurStartseite;

    public JFrameMitarbeiterEinlagerung()  {
       this.setVisible(true);
       initGUI();
    }

    public static void main(String[] args) {
        new JFrameMitarbeiterEinlagerung();
    }

    private void initGUI() {
        setBounds(new Rectangle(20, 20, 20, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 255);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblNeueArtikelnEinlagern = new JLabel("Neue Artikeln Einlagern");
            lblNeueArtikelnEinlagern.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
            lblNeueArtikelnEinlagern.setBounds(103, 10, 273, 13);
            contentPane.add(lblNeueArtikelnEinlagern);
        }
        {
            lblNewLabel = new JLabel("Name des Artikels");
            lblNewLabel.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblNewLabel.setBounds(10, 65, 182, 13);
            contentPane.add(lblNewLabel);
        }
        {
            lblBestandDesArtikels = new JLabel("Bestand des Artikels");
            lblBestandDesArtikels.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblBestandDesArtikels.setBounds(10, 125, 182, 13);
            contentPane.add(lblBestandDesArtikels);
        }
        {
            textField = new JTextField();
            textField.setBounds(133, 62, 173, 19);
            contentPane.add(textField);
            textField.setColumns(10);
        }
        {
            textField_1 = new JTextField();
            textField_1.setColumns(10);
            textField_1.setBounds(133, 122, 173, 19);
            contentPane.add(textField_1);
        }
        {
            btnEinfgen = new JButton("Einf\u00FCgen");
            btnEinfgen.setFocusPainted(false);
            btnEinfgen.setFocusable(false);
            btnEinfgen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnEinfgen.setBounds(291, 185, 85, 21);
            contentPane.add(btnEinfgen);
        }
        {
            btnZurStartseite = new JButton("Zur Startseite");
            btnZurStartseite.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnZurStartseite.setFocusable(false);
            btnZurStartseite.setFocusPainted(false);
            btnZurStartseite.setBounds(10, 185, 105, 21);
            contentPane.add(btnZurStartseite);
        }
    }
}
