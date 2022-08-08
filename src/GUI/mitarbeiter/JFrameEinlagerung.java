package GUI.mitarbeiter;

import GUI.services.MitarbeiterService;
import model.Artikel;
import model.Massengutartikel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JFrameEinlagerung extends JFrame {

    private JPanel contentPane;
    private JLabel lblArtikelEinlagern;
    private JLabel lblNameDesArtikels;
    private JLabel lblBestandDesArtikels;
    private JLabel lblPreis;
    private JLabel lblMasse;
    private JTextField txtName;
    private JTextField txtBestand;
    private JTextField txtPreis;
    private JTextField txtMasse;
    private JButton btnEinfgen;
    private JButton btnZurck;
    private MitarbeiterService mitarbeiterService;

    public JFrameEinlagerung(MitarbeiterService mitarbeiterService) {
        this.setVisible(true);
        initGUI();
        btnZurck.addActionListener(back());
        btnEinfgen.addActionListener(artikelFugen());
        this.mitarbeiterService = mitarbeiterService;

    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblArtikelEinlagern = new JLabel("Artikel Einlagern");
            lblArtikelEinlagern.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 13));
            lblArtikelEinlagern.setBounds(137, 10, 192, 55);
            contentPane.add(lblArtikelEinlagern);
        }
        {
            lblNameDesArtikels = new JLabel("Name des Artikels");
            lblNameDesArtikels.setFont(new Font("Andalus", Font.ITALIC, 11));
            lblNameDesArtikels.setBounds(10, 95, 104, 13);
            contentPane.add(lblNameDesArtikels);
        }
        {
            lblBestandDesArtikels = new JLabel("Bestand des Artikels");
            lblBestandDesArtikels.setFont(new Font("Andalus", Font.ITALIC, 11));
            lblBestandDesArtikels.setBounds(10, 136, 104, 13);
            contentPane.add(lblBestandDesArtikels);
        }
        {
            lblPreis = new JLabel("Preis");
            lblPreis.setFont(new Font("Andalus", Font.ITALIC, 11));
            lblPreis.setBounds(10, 177, 104, 13);
            contentPane.add(lblPreis);
        }
        {
            lblMasse = new JLabel("Masse");
            lblMasse.setFont(new Font("Andalus", Font.ITALIC, 11));
            lblMasse.setBounds(10, 224, 104, 13);
            contentPane.add(lblMasse);
        }
        {
            txtName = new JTextField();
            txtName.setBounds(137, 92, 192, 19);
            contentPane.add(txtName);
            txtName.setColumns(10);
        }
        {
            txtBestand = new JTextField();
            txtBestand.setColumns(10);
            txtBestand.setBounds(137, 133, 192, 19);
            contentPane.add(txtBestand);
        }
        {
            txtPreis = new JTextField();
            txtPreis.setColumns(10);
            txtPreis.setBounds(137, 174, 192, 19);
            contentPane.add(txtPreis);
        }
        {
            txtMasse = new JTextField();
            txtMasse.setColumns(10);
            txtMasse.setBounds(137, 221, 192, 19);
            contentPane.add(txtMasse);
        }
        {
            btnEinfgen = new JButton("Einf\u00FCgen");
            btnEinfgen.setFocusPainted(false);
            btnEinfgen.setFocusable(false);
            btnEinfgen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnEinfgen.setBounds(291, 282, 85, 21);
            contentPane.add(btnEinfgen);
        }
        {
            btnZurck = new JButton("Zur\u00FCck");
            btnZurck.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnZurck.setFocusable(false);
            btnZurck.setFocusPainted(false);
            btnZurck.setBounds(10, 282, 85, 21);
            contentPane.add(btnZurck);
        }
    }

    public ActionListener back() {
        return e -> {
            new JFrameMitarbeiter(mitarbeiterService);
            this.dispose();

        };
    }

    private ActionListener artikelFugen() {
        return e -> {
            try {
                if (Integer.parseInt(txtMasse.getText()) > 1) {
                    mitarbeiterService.artikelLegen(new
                            Massengutartikel(
                            txtName.getText()
                            , Integer.parseInt(txtBestand.getText())
                            , Double.parseDouble(txtPreis.getText()),
                            Integer.valueOf(txtMasse.getText())));
                } else {
                    mitarbeiterService.artikelLegen(new
                            Artikel(
                            txtName.getText()
                            , Integer.parseInt(txtBestand.getText())
                            , Double.parseDouble(txtPreis.getText())));
                }

                leereFelder();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }

    public void leereFelder() {
        txtName.setText("");
        txtBestand.setText("");
        txtPreis.setText("");
        txtMasse.setText("");

    }

}


