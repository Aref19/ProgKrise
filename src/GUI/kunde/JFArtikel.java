package GUI.kunde;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFArtikel extends JFrame {
    private JPanel contentPane;
    public JFArtikel()  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 569, 337);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        instalizer();
        setVisible(true);
    }

    private void instalizer(){
        JTextArea artikelArea = new JTextArea();
        artikelArea.setBounds(29, 30, 163, 159);
        contentPane.add(artikelArea);

        JTextArea warenArea = new JTextArea();
        warenArea.setBounds(354, 30, 163, 159);
        contentPane.add(warenArea);

        JLabel minusLab = new JLabel("-");
        minusLab.setBounds(224, 221, 16, 14);
        contentPane.add(minusLab);

        JLabel plusLab = new JLabel("+");
        plusLab.setBounds(294, 221, 46, 14);
        contentPane.add(plusLab);

        JLabel resultLab = new JLabel("0");
        resultLab.setBounds(260, 221, 6, 14);
        contentPane.add(resultLab);

        JButton addButton = new JButton("add");
        addButton.setBounds(29, 252, 89, 23);
        contentPane.add(addButton);

        JButton kasseButton = new JButton("zu Kasse");
        kasseButton.setBounds(428, 252, 89, 23);
        contentPane.add(kasseButton);

        JLabel Artikels = new JLabel("Artikels");
        Artikels.setBounds(89, 5, 46, 14);
        contentPane.add(Artikels);

        JLabel lblNewLabel = new JLabel("WarenKorb");
        lblNewLabel.setBounds(415, 5, 70, 14);
        contentPane.add(lblNewLabel);
    }
    public static void main(String[] args) {
        JFArtikel jfRegistieren = new JFArtikel();
    }
}
