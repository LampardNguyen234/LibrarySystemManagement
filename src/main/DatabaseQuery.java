/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Calendar;
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
    
    public static int countReaderOrBook(String table, String colName){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT count("+colName+") as countID FROM "+table);
            ResultSet res = pst.executeQuery();
            res.next();
            return res.getInt("countID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int countBookRemainOrNot(int status){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select count(ID) as countID from datalibrary.cuon_sach\n" +
                "where mStatus = "+String.valueOf(status));
            ResultSet res = pst.executeQuery();
            res.next();
            return res.getInt("countID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int countBookInMonth(String table, String colName, String countCol){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            String date1 = String.valueOf(Calendar.getInstance().getTime().getYear())+"-"+String.valueOf(Calendar.getInstance().getTime().getMonth())+
                    "-"+String.valueOf(Calendar.getInstance().getTime().getDate());
            String date2 = String.valueOf(Calendar.getInstance().getTime().getYear())+"-"+String.valueOf(Calendar.getInstance().getTime().getMonth()+1)+
                    "-"+String.valueOf(Calendar.getInstance().getTime().getDate());
            PreparedStatement pst = conn.prepareStatement("select count("+countCol+") as countID from " + table +
                " where " + colName + " between " + date1 + " and " + date2);
            ResultSet res = pst.executeQuery();
            res.next();
            return res.getInt("countID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
            PreparedStatement pst = conn.prepareStatement("select * from " + "datalibrary.tua_sach" + " where SKU like ? or Bname like ? or Gender like ? or Author like ?"
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
            +"', Publisher = '"+updateBook.getPublisher()+"', PublishedDay = '"+updateBook.getPublishedDay()+"', Gender = '"+updateBook.getGendre()
            +"', Price = '"+updateBook.getPrice()+"', Total = "+String.valueOf(updateBook.getTotal())+" where SKU = '"+updateBook.getSKU()+"'");
            System.out.println("update datalibrary.tua_sach set BName = '"+updateBook.getName()+"', Author = '"+updateBook.getAuthor()
            +"', Publisher = '"+updateBook.getPublisher()+"', PublishedDay = '"+updateBook.getPublishedDay()+"', Gender = '"+updateBook.getGendre()
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
                String Gender = res.getString("Gender");
                String Publisher = res.getString("Publisher");
                String PublishedDay = res.getString("PublishedDay");
                String Author = res.getString("Author");
                return new Book(SKU, Name, Gender, Publisher, PublishedDay, Author);
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
    
    public static ResultSet getReaderBook(){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select IDNguoiMuon, Name, count(IDNguoiMuon) as countID from ("+
                    "(select * from datalibrary.muon left outer join datalibrary.doc_gia on muon.IDNguoiMuon = doc_gia.ID)"+
                    " as muonsach)"+"group by IDNguoiMuon");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean CheckValidAccount(String Username, String Password, String Table) {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + Table +" where Username = ?");
            pst.setString(1, Username);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                try {
                    if(SupportFunctions.Hash256(Password).equals(res.getString("Pass")))
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
    
    public static ResultSet History(String userID, String choice){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from muon where IDNguoiMuon = ? and TinhTrang = ?");
            pst.setString(1, userID);
            pst.setString(2, choice);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet History(String userID){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from muon where IDNguoiMuon = ?");
            pst.setString(1, userID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ResultSet FindBookByID(String ID){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from cuon_sach where ID = ?");
            pst.setString(1, ID);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                String SKU = res.getString("SKU");
                return FindBooksBySKU(SKU);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static People findUserByUsername(String Username, String Table){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + Table + " where Username = ?");
            pst.setString(1, Username);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                People pl = new People(rs.getString("ID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Birthday"), rs.getString("Email"),
                        rs.getString("Username"), rs.getString("Pass"), rs.getString("Sex"),rs.getString("CMND"), rs.getString("PhoneNum"));
                return pl;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static People findUserByID(String ID, String Table){
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select * from " + Table + " where ID = ?");
            pst.setString(1, ID);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                People pl = new People(rs.getString("ID"), rs.getString("Name"), rs.getString("Address"), rs.getString("Birthday"), rs.getString("Email"),
                        rs.getString("Username"), rs.getString("Pass"), rs.getString("Sex"),rs.getString("CMND"), rs.getString("PhoneNum"));
                return pl;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
