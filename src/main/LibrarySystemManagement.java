/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.HomePage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lampard
 */
public class LibrarySystemManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            conn = DatabaseConnection.getMySQLConnection();
            new HomePage().show();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarySystemManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibrarySystemManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection conn;
}
