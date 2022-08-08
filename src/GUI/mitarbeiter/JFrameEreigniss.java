package GUI.mitarbeiter;

import GUI.Willkommen;
import GUI.services.MitarbeiterService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFrameEreigniss extends JFrame {

    private JPanel contentPane;
    private JLabel lblEreigniss;
    private JTable table;
    private JComboBox jComboBox;
    private JButton btnSortierenNach;
    private JButton btnFlittern;
    private JComboBox jCombFlittern;
    private JButton btnZurck;
    private JButton btnSchließen;
    private JTextField filterData;
    private MitarbeiterService mitarbeiterService;
    private DefaultTableModel defaultTableModel;


    public JFrameEreigniss(MitarbeiterService mitarbeiterService) {
        this.mitarbeiterService = mitarbeiterService;
        this.setVisible(true);
        Gitinit();
        putEreignisse();
        btnZurck.addActionListener(back());
        btnSortierenNach.addActionListener(sortieren());
        btnFlittern.addActionListener(fillternErigniss());
        btnSchließen.addActionListener(close());

    }



    public JFrameEreigniss() {
        this.mitarbeiterService = mitarbeiterService;
        this.setVisible(true);
        Gitinit();

        btnZurck.addActionListener(back());
    }

    public void Gitinit() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 399);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblEreigniss = new JLabel("Ereigniss");
        lblEreigniss.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 14));
        lblEreigniss.setBounds(250, 11, 74, 31);
        contentPane.add(lblEreigniss);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 53, 550, 208);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setToolTipText("");

        jComboBox = new JComboBox();
        jComboBox.setModel(new DefaultComboBoxModel(new String[]{"Datum","Artikel", "Person", "Ereignistyp"}));
        jComboBox.setFocusable(false);
        jComboBox.setToolTipText("");
        jComboBox.setFont(new Font("Andalus", Font.ITALIC, 12));
        jComboBox.setBounds(450, 272, 87, 22);
        contentPane.add(jComboBox);

        btnSortierenNach = new JButton("Sortieren Nach");
        btnSortierenNach.setFocusPainted(false);
        btnSortierenNach.setFocusable(false);
        btnSortierenNach.setFont(new Font("Andalus", Font.ITALIC, 12));
        btnSortierenNach.setBounds(300, 272, 120, 23);
        contentPane.add(btnSortierenNach);

        btnFlittern = new JButton("Flittern Nach");
        btnFlittern.setFocusPainted(false);
        btnFlittern.setFocusable(false);
        btnFlittern.setFont(new Font("Andalus", Font.ITALIC, 12));
        btnFlittern.setBounds(25, 272, 120, 23);
        contentPane.add(btnFlittern);

        filterData = new JTextField();
        filterData.setBounds(150, 272, 120, 23);
        contentPane.add(filterData);


        btnZurck = new JButton("Zurück");
        btnZurck.setFont(new Font("Andalus", Font.ITALIC, 12));
        btnZurck.setFocusable(false);
        btnZurck.setFocusPainted(false);
        btnZurck.setBounds(470, 327, 100, 23);
        contentPane.add(btnZurck);

        btnSchließen = new JButton("Schließen");
        btnSchließen.setFont(new Font("Andalus", Font.ITALIC, 12));
        btnSchließen.setFocusable(false);
        btnSchließen.setFocusPainted(false);
        btnSchließen.setBounds(10, 327, 106, 23);
        contentPane.add(btnSchließen);
    }

    public ActionListener back() {
        return e -> {
            new JFrameMitarbeiter(mitarbeiterService);
            this.dispose();
        };
    }



    private void putEreignisse(){
        defaultTableModel=mitarbeiterService.putErignisse();
        table.setModel(defaultTableModel);
    }

    private ActionListener sortieren() {
       return e->{
           defaultTableModel=mitarbeiterService.putErignisseSorted(jComboBox.getSelectedIndex());
               table.setModel(defaultTableModel);
       };

    }

    private ActionListener fillternErigniss() {
        return e->{
          defaultTableModel=  mitarbeiterService.ereignisFiltern(jComboBox.getSelectedIndex(),filterData.getText());
            table.setModel(defaultTableModel);
        };
    }

    public ActionListener close(){
        return e->{
            this.dispose();
            new Willkommen();
        };
    }

}
