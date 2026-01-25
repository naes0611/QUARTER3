/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package advancedcalculatorpackage.interfaces;


/**
 *
 * @author seany
 */
public interface UnitConverter<UnitType> {
    
    double convert(double value, UnitType unitFrom, UnitType unitTo);
    
    UnitType getActiveUnit();
    
    UnitType getInactiveUnit();
    
    void updateConversion();
}
