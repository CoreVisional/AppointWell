package com.apu.appointwell.classes.auth;

import com.apu.appointwell.classes.utils.FileUtils;
import com.apu.appointwell.classes.validators.DataValidation;
import java.io.File;

/**
 *
 * @author Alex
 */
public class StaffAccount {
    
    private final String staffFilePath = "D:\\AppointWell\\src\\main\\java\\com\\apu\\appointwell\\data\\accounts\\staff.txt";
    private final File staffFile = new File(staffFilePath);
    FileUtils fileUtils = new FileUtils();
    DataValidation dataValidation = new DataValidation();

    public void createDefaultStaffAccount() {
        String headers = "staff_id, name, email, password\n";
        String[] varargs = {"Admin, staff@appointwell.com, staff123\n"};
        
        fileUtils.verifyFileExistence(staffFile);
        
        if (!dataValidation.validateAccountExistence(staffFile)) {
            fileUtils.writeFile(staffFilePath, staffFile, headers, varargs);
        }
    }
}
