package GUI;

import GUI.alert.Alert;
import GUI.kunde.JFRegistieren;
import GUI.services.KundenService;
import exception.LoginFailedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Wilcomen extends JFrame {
    private Container container;
    private JTextField emailText;
    private JPasswordField passText;
    private JLabel emaiJLabel;
    private JLabel pasJLabel;
    private JButton anmeldJButton;
    private JButton registereJButton;
    private Panel rootPannel;
    private ButtonGroup buttonGroup;
    private KundenService kundenService;
    JRadioButton mitarbeiterRadio;
    JRadioButton kundRadio;

    public Wilcomen(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 423, 272);
        getContentPane().setLayout(null);
        initialize();
        this.setVisible(true);
        kundenService = new KundenService();
        anmeldJButton.addActionListener(anmelden());
        registereJButton.addActionListener(registrieren());
    }

    public void initialize() {

        emaiJLabel = new JLabel("email");
        emaiJLabel.setBounds(42, 70, 46, 14);
        getContentPane().add(emaiJLabel);
        buttonGroup = new ButtonGroup();
        emailText = new JTextField();
        emailText.setBounds(110, 67, 131, 20);
        getContentPane().add(emailText);
        emailText.setColumns(10);

        pasJLabel = new JLabel("pass");
        pasJLabel.setBounds(42, 108, 46, 14);
        getContentPane().add(pasJLabel);

        mitarbeiterRadio = new JRadioButton("mitarbeiter");
        buttonGroup.add(mitarbeiterRadio);

        mitarbeiterRadio.setBounds(292, 66, 109, 23);
        getContentPane().add(mitarbeiterRadio);

        kundRadio = new JRadioButton("kunde");
        buttonGroup.add(kundRadio);
        kundRadio.setSelected(true);
        kundRadio.setBounds(292, 104, 109, 23);
        getContentPane().add(kundRadio);

        registereJButton = new JButton("Registeren");
        registereJButton.setBounds(246, 199, 100, 23);
        getContentPane().add(registereJButton);

        anmeldJButton = new JButton("anmelden");
        anmeldJButton.setBounds(128, 199, 100, 23);
        getContentPane().add(anmeldJButton);

        passText = new JPasswordField();
        passText.setBounds(110, 105, 131, 20);
        getContentPane().add(passText);
    }

    private ActionListener registrieren() {
        return e -> {
            if (kundRadio.isSelected()) {
                kundenService.kill(this);
                new JFRegistieren("Registieren");
            } else if (mitarbeiterRadio.isSelected()) {
                //ToDo Ajab
            }
        };
    }

    private ActionListener anmelden() {
        return e -> {
            try {
                kundenService.login(emailText.getText(),passText.getText());
                kundenService.kill(this);
                kundenService.setPerson();
            } catch (LoginFailedException ex) {
                Alert alert=new Alert(this,ex.getMessage(),"Erorr");
                alert.showInfoMassage();
            }
        };
    }



    public static void main(String[] args) {
        Wilcomen wilcomen = new Wilcomen("");
    }

}
