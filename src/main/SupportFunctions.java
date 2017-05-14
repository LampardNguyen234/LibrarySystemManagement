/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Admin;
import GUI.HomePage;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thành
 */
public class SupportFunctions {

    /*Encrypted Password*/
    public static String Hash256(String password) throws NoSuchAlgorithmException {
        byte[] input = password.getBytes();
        MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
        SHA256.update(input);

        byte[] digest = SHA256.digest();

        StringBuffer hexDigest = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            hexDigest.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return hexDigest.toString();
    }

    /* Auto Generate An ID For A Manager */
    public static String GenerateStaffID() {
        try {
            Connection cnn = DatabaseConnection.getMySQLConnection();
            Random rand = new Random();
            int n;
            while (true) {
                n = rand.nextInt(1000000) + 1000000;
                String ID = String.valueOf(n);
                if (!DatabaseQuery.CheckIDUserExisted(ID, "nguoi_quan_ly")) {
                    return ID;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /*Generate an ID for a user*/
    public static String GenerateUserID() {
        Random rand = new Random();
        int n;
        while (true) {
            n = rand.nextInt(7000000) + 2000000;
            String ID = String.valueOf(n);
            if (!DatabaseQuery.CheckIDUserExisted(ID, "doc_gia")) {
                return ID;
            }
        }
    }

    /*Check if a given ID is staff ID or user ID (Staff ID begins with '1')*/
    public static boolean checkStaff(String ID) {
        char first = ID.charAt(0);
        return first == '1';
    }

    public static void setImageToLabel(JLabel label, String URL, boolean fullPath) {
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon icon;
        if (!fullPath) {
            icon = new ImageIcon(new ImageIcon(HomePage.class.getResource(URL)).getImage().getScaledInstance(label.getWidth(),
                    label.getHeight(), Image.SCALE_SMOOTH));
        } else {
            icon = new ImageIcon(new ImageIcon(URL).getImage().getScaledInstance(label.getWidth(),
                    label.getHeight(), Image.SCALE_SMOOTH));
        }
        label.setIcon(icon);
    }

    public static void setImageToLabel(JLabel label, String URL) {
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon icon = new ImageIcon(new ImageIcon(HomePage.class.getResource(URL)).getImage().getScaledInstance(label.getWidth(),
                label.eight(), Image.SCALE_SMOOTH));
        label.setIcon(icon);
    }

    public static int DisplayStaffResult(ResultSet res, JTable tbStaff) { //return the number of Staff
        int num = 0;
        String[] columnNames = {"ID", "Họ Và Tên", "Giới Tính", "Quê Quán", "Ngày Sinh", "CMND", "Email", "Điện Thoại"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            while (res.next()) {
                num++;
                String ID = res.getString(1);
                String FullName = res.getString(2);
                String Address = res.getString(3);
                String Gendre = res.getString(5);
                String Birthday = res.getString(4);
                String CMND = res.getString(6);
                String Email = res.getString(9);
                String PhoneNum = res.getString(10);
                model.addRow(new Object[]{ID, FullName, Gendre, Address, Birthday, CMND, Email, PhoneNum});
            }
            tbStaff.setModel(model);
            tbStaff.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            tbStaff.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbStaff.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbStaff.getColumnModel().getColumn(2).setPreferredWidth(25);
            tbStaff.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbStaff.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbStaff.getColumnModel().getColumn(5).setPreferredWidth(30);
            tbStaff.getColumnModel().getColumn(6).setPreferredWidth(50);
            tbStaff.getColumnModel().getColumn(7).setPreferredWidth(35);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }

    public static void DisplayImage(ArrayList<JLabel> lbImage, ArrayList<JLabel> Name, ArrayList<String> imgName) {
        int size = lbImage.size();
        for (int i = 0; i < size; i++) {
            try {
                JLabel lb = lbImage.get(i);
                JLabel lbName = Name.get(i);
                String URL = "src/GUI/Images/Books/" + imgName.get(i) + ".jpg";
                lb.setHorizontalAlignment(JLabel.CENTER);
                lb.setVerticalAlignment(JLabel.CENTER);
                lbName.setVerticalAlignment(JLabel.CENTER);
                lbName.setHorizontalAlignment(JLabel.CENTER);
                setImageToLabel(lb, URL, false);
                ResultSet res = DatabaseQuery.FindBooksByID(imgName.get(i));
                res.next();
                String bookName = res.getString("BName");
                lbName.setText(bookName);
            } catch (SQLException ex) {
                Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean deleteBookImage(String SKU) {
        File image = new File("src/GUI/Images/Books/" + SKU + ".jpg");
        return image.delete();
    }

    public static boolean checkBookImageExist(String SKU) {
        File image = new File("src/GUI/Images/Books/" + SKU + ".jpg");
        return image.isFile();
    }

    /*Return all the gendres in database*/
    public static ArrayList<String> GetAllGendres() {
        try {
            Connection conn = DatabaseConnection.getMySQLConnection();
            PreparedStatement pst = conn.prepareStatement("select Gendre from tua_sach group by Gendre");
            ResultSet res = pst.executeQuery();
            ArrayList<String> GenderList = new ArrayList<>();
            while (res.next()) {
                String gendre = res.getString("Gendre");
                GenderList.add(gendre);
            }
            return GenderList;
        } catch (SQLException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*Check if we still have a given book left*/
    public static ResultSet Display(ArrayList<JLabel> lbImage, ArrayList<JLabel> Name, ResultSet resBook, int Page) {
        try {
            int i = (Page - 1) * 10;
            while (i > 0) {
                try {
                    resBook.next();
                    i--;
                } catch (SQLException ex) {
                    Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int j = 0; j < 10; j++) {
                JLabel Image = lbImage.get(j);
                JLabel name = Name.get(j);
                if (resBook.next()) {
                    try {
                        name.setText(resBook.getString("BName"));
                        name.setToolTipText(resBook.getString("BName"));
                        String SKU = resBook.getString("SKU");
                        String URL;
                        if (checkBookImageExist(SKU)) {
                            URL = "Images/Books/" + SKU + ".jpg";
                        } else {
                            URL = "Images/NoPhotoAvailable.jpg";
                        }
                        setImageToLabel(Image, URL);
                    } catch (SQLException ex) {
                        Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    name.setText(null);
                    name.setToolTipText(null);
                    String URL = "Images/transparent.png";
                    setImageToLabel(Image, URL, false);
                }
            }
            resBook.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resBook;
    }

    public static int GetSize(ResultSet res) {
        int size = 0;
        try {
            if (res.last()) {
                size = res.getRow();
            }
            res.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return size;
    }

    public static int getMaxPage(int size, int quantityPerPage) {
        float result = (float) size / quantityPerPage;
        if (result - (int) result > 0) {
            return (int) result + 1;
        } else {
            return (int) result;
        }
    }

    public static boolean checkUserName(String username) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        boolean valid = (username != null) && pattern.matcher(username).matches();
        return valid;
    }

    public static boolean checkFileExist(String filePath) {
        File file = new File(filePath);
        return file.isFile();
    }

    public static boolean backupData() {
        String filePath = System.getProperty("user.dir");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String file = filePath + "\\Data\\mysql" + timeStamp + ".sql";
        System.out.println(file);
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("cmd /c mysqldump -uroot -p123456 datalibrary > " + file);
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup created successfully!");
                return true;
            } else {
                System.out.println("Could not create the backup");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean restoreData() {
        try {
            String filePath = "Data\\Datalibrary.sql";
            Connection con = DatabaseConnection.getMySQLConnection();
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con, false, false);

                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(filePath));

                // Exctute script
                sr.runScript(reader);
                return true;
            } catch (Exception e) {
                System.err.println("Failed to Execute" + filePath
                        + " The error is " + e.getMessage());
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void DisplayHistory(ResultSet res, JTable result) {
        String[] columnNames = {"ID sách", "SKU", "Tên sách", "Tác giả", "Ngày Mượn", "Ngày Trả", "Tình Trạng", "Hạn trả"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            while (res.next()) {
                String ID = res.getString(2);
                ResultSet rs = DatabaseQuery.FindBookByID(ID);
                rs.next();
                String SKU = rs.getString("SKU");
                String BName = rs.getString("BName");
                String Author = rs.getString("Author");
                String bDay = String.valueOf(res.getDate("NgayMuon"));
                String rDay = String.valueOf(res.getDate("NgayTra"));
                String dLine = String.valueOf(res.getDate("NgayTraDuKien"));
                String status = res.getString("TinhTrang");
                if (status.equals("0")) {
                    status = "Chưa trả";
                } else {
                    status = "Đã trả";
                }
                model.addRow(new Object[]{ID, SKU, BName, Author, bDay, rDay, status, dLine});
            }
            result.setModel(model);
            result.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
            result.getColumnModel().getColumn(0).setPreferredWidth(10);
            result.getColumnModel().getColumn(1).setPreferredWidth(20);
            result.getColumnModel().getColumn(2).setPreferredWidth(150);
            result.getColumnModel().getColumn(3).setPreferredWidth(150);
            result.getColumnModel().getColumn(4).setPreferredWidth(20);
            result.getColumnModel().getColumn(5).setPreferredWidth(20);
            result.getColumnModel().getColumn(6).setPreferredWidth(20);
            result.getColumnModel().getColumn(7).setPreferredWidth(20);

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean CopyImage(String fromPath, String toPath) {
        try {
            File source = new File(fromPath);
            File dest = new File(toPath);
            String destination = dest.toString().substring(3);
            destination = "build\\classes" + destination;
            System.out.println(dest.toString());
            File dest2 = new File(destination);
            System.out.println(dest2.toString());
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(source.toPath(), dest2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
