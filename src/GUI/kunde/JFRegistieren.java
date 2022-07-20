package GUI.kunde;

import GUI.alert.Alert;
import exception.INcorrectEmailException;
import exception.RegisitierungException;
import model.Adresse;
import model.Kunde;
import ui.EshopCui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFRegistieren extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField nameText;
    private JTextField nachnameText;
    private JTextField stadtText;
    private JTextField strasseText;
    private JTextField plzText;
    private JTextField hasunuText;
    private JTextField emailText;
    private JPasswordField passText1;
    private JPasswordField passText2;
    private JButton abshlissen;
    private EshopCui eshopCui;

    public JFRegistieren(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 505, 337);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        eshopCui = new EshopCui();
        instalizer();
        setVisible(true);
        abshlissen.addActionListener(this);

    }

    private void instalizer() {
        JPanel panel = new JPanel();
        panel.setBounds(100, 11, 311, 236);
        contentPane.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblNewLabel = new JLabel("Name :");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        nameText = new JTextField();
        GridBagConstraints gbc_nachnameText = new GridBagConstraints();
        gbc_nachnameText.insets = new Insets(0, 0, 5, 0);
        gbc_nachnameText.fill = GridBagConstraints.HORIZONTAL;
        gbc_nachnameText.gridx = 5;
        gbc_nachnameText.gridy = 1;
        panel.add(nameText, gbc_nachnameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Nach Name :");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 3;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        nachnameText = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 5;
        gbc_textField_1.gridy = 3;
        panel.add(nachnameText, gbc_textField_1);
        nachnameText.setColumns(10);

        JLabel nameLable = new JLabel("Stadt");
        GridBagConstraints gbc_nameLable = new GridBagConstraints();
        gbc_nameLable.insets = new Insets(0, 0, 5, 5);
        gbc_nameLable.gridx = 1;
        gbc_nameLable.gridy = 5;
        panel.add(nameLable, gbc_nameLable);

        stadtText = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 5;
        gbc_textField_2.gridy = 5;
        panel.add(stadtText, gbc_textField_2);
        stadtText.setColumns(10);

        JLabel na = new JLabel("Strasse");
        GridBagConstraints gbc_na = new GridBagConstraints();
        gbc_na.insets = new Insets(0, 0, 5, 5);
        gbc_na.gridx = 1;
        gbc_na.gridy = 7;
        panel.add(na, gbc_na);

        strasseText = new JTextField();
        GridBagConstraints gbc_strasseText = new GridBagConstraints();
        gbc_strasseText.insets = new Insets(0, 0, 5, 0);
        gbc_strasseText.fill = GridBagConstraints.HORIZONTAL;
        gbc_strasseText.gridx = 5;
        gbc_strasseText.gridy = 7;
        panel.add(strasseText, gbc_strasseText);
        strasseText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Plz");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 9;
        panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

        plzText = new JTextField();
        GridBagConstraints gbc_plzText = new GridBagConstraints();
        gbc_plzText.insets = new Insets(0, 0, 5, 0);
        gbc_plzText.fill = GridBagConstraints.HORIZONTAL;
        gbc_plzText.gridx = 5;
        gbc_plzText.gridy = 9;
        panel.add(plzText, gbc_plzText);
        plzText.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Nr");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 1;
        gbc_lblNewLabel_5.gridy = 11;
        panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

        hasunuText = new JTextField();
        GridBagConstraints gbc_hasunuText = new GridBagConstraints();
        gbc_hasunuText.insets = new Insets(0, 0, 5, 0);
        gbc_hasunuText.fill = GridBagConstraints.HORIZONTAL;
        gbc_hasunuText.gridx = 5;
        gbc_hasunuText.gridy = 11;
        panel.add(hasunuText, gbc_hasunuText);
        hasunuText.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("email");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 13;
        panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

        emailText = new JTextField();
        GridBagConstraints gbc_emailText = new GridBagConstraints();
        gbc_emailText.insets = new Insets(0, 0, 5, 0);
        gbc_emailText.fill = GridBagConstraints.HORIZONTAL;
        gbc_emailText.gridx = 5;
        gbc_emailText.gridy = 13;
        panel.add(emailText, gbc_emailText);
        emailText.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("pass");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 1;
        gbc_lblNewLabel_7.gridy = 15;
        panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

        passText1 = new JPasswordField();
        GridBagConstraints gbc_passText1 = new GridBagConstraints();
        gbc_passText1.insets = new Insets(0, 0, 5, 0);
        gbc_passText1.fill = GridBagConstraints.HORIZONTAL;
        gbc_passText1.gridx = 5;
        gbc_passText1.gridy = 15;
        panel.add(passText1, gbc_passText1);
        passText1.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("pass Wider");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 1;
        gbc_lblNewLabel_8.gridy = 17;
        panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

        passText2 = new JPasswordField();
        GridBagConstraints gbc_passText2 = new GridBagConstraints();
        gbc_passText2.insets = new Insets(0, 0, 5, 0);
        gbc_passText2.fill = GridBagConstraints.HORIZONTAL;
        gbc_passText2.gridx = 5;
        gbc_passText2.gridy = 17;
        panel.add(passText2, gbc_passText2);
        passText2.setColumns(10);

        abshlissen = new JButton("Registrieren");
        abshlissen.setBounds(202, 258, 100, 23);
        contentPane.add(abshlissen);
    }

    public static void main(String[] args) {
        JFRegistieren jfRegistieren = new JFRegistieren("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Alert alert;
        try {
            if (passText1.getText().equals(passText2.getText())) {
                Kunde kunde = new Kunde(nameText.getText(), nachnameText.getText(), new Adresse(Integer.valueOf(hasunuText.getText()),
                        Integer.valueOf(plzText.getText()), stadtText.getText(), strasseText.getText()), passText1.getText(), emailText.getText());
                eshopCui.kundeRegistrieren(kunde);
                this.dispose();
                //ToDo new JFarme Artikel oder so was
                return;
            } else {
                alert = new Alert(this, "pass nicht gleich", "Password");
            }
        } catch (INcorrectEmailException ex) {
            alert = new Alert(this, ex.getMessage(), "Email!");
        } catch (NumberFormatException ne) {
            alert = new Alert(this, "das ist keine Nr\n" + ne.getMessage(), "Nummer");
        } catch (RegisitierungException regex) {
            System.out.println("na");
            ;
            alert = new Alert(this, regex.getMessage(), "Registeren");
        }
        alert.showInfoMassage();

    }
}
