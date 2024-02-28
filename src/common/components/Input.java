package common.components;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Input extends UIComponent {
    private static void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setPreferredSize(new Dimension(200, 30));
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setBackground(BACKGROUND_COLOR);
        comboBox.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));
        comboBox.setSelectedIndex(-1);
    }

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

    public static JTextField createInput(String initialValue) {
        JTextField textField = new JTextField(initialValue);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setForeground(TEXT_COLOR);
        textField.setBackground(BACKGROUND_COLOR);
        textField.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));
        return textField;
    }

    public static JTextField createDateInput(LocalDate initialValue) {
        return createInput(initialValue != null ? initialValue.toString() : "");
    }

    public static JPanel createSelect2InputStrInt(Map<Integer, String> options) {
        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));
        configureComboBoxWithMap(comboBox, options);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

    public static JPanel createSelect2InputStrStr(Map<String, String> options) {
        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));
        configureComboBoxWithMap(comboBox, options);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

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
