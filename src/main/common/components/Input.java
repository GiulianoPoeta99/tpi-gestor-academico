package main.common.components;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Input class provides utility methods for creating and configuring
 * various types of input components, including text fields and combo boxes.
 * It simplifies the process of setting up input fields with consistent
 * styling and behavior across the application.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>WIDTH - The standard width for input components.</li>
 *   <li>HEIGHT - The standard height for input components.</li>
 * </ul>
 *
 * <p>Static Methods:</p>
 * <ul>
 *   <li>configureComboBox(JComboBox&lt;String&gt; comboBox) - Configures a combo box with standard styles and behavior.</li>
 *   <li>configureComboBoxWithMap(JComboBox&lt;String&gt; comboBox, Map&lt;?, String&gt; options) - Configures a combo box with a map of options, mapping selections to keys.</li>
 *   <li>createInput(String initialValue) - Creates a text field with an initial value.</li>
 *   <li>createDateInput(LocalDate initialValue) - Creates a text field for date input with an initial value.</li>
 *   <li>createSelect2InputStrInt(Map&lt;Integer, String&gt; options) - Creates a combo box for integer-string mappings.</li>
 *   <li>createSelect2InputStrStr(Map&lt;String, String&gt; options) - Creates a combo box for string-string mappings.</li>
 *   <li>createSelect2InputBoolStr() - Creates a combo box for boolean-string mappings.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.02.15
 * @author Giuliano Ignacio Poeta
 */
public class Input extends UIComponent {

    private static final int WIDTH = 450;
    private static final int HEIGHT = 35;

    /**
     * Configures a combo box with standard styles and behavior.
     *
     * @param comboBox The combo box to configure.
     */
    private static void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setBackground(BACKGROUND_COLOR);
        comboBox.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)));
        comboBox.setSelectedIndex(-1);
    }

    /**
     * Configures a combo box with a map of options, mapping selections to keys.
     *
     * @param comboBox The combo box to configure.
     * @param options A map of options where keys map to string values.
     */
    private static void configureComboBoxWithMap(JComboBox<String> comboBox, Map<?, String> options) {
        configureComboBox(comboBox);

        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem() != null) {
                String selectedValue = comboBox.getSelectedItem().toString();
                for (Map.Entry<?, String> entry : options.entrySet()) {
                    if (entry.getValue().equals(selectedValue)) {
                        comboBox.putClientProperty("selectedIndex", entry.getKey());
                        break;
                    }
                }
            }
        });
    }

    /**
     * Creates a text field with an initial value.
     *
     * @param initialValue The initial value for the text field.
     * @return A configured JTextField instance.
     */
    public static JTextField createInput(String initialValue) {
        JTextField textField = new JTextField(initialValue);
        textField.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        textField.setForeground(TEXT_COLOR);
        textField.setBackground(BACKGROUND_COLOR);
        textField.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)));
        return textField;
    }

    /**
     * Creates a text field for date input with an initial value.
     *
     * @param initialValue The initial value for the date input field.
     * @return A configured JTextField instance.
     */
    public static JTextField createDateInput(LocalDate initialValue) {
        return createInput(initialValue != null ? initialValue.toString() : "");
    }

    /**
     * Creates a combo box for integer-string mappings.
     *
     * @param options A map of integer keys to string values.
     * @return A JPanel containing the configured combo box.
     */
    public static JPanel createSelect2InputStrInt(Map<Integer, String> options) {
        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));
        configureComboBoxWithMap(comboBox, options);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates a combo box for string-string mappings.
     *
     * @param options A map of string keys to string values.
     * @return A JPanel containing the configured combo box.
     */
    public static JPanel createSelect2InputStrStr(Map<String, String> options) {
        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));
        configureComboBoxWithMap(comboBox, options);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates a combo box for boolean-string mappings.
     *
     * @return A JPanel containing the configured combo box.
     */
    public static JPanel createSelect2InputBoolStr() {
        Map<Boolean, String> options = new LinkedHashMap<>();
        options.put(true, "Si");
        options.put(false, "No");

        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));
        configureComboBoxWithMap(comboBox, options);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }
}
