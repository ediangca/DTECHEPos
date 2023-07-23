/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.form;

import inventory.Inventory_SupplierList;
import inventory.Inventory_UserSettings;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class Inventory_SupplierForm extends javax.swing.JDialog {

    /**
     * Creates new form Inventory_ProductForm
     */
    Inventory_SupplierList inventory_supplierlist;
    String validated_fields = "Please check the ff. fields:\n\n";

    Connection connection = null;
    Statement statement;
    ResultSet result;

    String Supplier_No = "";

    public Inventory_SupplierForm(java.awt.Frame parent, boolean modal, Inventory_SupplierList inventory_supplierlist) {
        super(parent, modal);
        initComponents();
        this.inventory_supplierlist = inventory_supplierlist;
        this.connection = inventory_supplierlist.connection;
        setLocationRelativeTo(parent);
    }

    public Inventory_SupplierForm(java.awt.Frame parent, boolean modal, Inventory_SupplierList inventory_supplierlist, String SupplierNo) {
        super(parent, modal);
        initComponents();
        this.inventory_supplierlist = inventory_supplierlist;
        this.connection = inventory_supplierlist.connection;
        this.Supplier_No = SupplierNo;

        but_save.setText("UPDATE");
        jRadioButton1.setVisible(false);
        field_supplierno.setText(SupplierNo);
        field_supplierno.setEnabled(false);
        restoreData();
        setLocationRelativeTo(parent);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        but_save = new javax.swing.JButton();
        but_cancel = new javax.swing.JButton();
        but_post = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_uinfo = new javax.swing.JPanel();
        field_supplierno = new javax.swing.JTextField();
        combo_sisactive = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_saddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        field_sname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        field_scontactno = new javax.swing.JTextField();
        field_semail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        field_svatexempt = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        field_stinno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SUPPLIER FORM");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setText("SUPPLIER FORM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));

        but_save.setText("SAVE");
        but_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_saveActionPerformed(evt);
            }
        });

        but_cancel.setText("CLOSE");
        but_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cancelActionPerformed(evt);
            }
        });

        but_post.setText("POST");
        but_post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_postActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_post, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_save, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(but_save, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(but_post, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        but_post.setVisible(false);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        panel_uinfo.setBackground(new java.awt.Color(255, 255, 255));

        field_supplierno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        combo_sisactive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "YES", "NO" }));
        combo_sisactive.setBorder(null);
        combo_sisactive.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        field_saddress.setColumns(20);
        field_saddress.setRows(5);
        field_saddress.setBorder(null);
        jScrollPane1.setViewportView(field_saddress);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Address");

        field_sname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Supplier No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Supplier Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Is Active");

        field_scontactno.setForeground(new java.awt.Color(153, 153, 153));
        field_scontactno.setText("n/a");
        field_scontactno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        field_scontactno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field_scontactnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_scontactnoFocusLost(evt);
            }
        });

        field_semail.setForeground(new java.awt.Color(153, 153, 153));
        field_semail.setText("n/a");
        field_semail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        field_semail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field_semailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_semailFocusLost(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Email");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Contact No.");

        field_svatexempt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        field_svatexempt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        field_svatexempt.setText("12.00");
        field_svatexempt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_svatexemptFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Vat");

        jRadioButton1.setText("Auto");
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tin No.");

        field_stinno.setForeground(new java.awt.Color(153, 153, 153));
        field_stinno.setText("n/a");
        field_stinno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        field_stinno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field_stinnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                field_stinnoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout panel_uinfoLayout = new javax.swing.GroupLayout(panel_uinfo);
        panel_uinfo.setLayout(panel_uinfoLayout);
        panel_uinfoLayout.setHorizontalGroup(
            panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_uinfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_uinfoLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_sisactive, 0, 259, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_uinfoLayout.createSequentialGroup()
                        .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_uinfoLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_uinfoLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_supplierno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_uinfoLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_sname)))
                        .addGap(4, 4, 4))
                    .addGroup(panel_uinfoLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_scontactno))
                    .addGroup(panel_uinfoLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_semail))
                    .addGroup(panel_uinfoLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_svatexempt))
                    .addGroup(panel_uinfoLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_stinno)
                        .addContainerGap())))
        );
        panel_uinfoLayout.setVerticalGroup(
            panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_uinfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field_supplierno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_scontactno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_semail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_stinno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_svatexempt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_uinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_sisactive, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUPPLIER INFORMATION", panel_uinfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cancelActionPerformed
        // TODO add your handling code here:
        if (!but_save.isVisible()) {
            dispose();
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "Do you really want to cancel adding/updating user?", "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (x == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_but_cancelActionPerformed

    private void but_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_saveActionPerformed
        // TODO add your handling code here:

        if (validate_field()) {
            JOptionPane.showConfirmDialog(this, validated_fields, "D-TECH WARNING", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean active = true;
        if (combo_sisactive.getSelectedIndex() > 1) {
            active = false;
        }
        try {
            if (but_save.getText().equalsIgnoreCase("save")) {
                statement = connection.createStatement();
//              Supplier_No., Supplier, Address, Contact_No., Email, Vat, Datetime_Created, Datetime_Updated, User_ID, isActive
                System.out.println("Saving Supplier Information...");
//                System.out.println("insert into `supplier` values('"
//                        + field_supplierno.getText() + "','"
//                        + field_sname.getText() + "','"
//                        + field_saddress.getText() + "','"
//                        + field_scontactno.getText() + "','"
//                        + field_semail.getText() + "',"
//                        + field_svatexempt.getText() + ",'"
//                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "','"
//                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "','" + inventory_supplierlist.inventory_mainframe.userID + "',"
//                        + active + ", 0)");
                statement.executeUpdate("insert into `supplier` values('"
                        + field_supplierno.getText() + "','"
                        + field_sname.getText() + "','"
                        + field_saddress.getText().trim() + "','"
                        + field_scontactno.getText() + "','"
                        + field_semail.getText() + "','"
                        + field_stinno.getText() + "',"
                        + field_svatexempt.getText() + ",'"
                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "','"
                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "','" + inventory_supplierlist.inventory_mainframe.userID + "',"
                        + active + ", 0)");

                JOptionPane.showConfirmDialog(this, "Supplier Successfully Added!", "D-TECH INFORMATION", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);

            } else {
                statement = connection.createStatement();
//              Supplier_No., Supplier, Address, Contact_No., Email, Vat, Datetime_Created, Datetime_Updated, User_ID, isActive
                System.out.println("Updating Supplier Information...");
                System.out.println("update `supplier` set Supplier ='"
                        + field_sname.getText().trim() + "', Address ='"
                        + field_saddress.getText() + "', `Contact_No.` ='"
                        + field_scontactno.getText() + "', Email ='"
                        + field_semail.getText() + "', `Tin_No.` ='"
                        + field_stinno.getText() + "', Vat ="
                        + field_svatexempt.getText() + ", Datetime_Updated ='"
                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "', User_ID ='"
                        + inventory_supplierlist.inventory_mainframe.userID + "', isActive = "
                        + active + " where `Supplier_No.` ='"
                        + field_supplierno.getText() + "'");
                statement.executeUpdate("update `supplier` set Supplier ='"
                        + field_sname.getText().trim() + "', Address ='"
                        + field_saddress.getText() + "', `Contact_No.` ='"
                        + field_scontactno.getText() + "', Email ='"
                        + field_semail.getText() + "', `Tin_No.` ='"
                        + field_stinno.getText() + "', Vat ="
                        + field_svatexempt.getText() + ", Datetime_Updated ='"
                        + new SimpleDateFormat("yyyy-MM-d HH:mm:ss").format(new Date()) + "', User_ID ='"
                        + inventory_supplierlist.inventory_mainframe.userID + "', isActive = "
                        + active + " where `Supplier_No.` ='"
                        + field_supplierno.getText() + "'");

                JOptionPane.showConfirmDialog(this, "Supplier Successfully Updated!", "D-TECH INFORMATION", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);

                dispose();

            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(this, e.getMessage(), "D-TECH WARNING", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
            
            dispose();
        }
        inventory_supplierlist.showQuery("SELECT * FROM supplierlist sl");
        clearfield();
    }//GEN-LAST:event_but_saveActionPerformed

    private void but_postActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_postActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_but_postActionPerformed

    private void field_scontactnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_scontactnoFocusGained
        // TODO add your handling code here:
        if (field_scontactno.getText().equalsIgnoreCase("n/a")) {
            field_scontactno.setText(null);
            field_scontactno.setForeground(new java.awt.Color(153, 153, 153));
        } else {
            field_scontactno.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_scontactnoFocusGained

    private void field_scontactnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_scontactnoFocusLost
        // TODO add your handling code here:
        if (field_scontactno.getText().isEmpty()) {
            field_scontactno.setText("n/a");
            field_scontactno.setForeground(new java.awt.Color(153, 153, 153));
        } else {
            field_scontactno.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_scontactnoFocusLost

    private void field_svatexemptFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_svatexemptFocusLost
        // TODO add your handling code here:
        if (field_svatexempt.getText().isEmpty()) {
            field_svatexempt.setText("0");
        }
    }//GEN-LAST:event_field_svatexemptFocusLost

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            field_supplierno.setText(getgeneratedproductNo());
        } else {
            field_supplierno.setText("");
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void field_semailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_semailFocusLost
        // TODO add your handling code here:
        if (field_semail.getText().isEmpty()) {
            field_semail.setText("n/a");
            field_semail.setForeground(new java.awt.Color(153, 153, 153));
        } else {
            field_semail.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_semailFocusLost

    private void field_semailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_semailFocusGained
        // TODO add your handling code here:
        if (field_semail.getText().equals("n/a")) {
            field_semail.setText(null);
            field_semail.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_semailFocusGained

    private void field_stinnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_stinnoFocusGained
        // TODO add your handling code here:
        if (field_stinno.getText().equals("n/a")) {
            field_stinno.setText(null);
            field_stinno.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_stinnoFocusGained

    private void field_stinnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_field_stinnoFocusLost
        // TODO add your handling code here:
        if (field_stinno.getText().isEmpty()) {
            field_stinno.setText("n/a");
            field_stinno.setForeground(new java.awt.Color(153, 153, 153));
        } else {
            field_stinno.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_field_stinnoFocusLost

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
            java.util.logging.Logger.getLogger(Inventory_UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory_UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory_UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory_UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inventory_SupplierForm dialog = new Inventory_SupplierForm(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton but_cancel;
    private javax.swing.JButton but_post;
    private javax.swing.JButton but_save;
    private javax.swing.JComboBox<String> combo_sisactive;
    private javax.swing.JTextArea field_saddress;
    private javax.swing.JTextField field_scontactno;
    private javax.swing.JTextField field_semail;
    private javax.swing.JTextField field_sname;
    private javax.swing.JTextField field_stinno;
    private javax.swing.JTextField field_supplierno;
    private javax.swing.JFormattedTextField field_svatexempt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_uinfo;
    // End of variables declaration//GEN-END:variables

    private boolean validate_field() {
        boolean validate = false;
        validated_fields = "Please check the ff. fields:\n\n";
        if (field_supplierno.getText().isEmpty()) {
            validated_fields = validated_fields + "* Invalid or Existing User ID.\n";
            validate = true;
            return validate;
        }
        if (field_sname.getText().isEmpty()) {
            validated_fields = validated_fields + "* Invalid Input for Lastname.\n";
            validate = true;
            return validate;
        }
        if (field_saddress.getText().isEmpty()) {
            validated_fields = validated_fields + "* Invalid Input for Address.\n";
            validate = true;
            return validate;
        }
        if (combo_sisactive.getSelectedIndex() == 0) {
            validated_fields = validated_fields + "* Select Status option.\n";
            validate = true;
            return validate;
        }
        if (field_scontactno.getText().isEmpty()) {
            validated_fields = validated_fields + "* Invalid Input for Description.\n";
            validate = true;
            return validate;
        }
        if (field_semail.getText().isEmpty()) {
            validated_fields = validated_fields + "* Invalid Input for Description.\n";
            validate = true;
            return validate;
        }
        if (combo_sisactive.getSelectedIndex() == 0) {
            validated_fields = validated_fields + "* Invalid Input for Status.\n";
            validate = true;
            return validate;
        }
        return validate;
    }

    private void clearfield() {
        field_supplierno.setText(null);
        field_sname.setText(null);
        field_saddress.setText(null);
        field_scontactno.setText("n/a");
        field_semail.setText("n/a");
        field_svatexempt.setText("12.00");
        combo_sisactive.setSelectedIndex(0);

        jTabbedPane1.setSelectedIndex(0);
        jRadioButton1ActionPerformed(null);

    }

    public void restoreData() {
        try {
            Statement statement1 = connection.createStatement();
//            Supplier_No., Supplier, Address, Contact_No., Email, Tin_No., Vat, Datetime_Created, Datetime_Updated, User_ID, isActive, cancelflag
            ResultSet result1 = statement1.executeQuery("SELECT * FROM supplier where `Supplier_No.` = '" + Supplier_No + "'");
            if (result1.next()) {

                Supplier_No = result1.getString(1);
                field_supplierno.setText(result1.getString(1));
                field_sname.setText(result1.getString(2));
                field_saddress.setText(result1.getString(3));
                field_scontactno.setText(result1.getString(4));
                field_semail.setText(result1.getString(5));
                field_stinno.setText(result1.getString(6));
                field_svatexempt.setText(result1.getString(7));

                if (result1.getBoolean(10)) {
                    combo_sisactive.setSelectedIndex(1);
                } else {
                    combo_sisactive.setSelectedIndex(2);
                }
                statement1.close();
                result1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getgeneratedproductNo() {
        String generated_no = "";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("select generate_supplierno();");
            if (result.next()) {
                generated_no = result.getString(1);
                field_supplierno.setText(result.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generated_no;
    }
}
