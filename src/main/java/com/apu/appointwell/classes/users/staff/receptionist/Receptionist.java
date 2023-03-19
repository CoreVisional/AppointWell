package com.apu.appointwell.classes.users.staff.receptionist;

import com.apu.appointwell.classes.users.User;

/**
 *
 * @author Alex
 */
public class Receptionist extends User {
    
    public Receptionist(String name, String email, char[] password) {
        super(name, email, password);
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
