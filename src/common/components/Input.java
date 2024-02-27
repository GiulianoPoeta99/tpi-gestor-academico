package common.components;

import career.Career;
import common.Model;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
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

    // Método para crear un input similar a un select 2 con datos de Career
    public static JComboBox<String> createCareerInput(Map<Integer, String> dataMap) {
        JComboBox<String> comboBox = new JComboBox<>(dataMap.values().toArray(new String[0]));
        comboBox.setPreferredSize(new Dimension(200, 30)); // Establecer el tamaño preferido
        comboBox.setForeground(TEXT_COLOR);
        comboBox.setBackground(BACKGROUND_COLOR);
        comboBox.setBorder(new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, TEXT_COLOR),
                new EmptyBorder(5, 5, 5, 5)
        ));
        return comboBox;
    }
}
