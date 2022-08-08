package GUI.kunde;

import GUI.alert.Alert;
import GUI.services.KundenService;
import model.Rechnung;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFrameRechnung extends JFrame {

    private JPanel contentPane;
    private JLabel lblIhreRechnung;
    private JTextArea textArea;
    private JButton btnSchlieen;
    private JButton btnDownload;
    private KundenService kundenService;
    private Rechnung rechnung;

    public JFrameRechnung(KundenService kundenService){
        this.setVisible(true);
        initGUI();
        this.kundenService=kundenService;
        rechnung=  kundenService.getRechnung();
        textAreaAddContent();
        btnDownload.addActionListener(rechnungDowland());
        btnSchlieen.addActionListener(close());
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
            textArea.setEditable(false);
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
    private ActionListener rechnungDowland(){
        return e->{
         kundenService.creatPdf();
            Alert alert = new Alert(this, "sie finden die Rechnung unter Rechnung/ ", "Rechnung");
            alert.showInfoMassage();
            Alert alertRechnung = new Alert(this, "wollen sie weiter Kaufen ", "Rechnung");
            int option = alertRechnung.vorsicht();
            if (option == JOptionPane.YES_OPTION) {
                new JFrameArtikel(kundenService);
            }
            kundenService.kill(this);
        };
    }

    private void textAreaAddContent(){
        textArea.setText(rechnung.toString());

    }

    private ActionListener close(){
        return e->{
            Alert alert = new Alert(this, "Danek", "Danke");
            alert.showInfoMassage();

            Alert alertRechnung = new Alert(this, "wollen sie weiter Kaufen ", "Rechnung");
            int option = alertRechnung.vorsicht();
            if (option == JOptionPane.YES_OPTION) {
                new JFrameArtikel(kundenService);
            }
            kundenService.kill(this);


        };
    }
}
