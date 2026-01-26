package advancedcalculatorpackage.interfaces;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontMetrics;
/**
 * Interface for managing converter display components
 * @author seany
 */
public interface ConverterDisplay {
    
    // Display Font Constants
    Font SEMIBOLD_FONT = new Font("Segoe UI Semibold", Font.PLAIN, 36);
    Font SEMILIGHT_FONT = new Font("Segoe UI Semilight", Font.PLAIN, 36);
    
    /**
     * Get the currently active display label
     * @return active JLabel
     */
    JLabel getActiveDisplay();
    
    /**
     * Get the currently inactive display label
     * @return inactive JLabel
     */
    JLabel getInactiveDisplay();
    
    /**
     * Resizes label font to fit content within maximum width
     * @param label the label to resize
     */
    default void resizeLabel(JLabel label) {
        String text = label.getText();
        if (text.isEmpty()) return;

        int maxWidth = 320; // Maximum width for the label
        int fontSize = 36; // Default Font Size
        Font font = label.getFont().deriveFont((float) fontSize);
        FontMetrics metrics = label.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);

        // If text fits at full size, set label width to text width
        if (textWidth <= maxWidth) {
            label.setSize(textWidth, label.getHeight());
            label.setFont(font);
        } else {
            // Text doesn't fit, shrink font until it fits in maxWidth
            label.setSize(maxWidth, label.getHeight());

            while (metrics.stringWidth(text) > maxWidth && fontSize > 8) {
                fontSize -= 1;
                font = label.getFont().deriveFont((float) fontSize);
                metrics = label.getFontMetrics(font);
            }
            label.setFont(font);
        }
    }
    
    /**
     * Resets label font to default size
     * @param label the label to reset
     */
    default void resetFontSize(JLabel label) {
        Font font = label.getFont().deriveFont(36f);
        label.setFont(font);
        // Reset label to appropriate width
        FontMetrics metrics = label.getFontMetrics(font);
        String text = label.getText();
        int textWidth = metrics.stringWidth(text);
        int maxWidth = 320;

        if (textWidth <= maxWidth) {
            label.setSize(textWidth, label.getHeight());
        } else {
            label.setSize(maxWidth, label.getHeight());
        }
    }
}
