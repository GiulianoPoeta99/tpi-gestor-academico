package common.components;

import javax.swing.*;
import java.awt.*;

public class TextComponent extends CommonComponent {

    public static JLabel h1(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font(DEFAULT_FONT, Font.BOLD, 24)); // Tamaño y tipo de fuente para H1
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente
        return label;
    }

}
