/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.StartUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
//        try {
//            Connection cnn = DatabaseConnection.getMySQLConnection("datalibrary");
//            PreparedStatement pst = cnn.prepareStatement("select * from tua_sach where Publisher = ?");
//            pst.setString(1, "");
//            ResultSet result = pst.executeQuery();
//            while(result.next()){
//                pst = cnn.prepareStatement("update tua_sach set Publisher = ? where SKU = ? ");
//                pst.setString(1, "Đang cập nhật");
//                pst.setString(2, result.getString("SKU"));
//                pst.executeUpdate();
//            }
//                    } catch (SQLException ex) {
//            Logger.getLogger(LibrarySystemManagement.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LibrarySystemManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
}
