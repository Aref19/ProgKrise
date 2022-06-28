package ui.gui.Login;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame {

    private JButton anmeldenButton;
    private JRadioButton kundeRadioButton;
    private JRadioButton mitarbeiterRadioButton;
    private JTextField emailInput;
    private JButton regisierenButton;
    private JPanel loginPanel;
    private JPasswordField passInput;

    public LogIn(String title) throws HeadlessException {
        super(title);
        setContentPane(loginPanel);
        setVisible(true);

        anmeldenButton.addActionListener(new LoginListener(emailInput,passInput));
        regisierenButton.addActionListener(new LoginListener());
    }

    public static void main(String[] args) {
        LogIn logIn=new LogIn("ds");
    }


}
