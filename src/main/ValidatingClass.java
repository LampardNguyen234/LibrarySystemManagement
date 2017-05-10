/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
/**
 *
 * @author Thành
 */
public class ValidatingClass {

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isEmailValid(String Email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(Email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isDateValid(String date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        try {
            df.parse(date);
            return true;
        } catch (java.text.ParseException ex) {
            Logger.getLogger(ValidatingClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    public static boolean isAgeValid(int Age)
    {
        if(Age<0 || Age>100)
            return false;
        return true;
    }
    
    public static boolean isCMNDExisting(String CMND, String table)
    {
        try {
            Connection cnn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = cnn.prepareStatement("select * from "+ table+ " where CMND = ?");
            pst.setString(1, CMND);
            ResultSet res = pst.executeQuery();
            if(res.next())
                return true;
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ValidatingClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidatingClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
