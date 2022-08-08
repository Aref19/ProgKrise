package ui.gui.Login;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField enamilFaild;
    private JTextField passField;
    private JButton anmeldenButton;
    private JButton regsieButton;

    public LoginPanel() {
        setupUI();
    }

    private void setupUI() {
        setLayout(new GridLayout());
        // Abstandhalter ("Filler") zwischen Rand und erstem Element
        /*Dimension borderMinSize = new Dimension(5, 10);
        Dimension borderPrefSize = new Dimension(5, 10);
        Dimension borderMaxSize = new Dimension(5, 10);
        add(new Box.Filler(borderMinSize, borderPrefSize, borderMaxSize));*/


        add(input());
        setBorder(BorderFactory.createEmptyBorder(200,20,100,20));
        setSize(new Dimension(200,200));



    }

    private JPanel checkBox() {
        Dimension fillerMinSize = new Dimension(5,5);
        Dimension fillerPreferredSize = new Dimension(5,500);
        Dimension fillerMaxSize = new Dimension(5,500);

        JRadioButton checkBox1 = new JRadioButton();
        checkBox1.setLabel("kund");
        JRadioButton checkBox2 = new JRadioButton();
        checkBox2.setLabel("Miarbeiter");
        JPanel box=new JPanel();
        box.setSize(new Dimension(0,Short.MAX_VALUE));
        box.setAlignmentY(50);
        box.add(checkBox1);
        box.add(checkBox2);

        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));
        return box;
    }

    private JPanel input() {
        JPanel box=new JPanel();
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));
        JLabel email=new JLabel();
        email.setText("Email");
        JTextField emaiinput=new JTextField();
        box.add(checkBox());
        box.add(email);
        box.add(emaiinput);
        JLabel pass=new JLabel();
        pass.setText("Password");
        JPasswordField passwordField=new JPasswordField();

        box.add(pass);
        box.add(passwordField);
        box.add(button());

        return box;
    }
    private JPanel button() {
        JPanel box=new JPanel();
        box.setLayout(new GridLayout());
        JButton anmelden=new JButton();
        anmelden.setText("anmelden");
        JButton regstieren=new JButton();
        regstieren.setText("regstieren");
        box.add(anmelden);
        box.add(regstieren);
        return box;
    }



}
