/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;


/**
 * Interface for unit conversion operations
 * @author seany
 * @param <UnitType> the unit type (UnitOfTemperature, UnitOfTime)
 */
public interface UnitConverter<UnitType> {
    
    /**
     * Convert value from one unit to another
     * @param value the value to convert
     * @param unitFrom source unit
     * @param unitTo target unit
     * @return converted value
     */
    double convert(double value, UnitType unitFrom, UnitType unitTo);
    
    /**
     * Get the unit for the active display
     * @return active unit
     */
    UnitType getActiveUnit();
    
    /**
     * Get the unit for the inactive display
     * @return inactive unit
     */
    UnitType getInactiveUnit();
    
    /**
     * Update conversion and display result
     */
    void updateConversion();
}
