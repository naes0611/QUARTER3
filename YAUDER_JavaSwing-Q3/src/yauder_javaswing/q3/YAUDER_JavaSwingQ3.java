/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yauder_javaswing.q3;

import javax.swing.*;

/**
 *
 * @author ihub27
 */
public class YAUDER_JavaSwingQ3 {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JButton button = new JButton();
    
    YAUDER_JavaSwingQ3(){
        frame.setVisible(true);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label.setText("Student Number:");
        label.setText("Student Full Name:");
        label.setText("Student Address:");
        
        
        
    }
    public static void main(String[] args) {
        new YAUDER_JavaSwingQ3(); 
    }
}
