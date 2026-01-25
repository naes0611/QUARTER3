/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;

import java.text.DecimalFormat;

/**
 *
 * @author seany
 */
public interface NumberFormatter {
    // Formatting Constants
    DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.############");
    int MAX_DIGIT_INPUT = 15;
    
    String formatNumber(double value);
    
    double parseDisplay();
}
