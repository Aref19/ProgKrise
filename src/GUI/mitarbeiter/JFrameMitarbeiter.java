package GUI.mitarbeiter;

import GUI.services.MitarbeiterService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMitarbeiter extends JFrame {

    private JPanel contentPane;
    private JLabel lblMitarbeiter;
    private JButton btnArtikelAnzeigen;
    private JButton btnNeuerMitarbeiterHinzufgen;
    private JButton btnArtkelnEinlagern;
    private JButton btnEreignissAnzeigen;

    private MitarbeiterService mitarbeiterService;

    public JFrameMitarbeiter(MitarbeiterService mitarbeiterService) {
        this.setVisible(true);
        initGUI();
        this.mitarbeiterService=mitarbeiterService;
        btnNeuerMitarbeiterHinzufgen.addActionListener(newMitarbeiter());
        btnArtikelAnzeigen.addActionListener(artikelAnzeigen());
        btnArtkelnEinlagern.addActionListener(newArtikel());

    }

    public JFrameMitarbeiter() {
        this.setVisible(true);

        initGUI();
        this.mitarbeiterService=mitarbeiterService;
        btnNeuerMitarbeiterHinzufgen.addActionListener(newMitarbeiter());
        btnArtikelAnzeigen.addActionListener(artikelAnzeigen());
        btnArtkelnEinlagern.addActionListener(newArtikel());

    }



    private void initGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 252);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        {
            lblMitarbeiter = new JLabel("Mitarbeiter");
            lblMitarbeiter.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
            lblMitarbeiter.setBounds(150, 10, 122, 13);
            contentPane.add(lblMitarbeiter);
        }
        {
            btnArtikelAnzeigen = new JButton("Artikel Anzeigen");
            btnArtikelAnzeigen.setFocusable(false);
            btnArtikelAnzeigen.setFocusPainted(false);
            btnArtikelAnzeigen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnArtikelAnzeigen.setBounds(17, 44, 336, 21);
            contentPane.add(btnArtikelAnzeigen);
        }
        {
            btnNeuerMitarbeiterHinzufgen = new JButton("Neuer Mitarbeiter Hinzuf\u00FCgen");
            btnNeuerMitarbeiterHinzufgen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnNeuerMitarbeiterHinzufgen.setFocusable(false);
            btnNeuerMitarbeiterHinzufgen.setFocusPainted(false);
            btnNeuerMitarbeiterHinzufgen.setBounds(17, 92, 336, 21);
            contentPane.add(btnNeuerMitarbeiterHinzufgen);
        }
        {
            btnArtkelnEinlagern = new JButton("Artkeln Einlagern");
            btnArtkelnEinlagern.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnArtkelnEinlagern.setFocusable(false);
            btnArtkelnEinlagern.setFocusPainted(false);
            btnArtkelnEinlagern.setBounds(17, 140, 336, 21);
            contentPane.add(btnArtkelnEinlagern);
        }
        {
            btnEreignissAnzeigen = new JButton("Ereigniss Anzeigen");
            btnEreignissAnzeigen.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            btnEreignissAnzeigen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnEreignissAnzeigen.setFocusable(false);
            btnEreignissAnzeigen.setFocusPainted(false);
            btnEreignissAnzeigen.setBounds(17, 186, 336, 21);
            contentPane.add(btnEreignissAnzeigen);
        }
    }

    public ActionListener newMitarbeiter() {
        return e -> {
            new JFrameNewMitarbeiter();
            this.dispose();
        };
    }

    public ActionListener artikelAnzeigen() {
        return e -> {
            new JFrameArtikelAnzeigen(mitarbeiterService);
            this.dispose();
        };
    }

    public ActionListener newArtikel() {
        return e -> {
            new JFrameEinlagerung();
            this.dispose();
        };
    }
}
