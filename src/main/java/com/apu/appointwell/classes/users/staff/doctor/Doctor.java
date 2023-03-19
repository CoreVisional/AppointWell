package com.apu.appointwell.classes.users.staff.doctor;

/**
 *
 * @author Alex
 */
public class Doctor {
    
    private String name;
    private String gender;
    private String birthdate;
    private int age;
    private String specialty;
    
    public Doctor(String name, String gender, String birthdate, int age, String specialty) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.age = age;
        this.specialty = specialty;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
