/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author lampard
 */
public class ReaderMain extends javax.swing.JFrame {
    String userName;
    /**
     * Creates new form mainGUI
     */
    public ReaderMain() {
        this.setResizable(false);
        initComponents();
        this.setShape(new RoundRectangle2D.Float(0, 0, 1000, 600, 45, 45));
        this.setSize(1000, 600);
        userName = "NGUYỄN VĂN THÀNH";
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
        pnMain = new javax.swing.JPanel();
        pnLeft = new javax.swing.JPanel();
        pnHome = new javax.swing.JPanel();
        lbHome = new javax.swing.JLabel();
        lbHome1 = new javax.swing.JLabel();
        pnHistory = new javax.swing.JPanel();
        lbHistory = new javax.swing.JLabel();
        lbHistory1 = new javax.swing.JLabel();
        pnUser = new javax.swing.JPanel();
        lbUserInfor = new javax.swing.JLabel();
        lbUserInfor1 = new javax.swing.JLabel();
        pnSearch = new javax.swing.JPanel();
        lbSearch = new javax.swing.JLabel();
        lbSearch1 = new javax.swing.JLabel();
        pbMainSearch = new javax.swing.JPanel();
        lbSearch100 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cbName = new javax.swing.JCheckBox();
        cbAuthor = new javax.swing.JCheckBox();
        cbGenre = new javax.swing.JCheckBox();
        cbPublisher = new javax.swing.JCheckBox();
        cbID = new javax.swing.JCheckBox();
        cbISBN = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        lbCancel = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbMinimize1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

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

        pnHome.setBackground(new java.awt.Color(38, 40, 55));

        lbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Home_32px_2.png"))); // NOI18N

        lbHome1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHome1.setForeground(new java.awt.Color(255, 255, 255));
        lbHome1.setText("Trang Chủ");
        lbHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHome1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHome1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addComponent(lbHome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(lbHome1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnHistory.setBackground(new java.awt.Color(38, 40, 55));

        lbHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Historical_32px.png"))); // NOI18N

        lbHistory1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHistory1.setForeground(new java.awt.Color(255, 255, 255));
        lbHistory1.setText("Lịch Sử Mượn Sách");
        lbHistory1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHistory1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbHistory1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbHistory1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnHistoryLayout = new javax.swing.GroupLayout(pnHistory);
        pnHistory.setLayout(pnHistoryLayout);
        pnHistoryLayout.setHorizontalGroup(
            pnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHistoryLayout.createSequentialGroup()
                .addComponent(lbHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHistory1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );
        pnHistoryLayout.setVerticalGroup(
            pnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(lbHistory1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnUser.setBackground(new java.awt.Color(38, 40, 55));

        lbUserInfor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/User_32px_1.png"))); // NOI18N

        lbUserInfor1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbUserInfor1.setForeground(new java.awt.Color(255, 255, 255));
        lbUserInfor1.setText("Thông Tin Cá Nhân");
        lbUserInfor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUserInfor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbUserInfor1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbUserInfor1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnUserLayout = new javax.swing.GroupLayout(pnUser);
        pnUser.setLayout(pnUserLayout);
        pnUserLayout.setHorizontalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserLayout.createSequentialGroup()
                .addComponent(lbUserInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserInfor1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );
        pnUserLayout.setVerticalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbUserInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(lbUserInfor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnSearch.setBackground(new java.awt.Color(38, 40, 55));

        lbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Search_32px_1.png"))); // NOI18N

        lbSearch1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbSearch1.setForeground(new java.awt.Color(255, 255, 255));
        lbSearch1.setText("Tìm Kiếm");
        lbSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSearch1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbSearch1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addComponent(lbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
            .addComponent(lbSearch1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        pnMain.add(pnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        pbMainSearch.setBackground(new java.awt.Color(38, 40, 55));
        pbMainSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSearch100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Search_32px_1.png"))); // NOI18N
        pbMainSearch.add(lbSearch100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 37));

        tfSearch.setBackground(new java.awt.Color(38, 40, 55));
        tfSearch.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfSearch.setForeground(new java.awt.Color(255, 255, 255));
        tfSearch.setBorder(null);
        pbMainSearch.add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 200, 30));

        jSeparator1.setAlignmentX(0.0F);
        jSeparator1.setAlignmentY(0.0F);
        jSeparator1.setRequestFocusEnabled(false);
        pbMainSearch.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 5));

        cbName.setBackground(new java.awt.Color(38, 40, 55));
        cbName.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbName.setForeground(new java.awt.Color(255, 255, 255));
        cbName.setText("Tên Sách");
        cbName.setAlignmentY(0.0F);
        pbMainSearch.add(cbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 7, -1, -1));

        cbAuthor.setBackground(new java.awt.Color(38, 40, 55));
        cbAuthor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbAuthor.setForeground(new java.awt.Color(255, 255, 255));
        cbAuthor.setText("Tác Giả");
        cbAuthor.setAlignmentY(0.0F);
        pbMainSearch.add(cbAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 7, -1, -1));

        cbGenre.setBackground(new java.awt.Color(38, 40, 55));
        cbGenre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbGenre.setForeground(new java.awt.Color(255, 255, 255));
        cbGenre.setText("Thể Loại");
        cbGenre.setAlignmentY(0.0F);
        pbMainSearch.add(cbGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 7, -1, -1));

        cbPublisher.setBackground(new java.awt.Color(38, 40, 55));
        cbPublisher.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbPublisher.setForeground(new java.awt.Color(255, 255, 255));
        cbPublisher.setText("Nhà Xuất Bản");
        cbPublisher.setAlignmentY(0.0F);
        pbMainSearch.add(cbPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 7, -1, -1));

        cbID.setBackground(new java.awt.Color(38, 40, 55));
        cbID.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbID.setForeground(new java.awt.Color(255, 255, 255));
        cbID.setText("Nhà Xuất Bản");
        cbID.setAlignmentY(0.0F);
        pbMainSearch.add(cbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 7, -1, -1));

        cbISBN.setBackground(new java.awt.Color(38, 40, 55));
        cbISBN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbISBN.setForeground(new java.awt.Color(255, 255, 255));
        cbISBN.setAlignmentY(0.0F);
        cbISBN.setLabel("SKU");
        pbMainSearch.add(cbISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 70, 35));

        pnMain.add(pbMainSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, -1));

        getContentPane().add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 540));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
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
            .addComponent(lbMinimize1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 30));

        jPanel1.setBackground(new java.awt.Color(40, 171, 227));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1010, 30));

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

    private void lbSearch1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearch1MouseExited
        // TODO add your handling code here:
        pnSearch.setBackground(new Color(38,40,55));
    }//GEN-LAST:event_lbSearch1MouseExited

    private void lbSearch1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearch1MouseEntered
        // TODO add your handling code here:
        pnSearch.setBackground(new Color(0, 116, 163));
    }//GEN-LAST:event_lbSearch1MouseEntered

    private void lbUserInfor1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfor1MouseExited
        // TODO add your handling code here:
        pnUser.setBackground(new Color(38,40,55));

    }//GEN-LAST:event_lbUserInfor1MouseExited

    private void lbUserInfor1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfor1MouseEntered
        // TODO add your handling code here:
        pnUser.setBackground(new Color(0, 116, 163));
    }//GEN-LAST:event_lbUserInfor1MouseEntered

    private void lbHistory1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHistory1MouseExited
        // TODO add your handling code here:
        pnHistory.setBackground(new Color(38,40,55));
    }//GEN-LAST:event_lbHistory1MouseExited

    private void lbHistory1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHistory1MouseEntered
        // TODO add your handling code here:
        pnHistory.setBackground(new Color(0, 116, 163));
    }//GEN-LAST:event_lbHistory1MouseEntered

    private void lbHome1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHome1MouseExited
        // TODO add your handling code here:
        pnHome.setBackground(new Color(38,40,55));
    }//GEN-LAST:event_lbHome1MouseExited

    private void lbHome1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHome1MouseEntered
        // TODO add your handling code here:
        pnHome.setBackground(new Color(0, 116, 163));
    }//GEN-LAST:event_lbHome1MouseEntered

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
            java.util.logging.Logger.getLogger(ReaderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReaderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReaderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReaderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run() {
                new ReaderMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAuthor;
    private javax.swing.JCheckBox cbGenre;
    private javax.swing.JCheckBox cbID;
    private javax.swing.JCheckBox cbISBN;
    private javax.swing.JCheckBox cbName;
    private javax.swing.JCheckBox cbPublisher;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbHistory;
    private javax.swing.JLabel lbHistory1;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbHome1;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbMinimize1;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbSearch1;
    private javax.swing.JLabel lbSearch100;
    private javax.swing.JLabel lbUserInfor;
    private javax.swing.JLabel lbUserInfor1;
    private javax.swing.JPanel pbMainSearch;
    private javax.swing.JPanel pnHistory;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnUser;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
