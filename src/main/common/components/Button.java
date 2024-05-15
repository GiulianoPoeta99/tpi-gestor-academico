package main.common.components;

import javax.swing.*;
import java.awt.*;

public class Button extends UIComponent {
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

    public static JButton success(String text, Runnable redirection) {
        return configureButton(text, SUCCESS_COLOR, redirection);
    }

    public static JButton primary(String text, Runnable redirection) {
        return configureButton(text, PRIMARY_COLOR, redirection);
    }

    public static JButton secondary(String text, Runnable redirection) {
        return configureButton(text, SECONDARY_COLOR, redirection);
    }

    public static JButton info(String text, Runnable redirection) {
        return configureButton(text, INFO_COLOR, redirection);
    }

    public static JButton warning(String text, Runnable redirection) {
        return configureButton(text, WARNING_COLOR, redirection);
    }

    public static JButton danger(String text, Runnable redirection) {
        return configureButton(text, DANGER_COLOR, redirection);
    }
}
