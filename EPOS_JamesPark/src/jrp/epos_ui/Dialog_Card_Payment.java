package jrp.epos_ui;

import java.awt.Color;

import jrp.epos_ui.classes.Payment;

/**
 * @author James Park
 */

public class Dialog_Card_Payment extends javax.swing.JDialog {

    private String CORRECT_PIN = "1234";
    private java.awt.Frame parent;
    
    public Dialog_Card_Payment(java.awt.Frame parent, boolean modal, double amountDue) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        txtAmountDue.setText("Amount Due: £" + String.format("%.2f", amountDue));
        this.setSize(parent.getSize());
        setLocation(parent.getX(), parent.getY());
        pnlMain.setLocation((this.getWidth()/2)-150, (getHeight()/2)-75);
        setBackground(new Color(0, 0, 0, 50));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        txtEnteredPin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnKeypadOne = new javax.swing.JButton();
        btnKeypadTwo = new javax.swing.JButton();
        btnKeypadThree = new javax.swing.JButton();
        btnKeypadFour = new javax.swing.JButton();
        btnKeypadFive = new javax.swing.JButton();
        btnKeypadSix = new javax.swing.JButton();
        btnKeypadSeven = new javax.swing.JButton();
        btnKeypadEigh = new javax.swing.JButton();
        btnKeypadNine = new javax.swing.JButton();
        btnKeypadEnter = new javax.swing.JButton();
        btnKeypadQty = new javax.swing.JButton();
        btnKeypadClr = new javax.swing.JButton();
        btnKeypadZero = new javax.swing.JButton();
        txtAmountDue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        txtEnteredPin.setBackground(new java.awt.Color(40, 113, 117));
        txtEnteredPin.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        txtEnteredPin.setForeground(new java.awt.Color(255, 255, 255));
        txtEnteredPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnlMain.add(txtEnteredPin);
        txtEnteredPin.setBounds(20, 100, 230, 50);

        jPanel2.setBackground(new java.awt.Color(117, 78, 52));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter Pin");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(60, 0, 140, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jrp/epos_ui/images/icons/card_icon.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 40, 40);

        btnExit.setBackground(new java.awt.Color(117, 78, 52));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jrp/epos_ui/images/icons/close_icon.png"))); // NOI18N
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit);
        btnExit.setBounds(230, 0, 40, 40);

        pnlMain.add(jPanel2);
        jPanel2.setBounds(0, 0, 270, 40);

        btnKeypadOne.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadOne.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadOne.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadOne.setText("1");
        btnKeypadOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadOneActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadOne);
        btnKeypadOne.setBounds(20, 160, 50, 50);

        btnKeypadTwo.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadTwo.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadTwo.setText("2");
        btnKeypadTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadTwoActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadTwo);
        btnKeypadTwo.setBounds(80, 160, 50, 50);

        btnKeypadThree.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadThree.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadThree.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadThree.setText("3");
        btnKeypadThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadThreeActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadThree);
        btnKeypadThree.setBounds(140, 160, 50, 50);

        btnKeypadFour.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadFour.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadFour.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadFour.setText("4");
        btnKeypadFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadFourActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadFour);
        btnKeypadFour.setBounds(20, 220, 50, 50);

        btnKeypadFive.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadFive.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadFive.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadFive.setText("5");
        btnKeypadFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadFiveActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadFive);
        btnKeypadFive.setBounds(80, 220, 50, 50);

        btnKeypadSix.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadSix.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadSix.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadSix.setText("6");
        btnKeypadSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadSixActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadSix);
        btnKeypadSix.setBounds(140, 220, 50, 50);

        btnKeypadSeven.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadSeven.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadSeven.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadSeven.setText("7");
        btnKeypadSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadSevenActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadSeven);
        btnKeypadSeven.setBounds(20, 280, 50, 50);

        btnKeypadEigh.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadEigh.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadEigh.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadEigh.setText("8");
        btnKeypadEigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadEighActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadEigh);
        btnKeypadEigh.setBounds(80, 280, 50, 50);

        btnKeypadNine.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadNine.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadNine.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadNine.setText("9");
        btnKeypadNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadNineActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadNine);
        btnKeypadNine.setBounds(140, 280, 50, 50);

        btnKeypadEnter.setBackground(new java.awt.Color(0, 153, 0));
        btnKeypadEnter.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadEnter.setForeground(new java.awt.Color(0, 0, 0));
        btnKeypadEnter.setText("OK");
        btnKeypadEnter.setAutoscrolls(true);
        btnKeypadEnter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeypadEnter.setIconTextGap(2);
        btnKeypadEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadEnterActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadEnter);
        btnKeypadEnter.setBounds(200, 280, 50, 110);

        btnKeypadQty.setBackground(new java.awt.Color(255, 255, 0));
        btnKeypadQty.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadQty.setForeground(new java.awt.Color(0, 0, 0));
        btnKeypadQty.setText("C");
        btnKeypadQty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKeypadQty.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnKeypadQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadQtyActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadQty);
        btnKeypadQty.setBounds(200, 220, 50, 50);

        btnKeypadClr.setBackground(new java.awt.Color(255, 0, 0));
        btnKeypadClr.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadClr.setForeground(new java.awt.Color(0, 0, 0));
        btnKeypadClr.setText("EX");
        btnKeypadClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadClrActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadClr);
        btnKeypadClr.setBounds(200, 160, 50, 50);

        btnKeypadZero.setBackground(new java.awt.Color(40, 113, 117));
        btnKeypadZero.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        btnKeypadZero.setForeground(new java.awt.Color(255, 255, 255));
        btnKeypadZero.setText("0");
        btnKeypadZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeypadZeroActionPerformed(evt);
            }
        });
        pnlMain.add(btnKeypadZero);
        btnKeypadZero.setBounds(80, 340, 50, 50);

        txtAmountDue.setEditable(false);
        txtAmountDue.setBackground(new java.awt.Color(40, 113, 117));
        txtAmountDue.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        txtAmountDue.setForeground(new java.awt.Color(255, 255, 255));
        txtAmountDue.setText("Amount");
        pnlMain.add(txtAmountDue);
        txtAmountDue.setBounds(20, 60, 230, 30);

        getContentPane().add(pnlMain);
        pnlMain.setBounds(0, 0, 270, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnKeypadOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadOneActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 1);
    }//GEN-LAST:event_btnKeypadOneActionPerformed

    private void btnKeypadTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadTwoActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 2);
    }//GEN-LAST:event_btnKeypadTwoActionPerformed

    private void btnKeypadThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadThreeActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 3);
    }//GEN-LAST:event_btnKeypadThreeActionPerformed

    private void btnKeypadFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadFourActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 4);
    }//GEN-LAST:event_btnKeypadFourActionPerformed

    private void btnKeypadFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadFiveActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 5);
    }//GEN-LAST:event_btnKeypadFiveActionPerformed

    private void btnKeypadSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadSixActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 6);
    }//GEN-LAST:event_btnKeypadSixActionPerformed

    private void btnKeypadSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadSevenActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 7);
    }//GEN-LAST:event_btnKeypadSevenActionPerformed

    private void btnKeypadEighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadEighActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 8);
    }//GEN-LAST:event_btnKeypadEighActionPerformed

    private void btnKeypadNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadNineActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 9);
    }//GEN-LAST:event_btnKeypadNineActionPerformed

    private void btnKeypadEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadEnterActionPerformed
        String enteredPin = txtEnteredPin.getText();
        if (enteredPin.equals(CORRECT_PIN)) {
            Payment.setPIN_SUCCESSFULL(true);
            this.dispose();
        } else {
            Payment.setPIN_SUCCESSFULL(false);
            new Dialog_OK_UI(
                parent, true,
                "Pin Error",
                "Wrong Pin Entered"
            ).setVisible(true);
        }
    }//GEN-LAST:event_btnKeypadEnterActionPerformed

    private void btnKeypadQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadQtyActionPerformed
        txtEnteredPin.setText("");
    }//GEN-LAST:event_btnKeypadQtyActionPerformed

    private void btnKeypadClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadClrActionPerformed
        new Dialog_OK_UI(
            parent, true,
            "Canceled",
            "Payment Method Canceled"
        ).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeypadClrActionPerformed

    private void btnKeypadZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeypadZeroActionPerformed
        txtEnteredPin.setText(txtEnteredPin.getText() + 0);
    }//GEN-LAST:event_btnKeypadZeroActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtEnteredPin.requestFocus();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Dialog_Card_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Card_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Card_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Card_Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_Card_Payment dialog = new Dialog_Card_Payment(new javax.swing.JFrame(), true, 0.00);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKeypadClr;
    private javax.swing.JButton btnKeypadEigh;
    private javax.swing.JButton btnKeypadEnter;
    private javax.swing.JButton btnKeypadFive;
    private javax.swing.JButton btnKeypadFour;
    private javax.swing.JButton btnKeypadNine;
    private javax.swing.JButton btnKeypadOne;
    private javax.swing.JButton btnKeypadQty;
    private javax.swing.JButton btnKeypadSeven;
    private javax.swing.JButton btnKeypadSix;
    private javax.swing.JButton btnKeypadThree;
    private javax.swing.JButton btnKeypadTwo;
    private javax.swing.JButton btnKeypadZero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtAmountDue;
    private javax.swing.JTextField txtEnteredPin;
    // End of variables declaration//GEN-END:variables
}