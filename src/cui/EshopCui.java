package cui;
import Domain.EshopVerwaltung;
import model.Adresse;
import model.Kunden;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EshopCui extends JFrame {
    private JPanel Kundeneinlogen;
    private JButton kundenButton;
    private JButton mitarbeiterButton;
    private JLabel name;

    public EshopCui() {
        setTitle("Hallo ");
        setContentPane(Kundeneinlogen);
        setSize(450, 350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        mitarbeiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kundAnlogen();
            }
        });
    }

    public static void main(String[] args) {
        EshopCui eshopCui = new EshopCui();
        EshopVerwaltung eshopVerwaltung = new EshopVerwaltung();
        eshopVerwaltung.artikelSortieren();
        Kunden kunden = new Kunden(1, "ajab", "o", new Adresse(12, 2, "", ""), "d");
        eshopVerwaltung.kundRegistieren(kunden);
        eshopVerwaltung.kundRegistieren(kunden);
        if (eshopVerwaltung.kundAnlogen("ab", "d")) {
            eshopVerwaltung.warenlegen();
            eshopVerwaltung.kaufen();
        }

    }

    public void kundAnlogen() {
        EshopCui eshopCui = new EshopCui();

    }
}