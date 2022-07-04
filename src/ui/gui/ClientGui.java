package ui.gui;

import ui.gui.Login.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class ClientGui extends JFrame {
    private LoginPanel  addPanel;
    public ClientGui(String title) throws HeadlessException {
        super(title);
        initialize();

    }
    private void initialize(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WidoAdpter());
        setLayout(new BorderLayout());
        addPanel=new LoginPanel();
        add(addPanel, BorderLayout.CENTER);
        setSize(640, 480);
        setVisible(true);

    }

}
