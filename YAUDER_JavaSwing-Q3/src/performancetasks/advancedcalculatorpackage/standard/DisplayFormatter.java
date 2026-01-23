package performancetasks.advancedcalculatorpackage.standard;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Handles formatting of numbers for display
 * Manages commas, decimals, and special formatting
 */
public class DisplayFormatter {
    private final DecimalFormat decimalFormat;
    private final DecimalFormat scientificFormat;
    private final int MAX_DISPLAY_DIGITS = 16;
    
    public DisplayFormatter() {
        this.decimalFormat = new DecimalFormat("#,##0.################");
        this.scientificFormat = new DecimalFormat("0.##############E0");
    }
    
    /**
     * Count significant digits 
     * (exluding seperators, decimal point, minus sign, plus sign, and scientific notation)
     * 
     */
    public int countSignificantDigits(String formattedNumber) {
        String digitsOnly = formattedNumber.replace(",", "")
                                           .replace(".", "")
                                           .replace("-", "")
                                           .replace("e", "")
                                           .replace("E", "")
                                           .replace("+", "");
        return digitsOnly.length();
    } 
    
    /**
     * Formats BigDecimal for display 
     * (removes trailing zeros, adds thousand seperator, and uses scientific notation if needed)
     * 
     */
    public String formatNumber (BigDecimal value) {
        if (value == null) return "0";
        
        BigDecimal stripped = value.stripTrailingZeros();
        String normalFormat;
        
        // Format normally first
        if (stripped.scale() <= 0) {
            normalFormat = String.format("%,d", stripped.toBigInteger());
        } else {
            normalFormat = decimalFormat.format(value);
        }
        
        // Check if digit count exceeds MAX_DISPLAY_DIGITS
        int digitCount = countSignificantDigits(normalFormat);
        
        // Use scientific notation if digit count exceeds MAX_DISPLAY_DIGITS
        if (digitCount > MAX_DISPLAY_DIGITS) {
            return scientificFormat.format(value);
        }
        
        return normalFormat;
    }
    
    /**
     * 
     */
    public BigDecimal parseNumber(String text) {
        return BigDecimal.ZERO;
    }
    
    /**
     * 
     * 
     */
    public boolean isError(String text) {
        return text.equals("Cannot divide by zero") || 
               text.equals("Invalid input") || 
               text.equals("Overflow") ||
               text.equals("Error");
    }
}