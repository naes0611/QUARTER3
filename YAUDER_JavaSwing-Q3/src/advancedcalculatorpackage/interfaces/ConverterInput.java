/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;

/**
 * Interface for handling user input
 * @author seany
 */
public interface ConverterInput {
    
    /**
     * Append a number to the active display
     * @param number the number string to append
     */
    void appendNumber(String number);
    
    /**
     * Format active label and update conversion
     */
    void formatAndUpdate();
    
    /**
     * Set which display is currently active
     * @param display1 true for display1, false for display2
     */
    void setActiveDisplay(boolean display1);
}
