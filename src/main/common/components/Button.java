package main.common.components;

import javax.swing.*;
import java.awt.*;

/**
 * The Button class provides static methods to create customized buttons
 * with different styles such as success, primary, secondary, info, warning, and danger.
 * Each button can be configured with a text, background color, and an action to be performed
 * when the button is clicked.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>configureButton(String text, Color backgroundColor, Runnable redirection) - Configures a button with specified properties.</li>
 *   <li>success(String text, Runnable redirection) - Creates a button with success style.</li>
 *   <li>primary(String text, Runnable redirection) - Creates a button with primary style.</li>
 *   <li>secondary(String text, Runnable redirection) - Creates a button with secondary style.</li>
 *   <li>info(String text, Runnable redirection) - Creates a button with info style.</li>
 *   <li>warning(String text, Runnable redirection) - Creates a button with warning style.</li>
 *   <li>danger(String text, Runnable redirection) - Creates a button with danger style.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.02.14
 * @author Giuliano Ignacio Poeta
 */
public class Button extends UIComponent {

    /**
     * Configures a button with specified text, background color, and redirection action.
     *
     * @param text The text to display on the button.
     * @param backgroundColor The background color of the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A configured JButton instance.
     */
    private static JButton configureButton(String text, Color backgroundColor, Runnable redirection) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);

        button.addActionListener(e -> redirection.run());

        return button;
    }

     /**
     * Creates a button with success style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with success style.
     */
    public static JButton success(String text, Runnable redirection) {
        return configureButton(text, SUCCESS_COLOR, redirection);
    }

    /**
     * Creates a button with primary style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with primary style.
     */
    public static JButton primary(String text, Runnable redirection) {
        return configureButton(text, PRIMARY_COLOR, redirection);
    }

    /**
     * Creates a button with secondary style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with secondary style.
     */
    public static JButton secondary(String text, Runnable redirection) {
        return configureButton(text, SECONDARY_COLOR, redirection);
    }

    /**
     * Creates a button with info style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with info style.
     */
    public static JButton info(String text, Runnable redirection) {
        return configureButton(text, INFO_COLOR, redirection);
    }

    /**
     * Creates a button with warning style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with warning style.
     */
    public static JButton warning(String text, Runnable redirection) {
        return configureButton(text, WARNING_COLOR, redirection);
    }

    /**
     * Creates a button with danger style.
     *
     * @param text The text to display on the button.
     * @param redirection The action to perform when the button is clicked.
     * @return A JButton with danger style.
     */
    public static JButton danger(String text, Runnable redirection) {
        return configureButton(text, DANGER_COLOR, redirection);
    }
}
