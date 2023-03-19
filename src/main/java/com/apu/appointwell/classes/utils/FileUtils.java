package com.apu.appointwell.classes.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class FileUtils {
    
    DialogsUI dialogsUI = new DialogsUI();
    
    public boolean verifyFileExistence(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return true;
    }
    
    public int generateID(String filename, File file) {

        int id = 1;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            reader.readLine(); // skip first line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                int currId = Integer.parseInt(fields[0].trim());
                if (currId >= id) {
                    id = currId + 1; // increment ID value
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }
    
    public void writeFile(String filename, File file, String headers, String... varargs) {
        
        int id = generateID(filename, file);
        
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            if (file.length() == 0) {
                writer.write(headers);
            }
            for (String line : varargs) {
                writer.write(id + ", " + line);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void updateFile(File file, String headers, JTable tableName) {
        
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {
            writer.write(headers);
            for (int i = 0; i < tableName.getRowCount(); i++) {
                for (int j = 0; j < tableName.getColumnCount(); j++) {
                    writer.write(tableName.getModel().getValueAt(i, j).toString());
                    if (j != tableName.getColumnCount() - 1) {
                        writer.write(", ");
                    }
                }
                writer.write("\n"); // add a newline after each row
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void populateComboBoxFromFile(String filepath, JComboBox comboBoxName, int columnIndex) {
        
        ArrayList<String> values = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            // Skip the first line that contains the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] records = line.split(", ");
                String data = records[columnIndex];
                // Add values
                values.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        for (String value : values) {
            comboBoxName.addItem(value);
        }
    }
       
    public void populateTableFromFile(String filename, JTable tableName) {

        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }   
    }
    
    public void populateTableFromFile(String filename, JTable tableName, int[] indices) {

        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                Object[] rowData = new Object[indices.length];
                for (int i = 0; i < indices.length; i++) {
                    rowData[i] = data[indices[i]];
                }
                model.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }   
    }
    
    public void populateAppointmentsTable(String name, String filename, JTable tableName, Set<String> status, int[] indices) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            Object[] rowData = new Object[indices.length + 1]; // add one element for the row number
            int rowNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                // Check if the appointment status matches one of the status values
                if (status.contains(data[8])) {
                    // Check if the name matches
                    if (name.equals(data[3])) {
                        rowData[0] = rowNumber; // set the first element to the row number
                        rowNumber++; // increment the row number
                        for (int i = 0; i < indices.length; i++) {
                            rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                        }
                        model.addRow(rowData);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void populateAppointmentsTable(String filename, JTable tableName, String status, int[] indices) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            Object[] rowData = new Object[indices.length + 1]; // add one element for the row number
            int rowNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");

                // Check if the appointment status matches one of the status values
                if (status.equals(data[8])) {
                    // Check if the name matches
                    rowData[0] = rowNumber; // set the first element to the row number
                    rowNumber++; // increment the row number
                    for (int i = 0; i < indices.length; i++) {
                        rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                    }
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void populateMedicalHistoryTable(String name, String filename, JTable tableName, String confirmStatus, String cancelStatus, int[] indices) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);

        LocalDate today = LocalDate.now(); // Get today's date
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            Object[] rowData = new Object[indices.length + 1]; // add one element for the row number
            int rowNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                // Check if the appointment status matches one of the status values
                if (name.equals(data[3]) && confirmStatus.equals(data[8])) {
                    // Check if the appointment date is before today's date
                    LocalDate appointmentBookedOnDate = LocalDate.parse(data[2]);
                    if (appointmentBookedOnDate.isBefore(today)) {
                        rowData[0] = rowNumber; // set the first element to the row number
                        rowNumber++; // increment the row number
                        for (int i = 0; i < indices.length; i++) {
                            rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                        }
                        model.addRow(rowData);
                    }
                } else if (name.equals(data[3]) && cancelStatus.equals(data[8])) {
                    rowData[0] = rowNumber; // set the first element to the row number
                    rowNumber++; // increment the row number
                    for (int i = 0; i < indices.length; i++) {
                        rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                    }
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void populateMedicalHistoryTable(String filename, JTable tableName, String confirmStatus, String cancelStatus, int[] indices) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        model.setRowCount(0);

        LocalDate today = LocalDate.now(); // Get today's date
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            Object[] rowData = new Object[indices.length + 1]; // add one element for the row number
            int rowNumber = 1;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                // Check if the appointment status matches one of the status values
                if (confirmStatus.equals(data[8])) {
                    // Check if the appointment date is before today's date
                    LocalDate appointmentBookedOnDate = LocalDate.parse(data[2]);
                    if (appointmentBookedOnDate.isBefore(today)) {
                        rowData[0] = rowNumber; // set the first element to the row number
                        rowNumber++; // increment the row number
                        for (int i = 0; i < indices.length; i++) {
                            rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                        }
                        model.addRow(rowData);
                    }
                } else if (cancelStatus.equals(data[8])) {
                    rowData[0] = rowNumber; // set the first element to the row number
                    rowNumber++; // increment the row number
                    for (int i = 0; i < indices.length; i++) {
                        rowData[i + 1] = data[indices[i]]; // assign the data values to the rest of the elements
                    }
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void updateAppointmentStatus(String filename, JTable tableName, String status, boolean showSuccessDialog) {
        
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();

        int row = tableName.getSelectedRow();
        
        if (row == -1) {
            dialogsUI.showErrorDialog("Please select a row!");
            return;
        }
        
        String appointmentNumber = model.getValueAt(row, 1).toString();
        
        try {
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path);
            boolean found = false;
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(", ");
                if (parts[1].equals(appointmentNumber)) {
                    parts[8] = status;
                    lines.set(i, String.join(", ", parts));
                    found = true;
                    break;
                }
            }
            if (!found) {
                dialogsUI.showErrorDialog("Appointment not found.");
                return;
            }
            Files.write(path, lines);
            if (showSuccessDialog) {
                dialogsUI.showSuccessDialog("Appointment status updated successfully.");
            }
        } catch (IOException e) {
            dialogsUI.showErrorDialog("Error updating appointment status: " + e.getMessage());
        }
    }
    
    public void updateDoctorAvailabilityStatus(String appointmentFilename, String timeslotFilename, JTable tableName, String statusName) {
        
        DefaultTableModel appointmentsModel = (DefaultTableModel) tableName.getModel();

        int selectedRow = tableName.getSelectedRow();

        if (selectedRow == -1) {
            dialogsUI.showErrorDialog("Please select an appointment!");
            return;
        }
        
        String appointmentDate = appointmentsModel.getValueAt(selectedRow, 2).toString();
        String appointmentTime = appointmentsModel.getValueAt(selectedRow, 3).toString();
        String doctorName = appointmentsModel.getValueAt(selectedRow, 5).toString();

        try {
            // Check if the appointment timeslot is "Unavailable"
            Path timeslotsPath = Paths.get(timeslotFilename);
            List<String> timeslotsLines = Files.readAllLines(timeslotsPath);
            boolean timeslotUnavailable = false;
            for (int i = 1; i < timeslotsLines.size(); i++) {
                String line = timeslotsLines.get(i);
                String[] parts = line.split(", ");
                if (parts[3].equals("Unavailable") && parts[1].equals(appointmentDate) && parts[2].equals(appointmentTime) && parts[4].equals(doctorName)) {
                    timeslotUnavailable = true;
                    break;
                }
            }
            if (timeslotUnavailable) {
                dialogsUI.showErrorDialog("This appointment cannot be confirmed as the doctor is unavailable at this time.");
                return;
            }

            updateAppointmentStatus(appointmentFilename, tableName, statusName, false);

            // Update the availability status of the doctor to "Unavailable"
            timeslotsLines = Files.readAllLines(timeslotsPath);
            boolean timeslotFound = false;
            for (int i = 1; i < timeslotsLines.size(); i++) {
                String line = timeslotsLines.get(i);
                String[] parts = line.split(", ");
                if (parts[3].equals("Available") && parts[1].equals(appointmentDate) && parts[2].equals(appointmentTime) && parts[4].equals(doctorName)) {
                    parts[3] = "Unavailable";
                    timeslotsLines.set(i, String.join(", ", parts));
                    timeslotFound = true;
                    break;
                }
            }
            if (!timeslotFound) {
                dialogsUI.showErrorDialog("Doctor timeslot not found.");
                return;
            }
            
            Files.write(timeslotsPath, timeslotsLines);
            dialogsUI.showSuccessDialog("Appointment confirmed successfully.");
            
        } catch (IOException e) {
            dialogsUI.showErrorDialog("Error updating appointment status: " + e.getMessage());
        }
    }
    
    public void displayCurrentAppointments(String filename, JTable tableName, String status, int[] indices) {

        try {
            List<String[]> appointments = Files.lines(Paths.get(filename))
                .skip(1)
                .map(line -> line.split(", "))
                .collect(Collectors.toList());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            List<String[]> filteredAppointments = appointments.stream()
                .filter(appointment -> LocalDate.parse(appointment[2], formatter).isEqual(LocalDate.now())
                    && appointment[8].equals(status))
                .collect(Collectors.toList());
            
            DefaultTableModel tableModel = (DefaultTableModel) tableName.getModel();
            tableModel.setRowCount(0);
            int tableRow = 1;
            for (String[] appointment : filteredAppointments) {
                Object[] rowData = new Object[indices.length + 1];
                rowData[0] = tableRow++;
                for (int i = 0; i < indices.length; i++) {
                    rowData[i + 1] = appointment[indices[i]];
                }
                tableModel.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void displayCurrentAppointments(String patientName, String filename, JTable tableName, String status, int[] indices) {

        try {
            List<String[]> appointments = Files.lines(Paths.get(filename))
                .skip(1)
                .map(line -> line.split(", "))
                .collect(Collectors.toList());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            List<String[]> filteredAppointments = appointments.stream()
                .filter(appointment -> LocalDate.parse(appointment[2], formatter).isEqual(LocalDate.now())
                    && appointment[8].equals(status) && appointment[3].equals(patientName))
                .collect(Collectors.toList());
            
            DefaultTableModel tableModel = (DefaultTableModel) tableName.getModel();
            tableModel.setRowCount(0);
            int tableRow = 1;
            for (String[] appointment : filteredAppointments) {
                Object[] rowData = new Object[indices.length + 1];
                rowData[0] = tableRow++;
                for (int i = 0; i < indices.length; i++) {
                    rowData[i + 1] = appointment[indices[i]];
                }
                tableModel.addRow(rowData);
            }
            
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void deleteDoctor(String doctorFilename, String timeslotFilename, String appointmentFilename, JTable tableName) {

        DefaultTableModel doctorTableModel = (DefaultTableModel) tableName.getModel();
        int selectedRow = tableName.getSelectedRow();

        if (selectedRow == -1) {
            dialogsUI.showErrorDialog("Please select a doctor!");
            return;
        }

        String doctorName = (String) doctorTableModel.getValueAt(selectedRow, 1);

        if (hasBookedOrConfirmedAppointment(doctorName, appointmentFilename)) {
            dialogsUI.showErrorDialog("Doctor has a booked or confirmed appointment and cannot be deleted.");
            return;
        }

        if (isAssignedToTimeslot(doctorName, timeslotFilename)) {
            dialogsUI.showErrorDialog("Doctor is assigned to a timeslot and cannot be deleted.");
            return;
        }

        try (Scanner doctorScanner = new Scanner(new File(doctorFilename))) {
            List<String> lines = new ArrayList<>();
            boolean skipHeader = true;
            int id = 1;
            while (doctorScanner.hasNextLine()) {
                String line = doctorScanner.nextLine();
                if (skipHeader) {
                    lines.add(line);
                    skipHeader = false;
                    continue;
                }
                String[] doctorFields = line.split(", ");
                String name = doctorFields[1];
                if (!name.equals(doctorName)) {
                    doctorFields[0] = Integer.toString(id++);
                    line = String.join(", ", doctorFields);
                    lines.add(line);
                }
            }
            Files.write(Paths.get(doctorFilename), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        doctorTableModel.removeRow(selectedRow);

        for (int i = selectedRow + 1; i < doctorTableModel.getRowCount(); i++) {
            doctorTableModel.setValueAt(i, i, 0);
        }
        
        dialogsUI.showSuccessDialog("Doctor Removed From System Successfully.");
    }

    private boolean hasBookedOrConfirmedAppointment(String doctorName, String appointmentFilename) {
        try (Scanner appointmentScanner = new Scanner(new File(appointmentFilename))) {
            while (appointmentScanner.hasNextLine()) {
                String line = appointmentScanner.nextLine();
                String[] appointmentFields = line.split(", ");
                String appointmentStatus = appointmentFields[8];
                String doctorInAppointment = appointmentFields[4];
                if (doctorInAppointment.equals(doctorName) && (appointmentStatus.equals("BOOKED") || appointmentStatus.equals("CONFIRMED"))) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
    private boolean isAssignedToTimeslot(String doctorName, String timeslotFilename) {
        try (Scanner timeslotScanner = new Scanner(new File(timeslotFilename))) {
            while (timeslotScanner.hasNextLine()) {
                String line = timeslotScanner.nextLine();
                String[] timeslotFields = line.split(", ");
                String doctorInTimeslot = timeslotFields[4];
                if (doctorInTimeslot.equals(doctorName)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
}
