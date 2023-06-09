package com.apu.appointwell.gui.auth;

import com.apu.appointwell.classes.utils.ImageUtils;
import com.apu.appointwell.classes.users.patient.Patient;
import com.apu.appointwell.classes.auth.Registration;
import com.apu.appointwell.classes.validators.DataValidation;
import com.apu.appointwell.classes.validators.InputValidation;
import java.util.Locale;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class RegistrationForm extends javax.swing.JFrame {
    
    ImageUtils imageUtils = new ImageUtils();
    
    InputValidation inputValidation = new InputValidation();
    DataValidation dataValidation = new DataValidation();

    Registration registration = new Registration();

    /**
     * Creates new form RegistrationForm
     */
    public RegistrationForm() {
        initComponents();
        initCustomComponents();
        setVisible(true);
    }
    
    private void initCustomComponents(){
        imageUtils.setFrameIcon(this, "/icons/medical-appointment.png");
        imageUtils.scaleImage(imgLabel, "/images/register-img.jpg");
        signInBtn.setText("<HTML><U>Sign In</U></HTML>");
        getCountryCodes();
        setGenderSelection();
    }
    
    private void getCountryCodes() {
        
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        List<String> countryCodes = new ArrayList<>();
        Set<String> countryCodeSet = new HashSet<>();
        Set<String> excludedCountryCodes = new HashSet<>();
        String[] excludedCountryCodeArray = {"001", "150", "419"};
   
        excludedCountryCodes.addAll(Arrays.asList(excludedCountryCodeArray));
        
        for (Locale locale : Locale.getAvailableLocales()) {
            String countryName = locale.getDisplayCountry();
            if (countryName.length() == 0) {
                continue;
            }
            String countryCode = locale.getCountry();
            if (countryCodeSet.contains(countryCode) || excludedCountryCodes.contains(countryCode)) {
                continue;
            }
            countryCodeSet.add(countryCode);
            String callingCode = "+" + phoneUtil.getCountryCodeForRegion(countryCode);
            countryCodes.add(countryCode + " " + callingCode);
        }
        Collections.sort(countryCodes);
        
        for (String countryCode : countryCodes) {
            countryCodeComboBox.addItem(countryCode);
        }
        
        countryCodeComboBox.setSelectedItem("MY +60");
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
        jPanel1 = new javax.swing.JPanel();
        createAccountLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        countryCodeComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        birthdateField = new com.toedter.calendar.JDateChooser();
        nameTxtField = new javax.swing.JTextField();
        emailTxtField = new javax.swing.JTextField();
        confirmPasswordTxtField = new javax.swing.JPasswordField();
        passwordTxtField = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        phoneNumberTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        registerBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        signInBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration - AppointWell");
        setResizable(false);

        mainPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setPreferredSize(new java.awt.Dimension(600, 720));

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );

        mainPanel.add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setBackground(new java.awt.Color(196, 30, 58));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        createAccountLabel.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        createAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        createAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        createAccountLabel.setText("Create Account");
        createAccountLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(createAccountLabel, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date of Birth:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password:");

        countryCodeComboBox.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password:");

        birthdateField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        birthdateField.setForeground(new java.awt.Color(0, 0, 0));
        birthdateField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        nameTxtField.setBackground(new java.awt.Color(196, 30, 58));
        nameTxtField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        nameTxtField.setForeground(new java.awt.Color(255, 255, 255));
        nameTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        nameTxtField.setCaretColor(new java.awt.Color(255, 255, 255));

        emailTxtField.setBackground(new java.awt.Color(196, 30, 58));
        emailTxtField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        emailTxtField.setForeground(new java.awt.Color(220, 220, 220));
        emailTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        emailTxtField.setCaretColor(new java.awt.Color(255, 255, 255));

        confirmPasswordTxtField.setBackground(new java.awt.Color(196, 30, 58));
        confirmPasswordTxtField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        confirmPasswordTxtField.setForeground(new java.awt.Color(255, 255, 255));
        confirmPasswordTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        confirmPasswordTxtField.setCaretColor(new java.awt.Color(255, 255, 255));

        passwordTxtField.setBackground(new java.awt.Color(196, 30, 58));
        passwordTxtField.setForeground(new java.awt.Color(255, 255, 255));
        passwordTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        passwordTxtField.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone:");

        phoneNumberTxtField.setBackground(new java.awt.Color(196, 30, 58));
        phoneNumberTxtField.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        phoneNumberTxtField.setForeground(new java.awt.Color(255, 255, 255));
        phoneNumberTxtField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
        phoneNumberTxtField.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name (Same as IC / Password):");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gender:");

        genderComboBox.setForeground(new java.awt.Color(0, 0, 0));
        genderComboBox.setToolTipText("");
        genderComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        genderComboBox.setFocusable(false);

        registerBtn.setBackground(new java.awt.Color(255, 255, 255));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(196, 30, 58));
        registerBtn.setText("REGISTER");
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.setFocusPainted(false);
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Already have an account?");

        signInBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(255, 255, 255));
        signInBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        signInBtn.setText("Sign In");
        signInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(countryCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumberTxtField))
                            .addComponent(emailTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPasswordTxtField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rightPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3)
                                    .addComponent(birthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmPasswordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(signInBtn))
                .addGap(21, 21, 21))
        );

        mainPanel.add(rightPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String filename = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\patients.txt";
        String name = getPatientName();
        String birthdate = getBirthdate();
        String gender = getSelectedGender();
        String email = getEmail();
        String countryCode = getCountryCode();
        String nationalCode = getNationalCode();
        String nationalNumber = getPhoneNumber();
        String phoneNumber = nationalCode + nationalNumber;
        char[] password = retrievePassword();
        char[] confirmPassword = confirmPasswordTxtField.getPassword();

        if (!inputValidation.validationEmptyFields(password, name, birthdate, gender, email)) {
            JOptionPane.showMessageDialog(this, "One or more fields are blank", "Empty Field", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.validateEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (dataValidation.validateDuplicateEmail(email, filename)) {
            JOptionPane.showMessageDialog(this, "This email already exists", "Duplicated Email", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.validatePhoneNumber(nationalNumber, countryCode)) {
            JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Phone Number Invalid", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.validatePassword(password)) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long with at least a number, an uppercase, and a symbol", "Weak Password", JOptionPane.ERROR_MESSAGE);
        } else if (!inputValidation.confirmPassword(password, confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password does not match", "Password Not Matched", JOptionPane.ERROR_MESSAGE);
        } else {
            Patient patient = new Patient(name, email, password, birthdate, gender, phoneNumber);
            JOptionPane.showMessageDialog(this, "Registration Successfully! You may now login.");
            registration.registerUser(patient);
            resetPasswordArray(password);
            LoginForm login = new LoginForm();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void signInBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInBtnMouseClicked
        LoginForm login = new LoginForm();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signInBtnMouseClicked

    private String getPatientName() {
        return nameTxtField.getText();
    }
    
    private String getEmail() {
        return emailTxtField.getText();
    }
    
    private String getPhoneNumber() {
        String phoneTxtField = phoneNumberTxtField.getText();
        String phoneNumberFormat = phoneTxtField.replaceAll("[^0-9]", "");
        return phoneNumberFormat;
    }

    private String getCountryCode() {
        return countryCodeComboBox.getSelectedItem().toString().split(" ")[0];
    }
    
    private String getNationalCode() {
        return countryCodeComboBox.getSelectedItem().toString().split(" ")[1];
    }

    private char[] retrievePassword() {
        return passwordTxtField.getPassword();
    }

    private void resetPasswordArray(char[] password) {
        Arrays.fill(password, '0');
    }
    
    private String getSelectedGender() {
        Object selectedItem = genderComboBox.getSelectedItem();
        if (selectedItem != null) {
            String selectedGender = selectedItem.toString();
            return selectedGender;
        }
        return null;
    }
    
    private void setGenderSelection() {
        String[] options = {"Male", "Female"};

        for (String option : options) {
            genderComboBox.addItem(option);
        }
        
        genderComboBox.setSelectedItem(null);
    }
    
    private String getBirthdate() {
        Date selectedDate = birthdateField.getDate();
        String formattedDate;

        if (selectedDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = dateFormat.format(selectedDate);
        } else {
            formattedDate = null;
        }

        return formattedDate;
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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser birthdateField;
    private javax.swing.JPasswordField confirmPasswordTxtField;
    private javax.swing.JComboBox<String> countryCodeComboBox;
    private javax.swing.JLabel createAccountLabel;
    private javax.swing.JTextField emailTxtField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JPasswordField passwordTxtField;
    private javax.swing.JTextField phoneNumberTxtField;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel signInBtn;
    // End of variables declaration//GEN-END:variables
}



