package com.apu.appointwell.classes.validators;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 *
 * @author Alex
 */
public class InputValidation {
    
    public boolean validationEmptyFields(char[] password, String... fields) {
        if (password == null || password.length == 0) {
            return false;
        }

        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }
    
    public boolean validationEmptyFields(String... fields) {
        
        for (String field : fields) {
            if (field == null || field.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validateEmail(String email) {
        boolean isEmailValid = true;
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        if (!email.matches(emailPattern)) {
            isEmailValid = false;
        }
        
        return isEmailValid;
    }
    
    public boolean validatePhoneNumber(String phone, String countryCode) {
        try {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber parsedPhoneNumber = phoneUtil.parse(phone, countryCode);
            return phoneUtil.isValidNumberForRegion(parsedPhoneNumber, countryCode);
        } catch (NumberParseException e) {
            return false;
        }
    }
    
    public boolean validatePassword(char[] password) {
        String passwordStr = new String(password);

        // Check length
        if (passwordStr.length() < 8) {
            return false;
        }

        // Check for at least one digit, one symbol, and one uppercase letter
        boolean hasDigit = false;
        boolean hasSymbol = false;
        boolean hasUppercase = false;
        for (char c : password) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSymbol = true;
            }
        }

        return hasDigit && hasSymbol && hasUppercase;
    }
    
    public boolean confirmPassword(char[] password, char[] passwordConfirmation) {
        
        if (password.length != passwordConfirmation.length) {
            return false;
        }
        
        for (int i = 0; i < password.length; i++) {
            if (password[i] != passwordConfirmation[i]) {
                return false;
            }
        }
        
        return true;   
    }
}
