package com.apu.appointwell.classes.utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alex
 */
public class ImageUtils {
    
    public void setFrameIcon(JFrame frame, String filepath) {
        URL resource = getClass().getResource(filepath);
        ImageIcon icon = new ImageIcon(resource);
        Image image = icon.getImage();
        frame.setIconImage(image);
    }

    public void scaleImage(JLabel imgLabel, String filepath) {
        URL resource = getClass().getResource(filepath);
        ImageIcon icon = new ImageIcon(resource);
        
        // Scale image to fix jLabel
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imgLabel.setIcon(scaledIcon);
    }
}
