package com.apu.appointwell.classes.timetable;

import com.apu.appointwell.classes.utils.DialogsUI;
import com.apu.appointwell.classes.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class TimeslotFileHandler {
    
    private static final String TIMESLOT_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\timeslots.txt";
    private static final String APPOINTMENTS_FILEPATH = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\appointments.txt";
    private static final String HEADERS = "timeslot_id, appointment_date, appointment_time, availability, doctor_name\n";

    FileUtils fileUtils = new FileUtils();
    DialogsUI dialogsUI = new DialogsUI();
    
    public void createTimeslot(Timeslot timeslot, JTable tableName) {
        
        String appointmentDate = timeslot.getAppointmentDate();
        LocalTime appointmentTime = timeslot.getAppointmentTime();
        String availability = timeslot.getAvailability();
        String doctorName = timeslot.getDoctor();

        int timeslotId = fileUtils.generateID(TIMESLOT_FILEPATH, new File(TIMESLOT_FILEPATH));
        
        String[] varargs = {appointmentDate + ", " + appointmentTime + ", " + availability + ", " + doctorName + "\n"};
        Object[] tableData = {timeslotId, appointmentDate, appointmentTime, availability, doctorName};

        File file = new File(TIMESLOT_FILEPATH);
        
        fileUtils.verifyFileExistence(file);
        fileUtils.writeFile(TIMESLOT_FILEPATH, file, HEADERS, varargs);

        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.addRow(tableData);
    }
    
    public void updateTimeslot(JTable tableName) {
        
        File file = new File(TIMESLOT_FILEPATH);
        
        fileUtils.updateFile(file, HEADERS, tableName);
    }
    
    public void deleteTimeslot(JTable tableName) {
        int selectedRow = tableName.getSelectedRow();
        if (selectedRow == -1) {
            dialogsUI.showErrorDialog("Please select a row!");
            return;
        }
        try {
            List<String> timeslots = Files.readAllLines(Paths.get(TIMESLOT_FILEPATH));
            List<String> appointments = Files.readAllLines(Paths.get(APPOINTMENTS_FILEPATH));
            String[] selectedTimeslot = timeslots.get(selectedRow + 1).split(",\\s*");
            for (int i = appointments.size() - 1; i >= 1; i--) {
                String[] appointment = appointments.get(i).split(",\\s*");
                if (appointment[4].equals(selectedTimeslot[1]) && appointment[5].equals(selectedTimeslot[2])
                        && appointment[3].equals(selectedTimeslot[4])) {
                    appointment[7] = "CANCELLED";
                    appointments.set(i, String.join(", ", appointment));
                }
            }
            dialogsUI.showSuccessDialog("Timeslot Deleted Successfully. Appointments related to this timeslot has been marked as CANCELLED");
            timeslots.remove(selectedRow + 1);
            Files.write(Paths.get(TIMESLOT_FILEPATH), timeslots);
            Files.write(Paths.get(APPOINTMENTS_FILEPATH), appointments);
            // update the table model and set the updated model to the JTable
            DefaultTableModel model = (DefaultTableModel) tableName.getModel();
            model.removeRow(selectedRow);
            tableName.setModel(model);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading/writing file: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
