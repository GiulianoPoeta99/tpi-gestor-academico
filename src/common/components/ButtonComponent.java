package common.components;

import javax.swing.*;
import java.awt.*;

public class ButtonComponent extends UIComponent{
    public static JButton buttonSuccess(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(SUCCESS_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }

    public static JButton buttonPrimary(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }

    public static JButton buttonSecondary(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(SECONDARY_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }

    public static JButton buttonInfo(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(INFO_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }

    public static JButton buttonWarning(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(WARNING_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }

    public static JButton buttonDanger(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(DANGER_COLOR);
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font(DEFAULT_FONT, Font.PLAIN, 13));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BACKGROUND_COLOR), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }
}
