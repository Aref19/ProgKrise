package GUI.kunde;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JFrameRechnung extends JFrame {

    private JPanel contentPane;
    private JLabel lblIhreRechnung;
    private JTextArea textArea;
    private JButton btnSchlieen;
    private JButton btnDownload;

    public JFrameRechnung(){
        this.setVisible(true);
        initGUI();
    }

    public static void main(String[] args) {
        new JFrameRechnung();
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 398, 400);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblIhreRechnung = new JLabel("Ihre Rechnung");
            lblIhreRechnung.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
            lblIhreRechnung.setBounds(134, 10, 157, 41);
            contentPane.add(lblIhreRechnung);
        }
        {
            textArea = new JTextArea();
            textArea.setEnabled(false);
            textArea.setBounds(10, 49, 362, 272);
            contentPane.add(textArea);
        }
        {
            btnSchlieen = new JButton("Schlie\u00DFen");
            btnSchlieen.setFocusable(false);
            btnSchlieen.setFocusPainted(false);
            btnSchlieen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnSchlieen.setBounds(274, 331, 98, 21);
            contentPane.add(btnSchlieen);
        }
        {
            btnDownload = new JButton("Download");
            btnDownload.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnDownload.setFocusable(false);
            btnDownload.setFocusPainted(false);
            btnDownload.setBounds(10, 331, 95, 21);
            contentPane.add(btnDownload);
        }
    }
}
