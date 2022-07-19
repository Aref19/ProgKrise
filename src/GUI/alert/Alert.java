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
        this.showMessageDialog(parent,massge,title,1);
    }
    public  void showWolcamMassge(){
        this.showMessageDialog(parent,massge);
    }

    public  int vorsicht(){
     int option =  this.showConfirmDialog (parent,massge,title,JOptionPane.YES_NO_OPTION);
     return option;
    }

}
