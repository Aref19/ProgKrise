package GUI.mitarbeiter;

import GUI.services.MitarbeiterService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameArtikelAnzeigen extends JFrame {
    private JPanel contentPane;
    private JTable textArea;
    private JLabel lblArtikelAnzeigen;
    private JButton btnSortieren;
    private JComboBox idUndName;
    private JButton btnZurck;
    private JButton btnSchlieen;

    private DefaultTableModel defaultTableModel;
    private MitarbeiterService mitarbeiterService;
    
    public JFrameArtikelAnzeigen(MitarbeiterService mitarbeiterService){
        this.setVisible(true);
        initGUI();
        this.mitarbeiterService=mitarbeiterService;
        putArtikel();

        btnSortieren.addActionListener(sortieren());
        btnZurck.addActionListener(back());
        btnSchlieen.addActionListener(close());
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 403, 343);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
           JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(27, 49, 329, 159);
            contentPane.add(scrollPane);
            {
                textArea= new JTable();
                scrollPane.setViewportView(textArea);
            }
        }
        {
            lblArtikelAnzeigen = new JLabel("Artikel Anzeigen");
            lblArtikelAnzeigen.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
            lblArtikelAnzeigen.setBounds(136, 10, 183, 13);
            contentPane.add(lblArtikelAnzeigen);
        }
        {
            btnSortieren = new JButton("Sortieren Nach");
            btnSortieren.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnSortierenActionPerformed(e);
                }

                private void btnSortierenActionPerformed(ActionEvent e) {
                }
            });
            btnSortieren.setFocusPainted(false);
            btnSortieren.setFocusable(false);
            btnSortieren.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnSortieren.setBounds(90, 218, 120, 21);
            contentPane.add(btnSortieren);
        }
        {
            idUndName = new JComboBox();
            idUndName.setModel(new DefaultComboBoxModel(new String[] {"Name", "Id"}));
            idUndName.setFocusable(false);
            idUndName.setBounds(235, 218, 65, 21);
            idUndName.setFont(new Font("Andalus",Font.ITALIC,10));
            contentPane.add(idUndName);
        }
        {
            btnZurck = new JButton("Zur\u00FCck");
            btnZurck.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnZurck.setFocusable(false);
            btnZurck.setFocusPainted(false);
            btnZurck.setBounds(10, 275, 106, 21);
            contentPane.add(btnZurck);
        }
        {
            btnSchlieen = new JButton("Schlie\u00DFen");
            btnSchlieen.setFont(new Font("Andalus", Font.ITALIC, 12));
            btnSchlieen.setFocusable(false);
            btnSchlieen.setFocusPainted(false);
            btnSchlieen.setBounds(273, 275, 106, 21);
            contentPane.add(btnSchlieen);
        }
    }

    private void putArtikel(){
       defaultTableModel= mitarbeiterService.putArtikel();
       textArea.setModel(defaultTableModel);
    }

   private void artikelSortieren(){
        boolean sort=false;
        if (idUndName.getSelectedIndex()== 1){
            sort=true;
        }
        defaultTableModel=mitarbeiterService.putArtikelSort(sort);
        textArea.setModel(defaultTableModel);
   }

   public ActionListener sortieren(){
        return e-> {
            artikelSortieren();
        };
   }

   public ActionListener back(){
        return e->{
            new JFrameMitarbeiter();
            this.dispose();
        };
   }
   public ActionListener close(){
        return e-> {
          this.dispose();
        };
   }
}
