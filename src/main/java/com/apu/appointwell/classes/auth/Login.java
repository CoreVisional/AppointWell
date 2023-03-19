package com.apu.appointwell.classes.auth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Alex
 */

public class Login {
    
    private static final String PATIENT_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\patients.txt";
    private static final String STAFF_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\staff.txt";
    
    public boolean isPatientLogin(String email, char[] password) {
        
        String[][] patientEmailsAndPasswords = getEmailsAndPassword(PATIENT_FILEPATH);
        
        if (patientEmailsAndPasswords != null) {
            for (String[] patientEmailAndPassword : patientEmailsAndPasswords) {
                if (email.equals(patientEmailAndPassword[0]) && Arrays.equals(password, patientEmailAndPassword[1].toCharArray())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isStaffLogin(String email, char[] password) {
        
        // Create a default staff account if one does not exists
        StaffAccount staffAccount = new StaffAccount();
        staffAccount.createDefaultStaffAccount();
        
        String[][] staffEmailsAndPasswords = getEmailsAndPassword(STAFF_FILEPATH);
        
        for (String[] staffEmailAndPassword : staffEmailsAndPasswords) {
            if (email.equals(staffEmailAndPassword[0]) && Arrays.equals(password, staffEmailAndPassword[1].toCharArray())) {
                return true;
            }
        }
        return false;
    }
    
    private String[][] getEmailsAndPassword(String filepath) {
        String[][] emailAndPassword = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            br.readLine();
            String line;
            
            // Check if file is empty
            int count = countLines(filepath);
            if (count == 0) {
                return null;
            }
            
            emailAndPassword = new String[countLines(filepath) - 1][2];
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] data;
                if (filepath.equals(PATIENT_FILEPATH)) {
                    data = line.split(", ");
                    emailAndPassword[i][0] = data[5];
                    emailAndPassword[i][1] = data[6];
                } else if (filepath.equals(STAFF_FILEPATH)) {
                    data = line.split(", ");
                    emailAndPassword[i][0] = data[2];
                    emailAndPassword[i][1] = data[3];
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        return emailAndPassword;
    }
    
    public String findPatientNameByEmail(String email) {
        String name = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENT_FILEPATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String currentEmail = fields[5].trim();
                if (email.equals(currentEmail)) {
                    name = fields[1].trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return name;
    }
    
    private int countLines(String filepath) {
        int lines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while (br.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return lines;
    }
}
