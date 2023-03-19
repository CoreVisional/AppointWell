package com.apu.appointwell.classes.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class DialogsUI {
    
    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showSuccessDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public int showConfirmDialog(String message) {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
