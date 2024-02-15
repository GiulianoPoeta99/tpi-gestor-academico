package common.components;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

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
}
