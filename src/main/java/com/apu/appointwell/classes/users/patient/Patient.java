package com.apu.appointwell.classes.users.patient;

import com.apu.appointwell.classes.users.User;

/**
 *
 * @author Alex
 */
public class Patient extends User {
   
    private String gender;
    private String phone;
    private String birthdate; 
    
    public Patient(String name, String email, char[] password, String birthdate, String gender, String phone) {
        super(name, email, password);
        this.birthdate = birthdate;
        this.gender = gender;
        this.phone = phone;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public char[] getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(char[] password) {
        super.setPassword(password);
    }
}
