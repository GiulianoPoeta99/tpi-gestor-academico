package main.common.components;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LayOut extends Common {

    private static JPanel contentPanel;

    public static JFrame mainFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        return frame;
    }

    public static JPanel sidePanel(Map<String, Runnable> redirections) {
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(Color.decode("#191C20"));

        for (Map.Entry<String, Runnable> redirection: redirections.entrySet()) {
            JButton button = sideButton(redirection.getKey(),redirection.getValue());
            sidePanel.add(button);
            sidePanel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        return sidePanel;
    }

    public static JButton sideButton(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(Color.decode("#191C20"));
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2E2F32")),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setFocusPainted(false); // Remover indicación de enfoque
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);

        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        button.addActionListener(e -> redirection.run());

        return button;
    }


    public static JPanel topPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.decode("#26663E"));
        topPanel.setPreferredSize(new Dimension(1280, 50));
        JLabel titleLabel = new JLabel("Academic Manager");
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        topPanel.setLayout(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.WEST);

        return topPanel;
    }

    public static JPanel contentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.decode("#3B3B3E"));
        return contentPanel;
    }

    public static JPanel getContentPanel() {
        return contentPanel;
    }
}
