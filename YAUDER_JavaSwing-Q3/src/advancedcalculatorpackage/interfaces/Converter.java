/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;

/**
 * Combined interface representing all converter functionality
 * @author seany
 * @param <UnitType> the unit type
 */
public interface Converter<UnitType> extends ConverterInput, ConverterDisplay, UnitConverter<UnitType>, NumberFormatter{
    
    /**
     * Counts the number of digits excluding formatting characters
     * @param formattedNumber the formatted number
     * @return the total amount of digits only
     */
    int countDigits(String formattedNumber);
}
