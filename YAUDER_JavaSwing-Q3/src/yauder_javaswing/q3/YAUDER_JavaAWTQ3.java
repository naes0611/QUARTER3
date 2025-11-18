
package yauder_javaswing.q3;

/**
 *
 * @author Sean Yauder
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.WindowConstants;

public class YAUDER_JavaAWTQ3 extends Frame implements ActionListener {

    Label lblStudentNo, lblFullName, lblStudentAddress;

    TextField txtStudentNo, txtFullName, txtStudentAddress;

    Button btnSave, btnClear;

    YAUDER_JavaAWTQ3(){
        
        lblStudentNo = new Label("Student Number:");
        lblFullName = new Label("Name:");
        lblStudentAddress = new Label("Address:");
        
        txtStudentNo = new TextField (20);
        txtFullName = new TextField (20);
        txtStudentAddress = new TextField (20);

        btnSave = new Button("Save");
        btnClear = new Button("Clear");
        
        setLayout(new GridLayout(4,2,10,10));
        
        //Add Components to frame
        add(lblStudentNo); add(txtStudentNo); 
        add(lblFullName); add(txtFullName);
        add(lblStudentAddress); add(txtStudentAddress);
        add(btnSave); add(btnClear);
        
        //Frame Settings
        setTitle("Student Form");
        setSize(300,200);
        setVisible(true);
        
        
        //Action Listener
        
    }
        
    public static void main(String[] args) {
        new YAUDER_JavaAWTQ3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
