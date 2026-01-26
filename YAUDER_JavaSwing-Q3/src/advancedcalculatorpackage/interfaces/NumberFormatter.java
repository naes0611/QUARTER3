/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;

import java.text.DecimalFormat;

/**
 * Interface for number formatting and parsing display text
 * @author seany
 */
public interface NumberFormatter {
    
    // Formatting Constants
    DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.############");
    int MAX_DIGIT_INPUT = 15;
    
    /**
     * Format number with commas and appropriate decimal places
     * @param value the value to be formatted
     * @return formatted String
     */
    String formatNumber(double value);
    
    /**
     * Parse display text to double value
     * @return parsed number
     */
    double parseDisplay();
}
