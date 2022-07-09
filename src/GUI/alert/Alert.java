package GUI.alert;

import javax.swing.*;

public class Alert extends JOptionPane {
    private String massge;
    private String title;
    private  JFrame parent;

    public Alert(JFrame parent,String massge,String title) {
        this.parent=parent;
        this.massge = massge;
        this.title=title;
    }
    public  void showInfoMassage(){
        Alert.showMessageDialog(parent,massge,title,1);
    }


}
