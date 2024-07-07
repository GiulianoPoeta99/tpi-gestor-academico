package main.site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.common.components.LayOut;
import main.common.components.Text;
import main.common.components.UIComponent;

/**
 * The SiteViews class provides methods to manage the layout and components
 * of the main site view. It includes methods to set up the main layout with
 * redirections and to generate components for the index view.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>layout(Map&lt;String, Runnable&gt; redirections) - Sets up the main site layout.</li>
 *   <li>index() - Generates components for the index view.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.07
 */
public class SiteViews {

    /**
     * Sets up the main site layout with the specified redirections.
     *
     * @param redirections A map of redirection actions for the side panel.
     */
    public static void layout(Map<String, Runnable> redirections) {
        JFrame frame = LayOut.mainFrame();
        JPanel topPanel = LayOut.topPanel();
        JPanel sidePanel = LayOut.sidePanel(redirections);
        JPanel contentPanel = LayOut.contentPanel();

        frame.setLayout(new BorderLayout());
        frame.add(sidePanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * Generates and returns a list of components for the index view.
     *
     * @return A list of JComponents for the index view.
     */
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Inicio");
        components.add(title);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        components.add(divBox);

        return components;
    }
}
