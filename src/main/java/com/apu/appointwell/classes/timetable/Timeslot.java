package com.apu.appointwell.classes.timetable;

import java.time.LocalTime;

/**
 *
 * @author Alex
 */
public class Timeslot {
    
    private String appointmentDate;
    private LocalTime appointmentTime;
    private String availability;
    private String doctor;
    
    public Timeslot(String appointmentDate, LocalTime appointmentTime, String availability, String doctor) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.availability = availability;
        this.doctor = doctor;
    }
    
    // Getter methods
    public String getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    public String getAvailability() {
        return availability;
    }
    
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDoctor() {
        return doctor;
    }
   
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
