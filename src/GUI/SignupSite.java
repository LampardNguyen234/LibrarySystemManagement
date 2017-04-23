/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.DatabaseQuery;
import main.People;
import main.SupportFunctions;
import main.ValidatingClass;

/**
 *
 * @author Thành
 */
public class SignupSite extends javax.swing.JFrame {

    /**
     * Creates new form LoginSite
     */
    public SignupSite() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        this.setResizable(false);
        this.setShape(new RoundRectangle2D.Float(0, 0, 600, 470, 45, 45));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pfPassword = new javax.swing.JPasswordField();
        lbSignup = new javax.swing.JLabel();
        lbLoginCard = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfBirthDay = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        tfFullName = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        tfAddress = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        tfPhoneNum = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        tfCMND = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lbCancel = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 218, 222));
        setMaximumSize(new java.awt.Dimension(600, 480));
        setMinimumSize(new java.awt.Dimension(600, 480));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 480));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(45, 59, 85));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 420));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(231, 76, 60));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(231, 76, 60));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng Ký");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 47));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 255));
        jLabel5.setText("TÊN ĐĂNG NHẬP");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, 160, -1));

        tfUsername.setBackground(new java.awt.Color(45, 59, 85));
        tfUsername.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfUsername.setForeground(new java.awt.Color(255, 255, 255));
        tfUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, 216, 23));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 255));
        jLabel6.setText("NGÀY SINH");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 365, 216, 7));

        pfPassword.setBackground(new java.awt.Color(45, 59, 85));
        pfPassword.setForeground(new java.awt.Color(255, 255, 255));
        pfPassword.setBorder(null);
        jPanel3.add(pfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 78, 216, 23));

        lbSignup.setBackground(new java.awt.Color(37, 191, 139));
        lbSignup.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbSignup.setForeground(new java.awt.Color(255, 255, 255));
        lbSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSignup.setText("Đăng Ký");
        lbSignup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSignupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSignupMouseExited(evt);
            }
        });
        jPanel3.add(lbSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 394, 96, 33));

        lbLoginCard.setBackground(new java.awt.Color(37, 191, 139));
        lbLoginCard.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbLoginCard.setForeground(new java.awt.Color(255, 255, 255));
        lbLoginCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLoginCard.setText("Đã Có Tài Khoản");
        lbLoginCard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLoginCard.setRequestFocusEnabled(false);
        lbLoginCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLoginCardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLoginCardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLoginCardMouseExited(evt);
            }
        });
        jPanel3.add(lbLoginCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 394, 150, 33));
        lbLoginCard.getAccessibleContext().setAccessibleDescription("");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 255));
        jLabel7.setText("EMAIL");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 315, 80, -1));

        tfBirthDay.setBackground(new java.awt.Color(45, 59, 85));
        tfBirthDay.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfBirthDay.setForeground(new java.awt.Color(255, 255, 255));
        tfBirthDay.setText("dd-MM-yyyy");
        tfBirthDay.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 216, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 255));
        jLabel8.setText("MẬT KHẨU");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 53, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 255));
        jLabel9.setText("GIỚI TÍNH");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 120, 110, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 255));
        jLabel10.setText("CMND");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 255, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 255));
        jLabel11.setText("SỐ ĐIỆN THOẠI");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 255, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 255));
        jLabel12.setText("ĐỊA CHỈ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 190, 84, -1));

        tfEmail.setBackground(new java.awt.Color(45, 59, 85));
        tfEmail.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 216, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 107, 216, -1));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 107, 216, 10));

        tfFullName.setBackground(new java.awt.Color(45, 59, 85));
        tfFullName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfFullName.setForeground(new java.awt.Color(255, 255, 255));
        tfFullName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 154, 218, -1));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 179, 218, 10));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 216, 10));

        tfAddress.setBackground(new java.awt.Color(45, 59, 85));
        tfAddress.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfAddress.setForeground(new java.awt.Color(255, 255, 255));
        tfAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 220, 218, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 245, 218, 10));

        tfPhoneNum.setBackground(new java.awt.Color(45, 59, 85));
        tfPhoneNum.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfPhoneNum.setForeground(new java.awt.Color(255, 255, 255));
        tfPhoneNum.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 217, -1));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 305, 217, 7));

        tfCMND.setBackground(new java.awt.Color(45, 59, 85));
        tfCMND.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfCMND.setForeground(new java.awt.Color(255, 255, 255));
        tfCMND.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(tfCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 280, 218, -1));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 305, 218, 10));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 255));
        jLabel13.setText("HỌ VÀ TÊN");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, -1));

        cbSex.setBackground(new java.awt.Color(45, 59, 85));
        cbSex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbSex.setForeground(new java.awt.Color(255, 255, 255));
        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cbSex.setBorder(null);
        jPanel3.add(cbSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 155, 70, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 440));

        jPanel1.setBackground(new java.awt.Color(53, 53, 53));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/bkLogo3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                .addComponent(lbMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 32));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbLoginCardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginCardMouseEntered
        // TODO add your handling code here:
        lbLoginCard.setForeground(new Color(253, 159, 58));
    }//GEN-LAST:event_lbLoginCardMouseEntered

    private void lbLoginCardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginCardMouseExited
        // TODO add your handling code here:
       lbLoginCard.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_lbLoginCardMouseExited

    private void lbCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lbCancelMouseClicked

    private void lbMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lbMinimizeMouseClicked

    private void lbSignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseExited
        // TODO add your handling code here:
        lbSignup.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_lbSignupMouseExited

    private void lbSignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseEntered
        // TODO add your handling code here:
        lbSignup.setForeground(new Color(255, 159, 58));
    }//GEN-LAST:event_lbSignupMouseEntered

    private void lbLoginCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLoginCardMouseClicked
        // TODO add your handling code here:
        dispose();
        new LoginSite().setVisible(true);
    }//GEN-LAST:event_lbLoginCardMouseClicked

    private void lbSignupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSignupMouseClicked
        // TODO add your handling code here:
        if (DatabaseQuery.CheckUserNameExisted(tfUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập bị trùng!");
        } else if (!SupportFunctions.checkUserName(tfUsername.getText())) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không hợp lệ!");
        } else if (pfPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống!");
        } else if (tfFullName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
        } else if (!ValidatingClass.isEmailValid(tfEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng, vui lòng nhập lại!");
        } else if (!ValidatingClass.isDateValid(tfBirthDay.getText())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng, vui lòng nhập lại!");
        } else if (ValidatingClass.isCMNDExisting(tfCMND.getText(), "doc_gia")) {
            JOptionPane.showMessageDialog(null, "CMND bị trùng, vui lòng nhập lại!");
        } else {
            try {
                String ID = SupportFunctions.GenerateUserID();
                People user = new People(ID, tfFullName.getText(), tfAddress.getText(), tfBirthDay.getText(), tfEmail.getText(),
                        tfUsername.getText(), SupportFunctions.Hash256(pfPassword.getText()), cbSex.getSelectedItem().toString(), tfCMND.getText(), tfPhoneNum.getText());
                boolean insertSuccessfully = DatabaseQuery.AddUser(user, "doc_gia");
                if (insertSuccessfully == true) {
                    JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công!");
                    Clear();
                    dispose();
                    new LoginSite().show();
                } else {
                    JOptionPane.showMessageDialog(null, "Tạo tài khoản không thành công!");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(SignupSite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lbSignupMouseClicked

    public void Clear() {
        tfFullName.setText("");
        tfUsername.setText("");
        tfEmail.setText("");
        tfBirthDay.setText("dd-MM-yyyy");
        tfCMND.setText("");
        tfPhoneNum.setText("");
        tfAddress.setText("");
        cbSex.setSelectedIndex(0);
        pfPassword.setText("");
    }

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
            java.util.logging.Logger.getLogger(SignupSite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupSite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupSite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupSite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupSite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbLoginCard;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbSignup;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfBirthDay;
    private javax.swing.JTextField tfCMND;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFullName;
    private javax.swing.JTextField tfPhoneNum;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
