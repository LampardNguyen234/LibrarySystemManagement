/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static main.LibrarySystemManagement.conn;


/**
 *
 * @author Thành
 */
public class DatabaseQuery {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static final long  WEEK = 604800000;

    public static ResultSet getBookInfo(String ID) {
        return null;
    }

    /*Check if the ID existed or not*/
    public static boolean CheckIDUserExisted(String ID, String database) {
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from " + database + " where ID = ?");
            pst.setString(1, ID);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    /*Return all manager in the database*/
    public static ResultSet getAllManager() {
        try {
            PreparedStatement pstatement = conn.prepareStatement("select * from nguoi_quan_ly");
            return pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet getAllReader() {
        try {
            PreparedStatement pstatement = conn.prepareStatement("select * from doc_gia");
            return pstatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    /*Insert a manager to database*/
    public static boolean AddUser(People user, String table) {
        try {
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
        } 
        return false;
    }

    public static boolean DeleteUser(String ID, String table) {
        try {
            PreparedStatement pst = conn.prepareStatement("delete from " + table + " where ID = ?");
            pst.setString(1, ID);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    public static boolean UpdateUser(People User, String table) {
        try {
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
        } 
        return false;
    }

    public static boolean AddBook(Book book){
        try {
            PreparedStatement pst = conn.prepareStatement("insert into datalibrary.tua_sach values (?,?,?,?,?,?,?,?)");
            pst.setString(1, book.getSKU());
            pst.setString(2, book.getName());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getGendre());
            pst.setString(5, book.getPublisher());
            pst.setString(6, book.getPublishedDay());
            pst.setString(7, book.getPrice());
            pst.setInt(8, book.getTotal());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ResultSet FindUserByKeyWord(String KeyWord, String table) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where ID like ? or Address like ? or Name like ? or CMND like ?");
            pst.setString(1, "%" + KeyWord + "%");
            pst.setString(2, "%" + KeyWord + "%");
            pst.setString(3, "%" + KeyWord + "%");
            pst.setString(4, "%" + KeyWord + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet FindUserByID(String ID, String database) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from " + database + " where ID like ?");
            pst.setString(1, "%" + ID + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet FindUserByCMND(String CMND, String table) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where CMND like ?");
            pst.setString(1, "%" + CMND + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet FindUserByName(String Name, String table) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where Name like ?");
            pst.setString(1, "%" + Name + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ResultSet FindUserByAddress(String Address, String table) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from " + table + " where Address like ?");
            pst.setString(1, "%" + Address + "%");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet GetAllBook() {
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach order by SKU");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static int countReaderOrBook(String table, String colName){
        try {
            
            PreparedStatement pst = conn.prepareStatement("SELECT count("+colName+") as countID FROM "+table);
            ResultSet res = pst.executeQuery();
            res.next();
            return res.getInt("countID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
    
    public static int countBookRemainOrNot(int status){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select count(ID) as countID from datalibrary.cuon_sach\n" +
                "where mStatus = "+String.valueOf(status));
            ResultSet res = pst.executeQuery();
            res.next();
            return res.getInt("countID");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return 0;
    }
    
    public static int countBookInMonth(String table, String colName, String countCol){
        try {
            
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
        }  
        return 0;
    }
    
    public static ResultSet SearchBookAdvanced(String querryString){
        try {
            
            PreparedStatement pst = conn.prepareStatement(querryString);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public static ResultSet SearchBookByKeyWord(String KeyWord) {
        try {
            
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
        } 
        return null;
    }

    public static boolean UpdateUserPassword(String ID, String Password, String table) {
        try {
            
            PreparedStatement pst = conn.prepareStatement("update " + table + " set Pass = ? where ID = ?");
            pst.setString(2, ID);
            pst.setString(1, Password);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    public static ResultSet FindBooksByID(String ID) {
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where ID =?");
            pst.setString(1, ID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ResultSet FindBooksBySKU(String SKU) {
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ResultSet FindBooksBySKU(String SKU, Connection conn) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.tua_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static boolean DeleteAllBook(String SKU){
        try {
            
            PreparedStatement pst = conn.prepareStatement("delete from datalibrary.cuon_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*Delete book from database*/
    public static boolean DeleteBook(String SKU) {
        DeleteAllBook(SKU);
        try {
            
            PreparedStatement pst  = conn.prepareStatement("delete from datalibrary.tua_sach where SKU = ?");
            pst.setString(1, SKU);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean updateBook(Book updateBook) throws ClassNotFoundException{
        try {
            
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
        } 
        return null;
    }

    public static boolean CheckUserNameExisted(String Username) {
        try {
            PreparedStatement pst = conn.prepareStatement("select * from doc_gia where Username = ?");
            pst.setString(1, Username);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return false;
    }
    
    public static ResultSet getReaderBook(){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select IDNguoiMuon, Name, count(IDNguoiMuon) as countID from ("+
                    "(select * from datalibrary.muon left outer join datalibrary.doc_gia on muon.IDNguoiMuon = doc_gia.ID)"+
                    " as muonsach)"+"group by IDNguoiMuon");
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static boolean CheckValidAccount(String Username, String Password, String Table) {
        try {
            
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
        }  
        return false;
    }
    
    public static ResultSet History(String userID, String choice){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.muon where IDNguoiMuon = ? and TinhTrang = ?");
            pst.setString(1, userID);
            pst.setString(2, choice);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ResultSet History(String userID){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.muon where IDNguoiMuon = ?");
            pst.setString(1, userID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ResultSet checkHistory(String userID, String bookID){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.muon where IDNguoiMuon = ? and IDSach = ?");
            pst.setString(1, userID);
            pst.setString(2, bookID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    public static void borrowBook(String userID, String bookID){
        try {
            
            String date1 = String.valueOf(Calendar.getInstance().getTime().getYear())+"-"+String.valueOf(Calendar.getInstance().getTime().getMonth())+
                    "-"+String.valueOf(Calendar.getInstance().getTime().getDate());
            String date2 = String.valueOf(Calendar.getInstance().getTime().getYear())+"-"+String.valueOf(Calendar.getInstance().getTime().getMonth())+
                    "-"+String.valueOf(Calendar.getInstance().getTime().getDate()+15);
            PreparedStatement pst = conn.prepareStatement("insert into datalibrary.muon (IDNguoiMuon, IDSach, NgayMuon, NgayTra, TinhTrang, NgayTraDuKien) "+
                    "values ("+userID+", "+bookID+", "+date1+", null, 0, "+date2);
            JOptionPane.showMessageDialog(null, "Cập nhật mượn sách thành công!!!");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static ResultSet FindBookByID(String ID){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.cuon_sach where ID = ?");
            pst.setString(1, ID);
            ResultSet res = pst.executeQuery();
            if(res.next())
            {
                String SKU = res.getString("SKU");
                return FindBooksBySKU(SKU, conn);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ResultSet FindBookStatusByID(String ID){
        try {
            
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.cuon_sach where ID = ?");
            pst.setString(1, ID);
            return pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static void updateBookStatus(String ID){
        try {
            
            PreparedStatement pst = conn.prepareStatement("update datalibrary.muon set TinhTrang = 1 where IDSach = ?");
            pst.setString(1, ID);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public static People findUserByUsername(String Username, String Table){
        try {
            
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
        }  
        return null;
    }
    
    public static People findUserByID(String ID, String Table){
        try {
            
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
        } 
        return null;
    }
    
     public static void ADDBorrow(String IDReaderString, String IDBook){
        try {
            
            PreparedStatement pst = conn.prepareStatement("insert into datalibrary.muon values(?,?,?,?,?, ?)");
            pst.setString(1, IDReaderString);
            pst.setString(2, IDBook);
            Random rand = new Random();
            long rando = rand.nextInt(514800)*1000;
            pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()- rando));
            pst.setTimestamp(4, null );
            pst.setString(5, "0");
            pst.setTimestamp(6, new Timestamp(System.currentTimeMillis() + WEEK-rando));
            pst.execute(); 
            System.out.println(IDBook);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void ADDBook(Book book, int ID, int location){
        try {
            PreparedStatement pst = conn.prepareStatement("insert into datalibrary.cuon_sach values(?,?,?,?,?)");
            Random rand = new Random();
            pst.setString(1, String.valueOf(ID));
            pst.setString(2, book.SKU);
            pst.setInt(3, rand.nextInt(2));
            pst.setInt(4, location);
            pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int GetBookshelf(String Theloai){
        try {
            PreparedStatement pst = conn.prepareStatement("select * from datalibrary.ke_sach where TheLoai = ?");
            pst.setString(1, Theloai);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return rs.getInt(2);
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
    
    public static ResultSet GetLentBook(){
        try {
            PreparedStatement pst = conn.prepareStatement("select ID from datalibrary.cuon_sach where mStatus = ?");
            pst.setInt(1, 1);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static int AddKE_Sach(String TheLoai){
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM datalibrary.ke_sach order by ID desc;");
            ResultSet rs = pst.executeQuery();
            rs.next();
            int ID = rs.getInt("ID");
            pst = conn.prepareStatement("insert into datalibrary.ke_sach values(?,?,?)");
            pst.setString(1, TheLoai);
            pst.setInt(2, ID+1);
            pst.setString(3, String.valueOf(ID+1));
            pst.execute();
            return ID+1;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int GetID(){
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM datalibrary.cuon_sach order by ID desc");
            ResultSet res = pst.executeQuery();
            res.next();
            return Integer.parseInt(res.getString("ID"));
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
