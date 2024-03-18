package main.common.components;

import javax.swing.*;
import java.awt.*;

public class Text extends Common {

    private static JLabel configureLabel(String text, int fontSize) {
        JLabel label = new JLabel("<html>" + text.replaceAll("\n", "<br>") + "</html>");
        label.setForeground(TEXT_COLOR);
        label.setFont(new Font(DEFAULT_FONT, Font.PLAIN, fontSize));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    public static JLabel h1(String text) {
        return configureLabel(text, 25);
    }

    public static JLabel h2(String text) {
        return configureLabel(text, 23);
    }

    public static JLabel h3(String text) {
        return configureLabel(text, 21);
    }

    public static JLabel h4(String text) {
        return configureLabel(text, 19);
    }

    public static JLabel h5(String text) {
        return configureLabel(text, 17);
    }

    public static JLabel h6(String text) {
        return configureLabel(text, 15);
    }

    public static JLabel p(String text) {
        return configureLabel(text, 14);
    }

    public static JLabel label(String text) {
        return configureLabel(text, 12);
    }
}
