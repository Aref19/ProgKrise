package ui.gui.Login;

import ui.EshopCui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.jar.JarEntry;

public class LoginListener implements ActionListener {
    EshopCui eshopCui ;
    private JTextField email;
    private JPasswordField pass;

    public LoginListener(JTextField email, JPasswordField pass) {

        this.email = email;
        this.pass = pass;
        eshopCui=new EshopCui();
    }
    public LoginListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("anmelden")) {
            System.out.println(email.getText()+pass.getText());
            try {
                System.out.println( eshopCui.mitarbeiterEinloggen(email.getText(),pass.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
