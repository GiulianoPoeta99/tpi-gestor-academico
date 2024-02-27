package common.components;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.Map;


public class Input extends UIComponent {
    public static JTextField createInput(String initialValue) {
        JTextField textField = new JTextField(initialValue);
        textField.setPreferredSize(new Dimension(200, 30)); // Establecer el tamaño preferido
        textField.setForeground(TEXT_COLOR);
        textField.setBackground(BACKGROUND_COLOR);
        textField.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));
        return textField;
    }

    public static JTextField createDateInput(LocalDate initialValue) {
        JTextField textField = new JTextField(initialValue != null ? initialValue.toString() : "");
        textField.setPreferredSize(new Dimension(200, 30)); // Establecer el tamaño preferido
        textField.setForeground(TEXT_COLOR);
        textField.setBackground(BACKGROUND_COLOR);
        textField.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));
        return textField;
    }

    public static JPanel createSelect2Input(Map<Integer, String> options) {
        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboBox = new JComboBox<>(options.values().toArray(new String[0]));

        comboBox.setPreferredSize(new Dimension(200, 30)); // Establecer el tamaño preferido
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setBackground(BACKGROUND_COLOR);
        comboBox.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));

        comboBox.setSelectedIndex(-1); // Para que inicialmente no haya ninguna opción seleccionada

        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem() != null) {
                String selectedValue = comboBox.getSelectedItem().toString();
                for (Map.Entry<Integer, String> entry : options.entrySet()) {
                    if (entry.getValue().equals(selectedValue)) {
                        comboBox.putClientProperty("selectedIndex", entry.getKey());
                        break;
                    }
                }
            }
        });

        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }
}
