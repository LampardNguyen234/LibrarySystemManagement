/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author Thành
 */
public class People {
    String ID;
    String FullName;
    String Address;
    String Birthday;
    String Email;
    String userName;
    String Password;

    public People(String ID, String FullName, String Address, String Birthday, String Email, String userName, String Password, String Sex, String CMND, String PhoneNumber) {
        this.ID = ID;
        this.FullName = FullName;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Email = Email;
        this.userName = userName;
        this.Password = Password;
        this.Sex = Sex;
        this.CMND = CMND;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public People(String ID, String FullName, String Address, String Birthday, String Email, String Sex, String CMND, String PhoneNumber) {
        this.ID = ID;
        this.FullName = FullName;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Email = Email;
        this.Sex = Sex;
        this.CMND = CMND;
        this.PhoneNumber = PhoneNumber;
    }

    public String getBirthday() {
        return Birthday;
    }
    String Sex;
    String CMND;
    String PhoneNumber;
    
    public String getSex() {
        return Sex;
    }

    public String getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getAddress() {
        return Address;
    }

    public String getCMND() {
        return CMND;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

}
