package com.apu.appointwell.classes.appointment;

import com.apu.appointwell.classes.timetable.Timeslot;
import java.time.LocalTime;

/**
 *
 * @author Alex
 */
public class Appointment extends Timeslot {

    private String patientName;
    private String visitType;
    
    public Appointment(String appointmentDate, LocalTime appointmentTime, String doctor, String patientName, String visitType) {
        super(appointmentDate, appointmentTime, "Available", doctor);
        this.patientName = patientName;
        this.visitType = visitType;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getVisitType() {
        return visitType;
    }
    
    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }
}
