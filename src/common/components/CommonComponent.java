package common.components;

import javax.swing.*;

import java.awt.*;

public class CommonComponent {

    private static final Color TEXT_COLOR = Color.decode("#CCCCCC");

    public static JLabel paragraph(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    public static JLabel heading(int size, String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    public static JLabel bold(String text) {
        JLabel label = new JLabel(text);
        Font boldFont = label.getFont().deriveFont(Font.BOLD);
        label.setFont(boldFont);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    // public static JLabel underline(String text) {
    //     JLabel label = new JLabel(text);
    //     Font underlineFont = label.getFont().deriveFont(Font.PLAIN | Font.UNDERLINE);
    //     label.setFont(underlineFont);
    //     label.setForeground(TEXT_COLOR);
    //     return label;
    // }

    public static JLabel italic(String text) {
        JLabel label = new JLabel(text);
        Font italicFont = label.getFont().deriveFont(Font.ITALIC);
        label.setFont(italicFont);
        label.setForeground(TEXT_COLOR);
        return label;
    }

    public static JSeparator horizontalRule() {
        return new JSeparator(SwingConstants.HORIZONTAL);
    }

    // public static void insertLineBreak(Container container) {
    //     container.add(Box.verticalStrut(10));
    // }
}
