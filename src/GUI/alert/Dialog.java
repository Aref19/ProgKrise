package GUI.alert;

import javax.swing.*;

public class Dialog extends JDialog implements Runnable {
    private String massge;
    private String title;
    private  JFrame parent;



    @Override
    public void run() {
      Dialog dialog=new Dialog().showWolcame();
        try {
            Thread.sleep(2000);
            dialog.dispose();
            Thread.interrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Dialog showWolcame(){
        this.massge = "Hallo in ProgKrise";
        this.title = title;
        this.parent = parent;
        this.setSize(200,50);
        this.add(new JLabel(massge));
        this.setVisible(true);
     return this;
    }
}
