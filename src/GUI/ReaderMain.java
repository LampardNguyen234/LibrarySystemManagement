package GUI;

import GUI.Admin;
import GUI.HomePage;
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
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import main.Book;
import main.DatabaseQuery;
import main.People;
import main.SupportFunctions;
import main.ValidatingClass;

/**
 *
 * @author lampard
 */
public class ReaderMain extends javax.swing.JFrame {
    public static People user;
    //ResultSet resUser;
    boolean key;
    ResultSet res;
    String Pass;
    String userName;
    int currentPage = 1;
    int maxPage = 1;
    int quantityPerPage = 10;
    int resultNum = 0;
<<<<<<< HEAD
    int state = 1;
=======
>>>>>>> 2ba989448add1c8f30bad2faa43b2d0673acd2ce
    int panel =1;
    
    ArrayList<JLabel> resultName = new ArrayList<>();
    ArrayList<JLabel> resultImage = new ArrayList<>();
    ArrayList<JPanel> resultPanel = new ArrayList<>();
    /**
     * Creates new form mainGUI
     */
    public ReaderMain(People user) {
        this.setResizable(false);
        initComponents();
        this.setShape(new RoundRectangle2D.Float(0, 0, 1000, 600, 45, 45));
        this.setSize(1000, 600);
        changeBackPanel(1);
<<<<<<< HEAD
        this.userName = "Nguyễn Văn Thành";
        lbUserName.setText("Khách hàng: "+userName);
=======
>>>>>>> 2ba989448add1c8f30bad2faa43b2d0673acd2ce
        
        this.user = user; 
        
        resultName.add(ResultName1);
        resultName.add(ResultName2);
        resultName.add(ResultName3);
        resultName.add(ResultName4);
        resultName.add(ResultName5);
        resultName.add(ResultName6);
        resultName.add(ResultName7);
        resultName.add(ResultName8);
        resultName.add(ResultName9);
        resultName.add(ResultName10);
        resultImage.add(ResultImage1);
        resultImage.add(ResultImage2);
        resultImage.add(ResultImage3);
        resultImage.add(ResultImage4);
        resultImage.add(ResultImage5);
        resultImage.add(ResultImage6);
        resultImage.add(ResultImage7);
        resultImage.add(ResultImage8);
        resultImage.add(ResultImage9);
        resultImage.add(ResultImage10);
        resultPanel.add(Result1);
        resultPanel.add(Result2);
        resultPanel.add(Result3);
        resultPanel.add(Result4);
        resultPanel.add(Result5);
        resultPanel.add(Result6);
        resultPanel.add(Result7);
        resultPanel.add(Result8);
        resultPanel.add(Result9);
        resultPanel.add(Result10);
        pnShowResult.hide();
        res = DatabaseQuery.GetAllBook();
        resultNum = SupportFunctions.GetSize(res);
        lbResultNum.setText("Có " + String.valueOf(resultNum)+" kết quả.");
        lbCurrentPage.setText("Trang hiện tại: "+ String.valueOf(currentPage));
        maxPage = SupportFunctions.getMaxPage(resultNum, quantityPerPage);
        res = SupportFunctions.Display(resultImage, resultName, res, currentPage);
        int total = SupportFunctions.GetSize(DatabaseQuery.History(user.getID()));
        int unret  = SupportFunctions.GetSize(DatabaseQuery.History(user.getID(), "0"));
        lbName.setText(user.getFullName());
        lbHInfo1.setText("Bạn đã mượn "+ String.valueOf(total)+" cuốn sách." );
        lbHInfo3.setText("Hiện đang có "+ String.valueOf(unret)+" cuốn sách chưa trả." );
    }
    
    public void showReaderInfor(){
        pnRI2.hide();
        pnRI3.hide();
        pnChangePass.hide();
        pnAvatar.show();
        pnShowInfo.show();
        pnRI1.show();
        lbReaderInfo.setText("Người dùng: " + user.getFullName());
        try {
            res.next();
            tfAddress.setText(user.getAddress());
            tfBirthDay.setText(user.getAddress());
            tfCMND.setText(user.getCMND());
            tfEmail.setText(user.getEmail());
            tfFName.setText(user.getFullName());
            tfPhoneNum.setText(user.getPhoneNumber());
            String str = user.getSex();
            if (str.equals("Nam"))
                cbSex.setSelectedIndex(0);
            else
                if (str.equals("Nữ"))
                    cbSex.setSelectedIndex(1);
            else
                if (str.equals("Khác"))
                    cbSex.setSelectedIndex(2);
            tfUserName.setText(user.getUserName());
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
    
<<<<<<< HEAD
    public void addDataToTable(ResultSet inpSet) {
        DefaultTableModel model = (DefaultTableModel) tbHistory.getModel();
        try {
            while (inpSet.next()){
                model.addRow(new Object[]{inpSet.getString("IDSach"),inpSet.getString("NgayMuon"),inpSet.getString("NgayTra"),inpSet.getString("NgayTraDuKien")});
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
=======
>>>>>>> 2ba989448add1c8f30bad2faa43b2d0673acd2ce
    public void changeBackPanel(int inpState){
        panel = inpState;
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

    public static String check(boolean key){
        if (key) {
            key = false;
            return "";
        }
        return " or";
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
        lbName = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        iconOnline = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pnHistory = new javax.swing.JPanel();
        lbHistory = new javax.swing.JLabel();
        lbHistory1 = new javax.swing.JLabel();
        pnUser = new javax.swing.JPanel();
        lbUserInfor = new javax.swing.JLabel();
        lbUserInfor1 = new javax.swing.JLabel();
        pnSearch = new javax.swing.JPanel();
        lbSearch = new javax.swing.JLabel();
        lbSearch1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pnReaderSearch = new javax.swing.JPanel();
        pbMainSearch = new javax.swing.JPanel();
        lbSearch100 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cbName = new javax.swing.JCheckBox();
        cbAuthor = new javax.swing.JCheckBox();
        cbGenre = new javax.swing.JCheckBox();
        cbPublisher = new javax.swing.JCheckBox();
        cbISBN = new javax.swing.JCheckBox();
        main = new javax.swing.JPanel();
        Result1 = new javax.swing.JPanel();
        ResultImage1 = new javax.swing.JLabel();
        Result6 = new javax.swing.JPanel();
        ResultImage6 = new javax.swing.JLabel();
        ResultName1 = new javax.swing.JLabel();
        Result2 = new javax.swing.JPanel();
        ResultImage2 = new javax.swing.JLabel();
        Result3 = new javax.swing.JPanel();
        ResultImage3 = new javax.swing.JLabel();
        Result4 = new javax.swing.JPanel();
        ResultImage4 = new javax.swing.JLabel();
        Result5 = new javax.swing.JPanel();
        ResultImage5 = new javax.swing.JLabel();
        Result7 = new javax.swing.JPanel();
        ResultImage7 = new javax.swing.JLabel();
        Result8 = new javax.swing.JPanel();
        ResultImage8 = new javax.swing.JLabel();
        Result9 = new javax.swing.JPanel();
        ResultImage9 = new javax.swing.JLabel();
        Result10 = new javax.swing.JPanel();
        ResultImage10 = new javax.swing.JLabel();
        ResultName2 = new javax.swing.JLabel();
        ResultName3 = new javax.swing.JLabel();
        ResultName4 = new javax.swing.JLabel();
        ResultName5 = new javax.swing.JLabel();
        ResultName6 = new javax.swing.JLabel();
        ResultName7 = new javax.swing.JLabel();
        ResultName8 = new javax.swing.JLabel();
        ResultName9 = new javax.swing.JLabel();
        ResultName10 = new javax.swing.JLabel();
        pnNext = new javax.swing.JPanel();
        lbNext = new javax.swing.JLabel();
        pnPrevious = new javax.swing.JPanel();
        lbPrevious = new javax.swing.JLabel();
        lbCurrentPage = new javax.swing.JLabel();
        lbResultNum = new javax.swing.JLabel();
        pnShowResult = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbResult = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taResult = new javax.swing.JTextArea();
        pnBack = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnReaderHistory = new javax.swing.JPanel();
        pnReaderHistoryInfo = new javax.swing.JPanel();
        lbHInfo1 = new javax.swing.JLabel();
        lbHInfo3 = new javax.swing.JLabel();
        lbHInfo2 = new javax.swing.JLabel();
        lbHInfo4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnRI3 = new javax.swing.JPanel();
        btChangePW1 = new javax.swing.JButton();
        pfCurPass = new javax.swing.JPasswordField();
        pfNewPass = new javax.swing.JPasswordField();
        pfTestNewPass = new javax.swing.JPasswordField();
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
        pnHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbName.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNameMouseClicked(evt);
            }
        });
        pnHome.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        lbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Logout Rounded_32px_2.png"))); // NOI18N
        lbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
        });
        pnHome.add(lbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        iconOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/online.jpg"))); // NOI18N
        pnHome.add(iconOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 10, 10));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Reader");
        pnHome.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 35, 60, 20));

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
                .addComponent(lbHistory1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lbUserInfor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jSeparator3)
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addComponent(pnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
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
        pbMainSearch.add(cbISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 3, 70, 30));

        main.setBackground(new java.awt.Color(255, 247, 238));
        main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Result1.setBackground(new java.awt.Color(255, 247, 238));
        Result1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage1.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultImage1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result1.add(ResultImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, -1, -1));

        Result6.setBackground(new java.awt.Color(255, 247, 238));
        Result6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage6.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result6.add(ResultImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 223, -1, -1));

        ResultName1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName1.setForeground(new java.awt.Color(0, 51, 204));
        ResultName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName1MouseClicked(evt);
            }
        });
        main.add(ResultName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 187, 130, 30));

        Result2.setBackground(new java.awt.Color(255, 247, 238));
        Result2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage2.setBackground(new java.awt.Color(255, 247, 238));
        ResultImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultImage2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result2.add(ResultImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 170));

        main.add(Result2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 11, -1, -1));

        Result3.setBackground(new java.awt.Color(255, 247, 238));
        Result3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage3.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultImage3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result3.add(ResultImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result3, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 11, -1, -1));

        Result4.setBackground(new java.awt.Color(255, 247, 238));
        Result4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage4.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result4.add(ResultImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 11, -1, -1));

        Result5.setBackground(new java.awt.Color(255, 247, 238));
        Result5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage5.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result5.add(ResultImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result5, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 11, -1, -1));

        Result7.setBackground(new java.awt.Color(255, 247, 238));
        Result7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage7.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result7.add(ResultImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result7, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 223, -1, -1));

        Result8.setBackground(new java.awt.Color(255, 247, 238));
        Result8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage8.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result8.add(ResultImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result8, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 223, -1, -1));

        Result9.setBackground(new java.awt.Color(255, 247, 238));
        Result9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage9.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result9.add(ResultImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 223, -1, -1));

        Result10.setBackground(new java.awt.Color(255, 247, 238));
        Result10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ResultImage10.setBackground(new java.awt.Color(255, 204, 204));
        ResultImage10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultImage10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Result10.add(ResultImage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 170));

        main.add(Result10, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 223, -1, -1));

        ResultName2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName2.setForeground(new java.awt.Color(0, 51, 204));
        ResultName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName2MouseClicked(evt);
            }
        });
        main.add(ResultName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 187, 130, 30));

        ResultName3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName3.setForeground(new java.awt.Color(0, 51, 204));
        ResultName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName3MouseClicked(evt);
            }
        });
        main.add(ResultName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 187, 130, 30));

        ResultName4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName4.setForeground(new java.awt.Color(0, 51, 204));
        ResultName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName4MouseClicked(evt);
            }
        });
        main.add(ResultName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 187, 130, 30));

        ResultName5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName5.setForeground(new java.awt.Color(0, 51, 204));
        ResultName5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName5MouseClicked(evt);
            }
        });
        main.add(ResultName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 187, 130, 30));

        ResultName6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName6.setForeground(new java.awt.Color(0, 51, 204));
        ResultName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName6MouseClicked(evt);
            }
        });
        main.add(ResultName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 399, 130, 30));

        ResultName7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName7.setForeground(new java.awt.Color(0, 51, 204));
        ResultName7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName7MouseClicked(evt);
            }
        });
        main.add(ResultName7, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 399, 130, 30));

        ResultName8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName8.setForeground(new java.awt.Color(0, 51, 204));
        ResultName8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName8MouseClicked(evt);
            }
        });
        main.add(ResultName8, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 399, 129, 30));

        ResultName9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName9.setForeground(new java.awt.Color(0, 51, 204));
        ResultName9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName9MouseClicked(evt);
            }
        });
        main.add(ResultName9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 399, 130, 30));

        ResultName10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ResultName10.setForeground(new java.awt.Color(0, 51, 204));
        ResultName10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ResultName10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultName10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultName10MouseClicked(evt);
            }
        });
        main.add(ResultName10, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 399, 130, 30));

        pnNext.setBackground(new java.awt.Color(38, 40, 55));

        lbNext.setBackground(new java.awt.Color(255, 255, 255));
        lbNext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbNext.setForeground(new java.awt.Color(255, 255, 255));
        lbNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNext.setText("Next");
        lbNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbNextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnNextLayout = new javax.swing.GroupLayout(pnNext);
        pnNext.setLayout(pnNextLayout);
        pnNextLayout.setHorizontalGroup(
            pnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNext, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        pnNextLayout.setVerticalGroup(
            pnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        main.add(pnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 435, 70, 20));

        pnPrevious.setBackground(new java.awt.Color(38, 40, 55));

        lbPrevious.setBackground(new java.awt.Color(255, 255, 255));
        lbPrevious.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbPrevious.setForeground(new java.awt.Color(255, 255, 255));
        lbPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrevious.setText("Previous");
        lbPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPreviousMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbPreviousMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbPreviousMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnPreviousLayout = new javax.swing.GroupLayout(pnPrevious);
        pnPrevious.setLayout(pnPreviousLayout);
        pnPreviousLayout.setHorizontalGroup(
            pnPreviousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        pnPreviousLayout.setVerticalGroup(
            pnPreviousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        main.add(pnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 435, 70, 20));

        lbCurrentPage.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbCurrentPage.setText("Trang hiện tại: ");
        main.add(lbCurrentPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 435, 120, 20));

        lbResultNum.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbResultNum.setText("Có: kết quả");
        main.add(lbResultNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 435, 230, 20));

        pnShowResult.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(lbResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 350));

        taResult.setEditable(false);
        taResult.setBackground(new java.awt.Color(38, 40, 55));
        taResult.setColumns(20);
        taResult.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        taResult.setForeground(new java.awt.Color(255, 255, 255));
        taResult.setRows(5);
        taResult.setTabSize(4);
        taResult.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taResult);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 0, 500, 350));

        pnBack.setBackground(new java.awt.Color(38, 40, 55));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Back");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnBackLayout = new javax.swing.GroupLayout(pnBack);
        pnBack.setLayout(pnBackLayout);
        pnBackLayout.setHorizontalGroup(
            pnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnBackLayout.setVerticalGroup(
            pnBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnShowResultLayout = new javax.swing.GroupLayout(pnShowResult);
        pnShowResult.setLayout(pnShowResultLayout);
        pnShowResultLayout.setHorizontalGroup(
            pnShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnShowResultLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnShowResultLayout.setVerticalGroup(
            pnShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnShowResultLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(pnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnReaderSearchLayout = new javax.swing.GroupLayout(pnReaderSearch);
        pnReaderSearch.setLayout(pnReaderSearchLayout);
        pnReaderSearchLayout.setHorizontalGroup(
            pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pbMainSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnReaderSearchLayout.createSequentialGroup()
                    .addComponent(pnShowResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnReaderSearchLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnReaderSearchLayout.setVerticalGroup(
            pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderSearchLayout.createSequentialGroup()
                .addComponent(pbMainSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
            .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderSearchLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnShowResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pnReaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnReaderSearchLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnMain.add(pnReaderSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 830, 580));
        pnReaderSearch.getAccessibleContext().setAccessibleName("pnSearch");

        pnReaderHistory.setBackground(new java.awt.Color(255, 255, 255));
        pnReaderHistory.setPreferredSize(new java.awt.Dimension(820, 480));

        pnReaderHistoryInfo.setBackground(new java.awt.Color(0, 204, 255));

        lbHInfo1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHInfo1.setText("Bạn đã mượn ... cuốn sách");

        lbHInfo3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbHInfo3.setText("Hiện đang có ... cuốn chưa trả");

        lbHInfo2.setBackground(new java.awt.Color(51, 255, 255));
        lbHInfo2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHInfo2.setForeground(new java.awt.Color(0, 0, 102));
        lbHInfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHInfo2.setText("Xem các sách đã trả");
        lbHInfo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbHInfo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHInfo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHInfo2MouseClicked(evt);
            }
        });

        lbHInfo4.setBackground(new java.awt.Color(51, 255, 255));
        lbHInfo4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbHInfo4.setForeground(new java.awt.Color(0, 0, 102));
        lbHInfo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHInfo4.setText("Xem các sách chưa trả");
        lbHInfo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbHInfo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHInfo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHInfo4MouseClicked(evt);
            }
        });

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

        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sách", "Ngày mượn", "Ngày trả", "Ngày trả dự kiến"
            }
        ));
        jScrollPane1.setViewportView(tbHistory);

        javax.swing.GroupLayout pnReaderHistoryLayout = new javax.swing.GroupLayout(pnReaderHistory);
        pnReaderHistory.setLayout(pnReaderHistoryLayout);
        pnReaderHistoryLayout.setHorizontalGroup(
            pnReaderHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnReaderHistoryInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderHistoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
        lbReaderInfo.setText("Người dùng: Văn Minh Hào");

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
                        .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pfNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfNewPassActionPerformed(evt);
            }
        });

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
                    .addComponent(pfCurPass)
                    .addComponent(pfNewPass)
                    .addComponent(pfTestNewPass))
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
                    .addComponent(pfCurPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfTestNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
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
                .addGap(42, 180, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnReaderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnReaderInfoLayout.createSequentialGroup()
                    .addContainerGap(240, Short.MAX_VALUE)
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
                    .addContainerGap(159, Short.MAX_VALUE)
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

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
        String querryString;
        boolean key = true;
        String keyword = "'%" + tfSearch.getText()+"%'";
        querryString = "select * from datalibrary.tua_sach where";
        if (cbISBN.isSelected()) {
            querryString += check(key) + " SKU like " + keyword;
            key = false;
        }
        if (cbAuthor.isSelected()) {
            querryString += check(key)+" Author like " + keyword;
            key = false;
        }
        if (cbName.isSelected()) {
            querryString += check(key)+" BName like " + keyword;
            key = false;
        }
        if (cbGenre.isSelected()) {
            querryString += check(key)+" Gendre like " + keyword;
            key = false;
        }
        if (cbPublisher.isSelected()) {
            querryString += check(key)+" Publisher like " + keyword;
            key = false;
        }
        querryString += " order by SKU";
        System.out.println(querryString);
        if (!key)
        res = DatabaseQuery.SearchBookAdvanced(querryString);
        else res = DatabaseQuery.GetAllBook();
        resultNum = SupportFunctions.GetSize(res);
        lbResultNum.setText("Có tất cả " + String.valueOf(resultNum) + " kết quả:");
        maxPage = SupportFunctions.getMaxPage(resultNum, quantityPerPage);
        res = SupportFunctions.Display(resultImage, resultName, res, currentPage = 1);
        lbCurrentPage.setText("Trang hiện tại: "+ String.valueOf(currentPage));
    }//GEN-LAST:event_tfSearchActionPerformed

    private void lbSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSearch1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(1);
        
    }//GEN-LAST:event_lbSearch1MouseClicked

    private void lbHistory1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHistory1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(2);
        if(panel == 2)
        {
            SupportFunctions.DisplayHistory(DatabaseQuery.History(user.getID()), tbHistory);
        }
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

    private void cbISBNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbISBNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbISBNMouseClicked

    private void lbUserInfor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserInfor1MouseClicked
        // TODO add your handling code here:
        changeBackPanel(3);
    }//GEN-LAST:event_lbUserInfor1MouseClicked

    private void lbNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNameMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbNameMouseClicked

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
        else if ((ValidatingClass.isCMNDExisting(tfCMND.getText(), "doc_gia")) && (!tfCMND.getText().equals(user.getCMND()))) {
            JOptionPane.showMessageDialog(null, "CMND bị trùng, vui lòng nhập lại!");
        } else {
            try {
                user = new People(user.getID(), tfFName.getText(),tfAddress.getText(),tfBirthDay.getText(),
                        tfEmail.getText(),tfUserName.getText(),user.getPassword(),cbSex.getSelectedItem().toString(),tfCMND.getText(),tfPhoneNum.getText());
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

    public void setText(JTextArea taResult, Book book) {
        taResult.setText("\n\n");
        taResult.append("  Tên: \t\t\t\t" + book.getName() + "\n");
        taResult.append("  SKU: \t\t\t\t" + book.getSKU() + "\n");
        taResult.append("  Tác giả: \t\t\t" + book.getAuthor() + "\n");
        taResult.append("  Nhà xuất bản: \t" + book.getPublisher() + "\n");
        taResult.append("  Ngày xuất bản: \t" + book.getPublishedDay() + "\n");
        taResult.append("  Thể loại: \t\t" + book.getGendre() + "\n");
    }

    public void setResult(JTextArea taResult, JLabel lbResult, Book book) {
        setText(taResult, book);
        String URL;
        if (SupportFunctions.checkBookImageExist(book.getSKU())) {
            URL = "Images/Books/" + book.getSKU() + ".jpg";
        } else {
            URL = "Images/NoPhotoAvailable.jpg";
        }
        SupportFunctions.setImageToLabel(lbResult, URL);
    }

    public void setClick(int i) {
        if (!resultName.get(i - 1).getText().equals(null)) {
            main.hide();
            pnShowResult.show();
            setResult(taResult, lbResult, DatabaseQuery.findBookByExactName(resultName.get(i - 1).getText()));
        }
    }
    
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
<<<<<<< HEAD
        // TODO add your handling code here:
        
        //Querry code here
        
        if (!pfCurPass.getText().equals(user.getPassword()))
            JOptionPane.showMessageDialog(null, "Nhập sai Password hiện tại!!!");
        else
        if (!pfNewPass.getText().equals(pfTestNewPass.getText()))
            JOptionPane.showMessageDialog(null, "Password mới không trùng khớp!!!");
        else
        {
            try {
                DatabaseQuery.UpdateUserPassword(user.getID(), pfNewPass.getText(), "doc_gia");
                pnChangePass.hide();
                pnRI2.hide();
                pnRI3.hide();
                pnShowInfo.show();
                pnRI1.show();
            } catch (Exception e) {
                Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "Có lỗi trong việc cập nhật CSDL, vui lòng thử lại!!!");
            }
        }
=======
>>>>>>> 2ba989448add1c8f30bad2faa43b2d0673acd2ce
        try {
            // TODO add your handling code here:
            
            //Querry code here
            
            if (!SupportFunctions.Hash256(pfCurPass.getText()).equals(user.getPassword()))
                JOptionPane.showMessageDialog(null, "Nhập sai Password hiện tại!!!");
            else
                if (!SupportFunctions.Hash256(pfNewPass.getText()).equals(SupportFunctions.Hash256(pfTestNewPass.getText())))
                    JOptionPane.showMessageDialog(null, "Password mới không trùng khớp!!!");
                else
                {
                    try {
                        DatabaseQuery.UpdateUserPassword(user.getID(), SupportFunctions.Hash256(pfNewPass.getText()), "doc_gia");
                        JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công!!!");
                        pnChangePass.hide();
                        pnRI2.hide();
                        pnRI3.hide();
                        pnShowInfo.show();
                        //pnAvatar.show();
                        pnRI1.show();
                    } catch (Exception e) {
                        Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ReaderMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btChangePW1MouseClicked

    private void pfNewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfNewPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfNewPassActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        main.show();
        pnShowResult.hide();
        res = SupportFunctions.Display(resultImage, resultName, res, currentPage);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        pnBack.setBackground(new Color(0, 116, 163));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        pnBack.setBackground(new Color(38, 40, 55));
    }//GEN-LAST:event_jLabel14MouseExited

    private void ResultName1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName1MouseClicked
        // TODO add your handling code here:
        setClick(1);
    }//GEN-LAST:event_ResultName1MouseClicked

    private void ResultName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName2MouseClicked
        // TODO add your handling code here:
        setClick(2);
    }//GEN-LAST:event_ResultName2MouseClicked

    private void ResultName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName3MouseClicked
        // TODO add your handling code here:
        setClick(3);
    }//GEN-LAST:event_ResultName3MouseClicked

    private void ResultName4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName4MouseClicked
        // TODO add your handling code here:
        setClick(4);
    }//GEN-LAST:event_ResultName4MouseClicked

    private void ResultName5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName5MouseClicked
        // TODO add your handling code here:
        setClick(5);
    }//GEN-LAST:event_ResultName5MouseClicked

    private void ResultName6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName6MouseClicked
        // TODO add your handling code here:
        setClick(6);
    }//GEN-LAST:event_ResultName6MouseClicked

    private void ResultName7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName7MouseClicked
        // TODO add your handling code here:
        setClick(7);
    }//GEN-LAST:event_ResultName7MouseClicked

    private void ResultName8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName8MouseClicked
        // TODO add your handling code here:
        setClick(8);
    }//GEN-LAST:event_ResultName8MouseClicked

    private void ResultName9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName9MouseClicked
        // TODO add your handling code here:
        setClick(9);
    }//GEN-LAST:event_ResultName9MouseClicked

    private void ResultName10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultName10MouseClicked
        // TODO add your handling code here:
        setClick(10);
    }//GEN-LAST:event_ResultName10MouseClicked

    private void lbNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseClicked
        // TODO add your handling code here:
        if (currentPage < maxPage) {
            currentPage++;
            lbCurrentPage.setText("Trang hiện tại: "+ String.valueOf(currentPage));
            res = SupportFunctions.Display(resultImage, resultName, res, currentPage);
        }
    }//GEN-LAST:event_lbNextMouseClicked

    private void lbNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseEntered
        // TODO add your handling code here:
        if (currentPage < maxPage) {
            Admin.changeBackPanelEntered(pnNext);
        }
    }//GEN-LAST:event_lbNextMouseEntered

    private void lbNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNextMouseExited
        // TODO add your handling code here:
        Admin.changeBackPanelExited(pnNext);
    }//GEN-LAST:event_lbNextMouseExited

    private void lbPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPreviousMouseClicked
        // TODO add your handling code here:
        if (currentPage > 1) {
            currentPage--;
            lbCurrentPage.setText("Trang hiện tại: "+ String.valueOf(currentPage));
            res = SupportFunctions.Display(resultImage, resultName, res, currentPage);
        }
    }//GEN-LAST:event_lbPreviousMouseClicked

    private void lbPreviousMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPreviousMouseEntered
        // TODO add your handling code here:
        if (currentPage > 1) {
            Admin.changeBackPanelEntered(pnPrevious);
        }
    }//GEN-LAST:event_lbPreviousMouseEntered

    private void lbPreviousMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPreviousMouseExited
        // TODO add your handling code here:
        Admin.changeBackPanelExited(pnPrevious);
    }//GEN-LAST:event_lbPreviousMouseExited

    private void lbHInfo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHInfo2MouseClicked
        // TODO add your handling code here:
        if(panel == 2){
            SupportFunctions.DisplayHistory(DatabaseQuery.History(user.getID(), "1"), tbHistory);
        }
    }//GEN-LAST:event_lbHInfo2MouseClicked

    private void lbHInfo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHInfo4MouseClicked
        // TODO add your handling code here:
        if(panel == 2){
            SupportFunctions.DisplayHistory(DatabaseQuery.History(user.getID(), "0"), tbHistory);
        }
    }//GEN-LAST:event_lbHInfo4MouseClicked

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        // TODO add your handling code here:
        dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_lbLogoutMouseClicked

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
                new ReaderMain(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Result1;
    private javax.swing.JPanel Result10;
    private javax.swing.JPanel Result2;
    private javax.swing.JPanel Result3;
    private javax.swing.JPanel Result4;
    private javax.swing.JPanel Result5;
    private javax.swing.JPanel Result6;
    private javax.swing.JPanel Result7;
    private javax.swing.JPanel Result8;
    private javax.swing.JPanel Result9;
    private javax.swing.JLabel ResultImage1;
    private javax.swing.JLabel ResultImage10;
    private javax.swing.JLabel ResultImage2;
    private javax.swing.JLabel ResultImage3;
    private javax.swing.JLabel ResultImage4;
    private javax.swing.JLabel ResultImage5;
    private javax.swing.JLabel ResultImage6;
    private javax.swing.JLabel ResultImage7;
    private javax.swing.JLabel ResultImage8;
    private javax.swing.JLabel ResultImage9;
    private javax.swing.JLabel ResultName1;
    private javax.swing.JLabel ResultName10;
    private javax.swing.JLabel ResultName2;
    private javax.swing.JLabel ResultName3;
    private javax.swing.JLabel ResultName4;
    private javax.swing.JLabel ResultName5;
    private javax.swing.JLabel ResultName6;
    private javax.swing.JLabel ResultName7;
    private javax.swing.JLabel ResultName8;
    private javax.swing.JLabel ResultName9;
    private javax.swing.JButton btChangePW;
    private javax.swing.JButton btChangePW1;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdate1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAuthor;
    private javax.swing.JCheckBox cbGenre;
    private javax.swing.JCheckBox cbISBN;
    private javax.swing.JCheckBox cbName;
    private javax.swing.JCheckBox cbPublisher;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JLabel iconOnline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
<<<<<<< HEAD
=======
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbBrowser;
>>>>>>> 2ba989448add1c8f30bad2faa43b2d0673acd2ce
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbCurrentPage;
    private javax.swing.JLabel lbHInfo1;
    private javax.swing.JLabel lbHInfo2;
    private javax.swing.JLabel lbHInfo3;
    private javax.swing.JLabel lbHInfo4;
    private javax.swing.JLabel lbHistory;
    private javax.swing.JLabel lbHistory1;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbMinimize1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNext;
    private javax.swing.JLabel lbPrevious;
    private javax.swing.JLabel lbReaderInfo;
    private javax.swing.JLabel lbResult;
    private javax.swing.JLabel lbResultNum;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbSearch1;
    private javax.swing.JLabel lbSearch100;
    private javax.swing.JLabel lbUserInfor;
    private javax.swing.JLabel lbUserInfor1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pbMainSearch;
    private javax.swing.JPasswordField pfCurPass;
    private javax.swing.JPasswordField pfNewPass;
    private javax.swing.JPasswordField pfTestNewPass;
    private javax.swing.JPanel pnAvatar;
    private javax.swing.JPanel pnBack;
    private javax.swing.JPanel pnChangePass;
    private javax.swing.JPanel pnHistory;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnNext;
    private javax.swing.JPanel pnPrevious;
    private javax.swing.JPanel pnRI1;
    private javax.swing.JPanel pnRI2;
    private javax.swing.JPanel pnRI3;
    private javax.swing.JPanel pnReaderHistory;
    private javax.swing.JPanel pnReaderHistoryInfo;
    private javax.swing.JPanel pnReaderInfo;
    private javax.swing.JPanel pnReaderSearch;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnShowInfo;
    private javax.swing.JPanel pnShowResult;
    private javax.swing.JPanel pnUser;
    private javax.swing.JTextArea taResult;
    private javax.swing.JTable tbHistory;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfBirthDay;
    private javax.swing.JTextField tfCMND;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFName;
    private javax.swing.JTextField tfPhoneNum;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JTextField tfUserName1;
    // End of variables declaration//GEN-END:variables
}
