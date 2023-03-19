package com.apu.appointwell.classes.auth;

import com.apu.appointwell.classes.users.patient.Patient;
import com.apu.appointwell.classes.utils.FileUtils;
import java.io.File;

/**
 *
 * @author Alex
 */
public class Registration {
    
    private final String filename = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\patients.txt";
    private final String headers = "patient_id, name, birthdate, gender, phone_number, email, password\n";
    FileUtils fileUtils = new FileUtils();
    
    public void registerUser(Patient patient) {
        String name = patient.getName();
        String birthdate = patient.getBirthdate();
        String gender = patient.getGender();
        String email = patient.getEmail();
        String phone = patient.getPhone();
        String password = new String(patient.getPassword());
        
        // Values to save
        String[] varargs = {name + ", " + birthdate + ", " + gender + ", " + phone + ", " + email + ", " + password + "\n"};
  
        File file = new File(filename);
        fileUtils.verifyFileExistence(file);
        fileUtils.writeFile(filename, file, headers, varargs);
    }
}
