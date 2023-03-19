package com.apu.appointwell.classes.validators;

import com.apu.appointwell.classes.timetable.Timeslot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alex
 */
public class DataValidation {
    
    public boolean validateAccountExistence(File filename) {
        
        try (Scanner scanner = new Scanner(filename)) {
            // Skip the first row (header)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Check if there is at least one record in the second row
            if (scanner.hasNextLine()) {
                String secondRow = scanner.nextLine();
                return !secondRow.isBlank();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }

        return false;
    }
    
    public boolean validateDuplicateEmail(String email, String filename) {
        
        Set<String> emails = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(", ");
                emails.add(fields[5].trim());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        return emails.contains(email);
    }
    
    public boolean validateDuplicateTimeslot(Timeslot timeslot, String filename) {
        try {
            String appointmentDate = timeslot.getAppointmentDate();
            LocalTime appointmentTime = timeslot.getAppointmentTime();

            boolean timeslotExists = Files.lines(Paths.get(filename))
                    .anyMatch(line -> {
                        String[] fields = line.split(",");
                        return fields[1].trim().equals(appointmentDate) && fields[2].trim().equals(appointmentTime.toString());
                    });

            return timeslotExists;
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return true;
        }
    }
    
    public boolean verifyEmail(String filename, String email) {
        
        boolean isEmailFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // skip headers
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(", ");
                String emailFromText = values[5].trim();
                if (email.equals(emailFromText)) {
                    isEmailFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return isEmailFound;
    }
    
    public boolean validateNewPassword(String filename, String email, char[] newPassword) {
        
        boolean isValid = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] patientData = line.split(",");
                String patientEmail = patientData[5].trim();
                if (patientEmail.equals(email)) {
                    String oldPassword = patientData[6].trim();
                    String newPassString = String.valueOf(newPassword);
                    if (oldPassword.equals(newPassString)) {
                        isValid = false;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return isValid;
    }
}
