package GUI.kunde;

import GUI.Willkommen;
import GUI.alert.Alert;
import GUI.services.KundenService;
import exception.BestandNichtAusreichendException;
import exception.NotFoundException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

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
    private JButton kasse;
    private JButton abbrechenBtn;
    private JLabel lArtikelLegenlb;
    private KundenService kundenService;
    private DefaultTableModel defaultTableModel;
    private JButton entfernen;
    int anzahl = 0;

    public static void main(String[] args) {
        new JFrameArtikel(new KundenService());
    }
    public JFrameArtikel(KundenService kundenService) {
        initGUI();
        this.setVisible(true);
        kundenService.model=new DefaultListModel<>();
        this.kundenService = kundenService;
        insertArtikel();
        minusBtn.addActionListener(cheangeCount());
        plusBtn.addActionListener(cheangeCount());
        btnEinfgen.addActionListener(fugeArtikel());
        entfernen.addActionListener(entfernArtiekl());
        kasse.addActionListener(kasse());
        abbrechenBtn.addActionListener(cancel());


    }



    private void initGUI() {
        setBounds(new Rectangle(20, 20, 20, 20));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 484, 520);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        //contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {


            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 80, 200, 306);
            contentPane.add(scrollPane);
            artikelsTablle = new JTable();
            scrollPane.setViewportView(artikelsTablle);

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
            ArtikelhinzufügenLabel = new JLabel("WarenKorb");
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
            btnEinfgen.setBounds(20, 399, 85, 21);
            contentPane.add(btnEinfgen);
        }
        {
            entfernen = new JButton("entfernen");
            entfernen.setBackground(Color.lightGray);
            entfernen.setFocusable(false);
            entfernen.setFocusPainted(false);
            entfernen.setFont(new Font("Andalus", Font.ITALIC, 12));
            entfernen.setBounds(new Rectangle(10, 10, 10, 10));
            entfernen.setBounds(120, 399, 85, 21);
            contentPane.add(entfernen);
        }
        {
            separator = new JSeparator();
            separator.setBounds(10, 430, 486, 13);
            contentPane.add(separator);
        }
        {
            kasse = new JButton("Zur kasse");
            kasse.setFont(new Font("Andalus", Font.ITALIC, 12));
            kasse.setFocusPainted(false);
            kasse.setFocusable(false);
            kasse.setBounds(314, 453, 142, 20);
            contentPane.add(kasse);
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



    private ActionListener cheangeCount() {
        return e -> {
            if (e.getActionCommand().equals("+")) {
                anzahl++;
                mengetextField.setText("" + anzahl);
            } else if (e.getActionCommand().equals("-")) {
                if (anzahl > 0) {
                    anzahl--;
                    mengetextField.setText("" + anzahl);
                }
            }
        };
    }

    private void insertArtikel() {
        defaultTableModel=kundenService.putArtikel();
        artikelsTablle.setModel(defaultTableModel);

    }

    private ActionListener fugeArtikel() {
        return e -> {
            try {
                if(anzahl>0){
                    if(artikelsTablle.getSelectedRow()!=-1){
                        int masse= Integer.parseInt(defaultTableModel.getValueAt(artikelsTablle.getSelectedRow(), 3).toString());
                        if(anzahl%masse==0){
                            ArtikelnhinzufügentextPane_1.setModel(kundenService.artikelEinfugen(
                                    defaultTableModel.getValueAt(artikelsTablle.getSelectedRow(), 0).toString(),
                                    defaultTableModel.getValueAt(artikelsTablle.getSelectedRow(), 1).toString(),
                                    defaultTableModel.getValueAt(artikelsTablle.getSelectedRow(), 2).toString(),
                                    anzahl
                            ));

                        }else {
                            Alert alert = new Alert(this, "bitte in "+masse+" Mengen nehmen", "Menge");
                            alert.showInfoMassage();
                        }

                    }else {
                        Alert alert = new Alert(this, "bitte select Produckt", "Menge");
                        alert.showInfoMassage();
                    }

                }else {
                    Alert alert = new Alert(this, "bitte select nummer", "Menge");
                    alert.showInfoMassage();
                }


            } catch (BestandNichtAusreichendException ex) {
                Alert alert = new Alert(this, ex.getMessage(), "Menge");
                alert.showInfoMassage();
            } catch (NotFoundException ex) {

            }
            anzahl = 0;
            mengetextField.setText("" + anzahl);
            defaultTableModel=kundenService.putArtikel();
            artikelsTablle.setModel(defaultTableModel);
        };
    }

    private ActionListener entfernArtiekl() {
        return e -> {
            int index = ArtikelnhinzufügentextPane_1.getSelectedIndex();
                try {
                   defaultTableModel= kundenService.entfernenFromKorp(index);
                    artikelsTablle.setModel(defaultTableModel);
                } catch (NotFoundException ex) {
                    Alert alert = new Alert(this, ex.getMessage(), "Eroor");
                    alert.showInfoMassage();
                }


        };
    }

    private ActionListener kasse(){
        return e->{
            new JFrameKasse(kundenService);
            kundenService.kill(this);
        };
    }
    public ActionListener cancel(){
        return e->{
            new Willkommen();
            dispose();

        };
    }

}

