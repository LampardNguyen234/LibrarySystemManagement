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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public static boolean isAgeValid(int Age) {
        if (Age < 0 || Age > 100) {
            return false;
        }
        return true;
    }

    public static boolean isCMNDExisting(String CMND, String table) {
        try {
            Connection cnn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = cnn.prepareStatement("select * from " + table + " where CMND = ?");
            pst.setString(1, CMND);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ValidatingClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidatingClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean checkPhonenum(String number) {//Kiểm tra số điện thoại hợp lệ
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            return false;
        } else if (number.length() == 10 || number.length() == 11) {
            if (number.length() == 10) {
                if (number.substring(0, 2).equals("09")) {
                    return true;
                } else {
                    if (number.substring(0, 30).equals("088") || number.substring(0, 30).equals("089")) {
                        return true;
                    }
                    return false;
                }
            } else if (number.substring(0, 2).equals("01")) {
                {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
