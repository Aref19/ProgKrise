package GUI.kunde;


import GUI.alert.Alert;
import GUI.services.KundenService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class JFrameKasse extends JFrame {
    private JPanel contentPane;
    private JLabel lblKasse;
    private JButton btnSchlieen;
    private JButton btnEinkaufFortsetzen;

   private JList<String> contentList;
    private JButton btnHerunterladen;
    private KundenService kundenService;

    public JFrameKasse(KundenService kundenService) {
        initGUI();

//        this.kundenService = new KundenService(eshop);
        this.kundenService = kundenService;

        this.setVisible(true);

        btnSchlieen.addActionListener(close());
        btnEinkaufFortsetzen.addActionListener(buy());
        contentList.setModel(this.kundenService.kasse());

    }

//    public static void main(String[] args) {
//        new JFrameKasse(kundenService);
//    }

    private void initGUI() {
        setForeground(SystemColor.inactiveCaption);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setForeground(SystemColor.inactiveCaption);
        contentPane.setBounds(new Rectangle(20, 20, 20, 20));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            lblKasse = new JLabel("Kasse");
            lblKasse.setVerticalTextPosition(SwingConstants.TOP);
            lblKasse.setFont(new Font("Andalus", Font.ITALIC, 14));
            lblKasse.setBounds(166, 10, 99, 13);
            contentPane.add(lblKasse);
        }
        {

            btnSchlieen = new JButton("Schliessen");
            btnSchlieen.setFont(new Font("Andalus", Font.ITALIC, 11));
            btnSchlieen.setFocusable(false);
            btnSchlieen.setFocusPainted(false);
            btnSchlieen.setBounds(10, 332, 85, 21);
            contentPane.add(btnSchlieen);
        }
        {

            btnEinkaufFortsetzen = new JButton("Kaufen");

            btnEinkaufFortsetzen.setFont(new Font("Andalus", Font.ITALIC, 11));
            btnEinkaufFortsetzen.setFocusPainted(false);
            btnEinkaufFortsetzen.setFocusable(false);
            btnEinkaufFortsetzen.setBounds(248, 332, 128, 21);
            contentPane.add(btnEinkaufFortsetzen);
        }
        {

            contentList = new JList<>();
            contentList.setBounds(10, 33, 366, 289);
            DefaultListCellRenderer renderer = (DefaultListCellRenderer) contentList.getCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(contentList);

        }
        {
            btnHerunterladen = new JButton("Herunterladen");
            btnHerunterladen.setFocusable(false);
            btnHerunterladen.setFocusPainted(false);
            btnHerunterladen.setFont(new Font("Andalus", Font.ITALIC, 11));
            btnHerunterladen.setBounds(120, 332, 107, 21);
            contentPane.add(btnHerunterladen);

        }
    }

    private ActionListener close(){
        return e -> {
            Alert alert = new Alert(this, "wollen sie die sache speichern falls ja kann nicht mehr remove", "Vorsicht");
            int option = alert.vorsicht();
            if (option == JOptionPane.YES_OPTION) {
               kundenService.saveWarenWarenKorb(false);
            }
            kundenService.kill(this);
        };
    }

    private ActionListener buy(){
        return e -> {
            kundenService.sacheKaufen();
            Alert alertRechnung = new Alert(this, "wollen sie Rechnung hrunterladen", "Rechnung");
            int option = alertRechnung.vorsicht();
            if (option == JOptionPane.YES_OPTION) {
                kundenService.creatPdf();
            }
            Alert alert = new Alert(this, "Danke für die Einkauf", "^-^");
            alert.showInfoMassage();
            kundenService.kill(this);
        };

    };
}

