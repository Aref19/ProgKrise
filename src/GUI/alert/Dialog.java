package GUI.alert;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import java.awt.*;

public class Dialog extends JDialog implements Runnable {
    private final  String massge;
    private final String title;
    private final JFrame parent;

    public Dialog(JFrame owner, String massge, String title, JFrame parent) {
        super(owner);
        this.massge = massge;
        this.parent=owner;
        this.title = title;
    }

    @Override
    public void run() {
     Dialog  dialog= showWolcame();
        try {
            Thread.sleep(2000);
            dialog.dispose();
            Thread.interrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private  Dialog showWolcame(){
        JLabel messageLable=new JLabel(massge);
        messageLable.setFont(new Font(massge, Font.ITALIC,12));
        this.add(messageLable);
        setBounds(300, 300, 300, 250);
        this.pack();
        this.setVisible(true);
     return this;
    }
}
