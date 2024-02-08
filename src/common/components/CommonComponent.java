package common.components;

import common.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class CommonComponent {
    // Método para crear un JLabel con el color de letra especificado
    public static JLabel p(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.decode("#CCCCCC"));
        return label;
    }

    // Método para la etiqueta <b> (negrita)
    public static JLabel b(String text) {
        return createLabel(text, Font.BOLD);
    }

    // Método para la etiqueta <i> (cursiva)
    public static JLabel i(String text) {
        return createLabel(text, Font.ITALIC);
    }

    // Métodos para títulos (h1 - h6)
    public static JLabel h1(String text) {
        return createHeaderLabel(text, Font.BOLD, 24);
    }

    public static JLabel h2(String text) {
        return createHeaderLabel(text, Font.BOLD, 20);
    }

    public static JLabel h3(String text) {
        return createHeaderLabel(text, Font.BOLD, 18);
    }

    public static JLabel h4(String text) {
        return createHeaderLabel(text, Font.BOLD, 16);
    }

    public static JLabel h5(String text) {
        return createHeaderLabel(text, Font.BOLD, 14);
    }

    public static JLabel h6(String text) {
        return createHeaderLabel(text, Font.BOLD, 12);
    }

    // Método para crear un JLabel con el color de letra especificado y estilo de fuente
    private static JLabel createHeaderLabel(String text, int style, int size) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.decode("#CCCCCC"));
        label.setFont(new Font(Font.SANS_SERIF, style, size));
        return label;
    }

    // Método para crear un JLabel con el color de letra especificado y estilo de fuente
    private static JLabel createLabel(String text, int style) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.decode("#CCCCCC"));
        label.setFont(label.getFont().deriveFont(style));
        return label;
    }
}
