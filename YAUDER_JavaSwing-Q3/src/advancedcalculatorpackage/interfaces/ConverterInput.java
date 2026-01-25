/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;

/**
 *
 * @author seany
 */
public interface ConverterInput {
    
    void appendNumber(String number);
    
    void setActiveDisplay(boolean display1);
    
    void formatAndUpdate();
}
