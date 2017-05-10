/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import main.DatabaseQuery;
import static main.DatabaseQuery.dateFormat;
import main.People;
import main.SupportFunctions;
import main.ValidatingClass;

/**
 *
 * @author lampard
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form mainGUI
     */
    int leftState = 0;
    int rightState = 0;
    final String staffDatabase = "nguoi_quan_ly";
    final String userDatabase = "doc_gia";
    public static People admin;
    public Admin(People admin) {
        this.setResizable(false);
        initComponents();
        this.setShape(new RoundRectangle2D.Float(0, 0, 1000, 600, 45, 45));
        this.setSize(1000, 600);
        this.admin=admin;
        adminName.setText(admin.getFullName());
        SetAdminState(0, 0);
        SetTable(DatabaseQuery.getAllManager(), tbStaff, 0);
        // tableSelected(tbStaff);
    }

    public static void changeBackPanelEntered(JPanel panel) {
        panel.setBackground(new Color(38, 221, 232));
    }

    public static void changeBackPanelExited(JPanel panel) {
        panel.setBackground(new Color(38, 40, 55));
    }

    /*Change the panels when clicking on labels*/
    public void SetAdminState(int left, int right) {
        leftState = left;
        rightState = right;
        switch (left) {
            case 0: //Staff Management
            {
                pnUser2.hide();
                changeBackPanelEntered(pnStaffManagement);
                changeBackPanelExited(pnUserManagement);
                changeBackPanelExited(pnBackUp);
                switch (right) {
                    case 0:
                        changeBackPanelEntered(pnStatistics);
                        changeBackPanelExited(pnAddStaff);
                        changeBackPanelExited(pnEdit);
                        pnMainStatistics.show();
                        pnMainAdd.hide();
                        pnMainEdit.hide();
                        btnEditStaff.setEnabled(false);
                        btnDeleteStaff.setEnabled(false);
                        btnResetPasswordStaff1.setEnabled(false);
                        searchFiled.setEditable(true);
                        ClearEdittingSpace();
                        ClearAddingSpace();
                        break;
                    case 1:
                        changeBackPanelEntered(pnAddStaff);
                        changeBackPanelExited(pnStatistics);
                        changeBackPanelExited(pnEdit);
                        pnMainStatistics.hide();
                        pnMainAdd.show();
                        pnMainEdit.hide();
                        searchFiled.setEditable(true);
                        ClearEdittingSpace();
                        break;
                    case 2:
                        changeBackPanelEntered(pnEdit);
                        changeBackPanelExited(pnStatistics);
                        changeBackPanelExited(pnAddStaff);
                        pnMainStatistics.hide();
                        pnMainAdd.hide();
                        pnMainEdit.show();
                        searchFiled.setEditable(false);
                        break;
                }
                break;
            }
            case 1: {//User Manager
                changeBackPanelEntered(pnUserManagement);
                changeBackPanelExited(pnStaffManagement);
                changeBackPanelExited(pnBackUp);
                switch (right) {
                    case 0:
                        SetTable(DatabaseQuery.getAllReader(), tbStaff1, 1);
                        changeBackPanelEntered(pnStatistics1);
                        changeBackPanelExited(pnAddStaff1);
                        changeBackPanelExited(pnEdit1);
                        pnMainStatistics1.show();
                        pnMainAdd1.hide();
                        pnMainEdit1.hide();
                        btnEditStaff1.setEnabled(false);
                        btnDeleteStaff1.setEnabled(false);
                        btnResetPasswordStaff2.setEnabled(false);
                        searchFiled1.setEditable(true);
                        ClearEdittingSpace();
                        ClearAddingSpace();
                        break;
                    case 1:
                        changeBackPanelEntered(pnAddStaff1);
                        changeBackPanelExited(pnStatistics1);
                        changeBackPanelExited(pnEdit1);
                        pnMainStatistics1.hide();
                        pnMainAdd1.show();
                        pnMainEdit1.hide();
                        searchFiled1.setEditable(true);
                        ClearEdittingSpace();
                        break;
                    case 2:
                        changeBackPanelEntered(pnEdit1);
                        changeBackPanelExited(pnStatistics1);
                        changeBackPanelExited(pnAddStaff1);
                        pnMainStatistics1.hide();
                        pnMainAdd1.hide();
                        pnMainEdit1.show();
                        searchFiled1.setEditable(false);
                        break;
                }
                break;
            }
            case 2: {
                changeBackPanelEntered(pnBackUp);
                changeBackPanelExited(pnStaffManagement);
                changeBackPanelExited(pnUserManagement);
            }
        }
    }

    public void ClearEdittingSpace() {
        tfID.setText("");
        tfFullname1.setText("");
        tfAddress1.setText("");
        tfBirthDay1.setText("dd-MM-yyyy");
        tfCMND1.setText("");
        tfEmail1.setText("");
        tfPhoneNum1.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnLeft = new javax.swing.JPanel();
        pnUser = new javax.swing.JPanel();
        adminIcon = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        onlineIcon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnStaffManagement = new javax.swing.JPanel();
        lbStaff = new javax.swing.JLabel();
        pnUserManagement = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        pnBackUp = new javax.swing.JPanel();
        lbBackUp = new javax.swing.JLabel();
        pnStaff = new javax.swing.JPanel();
        taskBar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchFiled = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        pnAddStaff = new javax.swing.JPanel();
        lbAddStaff = new javax.swing.JLabel();
        pnStatistics = new javax.swing.JPanel();
        lbStatistics = new javax.swing.JLabel();
        pnEdit = new javax.swing.JPanel();
        lbEditStaff = new javax.swing.JLabel();
        pnMainStatistics = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStaff = new javax.swing.JTable();
        lbNum = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEditStaff = new javax.swing.JButton();
        btnDeleteStaff = new javax.swing.JButton();
        btnResetPasswordStaff1 = new javax.swing.JButton();
        pnMainAdd = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tfCMND = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        tfFullname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfBirthDay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfPhoneNum = new javax.swing.JTextField();
        cbStaffSex = new javax.swing.JComboBox<>();
        pnMainEdit = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tfCMND1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tfFullname1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfBirthDay1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfAddress1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfEmail1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfPhoneNum1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        cbStaffEdit = new javax.swing.JComboBox<>();
        pnUser2 = new javax.swing.JPanel();
        taskBar1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        searchFiled1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        pnAddStaff1 = new javax.swing.JPanel();
        lbAddStaff1 = new javax.swing.JLabel();
        pnStatistics1 = new javax.swing.JPanel();
        lbStatistics1 = new javax.swing.JLabel();
        pnEdit1 = new javax.swing.JPanel();
        lbEditStaff1 = new javax.swing.JLabel();
        pnMainStatistics1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbStaff1 = new javax.swing.JTable();
        lbNum1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnEditStaff1 = new javax.swing.JButton();
        btnDeleteStaff1 = new javax.swing.JButton();
        btnResetPasswordStaff2 = new javax.swing.JButton();
        pnMainAdd1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tfCMND2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        btnRefresh1 = new javax.swing.JButton();
        tfFullname2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        tfBirthDay2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tfAddress2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        tfEmail2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        tfPhoneNum2 = new javax.swing.JTextField();
        cbUserAdd = new javax.swing.JComboBox<>();
        pnMainEdit1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        tfCMND3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnUpdate1 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        tfFullname3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        tfBirthDay3 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        tfAddress3 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        tfEmail3 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tfPhoneNum3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        tfID1 = new javax.swing.JTextField();
        cbUserEdit = new javax.swing.JComboBox<>();
        pnBackupScr = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbBackup = new javax.swing.JLabel();
        pnSaoLuu = new javax.swing.JPanel();
        lbSaoLuu = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbRestore = new javax.swing.JLabel();
        pnKhoiPhuc = new javax.swing.JPanel();
        lbKhoiPhuc = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbTime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbCancel = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbMinimize1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(53, 53, 53));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMain.setBackground(new java.awt.Color(255, 247, 238));
        pnMain.setAlignmentX(0.0F);
        pnMain.setAlignmentY(0.0F);
        pnMain.setDoubleBuffered(false);
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLeft.setBackground(new java.awt.Color(38, 40, 55));
        pnLeft.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnUser.setBackground(new java.awt.Color(38, 40, 55));
        pnUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/admin.jpg"))); // NOI18N
        pnUser.add(adminIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 55));

        adminName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminName.setText("Văn Minh Hào");
        pnUser.add(adminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 0, 150, -1));

        onlineIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/online.jpg"))); // NOI18N
        pnUser.add(onlineIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 35, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin");
        pnUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 50, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Logout Rounded_32px_2.png"))); // NOI18N
        jLabel4.setToolTipText("Đăng Xuất");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        pnUser.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 32, 32));

        pnStaffManagement.setBackground(new java.awt.Color(38, 40, 55));
        pnStaffManagement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbStaff.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbStaff.setForeground(new java.awt.Color(255, 255, 255));
        lbStaff.setText("Quản Lý Nhân Viên");
        lbStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbStaffMouseExited(evt);
            }
        });
        pnStaffManagement.add(lbStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnUserManagement.setBackground(new java.awt.Color(38, 40, 55));
        pnUserManagement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(255, 255, 255));
        lbUser.setText("Quản Lý Người Dùng");
        lbUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbUserMouseExited(evt);
            }
        });
        pnUserManagement.add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnBackUp.setBackground(new java.awt.Color(38, 40, 55));
        pnBackUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBackUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbBackUp.setForeground(new java.awt.Color(255, 255, 255));
        lbBackUp.setText("Backup Dữ Liệu");
        lbBackUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBackUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBackUpMouseExited(evt);
            }
        });
        pnBackUp.add(lbBackUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addGroup(pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnStaffManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnUserManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBackUp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnStaffManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnUserManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBackUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pnMain.add(pnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, -1));

        pnStaff.setBackground(new java.awt.Color(255, 247, 238));
        pnStaff.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taskBar.setBackground(new java.awt.Color(38, 40, 55));
        taskBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Search_32px_1.png"))); // NOI18N
        taskBar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        searchFiled.setBackground(new java.awt.Color(38, 40, 55));
        searchFiled.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchFiled.setForeground(new java.awt.Color(255, 255, 255));
        searchFiled.setBorder(null);
        searchFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFiledActionPerformed(evt);
            }
        });
        taskBar.add(searchFiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 5, 170, 20));
        taskBar.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 28, 170, -1));

        pnAddStaff.setBackground(new java.awt.Color(38, 40, 55));

        lbAddStaff.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbAddStaff.setForeground(new java.awt.Color(255, 255, 255));
        lbAddStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddStaff.setText("Thêm Nhân Viên");
        lbAddStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddStaffMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAddStaffMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAddStaffMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnAddStaffLayout = new javax.swing.GroupLayout(pnAddStaff);
        pnAddStaff.setLayout(pnAddStaffLayout);
        pnAddStaffLayout.setHorizontalGroup(
            pnAddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pnAddStaffLayout.setVerticalGroup(
            pnAddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar.add(pnAddStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 160, 40));

        pnStatistics.setBackground(new java.awt.Color(38, 40, 55));

        lbStatistics.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbStatistics.setForeground(new java.awt.Color(255, 255, 255));
        lbStatistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatistics.setText("Thống Kê");
        lbStatistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStatisticsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbStatisticsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbStatisticsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnStatisticsLayout = new javax.swing.GroupLayout(pnStatistics);
        pnStatistics.setLayout(pnStatisticsLayout);
        pnStatisticsLayout.setHorizontalGroup(
            pnStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pnStatisticsLayout.setVerticalGroup(
            pnStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar.add(pnStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 160, 40));

        pnEdit.setBackground(new java.awt.Color(38, 40, 55));

        lbEditStaff.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbEditStaff.setForeground(new java.awt.Color(255, 255, 255));
        lbEditStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEditStaff.setText("Chỉnh Sửa Thông Tin");
        lbEditStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnEditLayout = new javax.swing.GroupLayout(pnEdit);
        pnEdit.setLayout(pnEditLayout);
        pnEditLayout.setHorizontalGroup(
            pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEditStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnEditLayout.setVerticalGroup(
            pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEditStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar.add(pnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 200, -1));

        pnStaff.add(taskBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        pnMainStatistics.setBackground(new java.awt.Color(255, 247, 238));
        pnMainStatistics.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(38, 40, 55));

        tbStaff.setAutoCreateRowSorter(true);
        tbStaff.setBackground(new java.awt.Color(214, 217, 223));
        tbStaff.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbStaff.setForeground(new java.awt.Color(0, 0, 255));
        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbStaff.setGridColor(new java.awt.Color(255, 255, 255));
        tbStaff.setRowHeight(30);
        tbStaff.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbStaffMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbStaff);

        pnMainStatistics.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 320));

        lbNum.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNum.setForeground(new java.awt.Color(51, 51, 255));
        lbNum.setText("0");
        pnMainStatistics.add(lbNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 90, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Số Lượng:");
        pnMainStatistics.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 90, 40));

        btnEditStaff.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnEditStaff.setForeground(new java.awt.Color(51, 51, 255));
        btnEditStaff.setText("Chỉnh sửa");
        btnEditStaff.setEnabled(false);
        btnEditStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaffActionPerformed(evt);
            }
        });
        pnMainStatistics.add(btnEditStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        btnDeleteStaff.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDeleteStaff.setForeground(new java.awt.Color(51, 51, 255));
        btnDeleteStaff.setText("Xóa");
        btnDeleteStaff.setEnabled(false);
        btnDeleteStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStaffActionPerformed(evt);
            }
        });
        pnMainStatistics.add(btnDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 90, -1));

        btnResetPasswordStaff1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnResetPasswordStaff1.setForeground(new java.awt.Color(51, 51, 255));
        btnResetPasswordStaff1.setText("Đặt Lại Mật Khẩu");
        btnResetPasswordStaff1.setEnabled(false);
        btnResetPasswordStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordStaff1ActionPerformed(evt);
            }
        });
        pnMainStatistics.add(btnResetPasswordStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        pnStaff.add(pnMainStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 450));

        pnMainAdd.setBackground(new java.awt.Color(255, 247, 238));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Email:");

        tfCMND.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Số Điện Thoại:");

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("CMND:");

        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRefresh.setText("Làm Mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tfFullname.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Họ Và Tên:");

        tfBirthDay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfBirthDay.setText("dd-MM-yyyy");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Giới Tính:");

        tfAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Ngày Sinh:");

        tfEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Địa Chỉ:");

        tfPhoneNum.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cbStaffSex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbStaffSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfFullname)
                        .addComponent(tfBirthDay)
                        .addComponent(tfAddress)
                        .addComponent(tfEmail)
                        .addComponent(tfPhoneNum)
                        .addComponent(tfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbStaffSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(cbStaffSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(tfBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16))
                            .addComponent(tfPhoneNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12)))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnMainAddLayout = new javax.swing.GroupLayout(pnMainAdd);
        pnMainAdd.setLayout(pnMainAddLayout);
        pnMainAddLayout.setHorizontalGroup(
            pnMainAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainAddLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        pnMainAddLayout.setVerticalGroup(
            pnMainAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnStaff.add(pnMainAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 450));

        pnMainEdit.setBackground(new java.awt.Color(255, 247, 238));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Email:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 239, 100, -1));

        tfCMND1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(tfCMND1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 316, 270, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Số Điện Thoại:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 279, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate.setText("Cập Nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 101, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("CMND:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 317, 100, -1));

        tfFullname1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel5.add(tfFullname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 72, 270, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Họ Và Tên:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 77, 100, -1));

        tfBirthDay1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfBirthDay1.setText("dd-MM-yyyy");
        jPanel5.add(tfBirthDay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 156, 270, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Giới Tính:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 117, 100, -1));

        tfAddress1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(tfAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 197, 270, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Ngày Sinh:");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 157, 100, -1));

        tfEmail1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(tfEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 238, 270, -1));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Địa Chỉ:");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 198, 100, -1));

        tfPhoneNum1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(tfPhoneNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 275, 270, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 32, -1, -1));

        tfID.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfID.setEnabled(false);
        jPanel5.add(tfID, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 26, 270, -1));

        cbStaffEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbStaffEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        jPanel5.add(cbStaffEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 115, -1, -1));

        javax.swing.GroupLayout pnMainEditLayout = new javax.swing.GroupLayout(pnMainEdit);
        pnMainEdit.setLayout(pnMainEditLayout);
        pnMainEditLayout.setHorizontalGroup(
            pnMainEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainEditLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        pnMainEditLayout.setVerticalGroup(
            pnMainEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnStaff.add(pnMainEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 450));

        pnMain.add(pnStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 800, 540));

        pnUser2.setBackground(new java.awt.Color(255, 247, 238));
        pnUser2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taskBar1.setBackground(new java.awt.Color(38, 40, 55));
        taskBar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Search_32px_1.png"))); // NOI18N
        taskBar1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        searchFiled1.setBackground(new java.awt.Color(38, 40, 55));
        searchFiled1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        searchFiled1.setForeground(new java.awt.Color(255, 255, 255));
        searchFiled1.setBorder(null);
        searchFiled1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFiled1ActionPerformed(evt);
            }
        });
        taskBar1.add(searchFiled1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 5, 170, 20));
        taskBar1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 28, 170, -1));

        pnAddStaff1.setBackground(new java.awt.Color(38, 40, 55));

        lbAddStaff1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbAddStaff1.setForeground(new java.awt.Color(255, 255, 255));
        lbAddStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddStaff1.setText("Thêm Người Dùng");
        lbAddStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAddStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAddStaff1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbAddStaff1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbAddStaff1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnAddStaff1Layout = new javax.swing.GroupLayout(pnAddStaff1);
        pnAddStaff1.setLayout(pnAddStaff1Layout);
        pnAddStaff1Layout.setHorizontalGroup(
            pnAddStaff1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddStaff1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pnAddStaff1Layout.setVerticalGroup(
            pnAddStaff1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAddStaff1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar1.add(pnAddStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 160, 40));

        pnStatistics1.setBackground(new java.awt.Color(38, 40, 55));

        lbStatistics1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbStatistics1.setForeground(new java.awt.Color(255, 255, 255));
        lbStatistics1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatistics1.setText("Thống Kê");
        lbStatistics1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbStatistics1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbStatistics1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbStatistics1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbStatistics1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnStatistics1Layout = new javax.swing.GroupLayout(pnStatistics1);
        pnStatistics1.setLayout(pnStatistics1Layout);
        pnStatistics1Layout.setHorizontalGroup(
            pnStatistics1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatistics1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        pnStatistics1Layout.setVerticalGroup(
            pnStatistics1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatistics1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar1.add(pnStatistics1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 160, 40));

        pnEdit1.setBackground(new java.awt.Color(38, 40, 55));

        lbEditStaff1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbEditStaff1.setForeground(new java.awt.Color(255, 255, 255));
        lbEditStaff1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEditStaff1.setText("Chỉnh Sửa Thông Tin");
        lbEditStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnEdit1Layout = new javax.swing.GroupLayout(pnEdit1);
        pnEdit1.setLayout(pnEdit1Layout);
        pnEdit1Layout.setHorizontalGroup(
            pnEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEditStaff1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnEdit1Layout.setVerticalGroup(
            pnEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbEditStaff1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        taskBar1.add(pnEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 200, -1));

        pnUser2.add(taskBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        pnMainStatistics1.setBackground(new java.awt.Color(255, 247, 238));
        pnMainStatistics1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(38, 40, 55));

        tbStaff1.setAutoCreateRowSorter(true);
        tbStaff1.setBackground(new java.awt.Color(214, 217, 223));
        tbStaff1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbStaff1.setForeground(new java.awt.Color(0, 0, 255));
        tbStaff1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStaff1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbStaff1.setGridColor(new java.awt.Color(255, 255, 255));
        tbStaff1.setRowHeight(30);
        tbStaff1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbStaff1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbStaff1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbStaff1);

        pnMainStatistics1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 320));

        lbNum1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNum1.setForeground(new java.awt.Color(51, 51, 255));
        lbNum1.setText("0");
        pnMainStatistics1.add(lbNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 90, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 255));
        jLabel11.setText("Số Lượng:");
        pnMainStatistics1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 90, 40));

        btnEditStaff1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnEditStaff1.setForeground(new java.awt.Color(51, 51, 255));
        btnEditStaff1.setText("Chỉnh sửa");
        btnEditStaff1.setEnabled(false);
        btnEditStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaff1ActionPerformed(evt);
            }
        });
        pnMainStatistics1.add(btnEditStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, -1));

        btnDeleteStaff1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnDeleteStaff1.setForeground(new java.awt.Color(51, 51, 255));
        btnDeleteStaff1.setText("Xóa");
        btnDeleteStaff1.setEnabled(false);
        btnDeleteStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStaff1ActionPerformed(evt);
            }
        });
        pnMainStatistics1.add(btnDeleteStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 90, -1));

        btnResetPasswordStaff2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnResetPasswordStaff2.setForeground(new java.awt.Color(51, 51, 255));
        btnResetPasswordStaff2.setText("Đặt Lại Mật Khẩu");
        btnResetPasswordStaff2.setEnabled(false);
        btnResetPasswordStaff2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordStaff2ActionPerformed(evt);
            }
        });
        pnMainStatistics1.add(btnResetPasswordStaff2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        pnUser2.add(pnMainStatistics1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 450));

        pnMainAdd1.setBackground(new java.awt.Color(255, 247, 238));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Email:");

        tfCMND2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Số Điện Thoại:");

        btnAdd1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd1.setText("Thêm");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("CMND:");

        btnRefresh1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRefresh1.setText("Làm Mới");
        btnRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh1ActionPerformed(evt);
            }
        });

        tfFullname2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Họ Và Tên:");

        tfBirthDay2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfBirthDay2.setText("dd-MM-yyyy");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Giới Tính:");

        tfAddress2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày Sinh:");

        tfEmail2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Địa Chỉ:");

        tfPhoneNum2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cbUserAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbUserAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfFullname2)
                        .addComponent(tfBirthDay2)
                        .addComponent(tfAddress2)
                        .addComponent(tfEmail2)
                        .addComponent(tfPhoneNum2)
                        .addComponent(tfCMND2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tfFullname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(cbUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(tfBirthDay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(tfAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(tfEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25))
                            .addComponent(tfPhoneNum2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(tfCMND2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel28)))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnRefresh1))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnMainAdd1Layout = new javax.swing.GroupLayout(pnMainAdd1);
        pnMainAdd1.setLayout(pnMainAdd1Layout);
        pnMainAdd1Layout.setHorizontalGroup(
            pnMainAdd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainAdd1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        pnMainAdd1Layout.setVerticalGroup(
            pnMainAdd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnUser2.add(pnMainAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 450));

        pnMainEdit1.setBackground(new java.awt.Color(255, 247, 238));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Email:");
        jPanel7.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 239, 100, -1));

        tfCMND3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(tfCMND3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 316, 270, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Số Điện Thoại:");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 279, -1, -1));

        btnUpdate1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate1.setText("Cập Nhật");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 101, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("CMND:");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 317, 100, -1));

        tfFullname3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jPanel7.add(tfFullname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 72, 270, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Họ Và Tên:");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 77, 100, -1));

        tfBirthDay3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tfBirthDay3.setText("dd-MM-yyyy");
        jPanel7.add(tfBirthDay3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 156, 270, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Giới Tính:");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 117, 100, -1));

        tfAddress3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(tfAddress3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 197, 270, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Ngày Sinh:");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 157, 100, -1));

        tfEmail3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(tfEmail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 238, 270, -1));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Địa Chỉ:");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 198, 100, -1));

        tfPhoneNum3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel7.add(tfPhoneNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 275, 270, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("ID:");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 32, -1, -1));

        tfID1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfID1.setEnabled(false);
        jPanel7.add(tfID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 26, 270, -1));

        cbUserEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbUserEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        jPanel7.add(cbUserEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 115, -1, -1));

        javax.swing.GroupLayout pnMainEdit1Layout = new javax.swing.GroupLayout(pnMainEdit1);
        pnMainEdit1.setLayout(pnMainEdit1Layout);
        pnMainEdit1Layout.setHorizontalGroup(
            pnMainEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainEdit1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        pnMainEdit1Layout.setVerticalGroup(
            pnMainEdit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnUser2.add(pnMainEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 800, 450));

        pnMain.add(pnUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 800, 540));

        pnBackupScr.setBackground(new java.awt.Color(255, 247, 238));
        pnBackupScr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(101, 197, 185));

        lbBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/backup.png"))); // NOI18N

        pnSaoLuu.setBackground(new java.awt.Color(101, 197, 185));

        lbSaoLuu.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbSaoLuu.setForeground(new java.awt.Color(255, 255, 255));
        lbSaoLuu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSaoLuu.setText("SAO LƯU");
        lbSaoLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSaoLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSaoLuuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSaoLuuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSaoLuuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnSaoLuuLayout = new javax.swing.GroupLayout(pnSaoLuu);
        pnSaoLuu.setLayout(pnSaoLuuLayout);
        pnSaoLuuLayout.setHorizontalGroup(
            pnSaoLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSaoLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        pnSaoLuuLayout.setVerticalGroup(
            pnSaoLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSaoLuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lbBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(pnSaoLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnSaoLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnBackupScr.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 390));

        jPanel2.setBackground(new java.awt.Color(0, 159, 60));

        lbRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/restore.png"))); // NOI18N

        pnKhoiPhuc.setBackground(new java.awt.Color(0, 159, 60));

        lbKhoiPhuc.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        lbKhoiPhuc.setForeground(new java.awt.Color(255, 255, 255));
        lbKhoiPhuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbKhoiPhuc.setText("KHÔI PHỤC");
        lbKhoiPhuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbKhoiPhuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbKhoiPhucMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbKhoiPhucMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbKhoiPhucMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnKhoiPhucLayout = new javax.swing.GroupLayout(pnKhoiPhuc);
        pnKhoiPhuc.setLayout(pnKhoiPhucLayout);
        pnKhoiPhucLayout.setHorizontalGroup(
            pnKhoiPhucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbKhoiPhuc, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        pnKhoiPhucLayout.setVerticalGroup(
            pnKhoiPhucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbKhoiPhuc, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(pnKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnKhoiPhuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pnBackupScr.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 390));

        jPanel8.setBackground(new java.awt.Color(38, 40, 55));

        lbTime.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setText("Lần sao lưu gần nhất: 2017-05-06 20:51:26");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnBackupScr.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 800, 70));

        pnMain.add(pnBackupScr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 800, 540));

        getContentPane().add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1010, 460));

        jPanel4.setBackground(new java.awt.Color(53, 53, 53));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 43));

        lbCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Cancel_32px.png"))); // NOI18N
        lbCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCancelMouseClicked(evt);
            }
        });

        lbMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Minimize Window_32px_2.png"))); // NOI18N
        lbMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizeMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thư Viện Đại Học Bách Khoa");

        lbMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/bkLogo3.png"))); // NOI18N
        lbMinimize1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbMinimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(304, 304, 304)
                .addComponent(lbMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCancel)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lbMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbMinimize1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/banner2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, 110));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void lbCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbCancelMouseClicked

    private void lbMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lbMinimizeMouseClicked

    private void lbStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStaffMouseClicked
        pnStaff.show();
        pnUser2.hide();
        pnBackupScr.hide();
        SetAdminState(0, 0);
    }//GEN-LAST:event_lbStaffMouseClicked

    private void lbStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStaffMouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnStaffManagement);
    }//GEN-LAST:event_lbStaffMouseEntered

    private void lbStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStaffMouseExited
        // TODO add your handling code here:
        if (leftState != 0) {
            changeBackPanelExited(pnStaffManagement);
        }
    }//GEN-LAST:event_lbStaffMouseExited

    private void lbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseClicked
        // TODO add your handling code here:
        pnStaff.hide();
        pnUser2.show();
        pnBackupScr.hide();
        SetAdminState(1, 0);
    }//GEN-LAST:event_lbUserMouseClicked

    private void lbUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnUserManagement);
    }//GEN-LAST:event_lbUserMouseEntered

    private void lbUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseExited
        // TODO add your handling code here:
        if (leftState != 1) {
            changeBackPanelExited(pnUserManagement);
        }
    }//GEN-LAST:event_lbUserMouseExited

    private void lbBackUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackUpMouseClicked
        // TODO add your handling code here:
        pnStaff.hide();
        pnUser2.hide();
        pnBackupScr.show();
        SetAdminState(2, 0);
    }//GEN-LAST:event_lbBackUpMouseClicked

    private void lbBackUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackUpMouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnBackUp);
    }//GEN-LAST:event_lbBackUpMouseEntered

    private void lbBackUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackUpMouseExited
        // TODO add your handling code here:
        if (leftState != 2) {
            changeBackPanelExited(pnBackUp);
        }
    }//GEN-LAST:event_lbBackUpMouseExited

    private void lbStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatisticsMouseClicked
        // TODO add your handling code here:
        SetAdminState(0, 0);
        SetTable(DatabaseQuery.getAllManager(), tbStaff, 0);
    }//GEN-LAST:event_lbStatisticsMouseClicked

    public void SetTable(ResultSet res, JTable table, int index) {
        int num = SupportFunctions.DisplayStaffResult(res, table);
        if (index == 0) {
            lbNum.setText((String.valueOf(num)));
        } else if (index == 1) {
            lbNum1.setText((String.valueOf(num)));
        }
    }

    private void lbStatisticsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatisticsMouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnStatistics);

    }//GEN-LAST:event_lbStatisticsMouseEntered

    private void lbStatisticsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatisticsMouseExited
        // TODO add your handling code here:
        if (rightState != 0) {
            pnStatistics.setBackground(new Color(38, 40, 55));
        }
    }//GEN-LAST:event_lbStatisticsMouseExited

    private void lbAddStaffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaffMouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnAddStaff);
    }//GEN-LAST:event_lbAddStaffMouseEntered

    private void lbAddStaffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaffMouseExited
        // TODO add your handling code here:
        if (rightState != 1) {
            changeBackPanelExited(pnAddStaff);
        }
    }//GEN-LAST:event_lbAddStaffMouseExited

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (tfFullname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống");
        } else if (!ValidatingClass.isEmailValid(tfEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại!");
        } else if (!ValidatingClass.isDateValid(tfBirthDay.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng, vui lòng nhập lại!");
        } else if (ValidatingClass.isCMNDExisting(tfCMND.getText(), staffDatabase)) {
            JOptionPane.showMessageDialog(null, "CMND bị trùng, vui lòng nhập lại!");
        } else {
            try {
                String ID = SupportFunctions.GenerateStaffID();
                People staff = new People(ID, tfFullname.getText(), tfAddress.getText(), tfBirthDay.getText(), tfEmail.getText(), ID, SupportFunctions.Hash256("123456"),
                        cbStaffSex.getSelectedItem().toString(), tfCMND.getText(), tfPhoneNum.getText());
                boolean insertSuccessfully = DatabaseQuery.AddUser(staff, staffDatabase);
                if (insertSuccessfully == false) {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên không thành công, vui lòng thử lại!");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
                    btnRefreshActionPerformed(evt);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        ClearAddingSpace();
    }//GEN-LAST:event_btnRefreshActionPerformed

    public void ClearAddingSpace() {
        // TODO add your handling code here:
        tfFullname.setText("");
        tfAddress.setText("");
        tfBirthDay.setText("dd-MM-yyyy");
        tfCMND.setText("");
        tfEmail.setText("");
        tfPhoneNum.setText("");
    }

    private void lbAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaffMouseClicked
        // TODO add your handling code here:
        SetAdminState(0, 1);
    }//GEN-LAST:event_lbAddStaffMouseClicked

    private void btnDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaffActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int row = tbStaff.getSelectedRow();
            String ID = (String) tbStaff.getValueAt(row, 0);
            boolean delete = DatabaseQuery.DeleteUser(ID, staffDatabase);
            if (!delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                SetTable(DatabaseQuery.getAllManager(), tbStaff, 0);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại, vui lòng thử lại sau!");
            }
        }
    }//GEN-LAST:event_btnDeleteStaffActionPerformed

    private void btnEditStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaffActionPerformed
        try {
            // TODO add your handling code here:
            int row = tbStaff.getSelectedRow();
            String ID = (String) tbStaff.getValueAt(row, 0);
            SetAdminState(0, 2);
            ResultSet res = DatabaseQuery.FindUserByID(ID, staffDatabase);
            res.next();
            String gendre = res.getString("Sex");
            if (gendre.equals("Nam")) {
                cbStaffEdit.setSelectedIndex(0);
            }
            if (gendre.equals("Nữ")) {
                cbStaffEdit.setSelectedIndex(1);
            }
            if (gendre.equals("Khác")) {
                cbStaffEdit.setSelectedIndex(2);
            }
            tfID.setText(ID);
            tfFullname1.setText(res.getString("Name"));
            tfAddress1.setText(res.getString("Address"));
            tfBirthDay1.setText(res.getString("Birthday"));
            tfCMND1.setText(res.getString("CMND"));
            tfEmail1.setText(res.getString("Email"));
            tfPhoneNum1.setText(res.getString("PhoneNum"));
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditStaffActionPerformed

    private void tbStaffMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaffMousePressed
        // TODO add your handling code here:
        btnDeleteStaff.setEnabled(true);
        btnEditStaff.setEnabled(true);
        btnResetPasswordStaff1.setEnabled(true);
    }//GEN-LAST:event_tbStaffMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (tfFullname1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống");
        } else if (!ValidatingClass.isEmailValid(tfEmail1.getText())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại!");
        } else if (!ValidatingClass.isDateValid(tfBirthDay1.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng, vui lòng nhập lại!");
        } else {
            People staff = new People(tfID.getText(), tfFullname1.getText(), tfAddress1.getText(), tfBirthDay1.getText(), tfEmail1.getText(), cbStaffEdit.getSelectedItem().toString(), tfCMND1.getText(), tfPhoneNum1.getText());
            boolean status = DatabaseQuery.UpdateUser(staff, staffDatabase);
            if (status == false) {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công, vui lòng thử lại!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                SetAdminState(0, 0);
                SetTable(DatabaseQuery.getAllManager(), tbStaff, 0);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void searchFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFiledActionPerformed
        // TODO add your handling code here:
        String keyWord = searchFiled.getText();
        ResultSet res = DatabaseQuery.FindUserByKeyWord(keyWord, staffDatabase);
        SetAdminState(0, 0);
        SupportFunctions.DisplayStaffResult(res, tbStaff);
    }//GEN-LAST:event_searchFiledActionPerformed

    private void btnResetPasswordStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordStaff1ActionPerformed
        // TODO add your handling code here:
        int row = tbStaff.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(null, "Tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String ID = (String) tbStaff.getValueAt(row, 0);
            boolean IDExisted = DatabaseQuery.CheckIDUserExisted(ID, staffDatabase);
            if (!IDExisted) {
                JOptionPane.showMessageDialog(null, "ID người dùng không tồn tại");
            } else {
                boolean change = DatabaseQuery.UpdateUserPassword(ID, "123456", staffDatabase);
                if (change == true) {
                    JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu thành công!");
                    SetAdminState(0, 0);
                } else {
                    JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu không thành công, vui lòng thử lại!");
                }
            }
        }
    }//GEN-LAST:event_btnResetPasswordStaff1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void searchFiled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFiled1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFiled1ActionPerformed

    private void lbAddStaff1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaff1MouseClicked
        // TODO add your handling code here:
        SetAdminState(1, 1);
    }//GEN-LAST:event_lbAddStaff1MouseClicked

    private void lbAddStaff1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaff1MouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnAddStaff1);
    }//GEN-LAST:event_lbAddStaff1MouseEntered

    private void lbAddStaff1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAddStaff1MouseExited
        // TODO add your handling code here:
        if (rightState != 1) {
            changeBackPanelExited(pnAddStaff1);
        }
    }//GEN-LAST:event_lbAddStaff1MouseExited

    private void lbStatistics1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatistics1MouseClicked
        // TODO add your handling code here:
        SetAdminState(1, 0);
        SetTable(DatabaseQuery.getAllReader(), tbStaff1, 1);
    }//GEN-LAST:event_lbStatistics1MouseClicked

    private void lbStatistics1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatistics1MouseEntered
        // TODO add your handling code here:
        changeBackPanelEntered(pnStatistics1);
    }//GEN-LAST:event_lbStatistics1MouseEntered

    private void lbStatistics1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbStatistics1MouseExited
        // TODO add your handling code here:
        if (rightState != 0) {
            changeBackPanelExited(pnStatistics1);
        }
    }//GEN-LAST:event_lbStatistics1MouseExited

    private void tbStaff1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStaff1MousePressed
        // TODO add your handling code here:
        btnDeleteStaff1.setEnabled(true);
        btnEditStaff1.setEnabled(true);
        btnResetPasswordStaff2.setEnabled(true);
    }//GEN-LAST:event_tbStaff1MousePressed

    private void btnEditStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaff1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = tbStaff1.getSelectedRow();
            String ID = (String) tbStaff1.getValueAt(row, 0);
            SetAdminState(1, 2);
            ResultSet res = DatabaseQuery.FindUserByID(ID, userDatabase);
            res.next();
            String gendre = res.getString("Sex");
            if (gendre.equals("Nam")) {
                cbUserEdit.setSelectedIndex(0);
            }
            if (gendre.equals("Nữ")) {
                cbUserEdit.setSelectedIndex(1);
            }
            if (gendre.equals("Khác")) {
                cbUserEdit.setSelectedIndex(2);
            }
            tfID1.setText(ID);
            tfFullname3.setText(res.getString("Name"));
            tfAddress3.setText(res.getString("Address"));
            tfBirthDay3.setText(res.getString("Birthday"));
            tfCMND3.setText(res.getString("CMND"));
            tfEmail3.setText(res.getString("Email"));
            tfPhoneNum3.setText(res.getString("PhoneNum"));
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditStaff1ActionPerformed

    private void btnDeleteStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStaff1ActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int row = tbStaff1.getSelectedRow();
            String ID = (String) tbStaff1.getValueAt(row, 0);
            boolean delete = DatabaseQuery.DeleteUser(ID, userDatabase);
            if (!delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                SetTable(DatabaseQuery.getAllReader(), tbStaff1, 1);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thất bại, vui lòng thử lại sau!");
            }
        }
    }//GEN-LAST:event_btnDeleteStaff1ActionPerformed

    private void btnResetPasswordStaff2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordStaff2ActionPerformed
        // TODO add your handling code here:
        int row = tbStaff1.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(null, "Tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String ID = (String) tbStaff1.getValueAt(row, 0);
            boolean IDExisted = DatabaseQuery.CheckIDUserExisted(ID, userDatabase);
            if (!IDExisted) {
                JOptionPane.showMessageDialog(null, "ID người dùng không tồn tại");
            } else {
                try {
                    boolean change = DatabaseQuery.UpdateUserPassword(ID, SupportFunctions.Hash256("123456"), userDatabase);
                    if (change == true) {
                        JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu thành công!");
                        SetAdminState(1, 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đặt lại mật khẩu không thành công, vui lòng thử lại!");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnResetPasswordStaff2ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        if (tfFullname2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống");
        } else if (!ValidatingClass.isEmailValid(tfEmail2.getText())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại!");
        } else if (!ValidatingClass.isDateValid(tfBirthDay2.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng, vui lòng nhập lại!");
        } else if (ValidatingClass.isCMNDExisting(tfCMND2.getText(), userDatabase)) {
            JOptionPane.showMessageDialog(null, "CMND bị trùng, vui lòng nhập lại!");
        } else {
            String ID = SupportFunctions.GenerateUserID();
            People user = new People(ID, tfFullname2.getText(), tfAddress2.getText(), tfBirthDay2.getText(), tfEmail2.getText(), cbUserAdd.getSelectedItem().toString(), tfCMND2.getText(), tfPhoneNum2.getText());
            boolean insertSuccessfully = DatabaseQuery.AddUser(user, userDatabase);
            if (insertSuccessfully == false) {
                JOptionPane.showMessageDialog(null, "Thêm người dùng không thành công, vui lòng thử lại!");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm người dùng thành công!");
                btnRefresh1ActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh1ActionPerformed
        // TODO add your handling code here:
        ClearAddingSpace2();
    }//GEN-LAST:event_btnRefresh1ActionPerformed

    public void ClearAddingSpace2() {
        // TODO add your handling code here:
        tfFullname2.setText("");
        tfAddress2.setText("");
        tfBirthDay2.setText("dd-MM-yyyy");
        tfCMND2.setText("");
        tfEmail2.setText("");
        tfPhoneNum2.setText("");
    }

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
        if (tfFullname3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống");
        } else if (!ValidatingClass.isEmailValid(tfEmail3.getText())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại!");
        } else if (!ValidatingClass.isDateValid(tfBirthDay3.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng, vui lòng nhập lại!");
        } else {
            People user = new People(tfID1.getText(), tfFullname3.getText(), tfAddress3.getText(), tfBirthDay3.getText(), tfEmail3.getText(), cbUserEdit.getSelectedItem().toString(), tfCMND3.getText(), tfPhoneNum3.getText());
            boolean status = DatabaseQuery.UpdateUser(user, userDatabase);
            if (status == false) {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công, vui lòng thử lại!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                SetAdminState(1, 0);
                SetTable(DatabaseQuery.getAllReader(), tbStaff1, 1);
            }
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void lbSaoLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaoLuuMouseEntered
        // TODO add your handling code here:
        if (leftState == 2) {
            pnSaoLuu.setBackground(new Color(30, 49, 92));
        }
    }//GEN-LAST:event_lbSaoLuuMouseEntered

    private void lbSaoLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaoLuuMouseExited
        // TODO add your handling code here:
        if (leftState == 2) {
            pnSaoLuu.setBackground(new Color(101, 197, 185));
        }
    }//GEN-LAST:event_lbSaoLuuMouseExited

    private void lbKhoiPhucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKhoiPhucMouseExited
        // TODO add your handling code here:
        if (leftState == 2) {
            pnKhoiPhuc.setBackground(new Color(0, 159, 60));
        }
    }//GEN-LAST:event_lbKhoiPhucMouseExited

    private void lbKhoiPhucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKhoiPhucMouseEntered
        // TODO add your handling code here:
        if (leftState == 2) {
            pnKhoiPhuc.setBackground(new Color(30, 49, 92));
        }
    }//GEN-LAST:event_lbKhoiPhucMouseEntered

    private void lbKhoiPhucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKhoiPhucMouseClicked
        // TODO add your handling code here:
        boolean success = SupportFunctions.restoreData();
        if (success) {
            JOptionPane.showMessageDialog(null, "Khôi phục dữ liệu thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Khôi phục dữ liệu không thành công");
        }
    }//GEN-LAST:event_lbKhoiPhucMouseClicked

    private void lbSaoLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSaoLuuMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Sao lưu dữ liệu thành công.");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        lbTime.setText("Lần sao lưu gần nhất: " + now);
    }//GEN-LAST:event_lbSaoLuuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin(admin).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminIcon;
    private javax.swing.JLabel adminName;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDeleteStaff;
    private javax.swing.JButton btnDeleteStaff1;
    private javax.swing.JButton btnEditStaff;
    private javax.swing.JButton btnEditStaff1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefresh1;
    private javax.swing.JButton btnResetPasswordStaff1;
    private javax.swing.JButton btnResetPasswordStaff2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cbStaffEdit;
    private javax.swing.JComboBox<String> cbStaffSex;
    private javax.swing.JComboBox<String> cbUserAdd;
    private javax.swing.JComboBox<String> cbUserEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbAddStaff;
    private javax.swing.JLabel lbAddStaff1;
    private javax.swing.JLabel lbBackUp;
    private javax.swing.JLabel lbBackup;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbEditStaff;
    private javax.swing.JLabel lbEditStaff1;
    private javax.swing.JLabel lbKhoiPhuc;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbMinimize1;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbNum1;
    private javax.swing.JLabel lbRestore;
    private javax.swing.JLabel lbSaoLuu;
    private javax.swing.JLabel lbStaff;
    private javax.swing.JLabel lbStatistics;
    private javax.swing.JLabel lbStatistics1;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbUser;
    private javax.swing.JLabel onlineIcon;
    private javax.swing.JPanel pnAddStaff;
    private javax.swing.JPanel pnAddStaff1;
    private javax.swing.JPanel pnBackUp;
    private javax.swing.JPanel pnBackupScr;
    private javax.swing.JPanel pnEdit;
    private javax.swing.JPanel pnEdit1;
    private javax.swing.JPanel pnKhoiPhuc;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMainAdd;
    private javax.swing.JPanel pnMainAdd1;
    private javax.swing.JPanel pnMainEdit;
    private javax.swing.JPanel pnMainEdit1;
    private javax.swing.JPanel pnMainStatistics;
    private javax.swing.JPanel pnMainStatistics1;
    private javax.swing.JPanel pnSaoLuu;
    private javax.swing.JPanel pnStaff;
    private javax.swing.JPanel pnStaffManagement;
    private javax.swing.JPanel pnStatistics;
    private javax.swing.JPanel pnStatistics1;
    private javax.swing.JPanel pnUser;
    private javax.swing.JPanel pnUser2;
    private javax.swing.JPanel pnUserManagement;
    private javax.swing.JTextField searchFiled;
    private javax.swing.JTextField searchFiled1;
    private javax.swing.JPanel taskBar;
    private javax.swing.JPanel taskBar1;
    private javax.swing.JTable tbStaff;
    private javax.swing.JTable tbStaff1;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfAddress1;
    private javax.swing.JTextField tfAddress2;
    private javax.swing.JTextField tfAddress3;
    private javax.swing.JTextField tfBirthDay;
    private javax.swing.JTextField tfBirthDay1;
    private javax.swing.JTextField tfBirthDay2;
    private javax.swing.JTextField tfBirthDay3;
    private javax.swing.JTextField tfCMND;
    private javax.swing.JTextField tfCMND1;
    private javax.swing.JTextField tfCMND2;
    private javax.swing.JTextField tfCMND3;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfEmail2;
    private javax.swing.JTextField tfEmail3;
    private javax.swing.JTextField tfFullname;
    private javax.swing.JTextField tfFullname1;
    private javax.swing.JTextField tfFullname2;
    private javax.swing.JTextField tfFullname3;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfID1;
    private javax.swing.JTextField tfPhoneNum;
    private javax.swing.JTextField tfPhoneNum1;
    private javax.swing.JTextField tfPhoneNum2;
    private javax.swing.JTextField tfPhoneNum3;
    // End of variables declaration//GEN-END:variables

    private Runnable Runnable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
