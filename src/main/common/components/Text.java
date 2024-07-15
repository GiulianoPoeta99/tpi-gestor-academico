package main.common.components;

import javax.swing.*;
import java.awt.*;

/**
 * The Text class provides utility methods to create JLabel components with
 * different font sizes, simulating HTML-like headers (h1, h2, etc.) and paragraphs.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>configureLabel(String text, int fontSize) - Configures and returns a JLabel with the specified text and font size.</li>
 *   <li>h1(String text) - Creates a JLabel with h1 styling.</li>
 *   <li>h2(String text) - Creates a JLabel with h2 styling.</li>
 *   <li>h3(String text) - Creates a JLabel with h3 styling.</li>
 *   <li>h4(String text) - Creates a JLabel with h4 styling.</li>
 *   <li>h5(String text) - Creates a JLabel with h5 styling.</li>
 *   <li>h6(String text) - Creates a JLabel with h6 styling.</li>
 *   <li>p(String text) - Creates a JLabel with paragraph styling.</li>
 *   <li>label(String text) - Creates a JLabel with default label styling.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.14
 */
public class Text extends Common {

    /**
     * Configures and returns a JLabel with the specified text and font size.
     *
     * @param text The text to be displayed on the label.
     * @param fontSize The font size for the label text.
     * @return A configured JLabel.
     */
    private static JLabel configureLabel(String text, int fontSize) {
        JLabel label = new JLabel("<html>" + text.replaceAll("\n", "<br>") + "</html>");
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font(DEFAULT_FONT, Font.PLAIN, fontSize));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    /**
     * Creates a JLabel with h1 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h1.
     */
    public static JLabel h1(String text) {
        return configureLabel(text, 25);
    }

    /**
     * Creates a JLabel with h2 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h2.
     */
    public static JLabel h2(String text) {
        return configureLabel(text, 23);
    }

    /**
     * Creates a JLabel with h3 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h3.
     */
    public static JLabel h3(String text) {
        return configureLabel(text, 21);
    }

    /**
     * Creates a JLabel with h4 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h4.
     */
    public static JLabel h4(String text) {
        return configureLabel(text, 19);
    }

    /**
     * Creates a JLabel with h5 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h5.
     */
    public static JLabel h5(String text) {
        return configureLabel(text, 17);
    }

    /**
     * Creates a JLabel with h6 styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as h6.
     */
    public static JLabel h6(String text) {
        return configureLabel(text, 15);
    }

    /**
     * Creates a JLabel with paragraph styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as a paragraph.
     */
    public static JLabel p(String text) {
        return configureLabel(text, 14);
    }

    /**
     * Creates a JLabel with default label styling.
     *
     * @param text The text to be displayed on the label.
     * @return A JLabel styled as a default label.
     */
    public static JLabel label(String text) {
        return configureLabel(text, 12);
    }
}
