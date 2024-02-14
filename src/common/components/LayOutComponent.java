package common.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import site.SiteController;
import career.CareerController;
import student.StudentController;
import studyplan.StudyPlanController;
import subject.SubjectController;

public class LayOutComponent {

    private static JFrame frame;
    private static JPanel contentPanel;

    public static JFrame mainFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        return frame;
    }

    public static JPanel sidePanel(Map<String, Runnable> redirections) {
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack buttons vertically
        sidePanel.setBackground(Color.decode("#191C20")); // Dark color for the side panel

        // Create and add a button for each redirection
        for (Map.Entry<String, Runnable> redirection: redirections.entrySet()) {
            JButton button = sideButton(redirection.getKey(),redirection.getValue());
            sidePanel.add(button);
            sidePanel.add(Box.createRigidArea(new Dimension(0, 2))); // Add 2-pixel vertical space between buttons
        }

        return sidePanel;
    }

    public static JButton sideButton(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(Color.decode("#191C20")); // Color oscuro para el fondo
        button.setForeground(Color.decode("#CCCCCC")); // Color claro para el texto
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Tamaño y tipo de fuente para el texto
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2E2F32")), // Borde inferior
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Espacio interno alrededor del texto
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar horizontalmente el texto
        button.setAlignmentY(Component.CENTER_ALIGNMENT); // Centrar verticalmente el texto

        // Establecer el ancho máximo para permitir que el botón se expanda horizontalmente
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        // Agregar ActionListener para manejar los clics en el botón
        button.addActionListener(e -> {
            redirection.run();
        });

        return button;
    }


    public static JPanel topPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.decode("#000000")); // Color oscuro para el top panel
        topPanel.setPreferredSize(new Dimension(1280, 50)); // Establecer un ancho fijo
        JLabel titleLabel = new JLabel("Academic Manager");
        titleLabel.setForeground(Color.decode("#CCCCCC")); // Color claro para el texto
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Fuente y tamaño del texto

        // Crear un borde vacío para separar el título del borde izquierdo
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        topPanel.setLayout(new BorderLayout()); // Establecer el layout como BorderLayout
        topPanel.add(titleLabel, BorderLayout.WEST); // Añadir el título a la izquierda

        return topPanel;
    }

    public static JPanel contentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.decode("#2E2F32")); // Dark color for the content panel
        return contentPanel;
    }

    public static JPanel getContentPanel() {
        return contentPanel;
    }
}
