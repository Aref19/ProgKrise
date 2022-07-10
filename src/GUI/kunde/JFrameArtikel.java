package GUI.kunde;

import GUI.services.KundenService;
import model.Artikel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JFrameArtikel extends JFrame {

    private JPanel contentPane;
    private JTable artikelsTablle;
    private JLabel verfügbarenArtikelLabel;
    private JList<String> ArtikelnhinzufügentextPane_1;
    private JLabel ArtikelhinzufügenLabel;
    private JButton plusBtn;
    private JButton minusBtn;
    private JTextField mengetextField;
    private JButton btnEinfgen;
    private JSeparator separator;
    private JButton warenkorbBtn;
    private JButton abbrechenBtn;
    private JLabel lArtikelLegenlb;
    private KundenService kundenService;
    private DefaultTableModel defaultTableModel;

    public JFrameArtikel() {
        initGUI();
        this.setVisible(true);
        KundenService kundenService = new KundenService(this,mengetextField, ArtikelnhinzufügentextPane_1, defaultTableModel, artikelsTablle);
        minusBtn.addActionListener(kundenService);
        plusBtn.addActionListener(kundenService);
        btnEinfgen.addActionListener(kundenService);

    }

    public static void main(String[] args) {
        new JFrameArtikel();
    }

    private void initGUI() {
        setBounds(new Rectangle(20, 20, 20, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 484, 520);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            defaultTableModel = new DefaultTableModel();
            defaultTableModel.addColumn("name");
            defaultTableModel.addColumn("betsand");
            defaultTableModel.addColumn("preis");

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 80, 200, 306);
            contentPane.add(scrollPane);

            artikelsTablle = new JTable();
            scrollPane.setViewportView(artikelsTablle);
            artikelsTablle.setModel(defaultTableModel);
        }
        {
            verfügbarenArtikelLabel = new JLabel("Hier sind die Verf\u00FCgbaren Artikeln");
            verfügbarenArtikelLabel.setFont(new Font("Andalus", Font.ITALIC, 12));
            verfügbarenArtikelLabel.setFocusable(false);
            verfügbarenArtikelLabel.setBounds(21, 60, 200, 13);
            contentPane.add(verfügbarenArtikelLabel);
        }
        {
            ArtikelnhinzufügentextPane_1 = new JList<>();
            ArtikelnhinzufügentextPane_1.setBounds(238, 83, 218, 306);
            contentPane.add(ArtikelnhinzufügentextPane_1);
        }
        {
            ArtikelhinzufügenLabel = new JLabel("F\u00FCgen Sie Ihre Artikeln hinzu");
            ArtikelhinzufügenLabel.setFont(new Font("Andalus", Font.ITALIC, 12));
            ArtikelhinzufügenLabel.setBounds(289, 60, 218, 13);
            contentPane.add(ArtikelhinzufügenLabel);
        }
        {
            plusBtn = new JButton("+");
            plusBtn.setFocusable(false);
            plusBtn.setFocusPainted(false);
            plusBtn.setBounds(400, 399, 50, 20);
            contentPane.add(plusBtn);
        }
        {
            minusBtn = new JButton("-");
            minusBtn.setFocusPainted(false);
            minusBtn.setFocusable(false);
            minusBtn.setBounds(240, 399, 50, 20);
            contentPane.add(minusBtn);
        }
        {
            mengetextField = new JTextField();
            mengetextField.setText("0");
            mengetextField.setBounds(289, 400, 110, 19);
            contentPane.add(mengetextField);
            mengetextField.setColumns(10);
        }
        {
            btnEinfgen = new JButton("Einfeugen");
            btnEinfgen.setBackground(Color.lightGray);
            btnEinfgen.setFocusable(false);
            btnEinfgen.setFocusPainted(false);
            btnEinfgen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnEinfgen.setBounds(new Rectangle(10, 10, 10, 10));
            btnEinfgen.setBounds(69, 399, 85, 21);
            contentPane.add(btnEinfgen);
        }
        {
            separator = new JSeparator();
            separator.setBounds(10, 430, 486, 13);
            contentPane.add(separator);
        }
        {
            warenkorbBtn = new JButton("Weiter zu Warenkorb");
            warenkorbBtn.setFont(new Font("Andalus", Font.ITALIC, 12));
            warenkorbBtn.setFocusPainted(false);
            warenkorbBtn.setFocusable(false);
            warenkorbBtn.setBounds(314, 453, 142, 20);
            contentPane.add(warenkorbBtn);
        }
        {
            abbrechenBtn = new JButton("Abbrechen");
            abbrechenBtn.setFocusable(false);
            abbrechenBtn.setFocusPainted(false);
            abbrechenBtn.setFont(new Font("Andalus", Font.ITALIC, 12));
            abbrechenBtn.setBounds(10, 453, 96, 20);
            contentPane.add(abbrechenBtn);
        }
        {
            lArtikelLegenlb = new JLabel("Artikel Legen");
            lArtikelLegenlb.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 13));
            lArtikelLegenlb.setBounds(194, 10, 122, 28);
            contentPane.add(lArtikelLegenlb);
        }
    }
}

