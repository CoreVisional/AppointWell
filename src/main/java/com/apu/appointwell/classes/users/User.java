package com.apu.appointwell.classes.users;

/**
 *
 * @author Alex
 */
public class User {
    
    private String name;
    private String email;
    private char[] password;
    
    public User(String name, String email, char[] password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
