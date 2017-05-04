/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.DatabaseQuery;
import main.People;
import main.SupportFunctions;
import main.ValidatingClass;

/**
 *
 * @author lampard
 */
public class ReaderMain extends javax.swing.JFrame {
    String userName;
    String ID;
    String CMND;
    String Pass;
    ResultSet res;
    int currentPage = 1;
    int maxPage = 1;
    int quantityPerPage = 10;
    int resultNum = 0;
    
    ArrayList<JLabel> resultName = new ArrayList<>();
    ArrayList<JLabel> resultImage = new ArrayList<>();
    ArrayList<JPanel> resultPanel = new ArrayList<>();
    /**
     * Creates new form mainGUI
     */
    public ReaderMain() {
        this.setResizable(false);
        initComponents();
        this.setShape(new RoundRectangle2D.Float(0, 0, 1000, 600, 45, 45));
        this.setSize(1000, 600);
        changeBackPanel(1);
        this.userName = "Nguyễn Văn Thành";
        
        resultName.add(lbResTxt1);
        resultName.add(lbResTxt2);
        resultName.add(lbResTxt3);
        resultName.add(lbResTxt4);
        resultName.add(lbResTxt5);
        resultName.add(lbResTxt6);
        resultName.add(lbResTxt7);
        resultName.add(lbResTxt8);
        resultName.add(lbResTxt9);
        resultName.add(lbResTxt10);
        resultImage.add(lbResImg1);
        resultImage.add(lbResImg2);
        resultImage.add(lbResImg3);
        resultImage.add(lbResImg4);
        resultImage.add(lbResImg5);
        resultImage.add(lbResImg6);
        resultImage.add(lbResImg7);
        resultImage.add(lbResImg8);
        resultImage.add(lbResImg9);
        resultImage.add(lbResImg10);
//        resultPanel.add(Result1);
//        resultPanel.add(Result2);
//        resultPanel.add(Result3);
//        resultPanel.add(Result4);
//        resultPanel.add(Result5);
//        resultPanel.add(Result6);
//        resultPanel.add(Result7);
//        resultPanel.add(Result8);
//        resultPanel.add(Result9);
//        resultPanel.add(Result10);
//        pnShowResult.hide();
        
    }
    
    public void showReaderInfor(){
        pnRI2.hide();
        pnRI3.hide();
        pnChangePass.hide();
        pnAvatar.show();
        pnShowInfo.show();
        pnRI1.show();
        res = DatabaseQuery.FindUserByName(userName, "doc_gia");
        resultNum = SupportFunctions.GetSize(res);
        lbReaderInfo.setText("Khách hàng: " + userName);
        try {
            res.next();
            ID = res.getString("ID");
            CMND = res.getString("CMND");
            Pass = res.getString("Pass");
            tfAddress.setText(res.getString("Address"));
            tfBirthDay.setText(res.getString("BirthDay"));
            tfCMND.setText(res.getString("CMND"));
            tfEmail.setText(res.getString("Email"));
            tfFName.setText(res.getString("Name"));
            tfPhoneNum.setText(res.getString("Phonenum"));
            String str = res.getString("Sex");
            if (str.equals("Nam"))
                cbSex.setSelectedIndex(0);
            else
                if (str.equals("Nữ"))
                    cbSex.setSelectedIndex(1);
            else
                if (str.equals("Khác"))
                    cbSex.setSelectedIndex(2);
            tfUserName.setText(res.getString(7));
            tfAddress.disable();
            tfBirthDay.disable();
            tfCMND.disable();
            tfEmail.disable();
            tfFName.disable();
            tfPhoneNum.disable();
            tfUserName.disable();
            cbSex.disable();
        } catch (SQLException e) {
            Logger.getLogger(SupportFunctions.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    public void changeBackPanel(int inpState){
        switch (inpState){
            case 2:
                pnReaderSearch.hide();
                pnReaderInfo.hide();
                pnReaderHistory.show();
                break;
            case 1:
                pnReaderHistory.hide();
                pnReaderInfo.hide();
                pnReaderSearch.show();
                break;
            case 3:
                pnReaderHistory.hide();
                pnReaderSearch.hide();
                pnReaderInfo.show();
                showReaderInfor();
                break;
            default:
                break;
        }
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
        pnReaderSearch = new javax.swing.JPanel();
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
        lbResImg7 = new javax.swing.JLabel();
        lbResTxt2 = new javax.swing.JLabel();
        lbResImg6 = new javax.swing.JLabel();
        lbResImg8 = new javax.swing.JLabel();
        lbResImg9 = new javax.swing.JLabel();
        lbResImg10 = new javax.swing.JLabel();
        lbResTxt1 = new javax.swing.JLabel();
        lbResTxt4 = new javax.swing.JLabel();
        lbResTxt5 = new javax.swing.JLabel();
        lbResTxt3 = new javax.swing.JLabel();
        lbResTxt6 = new javax.swing.JLabel();
        lbResTxt7 = new javax.swing.JLabel();
        lbResTxt8 = new javax.swing.JLabel();
        lbResTxt9 = new javax.swing.JLabel();
        lbResTxt10 = new javax.swing.JLabel();
        lbResImg1 = new javax.swing.JLabel();
        lbResImg2 = new javax.swing.JLabel();
        lbResImg3 = new javax.swing.JLabel();
        lbResImg4 = new javax.swing.JLabel();
        lbResImg5 = new javax.swing.JLabel();
        lbResInfo = new javax.swing.JLabel();
        lbPrevious = new javax.swing.JLabel();
        lbNext = new javax.swing.JLabel();
        lbCurrent = new javax.swing.JLabel();
        pnReaderHistory = new javax.swing.JPanel();
        pnReaderHistoryInfo = new javax.swing.JPanel();
        lbHInfo1 = new javax.swing.JLabel();
        lbHInfo3 = new javax.swing.JLabel();
        lbHInfo2 = new javax.swing.JLabel();
        lbHInfo4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnReaderInfo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbReaderInfo = new javax.swing.JLabel();
        pnAvatar = new javax.swing.JPanel();
        lbAvatar = new javax.swing.JLabel();
        lbBrowser = new javax.swing.JLabel();
        pnShowInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfFName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfBirthDay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfCMND = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfPhoneNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        cbSex = new javax.swing.JComboBox<>();
        pnRI1 = new javax.swing.JPanel();
        btChangePW = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        pnRI2 = new javax.swing.JPanel();
        btUpdate1 = new javax.swing.JButton();
        pnChangePass = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfUserName1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfCurPass = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfNewPass = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfTestNewPass = new javax.swing.JTextField();
        pnRI3 = new javax.swing.JPanel();
        btChangePW1 = new javax.swing.JButton();
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHome1MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHistory1MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserInfor1MouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSearch1MouseClicked(evt);
            }
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
                .addContainerGap(377, Short.MAX_VALUE))
        );

        pnMain.add(pnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 550));

        pnReaderSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnReaderSearch.setPreferredSize(new java.awt.Dimension(820, 480));

        pbMainSearch.setBackground(new java.awt.Color(38, 40, 55));
        pbMainSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSearch100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Search_32px_1.png"))); // NOI18N
        pbMainSearch.add(lbSearch100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 37));

        tfSearch.setBackground(new java.awt.Color(38, 40, 55));
        tfSearch.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tfSearch.setForeground(new java.awt.Color(255, 255, 255));
        tfSearch.setBorder(null);
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });
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
        cbName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNameMouseClicked(evt);
            }
        });
        cbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNameActionPerformed(evt);
            }
        });
        pbMainSearch.add(cbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 7, -1, -1));

        cbAuthor.setBackground(new java.awt.Color(38, 40, 55));
        cbAuthor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbAuthor.setForeground(new java.awt.Color(255, 255, 255));
        cbAuthor.setText("Tác Giả");
        cbAuthor.setAlignmentY(0.0F);
        cbAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbAuthorMouseClicked(evt);
            }
        });
        cbAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAuthorActionPerformed(evt);
            }
        });
        pbMainSearch.add(cbAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 7, -1, -1));

        cbGenre.setBackground(new java.awt.Color(38, 40, 55));
        cbGenre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbGenre.setForeground(new java.awt.Color(255, 255, 255));
        cbGenre.setText("Thể Loại");
        cbGenre.setAlignmentY(0.0F);
        cbGenre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbGenreMouseClicked(evt);
            }
        });
        pbMainSearch.add(cbGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 7, -1, -1));

        cbPublisher.setBackground(new java.awt.Color(38, 40, 55));
        cbPublisher.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbPublisher.setForeground(new java.awt.Color(255, 255, 255));
        cbPublisher.setText("Nhà Xuất Bản");
        cbPublisher.setAlignmentY(0.0F);
        cbPublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPublisherMouseClicked(evt);
            }
        });
        pbMainSearch.add(cbPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 7, -1, -1));

        cbID.setBackground(new java.awt.Color(38, 40, 55));
        cbID.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbID.setForeground(new java.awt.Color(255, 255, 255));
        cbID.setText("Nhà Xuất Bản");
        cbID.setAlignmentY(0.0F);
        cbID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbIDMouseClicked(evt);
            }
        });
        pbMainSearch.add(cbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 7, -1, -1));

        cbISBN.setBackground(new java.awt.Color(38, 40, 55));
        cbISBN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cbISBN.setForeground(new java.awt.Color(255, 255, 255));
        cbISBN.setAlignmentY(0.0F);
        cbISBN.setLabel("SKU");
        cbISBN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbISBNMouseClicked(evt);
            }
        });
        pbMainSearch.add(cbISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 70, 35));

        lbResImg7.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg6.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg8.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg9.setBackground(new java.awt.Color(100, 240, 150));
        lbResImg9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbResImg10.setBackground(new java.awt.Color(100, 240, 150));
        lbResImg10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbResImg1.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg2.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg3.setBackground(new java.awt.Color(100, 240, 150));

        lbResImg4.setBackground(new java.awt.Color(100, 240, 150));
        lbResImg4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbResImg5.setBackground(new java.awt.Color(100, 240, 150));
        lbResImg5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbResInfo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbResInfo.setForeground(new java.awt.Color(0, 0, 102));
        lbResInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbResInfo.setText("Có tất cả ... kết quả");

        lbPrevious.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbPrevious.setForeground(new java.awt.Color(0, 0, 102));
        lbPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrevious.setText("Previous");

        lbNext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNext.setForeground(new java.awt.Color(0, 0, 102));
        lbNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNext.setText("Next");

        lbCurrent.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbCurrent.setText("Trang hiện tại: ");

        javax.swing.GroupLayout pnReaderSearchLayout = new javax.swing.GroupLayout(pnReaderSearch);
        pnReaderSearch.setLayout(pnReaderSearchLayout);
        pnReaderSearchLayout.setHorizontalGroup(
            pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderSearchLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnReaderSearchLayout.createSequentialGroup()
                        .addComponent(lbResTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbResTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbResTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lbResTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbResTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnReaderSearchLayout.createSequentialGroup()
                        .addComponent(lbResInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(lbCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(pnReaderSearchLayout.createSequentialGroup()
                        .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbResImg6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnReaderSearchLayout.createSequentialGroup()
                                .addComponent(lbResImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lbResImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnReaderSearchLayout.createSequentialGroup()
                                    .addComponent(lbResTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(lbResTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnReaderSearchLayout.createSequentialGroup()
                                    .addComponent(lbResImg7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(lbResImg8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbResImg9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbResImg10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResTxt5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbResImg5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
            .addComponent(pbMainSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnReaderSearchLayout.setVerticalGroup(
            pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderSearchLayout.createSequentialGroup()
                .addComponent(pbMainSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbResTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResImg7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResImg10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbResTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        lbResImg7.getAccessibleContext().setAccessibleName("lbResImg7");
        lbResTxt2.getAccessibleContext().setAccessibleName("lbResTxt2");
        lbResImg6.getAccessibleContext().setAccessibleName("lbResImg6");
        lbResImg8.getAccessibleContext().setAccessibleName("lbResImg8");
        lbResImg9.getAccessibleContext().setAccessibleName("lbResImg9");
        lbResImg10.getAccessibleContext().setAccessibleName("lbResImg10");
        lbResTxt1.getAccessibleContext().setAccessibleName("lbResTxt1");
        lbResTxt4.getAccessibleContext().setAccessibleName("lbResTxt4");
        lbResTxt5.getAccessibleContext().setAccessibleName("lbResTxt5");
        lbResTxt3.getAccessibleContext().setAccessibleName("lbResTxt3");
        lbResTxt6.getAccessibleContext().setAccessibleName("lbResTxt6");
        lbResTxt7.getAccessibleContext().setAccessibleName("lbResTxt7");
        lbResTxt8.getAccessibleContext().setAccessibleName("lbResTxt8");
        lbResTxt9.getAccessibleContext().setAccessibleName("lbResTxt9");
        lbResTxt10.getAccessibleContext().setAccessibleName("lbResTxt10");
        lbResImg1.getAccessibleContext().setAccessibleName("lbResImg1");
        lbResImg1.getAccessibleContext().setAccessibleDescription("lbResImg1");
        lbResImg2.getAccessibleContext().setAccessibleName("lbResImg2");
        lbResImg3.getAccessibleContext().setAccessibleName("lbResImg3");
        lbResImg4.getAccessibleContext().setAccessibleName("lbResImg4");
        lbResImg5.getAccessibleContext().setAccessibleName("lbResImg5");

        pnMain.add(pnReaderSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, 580));
        pnReaderSearch.getAccessibleContext().setAccessibleName("pnSearch");

        pnReaderHistory.setBackground(new java.awt.Color(255, 255, 255));
        pnReaderHistory.setPreferredSize(new java.awt.Dimension(820, 480));

        pnReaderHistoryInfo.setBackground(new java.awt.Color(255, 255, 255));

        lbHInfo1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHInfo1.setText("Bạn đã mượn ... cuốn sách");

        lbHInfo3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHInfo3.setText("Hiện đang có ... cuốn chưa trả");

        lbHInfo2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHInfo2.setForeground(new java.awt.Color(0, 0, 102));
        lbHInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHInfo2.setText("Xem các sách đã mượn");
        lbHInfo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbHInfo4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHInfo4.setForeground(new java.awt.Color(0, 0, 102));
        lbHInfo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHInfo4.setText("Xem các sách chưa trả");
        lbHInfo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnReaderHistoryInfoLayout = new javax.swing.GroupLayout(pnReaderHistoryInfo);
        pnReaderHistoryInfo.setLayout(pnReaderHistoryInfoLayout);
        pnReaderHistoryInfoLayout.setHorizontalGroup(
            pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderHistoryInfoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHInfo3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lbHInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHInfo2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lbHInfo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        pnReaderHistoryInfoLayout.setVerticalGroup(
            pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderHistoryInfoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderHistoryInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHInfo4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên sách", "Mã sách", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnReaderHistoryLayout = new javax.swing.GroupLayout(pnReaderHistory);
        pnReaderHistory.setLayout(pnReaderHistoryLayout);
        pnReaderHistoryLayout.setHorizontalGroup(
            pnReaderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnReaderHistoryInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnReaderHistoryLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnReaderHistoryLayout.setVerticalGroup(
            pnReaderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderHistoryLayout.createSequentialGroup()
                .addComponent(pnReaderHistoryInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnMain.add(pnReaderHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, 580));

        pnReaderInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnReaderInfo.setPreferredSize(new java.awt.Dimension(820, 480));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Thông tin tài khoản");

        lbReaderInfo.setBackground(new java.awt.Color(255, 255, 255));
        lbReaderInfo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbReaderInfo.setForeground(new java.awt.Color(255, 255, 255));
        lbReaderInfo.setText("Khách hàng: Văn Minh Hào");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(313, 313, 313))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(lbReaderInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbReaderInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnAvatar.setBackground(new java.awt.Color(255, 255, 255));
        pnAvatar.setInheritsPopupMenu(true);
        pnAvatar.setMaximumSize(new java.awt.Dimension(117, 163));

        lbAvatar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbBrowser.setBackground(new java.awt.Color(255, 255, 255));
        lbBrowser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbBrowser.setForeground(new java.awt.Color(102, 102, 102));
        lbBrowser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBrowser.setText("Browser ...");
        lbBrowser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbBrowser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBrowserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnAvatarLayout = new javax.swing.GroupLayout(pnAvatar);
        pnAvatar.setLayout(pnAvatarLayout);
        pnAvatarLayout.setHorizontalGroup(
            pnAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAvatarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBrowser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnAvatarLayout.setVerticalGroup(
            pnAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAvatarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrowser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnShowInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Tên đăng nhập:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Giới tính:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("CMND:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Số điện thoại:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Email:");

        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        pnRI1.setBackground(new java.awt.Color(255, 255, 255));

        btChangePW.setBackground(new java.awt.Color(0, 204, 255));
        btChangePW.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btChangePW.setText("Đổi mật khẩu");
        btChangePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChangePWMouseClicked(evt);
            }
        });
        btChangePW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePWActionPerformed(evt);
            }
        });

        btUpdate.setBackground(new java.awt.Color(0, 204, 255));
        btUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btUpdate.setText("Cập nhật thông tin");
        btUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnRI1Layout = new javax.swing.GroupLayout(pnRI1);
        pnRI1.setLayout(pnRI1Layout);
        pnRI1Layout.setHorizontalGroup(
            pnRI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRI1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btChangePW)
                .addGap(18, 18, 18)
                .addComponent(btUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRI1Layout.setVerticalGroup(
            pnRI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRI1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnRI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btChangePW)
                    .addComponent(btUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnRI2.setBackground(new java.awt.Color(255, 255, 255));

        btUpdate1.setBackground(new java.awt.Color(0, 204, 255));
        btUpdate1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btUpdate1.setText("Cập nhật thông tin");
        btUpdate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUpdate1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnRI2Layout = new javax.swing.GroupLayout(pnRI2);
        pnRI2.setLayout(pnRI2Layout);
        pnRI2Layout.setHorizontalGroup(
            pnRI2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRI2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btUpdate1)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnRI2Layout.setVerticalGroup(
            pnRI2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRI2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btUpdate1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnShowInfoLayout = new javax.swing.GroupLayout(pnShowInfo);
        pnShowInfo.setLayout(pnShowInfoLayout);
        pnShowInfoLayout.setHorizontalGroup(
            pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFName, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPhoneNum, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(pnShowInfoLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(pnShowInfoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnRI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnShowInfoLayout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(pnRI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
        );
        pnShowInfoLayout.setVerticalGroup(
            pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnShowInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSex, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnRI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnShowInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnShowInfoLayout.createSequentialGroup()
                    .addContainerGap(412, Short.MAX_VALUE)
                    .addComponent(pnRI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)))
        );

        pnChangePass.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Tên đăng nhập:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Mật khẩu hiện tại:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Mật khẩu mới:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Nhập lại mật khẩu mới:");

        pnRI3.setBackground(new java.awt.Color(255, 255, 255));

        btChangePW1.setBackground(new java.awt.Color(0, 204, 255));
        btChangePW1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btChangePW1.setText("Đổi mật khẩu");
        btChangePW1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChangePW1MouseClicked(evt);
            }
        });
        btChangePW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePW1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRI3Layout = new javax.swing.GroupLayout(pnRI3);
        pnRI3.setLayout(pnRI3Layout);
        pnRI3Layout.setHorizontalGroup(
            pnRI3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRI3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btChangePW1)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        pnRI3Layout.setVerticalGroup(
            pnRI3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRI3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btChangePW1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnChangePassLayout = new javax.swing.GroupLayout(pnChangePass);
        pnChangePass.setLayout(pnChangePassLayout);
        pnChangePassLayout.setHorizontalGroup(
            pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangePassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUserName1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(tfCurPass, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(tfNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(tfTestNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(pnChangePassLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(pnRI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnChangePassLayout.setVerticalGroup(
            pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangePassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCurPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTestNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(pnRI3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout pnReaderInfoLayout = new javax.swing.GroupLayout(pnReaderInfo);
        pnReaderInfo.setLayout(pnReaderInfoLayout);
        pnReaderInfoLayout.setHorizontalGroup(
            pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReaderInfoLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(pnAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(pnShowInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 170, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderInfoLayout.createSequentialGroup()
                    .addContainerGap(230, Short.MAX_VALUE)
                    .addComponent(pnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(170, 170, 170)))
        );
        pnReaderInfoLayout.setVerticalGroup(
            pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnReaderInfoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnReaderInfoLayout.createSequentialGroup()
                        .addComponent(pnAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnReaderInfoLayout.createSequentialGroup()
                        .addComponent(pnShowInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderInfoLayout.createSequentialGroup()
                    .addContainerGap(128, Short.MAX_VALUE)
                    .addComponent(pnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );

        pnMain.add(pnReaderInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, 580));

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

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
        res = DatabaseQuery.SearchBookByKeyWord(tfSearch.getText());
        resultNum = SupportFunctions.GetSize(res);
        lbResInfo.setText("Có tất cả " + String.valueOf(resultNum) + " kết quả:");
    }//GEN-LAST:event_tfSearchActionPerformed

    private void lbSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearch1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(1);
    }//GEN-LAST:event_lbSearch1MouseClicked

    private void lbHistory1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHistory1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(2);
    }//GEN-LAST:event_lbHistory1MouseClicked

    private void cbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNameActionPerformed

    private void cbNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNameMouseClicked

    private void cbAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAuthorActionPerformed

    private void cbAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbAuthorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAuthorMouseClicked

    private void cbGenreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbGenreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenreMouseClicked

    private void cbPublisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPublisherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPublisherMouseClicked

    private void cbIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIDMouseClicked

    private void cbISBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbISBNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbISBNMouseClicked

    private void lbUserInfor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfor1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(3);
    }//GEN-LAST:event_lbUserInfor1MouseClicked

    private void lbHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHome1MouseClicked
        // TODO add your handling code here:
        dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_lbHome1MouseClicked

    private void lbBrowserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBrowserMouseClicked
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Image file", "jpeg", "jpg", "png", "gif");
        file.setFileFilter(filter);
        file.setMultiSelectionEnabled(false);
        
        int action = file.showOpenDialog(this);
        if (action == JFileChooser.APPROVE_OPTION){
            File imgFile = file.getSelectedFile();
            ImageIcon imgIcon = new ImageIcon(imgFile.getAbsolutePath());
            lbAvatar.setIcon(imgIcon);
        }
    }//GEN-LAST:event_lbBrowserMouseClicked

    private void btUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdateMouseClicked
        // TODO add your handling code here:
        tfAddress.enable();
        tfBirthDay.enable();
        tfCMND.enable();
        tfEmail.enable();
        tfFName.enable();
        tfPhoneNum.enable();
        cbSex.enable();
        pnRI1.hide();
        pnRI2.show();
    }//GEN-LAST:event_btUpdateMouseClicked

    private void btChangePWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangePWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btChangePWActionPerformed

    private void btUpdate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUpdate1MouseClicked
        // TODO add your handling code here:        
        //Querry code here
        
        if (tfFName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống");
        }
        else if (!ValidatingClass.isEmailValid(tfEmail.getText())){
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng");
        }
        else if (!ValidatingClass.isDateValid(tfBirthDay.getText())){
            JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
        }
        else if ((ValidatingClass.isCMNDExisting(tfCMND.getText(), "doc_gia")) && (!tfCMND.getText().equals(CMND))) {
            JOptionPane.showMessageDialog(null, "CMND bị trùng, vui lòng nhập lại!");
        } else {
            try {
                People user = new People(ID, tfFName.getText(),tfAddress.getText(),tfBirthDay.getText(),
                        tfEmail.getText(),tfUserName.getText(),res.getString("Pass"),cbSex.getSelectedItem().toString(),tfCMND.getText(),tfPhoneNum.getText());
                DatabaseQuery.UpdateUser(user, "doc_gia");
                pnChangePass.hide();
                pnRI2.hide();
                pnRI3.hide();
                tfAddress.disable();
                tfBirthDay.disable();
                tfCMND.disable();
                tfEmail.disable();
                tfFName.disable();
                tfPhoneNum.disable();
                tfUserName.disable();
                cbSex.disable();
                pnShowInfo.show();
                pnRI1.show();
            } catch (Exception e) {
               Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        
        
        
        
    }//GEN-LAST:event_btUpdate1MouseClicked

    private void btChangePWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChangePWMouseClicked
        // TODO add your handling code here:
        pnShowInfo.hide();
        pnChangePass.show();
        pnRI1.hide();
        pnRI2.hide();
        pnAvatar.hide();
        tfUserName1.setText(tfUserName.getText());
        tfUserName1.disable();
        pnRI3.show();
    }//GEN-LAST:event_btChangePWMouseClicked

    private void btChangePW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangePW1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btChangePW1ActionPerformed

    private void btChangePW1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChangePW1MouseClicked
        // TODO add your handling code here:
        
        //Querry code here
        
        if (!tfCurPass.getText().equals(Pass))
            JOptionPane.showMessageDialog(null, "Nhập sai Password hiện tại!!!");
        else
        if (!tfNewPass.getText().equals(tfTestNewPass.getText()))
            JOptionPane.showMessageDialog(null, "Password mới không trùng khớp!!!");
        else
        {
            try {
                DatabaseQuery.UpdateUserPassword(ID, tfNewPass.getText(), "doc_gia");
                pnChangePass.hide();
                pnRI2.hide();
                pnRI3.hide();
                pnShowInfo.show();
                pnAvatar.show();
                pnRI1.show();
            } catch (Exception e) {
                Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
    }//GEN-LAST:event_btChangePW1MouseClicked

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
    private javax.swing.JButton btChangePW;
    private javax.swing.JButton btChangePW1;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdate1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAuthor;
    private javax.swing.JCheckBox cbGenre;
    private javax.swing.JCheckBox cbID;
    private javax.swing.JCheckBox cbISBN;
    private javax.swing.JCheckBox cbName;
    private javax.swing.JCheckBox cbPublisher;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbBrowser;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbCurrent;
    private javax.swing.JLabel lbHInfo1;
    private javax.swing.JLabel lbHInfo2;
    private javax.swing.JLabel lbHInfo3;
    private javax.swing.JLabel lbHInfo4;
    private javax.swing.JLabel lbHistory;
    private javax.swing.JLabel lbHistory1;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbHome1;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbMinimize1;
    private javax.swing.JLabel lbNext;
    private javax.swing.JLabel lbPrevious;
    private javax.swing.JLabel lbReaderInfo;
    private javax.swing.JLabel lbResImg1;
    private javax.swing.JLabel lbResImg10;
    private javax.swing.JLabel lbResImg2;
    private javax.swing.JLabel lbResImg3;
    private javax.swing.JLabel lbResImg4;
    private javax.swing.JLabel lbResImg5;
    private javax.swing.JLabel lbResImg6;
    private javax.swing.JLabel lbResImg7;
    private javax.swing.JLabel lbResImg8;
    private javax.swing.JLabel lbResImg9;
    private javax.swing.JLabel lbResInfo;
    private javax.swing.JLabel lbResTxt1;
    private javax.swing.JLabel lbResTxt10;
    private javax.swing.JLabel lbResTxt2;
    private javax.swing.JLabel lbResTxt3;
    private javax.swing.JLabel lbResTxt4;
    private javax.swing.JLabel lbResTxt5;
    private javax.swing.JLabel lbResTxt6;
    private javax.swing.JLabel lbResTxt7;
    private javax.swing.JLabel lbResTxt8;
    private javax.swing.JLabel lbResTxt9;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbSearch1;
    private javax.swing.JLabel lbSearch100;
    private javax.swing.JLabel lbUserInfor;
    private javax.swing.JLabel lbUserInfor1;
    private javax.swing.JPanel pbMainSearch;
    private javax.swing.JPanel pnAvatar;
    private javax.swing.JPanel pnChangePass;
    private javax.swing.JPanel pnHistory;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnRI1;
    private javax.swing.JPanel pnRI2;
    private javax.swing.JPanel pnRI3;
    private javax.swing.JPanel pnReaderHistory;
    private javax.swing.JPanel pnReaderHistoryInfo;
    private javax.swing.JPanel pnReaderInfo;
    private javax.swing.JPanel pnReaderSearch;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnShowInfo;
    private javax.swing.JPanel pnUser;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfBirthDay;
    private javax.swing.JTextField tfCMND;
    private javax.swing.JTextField tfCurPass;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFName;
    private javax.swing.JTextField tfNewPass;
    private javax.swing.JTextField tfPhoneNum;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTestNewPass;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JTextField tfUserName1;
    // End of variables declaration//GEN-END:variables
}
