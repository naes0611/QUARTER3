/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package performancetasks;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Sean Yauder
 */

enum DeductionType {
    SSS_RATE(0.05),
    PHILHEALTH_RATE(0.025),
    PAGIBIG_RATE(0.02),
    TAX_RATE(0.2);
    
    private final double rate;
    
    DeductionType(double rate){
        this.rate = rate;
    }
    
    public double getRate(){
        return rate;
    }
}

public class pt_simplepayrollsystem extends javax.swing.JFrame {
    private final HashMap<DeductionType, Double> deductions = new HashMap<>();
    private NumberFormat currencyFormat;
    /**
     * Creates new form pt_payroll
     */
    public pt_simplepayrollsystem() {
        initComponents();
        setupCurrencyField();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                exitApp();
            }
        });
    }
    
    private int exitApp(){
        int result = JOptionPane.showConfirmDialog(pt_simplepayrollsystem.this, "Are you sure you want to close the application?", "Message", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        return result;
    }
    
    private void setupCurrencyField(){
        Locale localePH = Locale.forLanguageTag("en-PH");
        
        currencyFormat = NumberFormat.getCurrencyInstance(localePH);
        
        NumberFormatter currencyFormatter = new NumberFormatter(currencyFormat);
        currencyFormatter.setAllowsInvalid(false);
        currencyFormatter.setOverwriteMode(false);
        
        hourlyRateField.setFormatterFactory(new DefaultFormatterFactory(currencyFormatter));
        hourlyRateField.addPropertyChangeListener("value", evt ->{
            if(hourlyRateField.getValue() == null){
                hourlyRateField.setValue(0.00);
            }
        });
        hourlyRateField.setValue(0.00);
    }
    
    public class computationResult {
        private final double totalDeductions;
        private final double netPay;
        
        public computationResult(double totalDeductions, double netPay){
            this.totalDeductions = totalDeductions;
            this.netPay = netPay;
        }
        
        
        public double getTotalDeductions(){
            return totalDeductions;
        }
        
        public double getNetPay(){
            return netPay;
        }
    }  
    
    private computationResult computeDeductions(double grossPay){
        double totalDeductions = 0;
        for (DeductionType type : DeductionType.values()) {
            double deduction = grossPay * type.getRate();
            deductions.put(type, deduction);
            totalDeductions += deduction;
        }
        double netPay = grossPay - totalDeductions;
        return new computationResult(totalDeductions, netPay);
    }
    
    public double grossPay() {
        int hrsWorked = Integer.parseInt(hoursWorkedField.getText());
        double hourlyRate = ((Number) 
                hourlyRateField.getValue()).doubleValue();
        double grossPay = hrsWorked * hourlyRate;
        return grossPay;
    }

    private String displayPayrollSummary() {
        computationResult result = computeDeductions(grossPay());
        String employeeName = employeeNameField.getText().trim();
        String grossPay = currencyFormat.format(grossPay());
        String SSSDeduction = currencyFormat.format(deductions.get(DeductionType.SSS_RATE));
        String PagIbigDeduction = currencyFormat.format(deductions.get(DeductionType.PAGIBIG_RATE));
        String PhilHealthDeduction = currencyFormat.format(deductions.get(DeductionType.PHILHEALTH_RATE));
        String TaxDeduction = currencyFormat.format(deductions.get(DeductionType.TAX_RATE));
        String totalDeductions = currencyFormat.format(result.totalDeductions);
        String netPay = currencyFormat.format(result.netPay);
        String payrollSummary ="<html>  Employee name: " + employeeName +"<br>"
                                +"  Gross Pay: " + grossPay + "<br>" +
                                "  Summary of Deductions:<br>"+
                                "  SSS: " + SSSDeduction + "<br>" +
                                "  Pag-ibig: " + PagIbigDeduction + "<br>" +
                                "  PhilHealth: " + PhilHealthDeduction + "<br>" +
                                "  Tax: " + TaxDeduction + "<br>" +
                                "  Total Deductions: " + totalDeductions + "<br>" +
                                "  Net Pay: " + netPay + "<html>";
        return payrollSummary;
    }
    
    private void errorMessages(String type){
        String message;
        switch(type){
            case "invalid input" -> {
                message = "Invalid input. Please check your inputs.";
            }
            case "employee name empty" -> {
                message = "Employee Name Field cannot be empty!";
            }
            case "hours worked empty" -> {
                message = "Hours Worked Field cannot be empty!";
            }
            case "hourly rate no input" -> {
                message = "Hourly Rate Field cannot be 0.00";
            }
            default -> message = "An unexpected error occurred.";
        }
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private boolean isValidInput(){
        String name = employeeNameField.getText();
        String hrsWorkedStr = hoursWorkedField.getText();
        double rateperHr = ((Number)hourlyRateField.getValue()).doubleValue();
        String hourlyRate = String.valueOf(rateperHr);
        if (name.trim().isEmpty()){
            errorMessages("employee name empty");
            return false;
        }
        
        if (hrsWorkedStr.trim().isEmpty()){
            errorMessages("hours worked empty");
            return false;
        }
        if ("0.0".equals(hourlyRate)){
            errorMessages("hourly rate no input");
            return false;
        }
        try {
            int hrsWorked = Integer.parseInt(hoursWorkedField.getText());
            return true;
        } catch (NumberFormatException e) {
            errorMessages("invalid input");
            return false;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        computeBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        hourlyRateField = new javax.swing.JFormattedTextField();
        employeeNameField = new javax.swing.JTextField();
        hoursWorkedField = new javax.swing.JTextField();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Simple Payroll System");
        setResizable(false);

        jLabel1.setText("Employee Name:");

        jLabel2.setText("Hours Worked:");

        jLabel3.setText("Hourly Rate:");

        dataLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payroll Summary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        computeBtn.setText("Compute");
        computeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        employeeNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employeeNameFieldKeyTyped(evt);
            }
        });

        hoursWorkedField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hoursWorkedFieldKeyTyped(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(employeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(hoursWorkedField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(computeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(employeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(hoursWorkedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(hourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(computeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(dataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeNameFieldKeyTyped
        char c = evt.getKeyChar();
        String text = employeeNameField.getText();
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                spaceCount++;
            }
        }
        if(Character.isAlphabetic(c)){
            if (text.length() > 20){
                evt.consume();
            }   
            return;
        }
        if(c == ' '){
            if(employeeNameField.getCaretPosition() == 0){
                evt.consume();
            }
            
            if (spaceCount >= 2) {
                evt.consume();
            }
            
            int caretPos = employeeNameField.getCaretPosition();
            if (caretPos > 0 && text.charAt(caretPos - 1) == ' ') {
                evt.consume();
            }
            return;
        }
        evt.consume();
    }//GEN-LAST:event_employeeNameFieldKeyTyped

    private void hoursWorkedFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hoursWorkedFieldKeyTyped
        char c = evt.getKeyChar();
        String text = hoursWorkedField.getText();
        if(Character.isDigit(c)){
            if(text.length()>=4){
                evt.consume();
            }
            return;
        }
        evt.consume();
    }//GEN-LAST:event_hoursWorkedFieldKeyTyped
    
    private void computeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeBtnActionPerformed
        if(!isValidInput()){
            return;
        }
        dataLabel.setText(displayPayrollSummary());
        //JOptionPane.showMessageDialog(pt_simplepayrollsystem.this, displayPayrollSummary(), "Payroll Summary", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_computeBtnActionPerformed
    
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        employeeNameField.setText("");
        hoursWorkedField.setText("");
        hourlyRateField.setValue(0.00);
        dataLabel.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        exitApp();
    }//GEN-LAST:event_exitBtnActionPerformed
    
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
            java.util.logging.Logger.getLogger(pt_simplepayrollsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pt_simplepayrollsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pt_simplepayrollsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pt_simplepayrollsystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pt_simplepayrollsystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton computeBtn;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JTextField employeeNameField;
    private javax.swing.JButton exitBtn;
    private javax.swing.JFormattedTextField hourlyRateField;
    private javax.swing.JTextField hoursWorkedField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
