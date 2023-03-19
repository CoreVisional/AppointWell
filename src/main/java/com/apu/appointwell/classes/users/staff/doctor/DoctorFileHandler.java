package com.apu.appointwell.classes.users.staff.doctor;

import com.apu.appointwell.classes.utils.FileUtils;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class DoctorFileHandler {
    
    private final String DOCTOR_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\doctors.txt";
    private final String HEADERS = "doctor_id, name, gender, birthdate, age, specialty\n";
    FileUtils fileUtils = new FileUtils();
    
    public void createDoctor(Doctor doctor, JTable tableName) {
        
        int doctorId;

        doctorId = fileUtils.generateID(DOCTOR_FILEPATH, new File(DOCTOR_FILEPATH));

        String doctorName = doctor.getName();
        String doctorGender = doctor.getGender();
        String doctorBirthdate = doctor.getBirthdate();
        int doctorAge = doctor.getAge();
        String doctorSpecialty = doctor.getSpecialty();
        
        String[] varargs = {doctorName + ", " + doctorGender + ", " + doctorBirthdate + ", " + doctorAge + ", " + doctorSpecialty + "\n"};
        Object[] tableData = {doctorId, doctorName, doctorGender, doctorBirthdate, doctorAge, doctorSpecialty};
        
        File file = new File(DOCTOR_FILEPATH);
        fileUtils.verifyFileExistence(file);
        fileUtils.writeFile(DOCTOR_FILEPATH, file, HEADERS, varargs);
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.addRow(tableData);
    }
    
    public void updateDoctor(JTable tableName) {
        
        File file = new File(DOCTOR_FILEPATH);
        
        fileUtils.updateFile(file, HEADERS, tableName);
    }
}
