/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Melanie
 */
public class Reports {

    public static String REPORTS_LOCATION = "D:\\Projects\\DTECHEPos\\reports";
    private HashMap map = null;
    private String reportName = "";
    private Connection connection = null;
    private JasperPrint jasperprint;

    public Reports() {
        map = new HashMap();
    }

    public Reports(Connection connection, String reportName) throws Exception {
//        System.out.println(new File(getClass().getResource("/reports/").toURI()).getPath());
//        REPORTS_LOCATION = new File(getClass().getResource("/reports/").toURI()).getPath();

        REPORTS_LOCATION = "D:\\Projects\\DTECHEPos\\reports\\";
        map = new HashMap();
        this.connection = connection;
        this.reportName = reportName;
    }

    public Reports(String reportName) {
        this();
        this.reportName = reportName;
    }

    public Reports(HashMap map, String reportName) {
        this(reportName);
        this.map = map;

    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setMap(HashMap map) {
        this.map = map;
    }

    public String getReportName() {
        return reportName;
    }

    private String getLocation() {
        return REPORTS_LOCATION + getReportName();
    }

    public void put(Object key, Object value) {
        map.put(key, value);
    }

    public HashMap getMap() {
        return map;
    }

    private InputStream getInputStream() {
        try {
            //factoratransaction

            System.out.println("locating : " + (REPORTS_LOCATION + reportName));
            String file = REPORTS_LOCATION + "/" + reportName;
            InputStream f = new FileInputStream(file);
            return f;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Connection getConnection() {
        return connection;
    }

    public boolean isJRViewer() {
        boolean succeed = false;
        try {
//            if (getInputStream() == null) {
//                System.err.println("InputStream error");
//                return false;
//            }
//            if (getMap() == null) {
//                System.err.println("Map error");
//                return false;
//            }
//            if (getConnection() == null) {
//                System.err.println("Connection error");
//                return false;
//            }
            System.err.println("not in parameter");
            jasperprint = JasperFillManager.fillReport(getInputStream(), getMap(), getConnection());
            if (jasperprint.getPages().isEmpty()) {
                succeed = true;
            }
        } catch (JRException ex) {
            ex.printStackTrace();
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return succeed;
    }

    public Component JRViewer() {
        try {
            jasperprint = JasperFillManager.fillReport(getInputStream(), getMap(), getConnection());
//            JRViewer jrv = new JRViewer(jasperprint);
            return new JRViewer(jasperprint);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void print() {
        try {
            jasperprint = JasperFillManager.fillReport(getInputStream(), getMap(), getConnection());
            JasperPrintManager.printReport(jasperprint, true);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void printpdf() {
        try {
            jasperprint = JasperFillManager.fillReport(getInputStream(), getMap(), getConnection());
            JasperPrintManager.printReportToPdf(jasperprint);
        } catch (JRException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String asd[]) {
        //Reports report = new Reports("DischargeSummary.jasper");
        //report.getMap().put("admission_id", "adm201188-1");
        try {

            System.out.println("Database Connecting..");
            MysqlConnect db = new MysqlConnect("localhost", "dtech_sales_inventory_db", "root", "");
            if (!(db.connect() == null)) {
                System.out.println("Database Successfully establish..");
            }
            Reports reports = new Reports(db.connect(), "c8pharmacy_warehouse.jasper");

            reports.getMap().put("warehouse_no", "WRH2021002");
            //report.getMap().put("admission_id", "adm201188-1");
            if (reports.isJRViewer()) {
                JOptionPane.showMessageDialog(null, "There's no data to print.");
                return;
            }

            JDialog d = new JDialog(new javax.swing.JFrame(), true);
            d.getContentPane().add(reports.JRViewer(), BorderLayout.CENTER);
            d.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            d.setVisible(true);
            d.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
