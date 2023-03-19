package com.apu.appointwell.classes.appointment;

import com.apu.appointwell.classes.utils.FileUtils;
import com.apu.appointwell.classes.utils.NumberGeneratorUtils;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class AppointmentFileHandler {
    
    private static final String APPOINTMENT_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\appointments.txt";
    private static final String HEADERS = "appointment_id, appointment_number, booked_on, patient_name, doctor_name, appointment_date, appointment_time, visit_type, appointment_status\n";
    
    FileUtils fileUtils = new FileUtils();
    
    public void createAppointment(Appointment appointment, JTable tableName) {
        
        NumberGeneratorUtils numberGeneratorUtils = new NumberGeneratorUtils();
        
        int appointmentId = fileUtils.generateID(APPOINTMENT_FILEPATH, new File(APPOINTMENT_FILEPATH));
        
        int appointmentNumber = numberGeneratorUtils.generateRandomNumbers();
        String patientName = appointment.getPatientName();
        String doctorName = appointment.getDoctor();
        String appointmentDate = appointment.getAppointmentDate();
        LocalTime appointmentTime = appointment.getAppointmentTime();
        String visitType = appointment.getVisitType();
        
        // Default Appointment Status Value
        String status = "BOOKED";
        
        LocalDate currentDate = LocalDate.now();
        
        String[] varargs = {appointmentNumber + ", " + currentDate + ", " + patientName + ", " + doctorName + ", " + appointmentDate + ", " + appointmentTime + ", " + visitType + ", " + status + "\n"};
        Object[] tableData = {appointmentId, appointmentNumber, doctorName, appointmentDate, appointmentTime, status};
        
        File file = new File(APPOINTMENT_FILEPATH);
        fileUtils.verifyFileExistence(file);
        fileUtils.writeFile(APPOINTMENT_FILEPATH, file, HEADERS, varargs);
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.addRow(tableData);
    }
}
