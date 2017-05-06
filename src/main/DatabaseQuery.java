/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thành
 */
public class DatabaseQuery {

    public static ResultSet getBookInfo(String ID) {
        return null;
    }

    /*Check if the ID existed or not*/
    public static boolean CheckIDUserExisted(String ID, String database) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + database + " where ID = ?");
            pst.setString(1, ID);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*Return all manager in the database*/
    public static ResultSet getAllManager() {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pstatement = conn.prepareStatement("select * from nguoi_quan_ly");
            return pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet getAllReader() {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pstatement = conn.prepareStatement("select * from doc_gia");
            return pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*Insert a manager to database*/
    public static boolean AddUser(People user, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pstatement = conn.prepareStatement("insert into datalibrary." + table + " "
                    + "(ID, Name, Address, Birthday, Sex, CMND, Username, Pass, Email, PhoneNum) values (?,?,?,?,?,?,?,?,?, ?)");
            pstatement.setString(1, user.getID());
            pstatement.setString(2, user.getFullName());
            pstatement.setString(3, user.getAddress());
            pstatement.setString(4, user.getBirthday());
            pstatement.setString(5, user.getSex());
            pstatement.setString(6, user.getCMND());
            pstatement.setString(7, user.getUserName());
            pstatement.setString(8, user.getPassword());
            pstatement.setString(9, user.getEmail());
            pstatement.setString(10, user.getPhoneNumber());
            if (pstatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean DeleteUser(String ID, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("delete from " + table + " where ID = ?");
            pst.setString(1, ID);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean UpdateUser(People User, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("update " + table + " set Name = ?, Address = ?, Birthday = ?, Sex = ?, CMND = ?, Email = ?, "
                    + "PhoneNum = ?  where ID = ?");
            pst.setString(1, User.getFullName());
            pst.setString(2, User.getAddress());
            pst.setString(3, User.getBirthday());
            pst.setString(4, User.getSex());
            pst.setString(5, User.getCMND());
            pst.setString(6, User.getEmail());
            pst.setString(7, User.getPhoneNumber());
            pst.setString(8, User.getID());
            int success = pst.executeUpdate();
            System.out.println(success);
            if (success == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ResultSet FindUserByKeyWord(String KeyWord, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where ID like ? or Address like ? or Name like ? or CMND like ?");
            pst.setString(1, "%" + KeyWord + "%");
            pst.setString(2, "%" + KeyWord + "%");
            pst.setString(3, "%" + KeyWord + "%");
            pst.setString(4, "%" + KeyWord + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet FindUserByID(String ID, String database) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + database + " where ID like ?");
            pst.setString(1, "%" + ID + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet FindUserByCMND(String CMND, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where CMND like ?");
            pst.setString(1, "%" + CMND + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet FindUserByName(String Name, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where Name like ?");
            pst.setString(1, "%" + Name + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet FindUserByAddress(String Address, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where Address like ?");
            pst.setString(1, "%" + Address + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet GetAllBook() {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach order by SKU");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet SearchBookAdvanced(String querryString){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement(querryString);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet SearchBookByKeyWord(String KeyWord) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("select * from " + "datalibrary.tua_sach" + " where SKU like ? or Bname like ? or Gendre like ? or Author like ?"
                    + " or Publisher like ? order by SKU");
            pst.setString(1, "%" + KeyWord + "%");
            pst.setString(2, "%" + KeyWord + "%");
            pst.setString(3, "%" + KeyWord + "%");
            pst.setString(4, "%" + KeyWord + "%");
            pst.setString(5, "%" + KeyWord + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean UpdateUserPassword(String ID, String Password, String table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("update " + table + " set Pass = ? where ID = ?");
            pst.setString(2, ID);
            pst.setString(1, Password);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ResultSet FindBooksByID(String ID) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where ID =?");
            pst.setString(1, ID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet FindBooksBySKU(String SKU) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean DeleteAllBook(String SKU){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("delete from datalibrary.cuon_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*Delete book from database*/
    public static boolean DeleteBook(String SKU) {
        DeleteAllBook(SKU);
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst  = conn.prepareStatement("delete from datalibrary.tua_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật vào CSDL, vui lòng thử lại");         
        }
        return false;
    }
    
    public static boolean updateBook(Book updateBook) throws ClassNotFoundException{
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("update datalibrary.tua_sach set BName = '"+updateBook.getName()+"', Author = '"+updateBook.getAuthor()
            +"', Publisher = '"+updateBook.getPublisher()+"', PublishedDay = '"+updateBook.getPublishedDay()+"', Gendre = '"+updateBook.getGendre()
            +"', Price = '"+updateBook.getPrice()+"', Total = "+String.valueOf(updateBook.getTotal())+" where SKU = '"+updateBook.getSKU()+"'");
            System.out.println("update datalibrary.tua_sach set BName = '"+updateBook.getName()+"', Author = '"+updateBook.getAuthor()
            +"', Publisher = '"+updateBook.getPublisher()+"', PublishedDay = '"+updateBook.getPublishedDay()+"', Gendre = '"+updateBook.getGendre()
            +"', Price = '"+updateBook.getPrice()+"', Total = "+String.valueOf(updateBook.getTotal())+" where SKU = '"+updateBook.getSKU()+"'");
            return pst.execute();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật vào CSDL, vui lòng thử lại");         
        }
        return false;
    }

    /*Find books by exact name*/
    public static Book findBookByExactName(String bookName) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection("datalibrary");
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where BName = ?");
            pst.setString(1, bookName);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                String SKU = res.getString("SKU");
                String Name = res.getString("BName");
                String Gendre = res.getString("Gendre");
                String Publisher = res.getString("Publisher");
                String PublishedDay = res.getString("PublishedDay");
                String Author = res.getString("Author");
                return new Book(SKU, Name, Gendre, Publisher, PublishedDay, Author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean CheckUserNameExisted(String Username) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from doc_gia where TaiKhoan = ?");
            pst.setString(1, Username);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean CheckValidAccount(String Username, String Password) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from doc_gia where TaiKhoan = ?");
            pst.setString(1, Username);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                try {
                    if(SupportFunctions.Hash256(Password).equals(res.getString("MatKhau")));
                    return true;
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
