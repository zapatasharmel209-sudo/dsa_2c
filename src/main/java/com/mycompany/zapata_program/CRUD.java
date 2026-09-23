/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.zapata_program;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CRUD extends JFrame {

    // UI Components
    private JTextField txtStudentId, txtFirstName, txtLastName, txtTotalScore, txtAverage, txtRanking;
    private JComboBox<String> cbCourseCode;
    private JTextField txtMath, txtEnglish, txtBiology, txtInfoTech, txtChemistry, txtPhysic;
    private JTextArea txtTranscript;
    private JTable recordTable;
    private DefaultTableModel tableModel;

    // Buttons
    private JButton btnResult, btnTranscript, btnReset, btnDelete, btnPrint, btnExit;

    // Color Palette base sa larawan
    private final Color COLOR_BG = new Color(175, 222, 225); // Light Cyan Background
    private final Color COLOR_BORDER = new Color(70, 150, 160); // Darker Cyan Border
    private final Color COLOR_PANEL_BG = new Color(210, 238, 240); // Soft Blue-Green Panel
    private final Color COLOR_BUTTON_BG = new Color(150, 210, 215); // Button Background

    public CRUD() {
        setTitle("Student Result Recording System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));

        // Layout Containers
        initTopPanel();
        initCenterTable();
        initBottomButtons();
    }

    private void initTopPanel() {
        JPanel topContainer = new JPanel(new GridLayout(1, 2, 10, 0));
        topContainer.setOpaque(false);
        topContainer.setBorder(new EmptyBorder(10, 10, 5, 10));

        Border customBorder = BorderFactory.createLineBorder(COLOR_BORDER, 3);

        // --- LEFT PANEL: Student Record Form ---
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.setBackground(COLOR_PANEL_BG);
        leftPanel.setBorder(BorderFactory.createCompoundBorder(customBorder, new EmptyBorder(10, 10, 10, 10)));

        JLabel lblTitleLeft = new JLabel("Student Record");
        lblTitleLeft.setFont(new Font("Tahoma", Font.BOLD, 18));
        leftPanel.add(lblTitleLeft, BorderLayout.NORTH);

        JPanel formGrid = new JPanel(new GridLayout(7, 4, 10, 8));
        formGrid.setOpaque(false);

        // Form Fields
        txtStudentId = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        cbCourseCode = new JComboBox<>(new String[]{"ART123", "BUS123", "PHY363", "EDU123", "PSY190", "COM123"});
        
        txtTotalScore = new JTextField();
        txtAverage = new JTextField();
        txtRanking = new JTextField();

        txtMath = new JTextField();
        txtEnglish = new JTextField();
        txtBiology = new JTextField();
        txtInfoTech = new JTextField();
        txtChemistry = new JTextField();
        txtPhysic = new JTextField();

        // Adding to Grid
        formGrid.add(createBoldLabel("Student_ID:"));
        formGrid.add(txtStudentId);
        formGrid.add(createBoldLabel("Mathematic:"));
        formGrid.add(txtMath);

        formGrid.add(createBoldLabel("First Name:"));
        formGrid.add(txtFirstName);
        formGrid.add(createBoldLabel("English:"));
        formGrid.add(txtEnglish);

        formGrid.add(createBoldLabel("Last Name:"));
        formGrid.add(txtLastName);
        formGrid.add(createBoldLabel("Biology:"));
        formGrid.add(txtBiology);

        formGrid.add(createBoldLabel("Course Code:"));
        formGrid.add(cbCourseCode);
        formGrid.add(createBoldLabel("Info Tech:"));
        formGrid.add(txtInfoTech);

        formGrid.add(createBoldLabel("Total Score:"));
        formGrid.add(txtTotalScore);
        formGrid.add(createBoldLabel("Chemistry:"));
        formGrid.add(txtChemistry);

        formGrid.add(createBoldLabel("Average:"));
        formGrid.add(txtAverage);
        formGrid.add(createBoldLabel("Physic:"));
        formGrid.add(txtPhysic);

        formGrid.add(createBoldLabel("Ranking:"));
        formGrid.add(txtRanking);
        formGrid.add(new JLabel("")); // Spacer
        formGrid.add(new JLabel("")); // Spacer

        leftPanel.add(formGrid, BorderLayout.CENTER);

        // --- RIGHT PANEL: Transcript ---
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBackground(COLOR_PANEL_BG);
        rightPanel.setBorder(BorderFactory.createCompoundBorder(customBorder, new EmptyBorder(10, 10, 10, 10)));

        JLabel lblTitleRight = new JLabel("Transcript");
        lblTitleRight.setFont(new Font("Tahoma", Font.BOLD, 18));
        rightPanel.add(lblTitleRight, BorderLayout.NORTH);

        txtTranscript = new JTextArea();
        txtTranscript.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtTranscript.setEditable(false);
        
        // Sample default text para magmukhang tulad ng nasa larawan
        txtTranscript.setText("""
                               Student Result Recording System
                              
                               Full Name:         ID:
                               ========================================
                               Mathematic:
                               English:
                               Biology:
                               InfoTech:
                               Chemistry:
                               Physic:
                               ========================================
                               Total Score:
                               Average:
                               Ranking:""");

        JScrollPane transcriptScroll = new JScrollPane(txtTranscript);
        transcriptScroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        rightPanel.add(transcriptScroll, BorderLayout.CENTER);

        // Add both to top container
        topContainer.add(leftPanel);
        topContainer.add(rightPanel);

        add(topContainer, BorderLayout.NORTH);
    }

    private void initCenterTable() {
        String[] columns = {
            "Student ID", "First Name", "Last Name", "Course Code", 
            "Math", "English", "Biology", "Info Tech", "Chemistry", "Physic", 
            "Total Score", "Average", "Ranking"
        };

        tableModel = new DefaultTableModel(columns, 0);
        recordTable = new JTable(tableModel);
        recordTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
        recordTable.setRowHeight(20);
        recordTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 11));

        // Magdagdag ng Sample Rows tulad ng nasa larawan
        tableModel.addRow(new Object[]{"AB123", "Kim", "Nguyen", "BUS123", "99", "98", "99", "89", "56", "74", "999", "99", "1st"});
        tableModel.addRow(new Object[]{"AD156", "Catalina", "Smith", "PHY363", "99", "99", "83", "86", "79", "94", "853", "83", "3rd"});
        tableModel.addRow(new Object[]{"AC100", "Carlin", "Doly", "PSY190", "99", "98", "99", "89", "56", "74", "999", "99", "1st"});
        tableModel.addRow(new Object[]{"QW980", "Paul", "Mason", "PHY363", "99", "98", "83", "86", "79", "94", "853", "83", "3rd"});
        tableModel.addRow(new Object[]{"RT1780", "Lisa", "Swatland", "PSY780", "99", "98", "99", "89", "56", "74", "999", "99", "1st"});
        tableModel.addRow(new Object[]{"HQ100", "Thom", "Garry", "PHY363", "99", "98", "83", "86", "79", "94", "853", "83", "3rd"});
        tableModel.addRow(new Object[]{"YT445", "Nina", "Junior", "COM123", "99", "98", "83", "86", "56", "74", "823", "83", "2nd"});
        tableModel.addRow(new Object[]{"DN1003", "Sean", "Dressing", "PSY190", "99", "90", "89", "89", "56", "74", "823", "83", "2nd"});
        tableModel.addRow(new Object[]{"QW552", "Jennifer", "Darlic", "EDU123", "99", "98", "99", "89", "56", "74", "999", "99", "1st"});
        tableModel.addRow(new Object[]{"PP980", "Grace", "Walter", "ART123", "90", "90", "90", "90", "90", "90", "540", "90", "1st"});

        JScrollPane tableScroll = new JScrollPane(recordTable);
        tableScroll.setBorder(BorderFactory.createCompoundBorder(
            new EmptyBorder(5, 10, 5, 10),
            BorderFactory.createLineBorder(COLOR_BORDER, 2)
        ));

        add(tableScroll, BorderLayout.CENTER);
    }

    private void initBottomButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6, 15, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(5, 10, 10, 10));

        btnResult = createStyledButton("Result");
        btnTranscript = createStyledButton("Transcript");
        btnReset = createStyledButton("Reset");
        btnDelete = createStyledButton("Delete");
        btnPrint = createStyledButton("Print");
        btnExit = createStyledButton("Exit");

        buttonPanel.add(btnResult);
        buttonPanel.add(btnTranscript);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnPrint);
        buttonPanel.add(btnExit);

        // Simple Action Listener para sa Exit button
        btnExit.addActionListener(e -> System.exit(0));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Utility Methods para sa styling
    private JLabel createBoldLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
        return lbl;
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Tahoma", Font.BOLD, 14));
        btn.setBackground(COLOR_BUTTON_BG);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(COLOR_BORDER, 2));
        btn.setPreferredSize(new Dimension(0, 35));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CRUD().setVisible(true);
        });
    }
}

/**
 *
 * @author CL2-PC
 */
public class CRUD extends javax.swing.JFrame {

    /**
     * Creates new form CRUD
     */
    public CRUD() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Course:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Student_ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Firstname:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lastname:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 20));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 140, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 140, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", "HM< BSOA" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("English:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Biology:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Chemistry:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Info Tech:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Mathematics:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Physics:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Average:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Ranking:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Total Score:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, -1));
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 140, -1));
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("STUDENT RECORD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jButton1.setText("EXIT");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jButton2.setText("RESET");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jButton3.setText("DELETE");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jButton4.setText("PRINT");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        jButton5.setText("RESULT");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jButton6.setText("TRANSCRIPT");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
