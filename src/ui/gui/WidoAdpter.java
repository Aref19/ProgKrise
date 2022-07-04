package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WidoAdpter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        Window w = e.getWindow();
        int result = JOptionPane.showConfirmDialog(w, "Wollen Sie die Anwendung schließen?");
        if (result == 0) {
            w.setVisible(false);
            w.dispose();
            System.exit(0);
        }
    }
}
