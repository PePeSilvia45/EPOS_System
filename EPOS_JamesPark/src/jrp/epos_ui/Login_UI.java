package jrp.epos_ui;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

import jrp.epos_ui.classes.DragListener;
import static jrp.epos_ui.classes.Login.Login;

/**
 * @author James Park
 */

public class Login_UI extends javax.swing.JFrame {

    
    public Login_UI() {
        initComponents();
        setSize(400, 200);
        this.setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        DragListener drag = new DragListener();
        this.addMouseListener(drag);
        this.addMouseMotionListener(drag);
        this.getRootPane().setDefaultButton(btnLogin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        imgStoreLogo = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlMain.setBackground(new java.awt.Color(255, 200, 163));
        pnlMain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMain.setLayout(null);

        pnlHeader.setBackground(new java.awt.Color(117, 78, 52));
        pnlHeader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlHeader.setLayout(null);

        imgStoreLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgStoreLogo.setText("icon");
        pnlHeader.add(imgStoreLogo);
        imgStoreLogo.setBounds(0, 0, 40, 40);

        btnExit.setBackground(new java.awt.Color(117, 78, 52));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jrp/epos_ui/images/icons/close_icon.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlHeader.add(btnExit);
        btnExit.setBounds(360, 0, 40, 40);

        lblTitle.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Login");
        pnlHeader.add(lblTitle);
        lblTitle.setBounds(110, 0, 220, 40);

        pnlMain.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 400, 40);

        jPanel2.setBackground(new java.awt.Color(195, 142, 106));
        pnlMain.add(jPanel2);
        jPanel2.setBounds(0, 0, 40, 230);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jrp/epos_ui/images/icons/password_icon.png"))); // NOI18N
        pnlMain.add(jLabel2);
        jLabel2.setBounds(70, 110, 40, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jrp/epos_ui/images/icons/user_icon.png.png"))); // NOI18N
        pnlMain.add(jLabel3);
        jLabel3.setBounds(70, 60, 40, 40);

        txtUsername.setBackground(new java.awt.Color(40, 113, 117));
        txtUsername.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        pnlMain.add(txtUsername);
        txtUsername.setBounds(120, 60, 230, 40);

        txtPin.setBackground(new java.awt.Color(40, 113, 117));
        txtPin.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        txtPin.setForeground(new java.awt.Color(255, 255, 255));
        txtPin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        pnlMain.add(txtPin);
        txtPin.setBounds(120, 110, 230, 40);

        btnLogin.setBackground(new java.awt.Color(40, 113, 117));
        btnLogin.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlMain.add(btnLogin);
        btnLogin.setBounds(180, 160, 100, 30);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 400, 200);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//================================MY CODE BELOW=================================

    public void setHeaderLogo() {
        imgStoreLogo.setText(null);
        String filename = "logo.png";

        ImageIcon imageIcon = new javax.swing.ImageIcon(
                "DATA\\images\\icons\\" + filename
        );
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(
                imgStoreLogo.getWidth(),
                imgStoreLogo.getHeight(),
                java.awt.Image.SCALE_SMOOTH
        );
        imgStoreLogo.setIcon(new ImageIcon(newimg));
    }
    public boolean check_id(String id){
        try{
            Integer.parseInt(id);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setHeaderLogo();
    }//GEN-LAST:event_formWindowOpened

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String id = txtUsername.getText();
        String pin = "";
        for (char c : txtPin.getPassword()) {
            pin += c;
        }
        if (check_id(id) && Login(id, pin)) {
            this.dispose();
            new EPOS_GUI().setVisible(true);
        } else {
            new Dialog_OK_UI(
                    this, true, 
                    "Login Failed", 
                    "Login Attempt Failed"
            ).setVisible(true);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

//===============================MY CODE ABOVE==================================
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel imgStoreLogo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
