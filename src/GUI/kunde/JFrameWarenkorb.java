package GUI.kunde;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameWarenkorb extends JFrame {
    private JPanel contentPane;
    private JLabel lblWarenkorb;
    private JLabel lblIhreBestellungen;
    private JButton btnZurück;
    private JButton btnLeeren;
    private JButton btnWeiterZurKasse;
    private JButton btnMinus;


    public JFrameWarenkorb() {
       initGUI();
       this.setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameWarenkorb();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 411, 405);
        contentPane = new JPanel();
        contentPane.setBounds(new Rectangle(30, 30, 30, 30));
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblWarenkorb = new JLabel("Warenkorb");
            lblWarenkorb.setVerticalTextPosition(SwingConstants.TOP);
            lblWarenkorb.setFont(new Font("Andalus", Font.BOLD, 14));
            lblWarenkorb.setBounds(155, 10, 89, 13);
            contentPane.add(lblWarenkorb);
        }
        {
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setBounds(78, 75, 234, 257);
            contentPane.add(textArea);
        }
        {
            lblIhreBestellungen = new JLabel("Ihre Bestellungen");
            lblIhreBestellungen.setFont(new Font("Andalus", Font.ITALIC, 12));
            lblIhreBestellungen.setVerticalTextPosition(SwingConstants.TOP);
            lblIhreBestellungen.setBounds(155, 52, 114, 13);
            contentPane.add(lblIhreBestellungen);
        }
        {
            btnZurück = new JButton("Zur\u00FCck");
            btnZurück.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnZurück.setFocusable(false);
            btnZurück.setFocusPainted(false);
            btnZurück.setHorizontalTextPosition(SwingConstants.RIGHT);
            btnZurück.setBounds(10, 342, 85, 21);
            contentPane.add(btnZurück);
        }
        {
            btnLeeren = new JButton("Leeren");
            btnLeeren.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnLeeren.setFocusPainted(false);
            btnLeeren.setFocusable(false);
            btnLeeren.setBounds(144, 342, 89, 21);
            contentPane.add(btnLeeren);
        }
        {
            btnWeiterZurKasse = new JButton("Weiter zur Kasse");
            btnWeiterZurKasse.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnWeiterZurKasse.setFocusable(false);
            btnWeiterZurKasse.setFocusPainted(false);
            btnWeiterZurKasse.setBounds(264, 342, 123, 21);
            contentPane.add(btnWeiterZurKasse);
        }
        {
            btnMinus = new JButton("-");
            btnMinus.setFocusable(false);
            btnMinus.setBounds(22, 183, 46, 21);
            contentPane.add(btnMinus);
        }

    }
}
