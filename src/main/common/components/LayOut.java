package main.common.components;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * The LayOut class provides methods to create and manage different components
 * of the GUI, including the main frame, side panel, buttons, top panel, and content panel.
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>contentPanel - The main content panel for the application.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>mainFrame() - Creates the main application frame.</li>
 *   <li>sidePanel(Map&lt;String, Runnable&gt; redirections) - Creates the side panel with navigation buttons.</li>
 *   <li>sideButton(String text, Runnable redirection) - Creates a side panel button with a given text and action.</li>
 *   <li>topPanel() - Creates the top panel with a title label.</li>
 *   <li>contentPanel() - Initializes the main content panel.</li>
 *   <li>getContentPanel() - Retrieves the main content panel.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.07
 */
public class LayOut extends Common {

    private static JPanel contentPanel;

    /**
     * Creates the main application frame.
     *
     * @return The main JFrame.
     */
    public static JFrame mainFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        return frame;
    }

    /**
     * Creates the side panel with navigation buttons.
     *
     * @param redirections A map of button names and their corresponding actions.
     * @return The side JPanel.
     */
    public static JPanel sidePanel(Map<String, Runnable> redirections) {
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(Color.decode("#191C20"));

        for (Map.Entry<String, Runnable> redirection : redirections.entrySet()) {
            JButton button = sideButton(redirection.getKey(), redirection.getValue());
            sidePanel.add(button);
            sidePanel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        return sidePanel;
    }

    /**
     * Creates a side panel button with a given text and action.
     *
     * @param text The text for the button.
     * @param redirection The action to perform on button click.
     * @return The configured JButton.
     */
    public static JButton sideButton(String text, Runnable redirection) {

        JButton button = new JButton(text);
        button.setBackground(Color.decode("#191C20"));
        button.setForeground(TEXT_COLOR);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#2E2F32")),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);

        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        button.addActionListener(e -> redirection.run());

        return button;
    }

    /**
     * Creates the top panel with a title label.
     *
     * @return The top JPanel.
     */
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

    /**
     * Initializes the main content panel.
     *
     * @return The content JPanel.
     */
    public static JPanel contentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.decode("#3B3B3E"));
        return contentPanel;
    }

    /**
     * Retrieves the main content panel.
     *
     * @return The main content JPanel.
     */
    public static JPanel getContentPanel() {
        return contentPanel;
    }
}
