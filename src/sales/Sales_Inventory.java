/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import classes.DBConnection;
import classes.MysqlConnect;
import inventory.Inventory_Login;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Sales_Inventory {

    /**
     * @param args the command line arguments
     */
    static DBConnection dbc;
    static MysqlConnect db;
    static Statement statement;
    static Connection connection;
    static ResultSet result;

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    System.out.println("Database Connecting..");
                    db = new MysqlConnect("localhost", "dtech_sales_inventory_db", "root", "");
                    connection = db.connect();
                    if (!(connection == null)) {
                        System.out.println("Database Successfully establish..");
                        statement = connection.createStatement();
                        System.err.println("SELECT Host, Port, Username, AES_DECRYPT(`Password`,9)as password, `Database` from host where isActive = 1;");
                        result = statement.executeQuery("SELECT Host, Port, Username, AES_DECRYPT(`Password`,9)as password, `Database` from host where isActive = 1;");
                        if (result.next()) {
                            System.out.println("Connecting Default Connection >>> " + result.getString(1) + " ..");
                            db = new MysqlConnect(result.getString(1), result.getString(5), result.getString(3), result.getString(4));
                            connection = db.connect();
                            System.out.println("Default Connection establish ..");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(new JFrame(), e.getMessage(), "D-TECH DB CONFIG ERROR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                    return;
                }

//                Inventory_Login inventorylogin = new inventory.Inventory_Login();
//                inventorylogin.setConnection(connection);
//                inventorylogin.setVisible(true);

                Sales_Mainframe saleslogin = new Sales_Mainframe();
                saleslogin.setConnection(db.connect());
                saleslogin.setVisible(true);
            }
        });
    }

}
