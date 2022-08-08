package GUI.alert;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import java.awt.*;

public class Dialog extends JDialog implements Runnable {
    private final String massge;
    private final String title;
    private final JFrame parent;

    public Dialog(JFrame owner, String massge, String title) {
        super(owner);
        this.massge = massge;
        this.parent = owner;
        this.title = title;
        setPreferredSize(new Dimension(300,75));
        setLocationRelativeTo(owner);
        setTitle(title);


    }

    @Override
    public void run() {
        Dialog dialog = showWolcame();
        try {
            Thread.sleep(1500);
            dialog.dispose();
            Thread.interrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Dialog showWolcame() {
        JLabel messageLable = new JLabel(massge,SwingConstants.CENTER);
        this.add(messageLable);
        this.pack();
        this.setVisible(true);
        return this;
    }
}
