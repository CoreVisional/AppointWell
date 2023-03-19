package com.apu.appointwell.classes.auth;

import com.apu.appointwell.gui.auth.LoginForm;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class AuthenticationManager {
    
    public void logout(JFrame frame) {
        LoginForm login = new LoginForm();
        login.setVisible(true);
        frame.dispose();
    }
}
