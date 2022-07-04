package GUI.alert;

import javax.swing.*;

public class RegisterungAlert extends JOptionPane {
    private String massge;
    private  JFrame parent;

    public RegisterungAlert(String massge) {
        this.massge = massge;
    }
    public  void show(){
        RegisterungAlert.showMessageDialog(parent,massge);
    }
}
