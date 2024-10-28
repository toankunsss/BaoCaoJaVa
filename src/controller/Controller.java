package controller;

import baocaojava.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Toan
 */
public class Controller implements ActionListener{
    private Login login;

    public Controller(Login login) {
        this.login = login;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src =e.getActionCommand();
        
    }
}
