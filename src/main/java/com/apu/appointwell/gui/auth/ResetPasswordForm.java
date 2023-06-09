package com.apu.appointwell.gui.auth;

import com.apu.appointwell.classes.utils.ImageUtils;
import com.apu.appointwell.classes.validators.DataValidation;
import com.apu.appointwell.classes.validators.InputValidation;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ResetPasswordForm extends javax.swing.JFrame {

    private static final String PATIENT_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\patients.txt";
    
    ImageUtils imageUtils = new ImageUtils();
    
    InputValidation inputValidation = new InputValidation();
    DataValidation dataValidation = new DataValidation();
    
    /**
     * Creates new form ResetPasswordForm
     */
    public ResetPasswordForm() {
        initComponents();
        initCustomComponents();
    }
    
    private void initCustomComponents(){
        imageUtils.setFrameIcon(this, "/icons/medical-appointment.png");
        imageUtils.scaleImage(imgLabel, "/images/forget-password-img.jpg");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailAddressTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resetPasswordBtn = new javax.swing.JButton();
        togglePasswordVisibilityBtn = new javax.swing.JToggleButton();
        newPasswordTxtField = new javax.swing.JPasswordField();
        confirmPasswordTxtField = new javax.swing.JPasswordField();
        backToSignInBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reset Password - AppointWell");

        mainPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setPreferredSize(new java.awt.Dimension(600, 720));
        leftPanel.setLayout(new java.awt.BorderLayout());

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftPanel.add(imgLabel, java.awt.BorderLayout.CENTER);

        mainPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setBackground(new java.awt.Color(153, 153, 153));
        rightPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(680, 120));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHANGE PASSWORD");
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        rightPanel.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Email Address:");

        emailAddressTxtField.setForeground(new java.awt.Color(0, 0, 0));
        emailAddressTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("New Password:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Confirm Password:");

        resetPasswordBtn.setBackground(new java.awt.Color(0, 153, 255));
        resetPasswordBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        resetPasswordBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetPasswordBtn.setText("Change Password");
        resetPasswordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordBtnActionPerformed(evt);
            }
        });

        togglePasswordVisibilityBtn.setBackground(new java.awt.Color(0, 0, 0));
        togglePasswordVisibilityBtn.setForeground(new java.awt.Color(0, 0, 0));
        togglePasswordVisibilityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide-icon.png"))); // NOI18N
        togglePasswordVisibilityBtn.setBorder(null);
        togglePasswordVisibilityBtn.setContentAreaFilled(false);
        togglePasswordVisibilityBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        togglePasswordVisibilityBtn.setFocusPainted(false);
        togglePasswordVisibilityBtn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/show-icon.png"))); // NOI18N
        togglePasswordVisibilityBtn.setRolloverEnabled(false);
        togglePasswordVisibilityBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                togglePasswordVisibilityBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                togglePasswordVisibilityBtnMouseReleased(evt);
            }
        });

        newPasswordTxtField.setForeground(new java.awt.Color(0, 0, 0));
        newPasswordTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        confirmPasswordTxtField.setForeground(new java.awt.Color(0, 0, 0));
        confirmPasswordTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));

        backToSignInBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        backToSignInBtn.setForeground(new java.awt.Color(255, 255, 255));
        backToSignInBtn.setText("<- Back to Sign In");
        backToSignInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToSignInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backToSignInBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToSignInBtn)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(emailAddressTxtField)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(resetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPasswordTxtField)
                            .addComponent(confirmPasswordTxtField, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(togglePasswordVisibilityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailAddressTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(togglePasswordVisibilityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPasswordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(resetPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(backToSignInBtn)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        rightPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        mainPanel.add(rightPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void togglePasswordVisibilityBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_togglePasswordVisibilityBtnMousePressed
        newPasswordTxtField.setEchoChar((char) 0);
    }//GEN-LAST:event_togglePasswordVisibilityBtnMousePressed

    private void togglePasswordVisibilityBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_togglePasswordVisibilityBtnMouseReleased
        newPasswordTxtField.setEchoChar('*');
    }//GEN-LAST:event_togglePasswordVisibilityBtnMouseReleased

    private void resetPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordBtnActionPerformed
               
        String userEmail = emailAddressTxtField.getText();
        char[] newPassword = newPasswordTxtField.getPassword();
        char[] passwordConfirmation = confirmPasswordTxtField.getPassword();
        
        if (!inputValidation.validationEmptyFields(newPassword, userEmail)) {
            JOptionPane.showMessageDialog(this, "One or more fields are blank", "Empty Field", JOptionPane.ERROR_MESSAGE);
        } else if (!dataValidation.verifyEmail(PATIENT_FILEPATH, userEmail)) {
            JOptionPane.showMessageDialog(this, "Email Does Not Exist", "Email Not Found", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.validatePassword(newPassword)) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long with at least a number, an uppercase, and a symbol", "Weak Password", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.confirmPassword(newPassword, passwordConfirmation)) {
            JOptionPane.showMessageDialog(this, "Password does not match", "Password Not Matched", JOptionPane.ERROR_MESSAGE);
        } else if (!dataValidation.validateNewPassword(PATIENT_FILEPATH, userEmail, newPassword)) {
            JOptionPane.showMessageDialog(this, "New password cannot be the same as the old password", "Failed To Change Password", JOptionPane.ERROR_MESSAGE);
        } else {
            resetPassword(PATIENT_FILEPATH, userEmail, newPassword);
            JOptionPane.showMessageDialog(this, "Password Changed Successfully");
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_resetPasswordBtnActionPerformed

    private void backToSignInBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToSignInBtnMousePressed
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToSignInBtnMousePressed

    private void resetPassword(String filename, String email, char[] newPassword) {
        
        Charset charset = Charset.forName("UTF-8");
        
        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            String line;
            long currentPosition = 0;
            while ((line = file.readLine()) != null) {
                String[] fields = line.split(", ");
                String currentEmail = fields[5].trim();
                if (currentEmail.equals(email)) {
                    currentPosition += line.indexOf(fields[6]);
                    file.seek(currentPosition);
                    byte[] passwordBytes = new String(newPassword).getBytes(charset);
                    file.write(passwordBytes);
                    break;
                }
                currentPosition = file.getFilePointer();
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPasswordForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backToSignInBtn;
    private javax.swing.JPasswordField confirmPasswordTxtField;
    private javax.swing.JTextField emailAddressTxtField;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField newPasswordTxtField;
    private javax.swing.JButton resetPasswordBtn;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JToggleButton togglePasswordVisibilityBtn;
    // End of variables declaration//GEN-END:variables
}
